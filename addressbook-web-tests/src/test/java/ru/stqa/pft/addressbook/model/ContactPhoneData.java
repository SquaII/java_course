package ru.stqa.pft.addressbook.model;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactPhoneData {
    private List<String> phones = new ArrayList<>(Arrays.asList(null, null, null, null));

    public String getFax() {
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

    public ContactPhoneData withFax(String fax) {
        this.phones.set(3, fax);
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

    public ContactPhoneData withPhones(WebElement phonesData) {
        String[] phonesList = phonesData.getText().split("\n");
        for (int i=0; i < 4; i++) {
            if (i < phonesList.length && phonesList[i].equals("")) { this.phones.add(phonesList[i]);}
            else { this.phones.add(null);}
        }
        return this;
    }

    @Override
    public String toString() {
        return "ContactPhoneData{" +
                "fax='" + getFax() + '\'' +
                ", work='" + getWork() + '\'' +
                ", mobile='" + getMobile() + '\'' +
                ", home='" + getHome() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactPhoneData that = (ContactPhoneData) o;

        return phones != null ? phones.equals(that.phones) : that.phones == null;

    }

    @Override
    public int hashCode() {
        int result = getHome() != null ? getHome().hashCode() : 0;
        result = 31 * result + (getWork() != null ? getWork().hashCode() : 0);
        result = 31 * result + (getMobile() != null ? getMobile().hashCode() : 0);
        result = 31 * result + (getFax() != null ? getFax().hashCode() : 0);
        return result;
    }

}
