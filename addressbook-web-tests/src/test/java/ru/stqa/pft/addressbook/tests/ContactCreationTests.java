package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactData(getContactData(), true);
        app.getContactHelper().submitContactCreation();
    }

    public ContactData getContactData() {
        ContactNameData nameData = new ContactNameData("first_name", "middle_name", "last_name", "nick_name");
        ContactPhoneData phoneData = new ContactPhoneData("fax", "work", "mobile", "home");
        ContactEmailData emailData = new ContactEmailData("email", "email2", "email3");
        ContactOtherData otherData = new ContactOtherData("title", "company", "address");
        return new ContactData(nameData, phoneData, emailData, otherData, "test1");
    }

}
