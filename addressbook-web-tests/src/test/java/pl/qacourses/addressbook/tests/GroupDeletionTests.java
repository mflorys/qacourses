package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.GroupData;

import java.util.Set;

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
        Set<GroupData> before = app.groups().all();
        GroupData deletedGroup = before.iterator().next();
        app.groups().delete(deletedGroup);
        Set<GroupData> after = app.groups().all();

        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);

    }
}
