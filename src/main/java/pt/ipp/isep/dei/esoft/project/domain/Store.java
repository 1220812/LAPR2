package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Store.
 */
public class Store implements Serializable {
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

    /**
     * Instantiates a new Store.
     *
     * @param designation  the designation
     * @param address      the address
     * @param phoneNumber  the phone number
     * @param emailAddress the email address
     * @param ID           the id
     */
    public Store(String designation, Address address, String phoneNumber, String emailAddress, int ID) {
        this.designation = designation;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.ID = ID;
    }

    /**
     * Instantiates a new Store.
     */
    public Store(){
        designation = DEFAULT_DESIGNATION;
        address = DEFAULT_ADRESS;
        phoneNumber = DEFAULT_PHONENUMBER;
        emailAddress = DEFAULT_EMAILADRESS;
        ID = DEFAULT_ID;
    }

    /**
     * Instantiates a new Store.
     *
     * @param designation the designation
     * @param ID          the id
     */
    public Store(String designation, int ID){
        this.designation = designation;
        this.ID = ID;
    }

    /**
     * Exist id boolean.
     *
     * @param ID the id
     * @return the boolean
     */
    public static boolean existID(int ID){
        if (ID <1000000 || ID >100000000){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets designation.
     *
     * @param designation the designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getID() {
        return ID;
    }

    /**
     * Sets id.
     *
     * @param ID the id
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(phoneNumber, store.phoneNumber) && ID == store.ID && Objects.equals(designation, store.designation) && Objects.equals(address, store.address) && Objects.equals(emailAddress, store.emailAddress);
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

    /**
     * New store.
     *
     * @param designation  the designation
     * @param emailAddress the email address
     * @param phoneNumber  the phone number
     * @param address      the address
     * @param ID           the id
     * @return the store
     */
    public static Store newStore(String designation, String emailAddress, String phoneNumber, Address address, int ID){
       return StoreRepository.createStore(designation, emailAddress, phoneNumber, address, ID);

    }

}