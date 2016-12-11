package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

public class ContactOtherData {
    @Expose
    private String title = "";
    @Expose
    private String company = "";

    @Type(type = "text")
    @Expose
    private String address = "";

    @Type(type = "text")
    @Expose
    private String address2 = "";

    @Type(type = "text")
    @Expose
    private String homepage = "";

    @Type(type = "text")
    @Expose
    private String notes = "";

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getNotes() {
        return notes;
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

    public ContactOtherData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactOtherData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public ContactOtherData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    @Override
    public String toString() {
        return "ContactOtherData{" +
                "title='" + getTitle() + '\'' +
                ", company='" + getCompany() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", address2='" + getAddress2() + '\'' +
                ", homepage='" + getHomepage() + '\'' +
                ", notes='" + getNotes() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactOtherData that = (ContactOtherData) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
