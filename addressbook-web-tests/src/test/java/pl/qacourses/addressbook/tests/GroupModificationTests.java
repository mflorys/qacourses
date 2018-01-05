package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (!app.groups().isThereAGroup()) {
            app.groups().create(new GroupData("test1", null, "test3"));
        }
    }

    @Test
    public void testGroupModification(){
        List<GroupData> before = app.groups().list();
        int index = before.size() - 1;
        GroupData group = new GroupData(before.get(index).getId(), "test1edited", "test2edited", "test3edited");
        app.groups().modify(index, group);
        List<GroupData> after = app.groups().list();

        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
