package pl.qacourses.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNewPage();
        app.getContactsHelper().fillNewContactForm(new ContactData("John", "Travolta", "qacourses", "123123123", "test@email.com"));
        app.getContactsHelper().sumbitNewContactForm();
        app.getNavigationHelper().returnToHomePage();
    }
}
