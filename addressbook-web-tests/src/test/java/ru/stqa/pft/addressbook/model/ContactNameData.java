package ru.stqa.pft.addressbook.model;

public class ContactNameData {
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;

    public ContactNameData(String firstName, String middleName, String lastName, String nickName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
    }

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

    public void setFirstName(String firstName) {this.firstName = firstName; }
    public void setMiddleName(String middleName) {this.middleName= middleName; }
    public void setLastName(String lastName) {this.lastName = lastName; }
    public void setNickName(String nickName) {this.nickName = nickName; }

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
