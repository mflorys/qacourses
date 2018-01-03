package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification(){
        if (!app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact(app, new ContactData(
                    null,
                    "Travolta",
                    null,
                    "123123123",
                    "test@email.com",
                    "some_group"));
        }

        List<ContactData> before = app.getContactsHelper().getContactList();
        app.getContactsHelper().initContactModification(before.size() -  1);
        ContactData contact = new ContactData("John Edited", "Travolta Edited", null, "123123123", "test@edited.com", null);
        app.getContactsHelper().fillNewContactForm(contact, false);
        app.getContactsHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactsHelper().getContactList();

        before.remove(before.size() - 1);
        before.add(contact);

        Comparator<? super ContactData> byLastName = Comparator.comparing(ContactData::getLastName);
        before.sort(byLastName);
        after.sort(byLastName);
        Assert.assertEquals(before, after);
    }
}