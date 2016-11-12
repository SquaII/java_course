package ru.stqa.pft.addressbook.model;

public class ContactPhoneData {
    private final String fax;
    private final String work;
    private final String mobile;
    private final String home;

    public ContactPhoneData() {
        this.fax = null;
        this.work = null;
        this.mobile = null;
        this.home = null;
    }

    public ContactPhoneData(String fax, String work, String mobile, String home) {
        this.fax = fax;
        this.work = work;
        this.mobile = mobile;
        this.home = home;
    }

    public String getFax() {
        return fax;
    }

    public String getWork() {
        return work;
    }

    public String getMobile() {
        return mobile;
    }

    public String getHome() {
        return home;
    }

    @Override
    public String toString() {
        return "ContactPhoneData{" +
                "fax='" + fax + '\'' +
                ", work='" + work + '\'' +
                ", mobile='" + mobile + '\'' +
                ", home='" + home + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactPhoneData that = (ContactPhoneData) o;

        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (work != null ? !work.equals(that.work) : that.work != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        return home != null ? home.equals(that.home) : that.home == null;

    }

    @Override
    public int hashCode() {
        int result = fax != null ? fax.hashCode() : 0;
        result = 31 * result + (work != null ? work.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (home != null ? home.hashCode() : 0);
        return result;
    }
}
