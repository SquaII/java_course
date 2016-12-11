package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import org.openqa.selenium.WebElement;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactPhoneData {

    @Type(type = "text")
    private String home = "";

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobile = "";

    @Type(type = "text")
    private String work = "";

    @Type(type = "text")
    private String fax = "";

    @Column(name = "phone2")
    @Type(type = "text")
    private String home2 = "";

    @Transient
    @Expose
    private List<String> phones = new ArrayList<>(Arrays.asList("", "", "", "", ""));

    @Transient
    @XStreamOmitField
    private boolean isListData = false;

    public String getFax() {
        return phones.get(4);
    }

    public String getHome2() {
        return phones.get(3);
    }

    public String getWork() {
        return phones.get(2);
    }

    public String getMobile() {
        return phones.get(1);
    }

    public String getHome() {
        return phones.get(0);
    }

    public ContactPhoneData withHome2(String home2) {
        this.phones.set(3, home2);
        return this;
    }

    public ContactPhoneData withFax(String fax) {
        this.phones.set(4, fax);
        return this;
    }

    public ContactPhoneData withWork(String work) {
        this.phones.set(2, work);
        return this;
    }

    public ContactPhoneData withMobile(String mobile) {
        this.phones.set(1, mobile);
        return this;
    }

    public ContactPhoneData withHome(String home) {
        this.phones.set(0, home);
        return this;
    }

    public ContactPhoneData withAsListData(boolean flag) {
        this.isListData = flag;
        return this;
    }

    public ContactPhoneData withPhones(WebElement phonesData) {
        String[] phonesList = phonesData.getText().split("\n");
        for (int i = 0; i < phonesList.length; i++) {
            if (! phonesList[i].equals("")) { this.phones.set(i, phonesList[i]); }
            else { this.phones.add(null); }
        }
        return this;
    }

    public ContactPhoneData withCleanPhones() {
        for (int i = 0; i < this.phones.size(); i++) {
            if (phones.get(i) != null) {
                phones.set(i, phones.get(i).replaceAll("\\s", "").replaceAll("[-()]", ""));
            }
        }
        return this;
    }

    public void fixDBData() {
        phones.set(0, home);
        phones.set(1, mobile);
        phones.set(2, work);
        phones.set(3, home2);
        phones.set(4, fax);
    }

    @Override
    public String toString() {
        return "ContactPhoneData{" +
                "fax='" + getFax() + '\'' +
                ", work='" + getWork() + '\'' +
                ", mobile='" + getMobile() + '\'' +
                ", home='" + getHome() + '\'' +
                ", home2='" + getHome2() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPhoneData that = (ContactPhoneData) o;
        if (this.isListData) {
            return phones != null ? this.hashCode() == that.hashCode() : that.phones == null;
        } else {
            return phones != null ? phones.equals(that.phones) : that.phones == null;
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
        if (this.isListData) {
            result = result + 31 * (getHome() != null ? getHome().hashCode() : 0);
            result = result + 31 * (getHome2() != null ? getHome2().hashCode() : 0);
            result = result + 31 * (getWork() != null ? getWork().hashCode() : 0);
            result = result + 31 * (getMobile() != null ? getMobile().hashCode() : 0);
            result = result + 31 * (getFax() != null ? getFax().hashCode() : 0);
        } else {
            result = 31 * result + (getHome() != null ? getHome().hashCode() : 0);
            result = 31 * result + (getHome2() != null ? getHome2().hashCode() : 0);
            result = 31 * result + (getWork() != null ? getWork().hashCode() : 0);
            result = 31 * result + (getMobile() != null ? getMobile().hashCode() : 0);
            result = 31 * result + (getFax() != null ? getFax().hashCode() : 0);
        }
        return result;
    }

}
