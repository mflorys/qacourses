package pl.qacourses.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.qacourses.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1edited", "test2edited", "test3edited"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after);
    }
}
