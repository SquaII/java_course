package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.contact().list();
        ContactData contact = getContactData();

        app.contact().create(contact);

        // check result
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        contact.convertToListData();
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    private ContactData getContactData() {
        return new ContactData()
                .withContactNameData(new ContactNameData()
                        .withFirstName("first_name").withMiddleName("middle_name").withLastName("last_name").withNickName("nick_name"))
                .withContactPhoneData(new ContactPhoneData()
                        .withHome("home").withMobile("mobile").withWork("work").withFax("fax"))
                .withContactEmailData(new ContactEmailData()
                        .withEmail1("email").withEmail2("email2").withEmail3("email3"))
                .withContactOtherData(new ContactOtherData()
                        .withTitle("title").withCompany("company").withAddress("address"))
                .withGroupName("test1");
    }

}
