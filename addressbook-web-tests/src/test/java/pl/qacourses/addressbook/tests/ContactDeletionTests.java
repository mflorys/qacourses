package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contacts().list().size() == 0){
            app.contacts().create(app, new ContactData(
                    "John",
                    "Travolta",
                    "qacourses",
                    "123123123",
                    "test@email.com",
                    "some_group"));
        }
    }

    @Test
    public void testContactDeletion(){
        List<ContactData> before = app.contacts().list();
        int index = before.size() - 1;
        app.contacts().delete(index);
        app.goTo().homePage();
        List<ContactData> after = app.contacts().list();

        before.remove(index);
        Assert.assertEquals(before, after);


    }

}
