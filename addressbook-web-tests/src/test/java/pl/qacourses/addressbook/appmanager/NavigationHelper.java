package pl.qacourses.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Maciej.Florys on 15/12/2017.
 */
public class NavigationHelper {

    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }
}
