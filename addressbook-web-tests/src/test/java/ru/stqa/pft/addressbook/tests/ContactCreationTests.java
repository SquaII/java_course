package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        Set<ContactData> before = app.contact().all();
        ContactData contact = getContactData();
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        contact.convertToListData();
        before.add(contact);
        Assert.assertEquals(before, after);
    }

    private ContactData getContactData() {
        ContactPhoneData phoneData= new ContactPhoneData().withHome("home").withMobile("mobile").withWork("work").withFax("fax");
        phoneData.isListData = true;
        ContactEmailData emailData = new ContactEmailData().withEmail1("email").withEmail2("email2").withEmail3("email3");
        emailData.isListData = true;
        return new ContactData()
                .withContactNameData(new ContactNameData()
                        .withFirstName("first_name").withMiddleName("middle_name").withLastName("last_name").withNickName("nick_name"))
                .withContactPhoneData(phoneData)
                .withContactEmailData(emailData)
                .withContactOtherData(new ContactOtherData()
                        .withTitle("title").withCompany("company").withAddress("address"))
                .withGroupName("test1");
    }

}
