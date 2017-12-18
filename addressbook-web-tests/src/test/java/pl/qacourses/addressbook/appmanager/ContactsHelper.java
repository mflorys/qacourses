package pl.qacourses.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.qacourses.addressbook.model.ContactData;

public class ContactsHelper extends HelperBase{

    public ContactsHelper(WebDriver wd){
        super(wd);
    }

    public void sumbitNewContactForm() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillNewContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("lastname"),contactData.getLastName());
        type(By.name("company"),contactData.getCompanyName());
        type(By.name("home"),contactData.getHomeNumber());
        type(By.name("email"),contactData.getEmail());
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

    public void initGroupModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }
}
