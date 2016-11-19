package ru.stqa.pft.addressbook.model;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactPhoneData {
    private List<String> phones = new ArrayList<>();

    public ContactPhoneData() {
        for (int i=0; i < 4; i++) {
            phones.add(null);
        }
    }

    public ContactPhoneData(String home, String mobile, String work, String fax) {
        this.phones.add(home);
        this.phones.add(mobile);
        this.phones.add(work);
        this.phones.add(fax);
    }

    public ContactPhoneData(WebElement phonesData) {
        String[] phonesList = phonesData.getText().split("\n");
        for (int i=0; i < 4; i++) {
            if (i < phonesList.length && phonesList[i].equals("")) { this.phones.add(phonesList[i]);}
            else { this.phones.add(null);}
        }
    }

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
