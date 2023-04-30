package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Store {
    private String designation;
    private String location;
    private int phoneNumber;
    private String emailAddress;
    private int ID;

    private Localization localization;

    private static final String DEFAULT_DESIGNATION = "No name";
    private static final String DEFAULT_LOCATION = "No location";
    private static final int DEFAULT_PHONENUMBER = 000000000;
    private static final String DEFAULT_EMAILADDRESS = "No name";
    private static final int DEFAULT_ID = 00000000;

    public Store(String designation, String location, int phoneNumber, String emailAddress, int ID, Localization localization) {
        this.designation = designation;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.ID = ID;
        this.localization = localization;
    }

    public Store(){
        this.designation = DEFAULT_DESIGNATION;
        this.location = DEFAULT_LOCATION;
        this.phoneNumber = DEFAULT_PHONENUMBER;
        this.emailAddress = DEFAULT_EMAILADDRESS;
        this.ID = DEFAULT_ID;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Localization getLocalization (){return localization;}

    public void setLocalization (Localization localization){this.localization=localization;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return phoneNumber == store.phoneNumber && ID == store.ID && Objects.equals(designation, store.designation) && Objects.equals(location, store.location) && Objects.equals(emailAddress, store.emailAddress) && Objects.equals(localization, store.localization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation, location, phoneNumber, emailAddress, ID, localization);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "designation='" + designation + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", ID=" + ID + '\'' +
                ", localization=" + localization  +
                '}';
    }

    @Override
    protected Store clone() throws CloneNotSupportedException {
        return new Store (this.designation, this.location, this.phoneNumber, this.emailAddress,this.ID, this.localization);
    }
}
