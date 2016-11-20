package ru.stqa.pft.addressbook.model;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactEmailData {
    private List<String> emails = new ArrayList<>(Arrays.asList(null, null, null));

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
        for (int i=0; i < 3; i++) {
            if (i < emailsList.size()) { this.emails.add(emailsList.get(i).getText());}
            else { this.emails.add(null);}
        }
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

        ContactEmailData emailData = (ContactEmailData) o;

        return emails != null ? emails.equals(emailData.emails) : emailData.emails == null;

    }

    @Override
    public int hashCode() {
        int result = getEmail1() != null ? getEmail1().hashCode() : 0;
        result = 31 * result + (getEmail2() != null ? getEmail2().hashCode() : 0);
        result = 31 * result + (getEmail3() != null ? getEmail3().hashCode() : 0);
        return result;
    }
}
