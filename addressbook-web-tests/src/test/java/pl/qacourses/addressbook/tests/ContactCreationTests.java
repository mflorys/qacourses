package pl.qacourses.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.gotoAddNewPage();
        app.fillNewContactForm(new ContactData("John", "Travolta", "qacourses", "123123123", "test@email.com"));
        app.sumbitNewContactForm();
        app.returnToHomePage();
    }
}
