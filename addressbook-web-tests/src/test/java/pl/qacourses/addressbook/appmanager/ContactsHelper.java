package pl.qacourses.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.qacourses.addressbook.model.ContactData;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(WebDriver wd) {
        super(wd);
    }

    public void sumbitNewContactForm() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillNewContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("home"), contactData.getHomeNumber());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            if (contactData.getGroup() != null && (new Select(wd.findElement(By.name("new_group"))).getOptions().size() > 1)){
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            }
        } else {
            Assert.assertTrue(!isElementPresent(By.name("new_group")));
        }
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void clickDeleteButton() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    public void acceptDeletionAlert() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void createContact(ApplicationManager app, ContactData contact) {
        app.getNavigationHelper().gotoAddNewPage();
        fillNewContactForm(contact, true);
        sumbitNewContactForm();
        app.getNavigationHelper().returnToHomePage();
    }

    public boolean isThereAContact() {
        if (isElementPresent(By.name("selected[]"))) {
            return true;
        }
        return false;
    }
}
