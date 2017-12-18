package pl.qacourses.addressbook.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification(){
        app.getContactsHelper().initGroupModification();
        app.getContactsHelper().fillNewContactForm(new ContactData("John Edited", "Travolta Edited", "qacourses edited", "123123123", "test@edited.com"));
        app.getContactsHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
    }
}
