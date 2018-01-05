package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.contacts().list();
        ContactData contact = new ContactData()
                .withFirstName("John").withLastName("Travolta").withHomeNumber("123123123").withEmail("test@email.com");

        app.contacts().create(this.app, contact);
        app.goTo().homePage();
        List<ContactData> after = app.contacts().list();

        Assert.assertEquals(after.size(), before.size() + 1);

        Comparator<? super ContactData> byLastName = Comparator.comparing(ContactData::getLastName);
        before.add(contact);
        before.sort(byLastName);
        after.sort(byLastName);

        Assert.assertEquals(before, after);
    }
}
