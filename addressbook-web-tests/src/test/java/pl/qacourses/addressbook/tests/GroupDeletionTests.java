package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.groups().list().size() == 0) {
            app.groups().create(new GroupData().withName("test1").withFooter("test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.groups().list();
        int index = before.size() - 1;
        app.groups().delete(index);
        List<GroupData> after = app.groups().list();

        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }
}
