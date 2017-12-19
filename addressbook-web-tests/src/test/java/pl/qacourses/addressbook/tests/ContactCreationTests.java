package pl.qacourses.addressbook.tests;

import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactsHelper().createContact(this.app, new ContactData(
                null,
                "Travolta",
                "qacourses",
                "123123123",
                "test@email.com",
                "test1"));
    }
}
