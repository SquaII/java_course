package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withContactNameData(new ContactNameData().withFirstName("first").withLastName("last")));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = getContactData(modifiedContact.getId());
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));

        before.remove(modifiedContact);
        contact.convertToListData();
        before.add(contact);
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

    private ContactData getContactData(int id) {
        ContactPhoneData phoneData= new ContactPhoneData().withHome("home_mod").withWork("work_mod").withFax("fax_mod");
        phoneData.isListData = true;
        ContactEmailData emailData = new ContactEmailData().withEmail2("email2_mod").withEmail3("email3_mod");
        emailData.isListData = true;
        return new ContactData()
                .withId(id)
                .withContactNameData(new ContactNameData()
                        .withFirstName("first_name_mod").withMiddleName("middle_name_mod").withLastName("last_name_mod").withNickName("nick_name_mod"))
                .withContactPhoneData(phoneData)
                .withContactEmailData(emailData)
                .withContactOtherData(new ContactOtherData()
                        .withTitle("title_mod").withCompany("company_mod").withAddress("address_mod"));
    }

}
