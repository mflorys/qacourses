package pl.qacourses.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }
}
