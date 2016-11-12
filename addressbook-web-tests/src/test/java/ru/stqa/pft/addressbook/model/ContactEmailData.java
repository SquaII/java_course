package ru.stqa.pft.addressbook.model;

public class ContactEmailData {
    private final String email;
    private final String email2;
    private final String email3;

    public ContactEmailData() {
        this.email = null;
        this.email2 = null;
        this.email3 = null;
    }

    public ContactEmailData(String email, String email2, String email3) {
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    @Override
    public String toString() {
        return "ContactEmailData{" +
                "email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEmailData that = (ContactEmailData) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        return email3 != null ? email3.equals(that.email3) : that.email3 == null;

    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        return result;
    }
}
