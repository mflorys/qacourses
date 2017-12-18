package pl.qacourses.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion(){
        app.getContactsHelper().selectContact();
        app.getContactsHelper().clickDeleteButton();
        app.getContactsHelper().acceptDeletionAlert();
        app.getNavigationHelper().returnToHomePage();
    }
}
