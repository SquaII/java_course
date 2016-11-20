package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private ContactNameData contactNameData;
    private ContactPhoneData contactPhoneData;
    private ContactEmailData contactEmailData;
    private ContactOtherData contactOtherData;
    private String groupName;

    public int getId() {
        return id;
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

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withContactNameData(ContactNameData contactNameData) {
        this.contactNameData = contactNameData;
        return this;
    }

    public ContactData withContactPhoneData(ContactPhoneData contactPhoneData) {
        this.contactPhoneData = contactPhoneData;
        return this;
    }

    public ContactData withContactEmailData(ContactEmailData contactEmailData) {
        this.contactEmailData = contactEmailData;
        return this;
    }

    public ContactData withContactOtherData(ContactOtherData contactOtherData) {
        this.contactOtherData = contactOtherData;
        return this;
    }

    public ContactData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public void convertToListData() {
        this.contactNameData.withMiddleName(null);
        this.contactNameData.withNickName(null);
        this.contactOtherData.withTitle(null);
        this.contactOtherData.withCompany(null);
        this.groupName = null;
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
                "id=" + getId() +
                ", contactNameData=" + getContactNameData() +
                ", contactPhoneData=" + getContactPhoneData() +
                ", contactEmailData=" + getContactEmailData() +
                ", contactOtherData=" + getContactOtherData() +
                ", groupName='" + getGroupName() + '\'' +
                '}';
    }

}

