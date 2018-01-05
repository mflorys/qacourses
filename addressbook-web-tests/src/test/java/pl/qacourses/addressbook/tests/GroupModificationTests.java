package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (!app.groups().isThereAGroup()) {
            app.groups().create(new GroupData().withName("test1").withFooter("test3"));
        }
    }

    @Test
    public void testGroupModification(){
        Set<GroupData> before = app.groups().all();
        GroupData modifiedGroup = before.iterator().next();

        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1edited").withHeader("test2edited").withFooter("test3edited");
        app.groups().modify(group);
        Set<GroupData> after = app.groups().all();

        Assert.assertEquals(before.size(), after.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
