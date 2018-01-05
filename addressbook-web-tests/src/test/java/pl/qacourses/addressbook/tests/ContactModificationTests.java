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
            app.contacts().create(app, new ContactData()
                    .withFirstName("John").withLastName("Travolta").withHomeNumber("123123123").withEmail("test@email.com"));
        }
    }

    @Test
    public void testContactModification(){
        List<ContactData> before = app.contacts().list();
        ContactData contact = new ContactData()
                .withFirstName("John").withLastName("Travolta").withHomeNumber("123123123").withEmail("test@email.com").withGroup("some_group");
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