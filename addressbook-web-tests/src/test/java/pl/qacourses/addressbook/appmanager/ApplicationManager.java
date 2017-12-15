package pl.qacourses.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pl.qacourses.addressbook.tests.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    FirefoxDriver wd;

    private final NavigationHelper navigationHelper = new NavigationHelper();
    private GroupHelper groupHelper;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        navigationHelper.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        navigationHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        navigationHelper.wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(navigationHelper.wd);
        login("admin", "secret");
    }

    private void login(String username, String password) {
        navigationHelper.wd.findElement(By.name("user")).click();
        navigationHelper.wd.findElement(By.name("user")).clear();
        navigationHelper.wd.findElement(By.name("user")).sendKeys(username);
        navigationHelper.wd.findElement(By.name("pass")).click();
        navigationHelper.wd.findElement(By.name("pass")).clear();
        navigationHelper.wd.findElement(By.name("pass")).sendKeys(password);
        navigationHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void stop() {
        navigationHelper.wd.quit();
    }

    public void deleteSelectedGroups() {
        navigationHelper.wd.findElement(By.name("delete")).click();
    }

    public void returnToHomePage() {
        navigationHelper.wd.findElement(By.linkText("home")).click();
    }

    public void sumbitNewContactForm() {
        navigationHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillNewContactForm(ContactData contactData) {
        navigationHelper.wd.findElement(By.name("firstname")).click();
        navigationHelper.wd.findElement(By.name("firstname")).clear();
        navigationHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        navigationHelper.wd.findElement(By.name("lastname")).click();
        navigationHelper.wd.findElement(By.name("lastname")).clear();
        navigationHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        navigationHelper.wd.findElement(By.name("company")).click();
        navigationHelper.wd.findElement(By.name("company")).clear();
        navigationHelper.wd.findElement(By.name("company")).sendKeys(contactData.getCompanyName());
        navigationHelper.wd.findElement(By.name("home")).click();
        navigationHelper.wd.findElement(By.name("home")).clear();
        navigationHelper.wd.findElement(By.name("home")).sendKeys(contactData.getHomeNumber());
        navigationHelper.wd.findElement(By.name("email")).click();
        navigationHelper.wd.findElement(By.name("email")).clear();
        navigationHelper.wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void gotoAddNewPage() {
        navigationHelper.wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
