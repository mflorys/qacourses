package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactsHelper().getContactList();
        app.getContactsHelper().createContact(this.app, new ContactData(
                null,
                "Travolta",
                "qacourses",
                "123123123",
                "test@email.com",
                null));
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactsHelper().getContactList();
        Assert.assertEquals(before.size() + 1, after.size());

    }
}
