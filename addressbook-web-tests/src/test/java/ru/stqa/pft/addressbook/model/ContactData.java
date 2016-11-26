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

    public String getFirstName() {
        return contactNameData.getFirstName();
    }

    public String getMiddleName() {
        return contactNameData.getMiddleName();
    }

    public String getLastName() {
        return contactNameData.getLastName();
    }

    public String getNickName() {
        return contactNameData.getNickName();
    }

    public String getEmail1() {
        return contactEmailData.getEmail1();
    }

    public String getEmail2() {
        return contactEmailData.getEmail2();
    }

    public String getEmail3() {
        return contactEmailData.getEmail3();
    }

    public String getHomePhone() {
        return contactPhoneData.getHome();
    }

    public String getHomePhone2() {
        return contactPhoneData.getHome2();
    }

    public String getFax() {
        return contactPhoneData.getFax();
    }

    public String getMobilePhone() {
        return contactPhoneData.getMobile();
    }

    public String getWorkPhone() {
        return contactPhoneData.getWork();
    }

    public String getAddress() {
        return contactOtherData.getAddress();
    }

    public String getAddress2() {
        return contactOtherData.getAddress2();
    }

    public String getTitle() {
        return contactOtherData.getTitle();
    }

    public String getHomepage() {
        return contactOtherData.getHomepage();
    }

    public String getCompany() {
        return contactOtherData.getCompany();
    }

    public String getNotes() {
        return contactOtherData.getNotes();
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
        return new ContactData().withAsListData(true)
            .withId(id)
            .withContactNameData(new ContactNameData()
                .withFirstName(getFirstName()).withLastName(getLastName()))
            .withContactEmailData(new ContactEmailData()
                .withEmail1(getEmail1())
                .withEmail2(getEmail2())
                .withEmail3(getEmail3()))
            .withContactPhoneData(new ContactPhoneData()
                .withHome(getHomePhone()).withMobile(getMobilePhone())
                .withWork(getWorkPhone()).withHome2(getHomePhone2()).withCleanPhones())
            .withContactOtherData(new ContactOtherData().withAddress(getContactOtherData().getAddress()));
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

