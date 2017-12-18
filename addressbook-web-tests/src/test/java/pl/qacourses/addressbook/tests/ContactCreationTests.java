package pl.qacourses.addressbook.tests;

import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNewPage();
        app.getContactsHelper().fillNewContactForm(new ContactData("John", "Travolta", "qacourses", "123123123", "test@email.com", "test1"), true);
        app.getContactsHelper().sumbitNewContactForm();
        app.getNavigationHelper().returnToHomePage();
    }
}
