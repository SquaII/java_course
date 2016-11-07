package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final ContactNameData contactNameData;
    private final ContactPhoneData contactPhoneData;
    private final ContactEmailData contactEmailData;
    private final ContactOtherData contactOtherData;
    private String groupName;

    public ContactData(ContactNameData contactNameData, ContactPhoneData contactPhoneData, ContactEmailData contactEmailData,
                       ContactOtherData contactOtherData, String groupName) {
        this.contactNameData = contactNameData;
        this.contactPhoneData = contactPhoneData;
        this.contactEmailData = contactEmailData;
        this.contactOtherData = contactOtherData;
        this.groupName = groupName;
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

    public String getGroupName() {
        return groupName;
    }
}

