package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private ContactNameData contactNameData;
    private ContactPhoneData contactPhoneData;
    private ContactEmailData contactEmailData;
    private ContactOtherData contactOtherData;
    private String groupName;
    private boolean isListData = false;

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
        this.contactPhoneData = contactPhoneData.withAsListData(this.isListData);
        return this;
    }

    public ContactData withContactEmailData(ContactEmailData contactEmailData) {
        this.contactEmailData = contactEmailData.withAsListData(this.isListData);
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

    public ContactData withAsListData(boolean flag) {
        this.isListData = flag;
        return this;
    }

    public ContactData getListData() {
        ContactData contactData = new ContactData().withAsListData(true)
            .withId(this.id)
            .withContactNameData(new ContactNameData()
                .withFirstName(this.contactNameData.getFirstName()).withLastName(this.contactNameData.getLastName()))
            .withContactEmailData(new ContactEmailData()
                .withEmail1(this.contactEmailData.getEmail1())
                .withEmail2(this.contactEmailData.getEmail2())
                .withEmail3(this.contactEmailData.getEmail3()))
            .withContactPhoneData(new ContactPhoneData()
                .withHome(this.contactPhoneData.getHome()).withMobile(this.contactPhoneData.getMobile())
                .withWork(this.contactPhoneData.getWork()).withHome2(this.contactPhoneData.getHome2()).withCleanPhones())
            .withContactOtherData(new ContactOtherData().withAddress(this.getContactOtherData().getAddress()));
        return contactData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (contactNameData != null ? !contactNameData.equals(that.contactNameData) : that.contactNameData != null)
            return false;
        if (contactPhoneData != null ? !contactPhoneData.equals(that.contactPhoneData) : that.contactPhoneData != null)
            return false;
        if (contactEmailData != null ? !contactEmailData.equals(that.contactEmailData) : that.contactEmailData != null)
            return false;
        if (contactOtherData != null ? !contactOtherData.equals(that.contactOtherData) : that.contactOtherData != null)
            return false;
        return groupName != null ? groupName.equals(that.groupName) : that.groupName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (contactNameData != null ? contactNameData.hashCode() : 0);
        result = 31 * result + (contactPhoneData != null ? contactPhoneData.hashCode() : 0);
        result = 31 * result + (contactEmailData != null ? contactEmailData.hashCode() : 0);
        result = 31 * result + (contactOtherData != null ? contactOtherData.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
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

