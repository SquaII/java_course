package ru.stqa.pft.addressbook.model;

public class ContactOtherData {
    private final String title;
    private final String company;
    private final String address;

    public ContactOtherData() {
        this.title = null;
        this.company = null;
        this.address = null;
    }

    public ContactOtherData(String title, String company, String address) {
        this.title = title;
        this.company = company;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ContactOtherData{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
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
