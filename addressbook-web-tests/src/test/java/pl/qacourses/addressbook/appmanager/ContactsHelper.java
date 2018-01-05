package pl.qacourses.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.qacourses.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContactForm() {
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

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void clickDeleteButton() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    public void acceptDeletionAlert() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int index) {
        clickEditContactButton(index+2);
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void create (ApplicationManager app, ContactData contact) {
        app.goTo().addNewPage();
        fillNewContactForm(contact, true);
        submitNewContactForm();
        app.goTo().homePage();
    }

    public void modify(ContactData contact, int index) {
        initContactModification(index);
        fillNewContactForm(contact, false);
        submitContactModification();
    }

    public void delete(int index) {
        selectContact(index);
        clickDeleteButton();
        acceptDeletionAlert();
    }

    public boolean isThereAContact() {
        if (isElementPresent(By.name("selected[]"))) {
            return true;
        }
        return false;
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> rows = wd.findElements(By.name("entry"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String email = cells.get(4).getText();
            String homeNumber = cells.get(5).getText();

            contacts.add(new ContactData(firstName, lastName, null, homeNumber, email, null));
        }

        return contacts;
    }

    private void clickEditContactButton(int i) {
        wd.findElement(By.xpath("//tr[" + String.valueOf(i)  + "]/td[8]/a/img")).click();
    }
}
