package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    /* Тест редактирует первый контакт в списке контактов */
    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();

        // prepare data
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(new ContactNameData("first", null, "last", null)));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        int contractId = app.getContactHelper().initContactModification();
        ContactData contact = getContactData();
        contact.setId(contractId);

        // modify contact
        app.getContactHelper().fillContactData(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

        // check result
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        contact.convertToListData();
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    private ContactData getContactData() {
        ContactNameData nameData = new ContactNameData("first_name_mod", "middle_name_mod", "last_name_mod", "nick_name_mod");
        ContactPhoneData phoneData = new ContactPhoneData("fax_mod", "work_mod", "mobile_mod", "home_mod");
        ContactEmailData emailData = new ContactEmailData("email_mod", "email2_mod", "email3_mod");
        ContactOtherData otherData = new ContactOtherData("title_mod", "company_mod", "address_mod");
        return new ContactData(nameData, phoneData, emailData, otherData, null);
    }

}
