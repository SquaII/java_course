package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

public class ContactNameData {
    @Expose
    private String firstName;
    @Expose
    private String middleName;
    @Expose
    private String lastName;
    @Expose
    private String nickName;

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public ContactNameData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactNameData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactNameData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactNameData withNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    @Override
    public String toString() {
        return "ContactNameData{" +
                "firstName='" + getFirstName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", nickName='" + getNickName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactNameData nameData = (ContactNameData) o;

        if (firstName != null ? !firstName.equals(nameData.firstName) : nameData.firstName != null) return false;
        if (middleName != null ? !middleName.equals(nameData.middleName) : nameData.middleName != null) return false;
        if (lastName != null ? !lastName.equals(nameData.lastName) : nameData.lastName != null) return false;
        return nickName != null ? nickName.equals(nameData.nickName) : nameData.nickName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        return result;
    }
}
