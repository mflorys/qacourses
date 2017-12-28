package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactsHelper().getContactList();
        ContactData contact = new ContactData(
                "John",
                "Travolta",
                "qacourses",
                "123123123",
                "test@email.com",
                null
        );
        app.getContactsHelper().createContact(this.app, contact);
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactsHelper().getContactList();

        Comparator<? super ContactData> byLastName = Comparator.comparing(ContactData::getLastName);
        before.add(contact);
        before.sort(byLastName);
        after.sort(byLastName);

        Assert.assertEquals(before, after);
    }
}
