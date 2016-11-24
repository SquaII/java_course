package ru.stqa.pft.addressbook.model;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactEmailData {
    private List<String> emails = new ArrayList<>(Arrays.asList(null, null, null));
    private boolean isListData = false;

    public String getEmail1() {
        return emails.get(0);
    }

    public String getEmail2() {
        return emails.get(1);
    }

    public String getEmail3() {
        return emails.get(2);
    }

    public ContactEmailData withEmail1(String email1) {
        this.emails.set(0, email1);
        return this;
    }

    public ContactEmailData withEmail2(String email2) {
        this.emails.set(1, email2);
        return this;
    }

    public ContactEmailData withEmail3(String email3) {
        this.emails.set(2, email3);
        return this;
    }

    public ContactEmailData withEmails(List<WebElement> emailsList) {
        for (int i=0; i < emailsList.size(); i++) {
            this.emails.set(i, emailsList.get(i).getText());
        }
        return this;
    }

    public ContactEmailData withAsListData(boolean flag) {
        this.isListData = flag;
        return this;
    }

    @Override
    public String toString() {
        return "ContactEmailData{" +
                "email='" + getEmail1() + '\'' +
                ", email2='" + getEmail2() + '\'' +
                ", email3='" + getEmail3() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactEmailData that = (ContactEmailData) o;
        if (this.isListData) {
            return emails != null ? this.hashCode() == that.hashCode() : that.emails == null;
        } else {
            return emails != null ? emails.equals(that.emails) : that.emails == null;
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
        if (this.isListData) {
            result = result + 31 * (getEmail1() != null ? getEmail1().hashCode() : 0);
            result = result + 31 * (getEmail2() != null ? getEmail2().hashCode() : 0);
            result = result + 31 * (getEmail3() != null ? getEmail3().hashCode() : 0);
        } else {
            result = 31 * result + (getEmail1() != null ? getEmail1().hashCode() : 0);
            result = 31 * result + (getEmail2() != null ? getEmail2().hashCode() : 0);
            result = 31 * result + (getEmail3() != null ? getEmail3().hashCode() : 0);
        }
        return result;
    }
}
