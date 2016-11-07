package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(null, null, null, null, null));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactData(getContactData(), false);
        app.getContactHelper().submitContactModification();
    }

    public ContactData getContactData() {
        ContactNameData nameData = new ContactNameData("first_name_mod", "middle_name_mod", "last_name_mod", "nick_name_mod");
        ContactPhoneData phoneData = new ContactPhoneData("fax_mod", "work_mod", "mobile_mod", "home_mod");
        ContactEmailData emailData = new ContactEmailData("email_mod", "email2_mod", "email3_mod");
        ContactOtherData otherData = new ContactOtherData("title_mod", "company_mod", "address_mod");
        return new ContactData(nameData, phoneData, emailData, otherData, null);
    }

}
