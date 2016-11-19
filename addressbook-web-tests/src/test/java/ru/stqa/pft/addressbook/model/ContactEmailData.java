package ru.stqa.pft.addressbook.model;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactEmailData {
    private List<String> emails = new ArrayList<>();

    public ContactEmailData() {
        for (int i=0; i < 3; i++) {
            emails.add(null);
        }
    }

    public ContactEmailData(String email, String email2, String email3) {
        this.emails.add(email);
        this.emails.add(email2);
        this.emails.add(email3);
    }

    public ContactEmailData(List<WebElement> emailsList) {
        for (int i=0; i < 3; i++) {
            if (i < emailsList.size()) { this.emails.add(emailsList.get(i).getText());}
            else { this.emails.add(null);}
        }
    }

    public String getEmail1() {
        return emails.get(0);
    }

    public String getEmail2() {
        return emails.get(1);
    }

    public String getEmail3() {
        return emails.get(2);
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
