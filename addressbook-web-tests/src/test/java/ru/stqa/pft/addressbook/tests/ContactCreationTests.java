package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        ContactData contact = getContactData();
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        contact.convertToListData();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
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
