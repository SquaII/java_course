package ru.stqa.pft.addressbook.tests;

import org.hamcrest.core.Is;
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
        int addedContactID = after.stream().mapToInt((c) -> c.getId()).max().getAsInt();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.getListData().withId(addedContactID))));

        app.contact().viewDetails(addedContactID);
        assertThat(true, equalTo(app.contact().checkDetails(contact)));
    }

    private ContactData getContactData() {
        return new ContactData().withAsListData(true)
                .withContactNameData(new ContactNameData()
                        .withFirstName("first_name").withMiddleName("middle_name").withLastName("last_name").withNickName("nick_name"))
                .withContactPhoneData(new ContactPhoneData()
                        .withHome("home").withMobile("mobile").withWork("work").withFax("fax").withHome2("home2"))
                .withContactEmailData(new ContactEmailData()
                        .withEmail1("email").withEmail2("email2").withEmail3("email3"))
                .withContactOtherData(new ContactOtherData()
                        .withTitle("title").withCompany("company").withAddress("address")
                        .withAddress2("address2").withHomepage("homepage").withNotes("notes"))
                .withGroupName("test1");
    }

}
