package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Store {
    private String designation;
    private Address address;
    private int phoneNumber;
    private String emailAddress;
    private int ID;

    private static final int DEFAULT_ID = 0;
    private static final String DEFAULT_DESIGNATION = "no store designation";
    private static final Address DEFAULT_ADRESS = new Address(null, null, null , null, null);
    private static final String DEFAULT_EMAILADRESS = "no store email";
    private static final int DEFAULT_PHONENUMBER = 0;

    public Store(String designation, Address address, int phoneNumber, String emailAddress, int ID) {
        this.designation = designation;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.ID = ID;
    }

    public Store(){
        designation = DEFAULT_DESIGNATION;
        address = DEFAULT_ADRESS;
        phoneNumber = DEFAULT_PHONENUMBER;
        emailAddress = DEFAULT_EMAILADRESS;
        ID = DEFAULT_ID;
    }
    public Store(String designation, int ID){
        this.designation = designation;
        this.ID = ID;
    }


    public static boolean existID(int ID){
        if (ID <1000000 || ID >100000000){
            return false;
        }else{
            return true;
        }
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return phoneNumber == store.phoneNumber && ID == store.ID && Objects.equals(designation, store.designation) && Objects.equals(address, store.address) && Objects.equals(emailAddress, store.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation, address, phoneNumber, emailAddress, ID);
    }

    @Override
    public String toString() {
        return designation;
    }
    public String toString2(){
        return "Store{" +
                "designation='" + designation + '\'' +
                ", address=" + address +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", ID=" + ID +
                '}';
    }

    @Override
    public Store clone() throws CloneNotSupportedException {
        return new Store (this.designation, this.address, this.phoneNumber, this.emailAddress, this.ID);
    }

    public static Store newStore(String desigantion, String emailAddress, int phoneNumber, Address address, int ID){
        Store newStore = newStore(desigantion, emailAddress, phoneNumber, address, ID);
        return newStore;
    }

}