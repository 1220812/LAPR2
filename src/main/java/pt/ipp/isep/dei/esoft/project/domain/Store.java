package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.util.Objects;

public class Store {
    private String designation;
    private Address address;
    private String phoneNumber;
    private String emailAddress;
    private int ID;

    private static final int DEFAULT_ID = 0;
    private static final String DEFAULT_DESIGNATION = "no store designation";
    private static final Address DEFAULT_ADRESS = new Address();
    private static final String DEFAULT_EMAILADRESS = "no store email";
    private static final String DEFAULT_PHONENUMBER = "000-000-0000";

    public Store(String designation, Address address, String phoneNumber, String emailAddress, int ID) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    @Override
    public Store clone() {
        return new Store (this.designation, this.address, this.phoneNumber, this.emailAddress, this.ID);
    }

    public static Store newStore(String designation, String emailAddress, String phoneNumber, Address address, int ID){
       return StoreRepository.createStore(designation, emailAddress, phoneNumber, address, ID);

    }

}