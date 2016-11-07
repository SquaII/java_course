package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("//*[@id='content']//input[@value='Enter']"));
    }

    public void fillContactData(ContactData contactData, boolean creation) {
        fillContactNames(contactData.getContactNameData());
        fillContactPhones(contactData.getContactPhoneData());
        fillContactEmails(contactData.getContactEmailData());
        fillContactOthers(contactData.getContactOtherData());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroupName());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void fillContactOthers(ContactOtherData contactOtherData) {
        type(By.name("title"), contactOtherData.getTitle());
        type(By.name("company"), contactOtherData.getCompany());
        type(By.name("address"), contactOtherData.getAddress());
    }

    public void fillContactEmails(ContactEmailData contactEmailData) {
        type(By.name("email"), contactEmailData.getEmail());
        type(By.name("email2"), contactEmailData.getEmail2());
        type(By.name("email3"), contactEmailData.getEmail3());
    }

    public void fillContactPhones(ContactPhoneData contactPhoneData) {
        type(By.name("home"), contactPhoneData.getHome());
        type(By.name("mobile"), contactPhoneData.getMobile());
        type(By.name("work"), contactPhoneData.getWork());
        type(By.name("fax"), contactPhoneData.getFax());
    }

    public void fillContactNames(ContactNameData contactNameData) {
        type(By.name("firstname"), contactNameData.getFirstName());
        type(By.name("middlename"),contactNameData.getMiddleName());
        type(By.name("lastname"), contactNameData.getLastName());
        type(By.name("nickname"), contactNameData.getNickName());
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']//tr[2]//img[@title='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}
