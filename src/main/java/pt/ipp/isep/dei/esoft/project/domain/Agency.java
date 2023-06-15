package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

public class Agency implements Serializable {

    /**
     * agency id
     */
    private int id;
    /**
     * agency designation
     */
    private String designation;
    /**
     * agency address
     */
    private Address address;
    /**
     * agency email address
     */
    private String emailAddress;
    /**
     * agency phone number
     */
    private String phoneNumber;
    /**
     * default agency id
     */
    private static final int DEFAULT_ID = 0;
    /**
     * default agency designation
     */
    private static final String DEFAULT_DESIGNATION = "no agency designation";
    /**
     * default agency address
     */
    private static final Address DEFAULT_ADDRESS = new Address();
    /**
     * default agency email address
     */
    private static final String DEFAULT_EMAIL_ADDRESS = "no agency email";
    /**
     * default agency phone number
     */
    private static final String DEFAULT_PHONE_NUMBER = "000-000-000";

    /**
     * This method creates a new instance of Agency
     *
     * @param id           agency id
     * @param designation  agency designation
     * @param address      agency address
     * @param emailAddress agency email address
     * @param phoneNumber  agency phone number
     */

    public Agency(int id, String designation, Address address, String emailAddress, String phoneNumber) {
        this.id = id;
        this.designation = designation;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method creates a new instance of Agency with all the attributes by default
     */

    public Agency() {
        designation = DEFAULT_DESIGNATION;
        address = DEFAULT_ADDRESS;
        phoneNumber = DEFAULT_PHONE_NUMBER;
        emailAddress = DEFAULT_EMAIL_ADDRESS;
        id = DEFAULT_ID;
    }

    /**
     * Method to compare the attributes of the current object with those of another object
     *
     * @param o object that will be compared with
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Agency)) {
            return false;
        }
        Agency that = (Agency) o;
        return id == that.id;
    }

    /**
     * Method to show the ID
     *
     * @return id
     */

    public int getID() {
        return id;
    }

    /**
     * Method to show the designation
     *
     * @return designation
     */

    public String getDesignation() {
        return designation;
    }

    /**
     * Method to show the address
     *
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Method to show the phone number
     *
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to show the email address
     *
     * @return email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Method to change the address
     *
     * @param address new address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Method to change the designation
     *
     * @param designation new designation
     */

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Method to change the email address
     *
     * @param emailAddress new email address
     */

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Method to change the ID
     *
     * @param id new ID
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method to change the phone number
     *
     * @param phoneNumber new phone number
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method to return a hash code for the object in order to ensure that this hash code will not collide with the others
     *
     * @return hash code
     */

    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Method to show the Agency characteristics
     *
     * @return String with te Agency characteristics
     */

    public String toString() {
        return "Agency : " +
                "\n" +
                " id = " + id +
                ", designation = " + designation +
                ", address = " + address +
                ", emailAddress = " + emailAddress +
                ", phoneNumber = " + phoneNumber;
    }

    /**
     * This method creates a new instance of the agency object and initializes its attributes with the exact same values of the original object
     *
     * @return a clone of the agency object
     */

    public Agency clone() {
        return new Agency(this.id, this.designation, this.address, this.emailAddress, this.phoneNumber);
    }
}