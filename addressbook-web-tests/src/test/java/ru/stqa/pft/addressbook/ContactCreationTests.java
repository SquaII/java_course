package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreationTests {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        // firefox 47 и 48 не работает с selenium 2.53
        System.setProperty("webdriver.firefox.bin","F:\\Programs\\Firefox 46\\firefox.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactData();
        submitContactCreation();
    }

    private ContactData getContactData() {
        ContactNameData nameData = new ContactNameData("first_name", "middle_name", "last_name", "nick_name");
        ContactPhoneData phoneData = new ContactPhoneData("fax", "work", "mobile", "home");
        ContactEmailData emailData = new ContactEmailData("email", "email2", "email3");
        ContactOtherData otherData = new ContactOtherData("title", "company", "address");
        return new ContactData(nameData, phoneData, emailData, otherData);
    }

    private void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillContactData() {
        ContactData contactData = getContactData();
        fillContactNames(contactData.getContactNameData());
        fillContactPhones(contactData.getContactPhoneData());
        fillContactEmails(contactData.getContactEmailData());
        fillContractOthers(contactData.getContactOtherData());
    }

    private void fillContractOthers(ContactOtherData contactOtherData) {
        wd.findElement(By.name("title")).sendKeys(contactOtherData.getTitle());
        wd.findElement(By.name("company")).sendKeys(contactOtherData.getCompany());
        wd.findElement(By.name("address")).sendKeys(contactOtherData.getAddress());
    }

    private void fillContactEmails(ContactEmailData contactEmailData) {
        wd.findElement(By.name("email")).sendKeys(contactEmailData.getEmail());
        wd.findElement(By.name("email2")).sendKeys(contactEmailData.getEmail2());
        wd.findElement(By.name("email3")).sendKeys(contactEmailData.getEmail3());
    }

    private void fillContactPhones(ContactPhoneData contactPhoneData) {
        wd.findElement(By.name("home")).sendKeys(contactPhoneData.getHome());
        wd.findElement(By.name("mobile")).sendKeys(contactPhoneData.getMobile());
        wd.findElement(By.name("work")).sendKeys(contactPhoneData.getWork());
        wd.findElement(By.name("fax")).sendKeys(contactPhoneData.getFax());
    }

    private void fillContactNames(ContactNameData contactNameData) {
        wd.findElement(By.name("firstname")).sendKeys(contactNameData.getFirstName());
        wd.findElement(By.name("middlename")).sendKeys(contactNameData.getMiddleName());
        wd.findElement(By.name("lastname")).sendKeys(contactNameData.getLastName());
        wd.findElement(By.name("nickname")).sendKeys(contactNameData.getNickName());
    }

    private void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
