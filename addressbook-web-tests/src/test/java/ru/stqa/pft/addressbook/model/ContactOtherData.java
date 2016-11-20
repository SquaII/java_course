package ru.stqa.pft.addressbook.model;

public class ContactOtherData {
    private String title;
    private String company;
    private String address;

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public ContactOtherData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactOtherData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactOtherData withAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "ContactOtherData{" +
                "title='" + getTitle() + '\'' +
                ", company='" + getCompany() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactOtherData that = (ContactOtherData) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
