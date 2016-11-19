package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        // prepare data
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = getContactData();

        // create contact
        app.getContactHelper().createContact(contact);

        // check result
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        contact.convertToListData();
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    private ContactData getContactData() {
        ContactNameData nameData = new ContactNameData("first_name", "middle_name", "last_name", "nick_name");
        ContactPhoneData phoneData = new ContactPhoneData("fax", "work", "mobile", "home");
        ContactEmailData emailData = new ContactEmailData("email", "email2", "email3");
        ContactOtherData otherData = new ContactOtherData("title", "company", "address");
        return new ContactData(nameData, phoneData, emailData, otherData, "test1");
    }

}
