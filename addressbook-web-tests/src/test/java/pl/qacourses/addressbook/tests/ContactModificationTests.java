package pl.qacourses.addressbook.tests;

import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification(){
        app.getContactsHelper().initContactModification();
        app.getContactsHelper().fillNewContactForm(new ContactData("John Edited", "Travolta Edited", "qacourses edited", "123123123", "test@edited.com", null), false);
        app.getContactsHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
    }
}
