package ru.stqa.pft.addressbook.model;

import ru.stqa.pft.addressbook.model.ContactEmailData;
import ru.stqa.pft.addressbook.model.ContactNameData;
import ru.stqa.pft.addressbook.model.ContactOtherData;
import ru.stqa.pft.addressbook.model.ContactPhoneData;

public class ContactData {
    private final ContactNameData contactNameData;
    private final ContactPhoneData contactPhoneData;
    private final ContactEmailData contactEmailData;
    private final ContactOtherData contactOtherData;

    public ContactData(ContactNameData contactNameData, ContactPhoneData contactPhoneData, ContactEmailData contactEmailData,
                       ContactOtherData contactOtherData) {
        this.contactNameData = contactNameData;
        this.contactPhoneData = contactPhoneData;
        this.contactEmailData = contactEmailData;
        this.contactOtherData = contactOtherData;
    }

    public ContactOtherData getContactOtherData(){
        return contactOtherData;
    }

    public ContactNameData getContactNameData() {
        return contactNameData;
    }

    public ContactPhoneData getContactPhoneData() {
        return contactPhoneData;
    }

    public ContactEmailData getContactEmailData() {
        return contactEmailData;
    }
}
