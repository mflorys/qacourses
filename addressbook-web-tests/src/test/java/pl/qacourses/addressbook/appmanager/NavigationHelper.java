package pl.qacourses.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void homePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public void addNewPage() {
        if (!isElementPresent(By.tagName("h1"))
                || !wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
                || !isElementPresent(By.name("submit"))){
            click(By.linkText("add new"));
        }
    }

    public void groupPage() {
        if (!isElementPresent(By.tagName("h1"))
                || !wd.findElement(By.tagName("h1")).getText().equals("Groups")
                || !isElementPresent(By.name("new"))){
            click(By.linkText("groups"));
        }
    }
}
