package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private final ContactNameData contactNameData;
    private final ContactPhoneData contactPhoneData;
    private final ContactEmailData contactEmailData;
    private final ContactOtherData contactOtherData;
    private String groupName;

    public ContactData(ContactNameData contactNameData) {
        this.id = 0;
        this.contactNameData = contactNameData;
        this.contactPhoneData = new ContactPhoneData();
        this.contactEmailData = new ContactEmailData();
        this.contactOtherData = new ContactOtherData();
        this.groupName = null;
    }

    public ContactData(ContactNameData contactNameData, ContactPhoneData contactPhoneData, ContactEmailData contactEmailData,
                       ContactOtherData contactOtherData, String groupName) {
        this.id = 0;
        this.contactNameData = contactNameData;
        this.contactPhoneData = contactPhoneData;
        this.contactEmailData = contactEmailData;
        this.contactOtherData = contactOtherData;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        return contactNameData != null ? contactNameData.equals(that.contactNameData) : that.contactNameData == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (contactNameData != null ? contactNameData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", contactNameData=" + contactNameData +
                ", contactPhoneData=" + contactPhoneData +
                ", contactEmailData=" + contactEmailData +
                ", contactOtherData=" + contactOtherData +
                ", groupName='" + groupName + '\'' +
                '}';
    }

}

