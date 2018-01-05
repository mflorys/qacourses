package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contacts().list().size() == 0){
            app.contacts().create(app, new ContactData(
                    null,
                    "Travolta",
                    null,
                    "123123123",
                    "test@email.com",
                    "some_group"));
        }
    }

    @Test
    public void testContactModification(){
        List<ContactData> before = app.contacts().list();
        ContactData contact = new ContactData("John Edited", "Travolta Edited", null, "123123123", "test@edited.com", null);
        int index = before.size() -  1;
        app.contacts().modify(contact, index);
        app.goTo().homePage();
        List<ContactData> after = app.contacts().list();

        before.remove(index);
        before.add(contact);

        Comparator<? super ContactData> byLastName = Comparator.comparing(ContactData::getLastName);
        before.sort(byLastName);
        after.sort(byLastName);
        Assert.assertEquals(before, after);
    }

}