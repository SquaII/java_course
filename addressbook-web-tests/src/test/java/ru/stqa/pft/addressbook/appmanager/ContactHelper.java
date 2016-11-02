package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactData(ContactData contactData) {
        fillContactNames(contactData.getContactNameData());
        fillContactPhones(contactData.getContactPhoneData());
        fillContactEmails(contactData.getContactEmailData());
        fillContractOthers(contactData.getContactOtherData());
    }

    public void fillContractOthers(ContactOtherData contactOtherData) {
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

}
