package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (contactData.getContactNameData() != null) { fillContactNames(contactData.getContactNameData()); }
        if (contactData.getContactPhoneData() != null) { fillContactPhones(contactData.getContactPhoneData()); }
        if (contactData.getContactEmailData() != null) { fillContactEmails(contactData.getContactEmailData()); }
        if (contactData.getContactOtherData() != null) { fillContactOthers(contactData.getContactOtherData()); }

        if (creation) {
            if (contactData.getGroups().size() > 0) {
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        attach(By.name("photo"), contactData.getPhoto());
    }

    public void fillContactOthers(ContactOtherData contactOtherData) {
        type(By.name("title"), contactOtherData.getTitle());
        type(By.name("company"), contactOtherData.getCompany());
        type(By.name("address"), contactOtherData.getAddress());
        type(By.name("address2"), contactOtherData.getAddress2());
        type(By.name("homepage"), contactOtherData.getHomepage());
        type(By.name("notes"), contactOtherData.getNotes());
    }

    public void fillContactEmails(ContactEmailData contactEmailData) {
        type(By.name("email"), contactEmailData.getEmail1());
        type(By.name("email2"), contactEmailData.getEmail2());
        type(By.name("email3"), contactEmailData.getEmail3());
    }

    public void fillContactPhones(ContactPhoneData contactPhoneData) {
        type(By.name("home"), contactPhoneData.getHome());
        type(By.name("mobile"), contactPhoneData.getMobile());
        type(By.name("work"), contactPhoneData.getWork());
        type(By.name("fax"), contactPhoneData.getFax());
        type(By.name("phone2"), contactPhoneData.getHome2());
    }

    public void fillContactNames(ContactNameData contactNameData) {
        type(By.name("firstname"), contactNameData.getFirstName());
        type(By.name("middlename"),contactNameData.getMiddleName());
        type(By.name("lastname"), contactNameData.getLastName());
        type(By.name("nickname"), contactNameData.getNickName());
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int id) {
        wd.findElement(By.xpath("//table[@id='maintable']//*[@href='edit.php?id=" + id + "']")).click();
    }

    public void viewDetails(int id) {
        wd.findElement(By.xpath("//table[@id='maintable']//*[@href='view.php?id=" + id + "']")).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactData contactData) {
        initContactCreation();
        fillContactData(contactData, true);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModification(contact.getId());
        fillContactData(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        contactCache = null;
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
        for (WebElement element : elements){
            WebElement phonesData = element.findElement(By.xpath("td[6]"));
            ContactPhoneData phoneData = new ContactPhoneData().withPhones(phonesData);

            List<WebElement> emailsList = new ArrayList<>();
            try {
                emailsList = element.findElements(By.xpath("td[5]/a"));     // no emails for contact
            }
            catch (NoSuchElementException ex) {}
            ContactEmailData emailData = new ContactEmailData().withEmails(emailsList);

            String lastName = element.findElement(By.xpath("td[2]")).getText();
            String firstName = element.findElement(By.xpath("td[3]")).getText();
            String address = element.findElement(By.xpath("td[4]")).getText();
            ContactData contactData = new ContactData().withAsListData(true)
                    .withId(Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id")))
                    .withContactNameData(new ContactNameData().withFirstName(firstName).withLastName(lastName))
                    .withContactPhoneData(phoneData)
                    .withContactEmailData(emailData)
                    .withContactOtherData(new ContactOtherData().withAddress(address));

            contactCache.add(contactData);
        }
        return new Contacts(contactCache);
    }

    public boolean checkDetails(ContactData c) {
        String contactHTML = wd.findElement(By.xpath("//div[@id='content']")).getAttribute("innerHTML");
        String expectedHTML = String.format("<b>%s%s%s</b><br>", c.getFirstName() + " " , c.getMiddleName() + " ", c.getLastName());
        if (c.getNickName() != null && !c.getNickName().equals("")) {
            expectedHTML = expectedHTML + String.format("%s<br>", c.getNickName());
        }
        if (c.getPhoto() != null && !c.getPhoto().equals("")) {
            expectedHTML = expectedHTML + String.format("<img.+><br>");
        }
        if (c.getTitle() != null && !c.getTitle().equals("")) {
            expectedHTML = expectedHTML + String.format("<i>%s<br></i>", c.getTitle());
        }
        if (c.getCompany() != null && !c.getCompany().equals("")) {
            expectedHTML = expectedHTML +String.format("%s<br>", c.getCompany());
        }
        if (c.getAddress() != null && !c.getAddress().equals("")) {
            expectedHTML = expectedHTML + String.format("%s<br>", c.getAddress());
        }
        expectedHTML = expectedHTML + " <br>";
        if (c.getHomePhone() != null && !c.getHomePhone().equals("")) {
            expectedHTML = expectedHTML + String.format("H: %s<br>", c.getHomePhone());
        }
        if (c.getMobilePhone() != null && !c.getMobilePhone().equals("")) {
            expectedHTML = expectedHTML + String.format("M: %s<br>", c.getMobilePhone());
        }
        if (c.getWorkPhone() != null && !c.getWorkPhone().equals("")) {
            expectedHTML = expectedHTML + String.format("W: %s<br>", c.getWorkPhone());
        }
        if (c.getFax() != null && !c.getFax().equals("")) {
            expectedHTML = expectedHTML + String.format("F: %s<br>", c.getFax());
        }
        expectedHTML = expectedHTML + " <br>";
        if (c.getEmail1() != null && !c.getEmail1().equals("")) {
            expectedHTML = expectedHTML + String.format("<a href=\"mailto:%s\">%s</a><br>", c.getEmail1(), c.getEmail1());
        }
        if (c.getEmail2() != null && !c.getEmail2().equals("")) {
            expectedHTML = expectedHTML + String.format("<a href=\"mailto:%s\">%s</a><br>", c.getEmail2(), c.getEmail2());
        }
        if (c.getEmail3() != null && !c.getEmail3().equals("")) {
            expectedHTML = expectedHTML + String.format("<a href=\"mailto:%s\">%s</a><br>", c.getEmail3(), c.getEmail3());
        }
        if (c.getHomepage() != null && !c.getHomepage().equals("")) {
            expectedHTML = expectedHTML + String.format("<label>Homepage:</label><a href=\"http://%s\">%s</a><br> <br>",
                c.getHomepage(), c.getHomepage());
        }
        expectedHTML = expectedHTML + " <br>";
        if (c.getAddress2() != null && !c.getAddress2().equals("")) {
            expectedHTML = expectedHTML + String.format("%s<br>", c.getAddress2());
        }
        if (c.getHomePhone2() != null && !c.getHomePhone2().equals("")) {
            expectedHTML = expectedHTML + String.format(" <br>P: %s<br><br>", c.getHomePhone2());
        }
        if (c.getNotes() != null && !c.getNotes().equals("")) {
            expectedHTML = expectedHTML + String.format("%s<br><br>", c.getNotes());
        }
        /*
        if (c.getGroupName() != null && !c.getGroupName().equals("")) {
            expectedHTML = expectedHTML + String.format("\n<br><i>Member of: <a href=\"./index.php\\?group=[0-9]+\">%s</a></i>\t\n<br>",
                c.getGroupName());
        }
        */
        Matcher result =  Pattern.compile(expectedHTML).matcher(contactHTML);
        return result.find();
    }

    public void addToGroup(ContactData contact, GroupData group) {
        new Select(wd.findElement(By.name("group"))).selectByVisibleText("[all]");
        selectContactById(contact.getId());
        new Select(wd.findElement(By.name("to_group"))).selectByValue(String.valueOf(group.getId()));
        click(By.name("add"));
        click(By.linkText(String.format("group page \"%s\"", group.getName())));
    }

    public void removeFromGroup(ContactData contact, GroupData group) {
        new Select(wd.findElement(By.name("group"))).selectByValue(String.valueOf(group.getId()));
        selectContactById(contact.getId());
        click(By.name("remove"));
        click(By.linkText(String.format("group page \"%s\"", group.getName())));
    }
}
