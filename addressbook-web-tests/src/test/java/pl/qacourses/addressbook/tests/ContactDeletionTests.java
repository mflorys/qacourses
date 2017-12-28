package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion(){
        if (!app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact(app, new ContactData(
                    "John",
                    "Travolta",
                    "qacourses",
                    "123123123",
                    "test@email.com",
                    "some_group"));
        }
        List<ContactData> before = app.getContactsHelper().getContactList();
        app.getContactsHelper().selectContact(before.size() - 1);
        app.getContactsHelper().clickDeleteButton();
        app.getContactsHelper().acceptDeletionAlert();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactsHelper().getContactList();

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);


    }
}
