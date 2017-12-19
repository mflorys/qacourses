package pl.qacourses.addressbook.tests;

import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion(){
        if (!app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact(app, new ContactData(null, "Travolta", "qacourses", "123123123", "test@email.com", null));
        }
        app.getContactsHelper().selectContact();
        app.getContactsHelper().clickDeleteButton();
        app.getContactsHelper().acceptDeletionAlert();
        app.getNavigationHelper().returnToHomePage();
    }
}
