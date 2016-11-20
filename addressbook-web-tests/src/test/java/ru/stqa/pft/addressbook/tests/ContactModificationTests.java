package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (! app.contact().isThereAContact()) {
            app.contact().create(new ContactData()
                    .withContactNameData(new ContactNameData().withFirstName("first").withLastName("last")));
        }
    }

    /* Тест редактирует первый контакт в списке контактов */
    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        int contractId = app.contact().initContactModification();
        ContactData contact = getContactData();
        contact.withId(contractId);

        app.contact().modify(contact);

        // check result
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        contact.convertToListData();
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    private ContactData getContactData() {
        return new ContactData()
                .withContactNameData(new ContactNameData()
                        .withFirstName("first_name_mod").withMiddleName("middle_name_mod").withLastName("last_name_mod").withNickName("nick_name_mod"))
                .withContactPhoneData(new ContactPhoneData()
                        .withHome("home_mod").withMobile("mobile_mod").withWork("work_mod").withFax("fax_mod"))
                .withContactEmailData(new ContactEmailData()
                        .withEmail1("email_mod").withEmail2("email2_mod").withEmail3("email3_mod"))
                .withContactOtherData(new ContactOtherData()
                        .withTitle("title_mod").withCompany("company_mod").withAddress("address_mod"));
    }

}
