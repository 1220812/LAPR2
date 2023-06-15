package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

public class Client extends User implements Serializable {
    /**
     * name of the client
     */
    private String name;
    /**
     * phone number of the client
     */
    private String phoneNumber;
    /**
     * email address of the client
     */
    private String emailAddress;
    /**
     * tax number of the client
     */
    private TaxNumber taxNumber;
    /**
     * passport card number of the client
     */
    private PassportCardNumber passportCardNumber;
    /**
     * address of the client
     */
    private Address address;
    /**
     * Method that shows the phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Method to change the phone number
     * @param phoneNumber changed phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Method to show the email address
     * @return email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
     * Method to change the email address
     * @param emailAddress changed email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /**
     * Method to show the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to change the name
     * @param name changed name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to show the tax number
     * @return tax number
     */
    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    /**
     * Method to show the passport card number
     * @return passport card number
     */
    public PassportCardNumber getPassportCardNumber() {
        return passportCardNumber;
    }

    /**
     * Method to change the tax number
     * @param taxNumber changed tax number
     */
    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * Method to change the passport card number
     * @param passportCardNumber changed passport card number
     */
    public void setPassportCardNumber(PassportCardNumber passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }

    /**
     * Method to show the address
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Method to change the address
     * @param address changed address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Creates an instance of Client with name, phone number, email address, address, tax number and passport card number
     * @param name Client's name
     * @param phoneNumber Client´s phone number
     * @param emailAddress Client's email address
     * @param address Client's address
     * @param taxNumber Client's tax number
     * @param passportCardNumber Client's passport card number
     */

    public Client(String name, String phoneNumber, String emailAddress, Address address, TaxNumber taxNumber, PassportCardNumber passportCardNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.taxNumber = taxNumber;
        this.passportCardNumber = passportCardNumber;
    }

    /**
     * Creates an instance of Client with name, phone number, email address, tax number and passport card number
     * @param name name of the client
     * @param phoneNumber phone number of the client
     * @param emailAddress email address of the client
     * @param taxNumber tax number of the client
     * @param passportCardNumber passport card number of the client
     */
    public Client(String name, String phoneNumber, String emailAddress, TaxNumber taxNumber, PassportCardNumber passportCardNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.taxNumber = taxNumber;
        this.passportCardNumber = passportCardNumber;
    }

    /**
     * Creates an instance of Client with name
     * @param name name of the client
     */
    public Client(String name){
        this.name = name;
    }
    /**
     * Compares two instances of Client
     * @param o other instance of Client
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return phoneNumber == client.phoneNumber && Objects.equals(name, client.name) && Objects.equals(emailAddress, client.emailAddress) && Objects.equals(taxNumber, client.taxNumber) && Objects.equals(passportCardNumber, client.passportCardNumber) && Objects.equals(address, client.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, emailAddress, taxNumber, passportCardNumber, address);
    }

    /**
     * Textual representation of an instance of Client
     */
    @Override
    public String toString() {
        return name;
    }

    public Client clone(){ return new Client(this.name,this.phoneNumber, this.emailAddress,this.address,this.taxNumber,this.passportCardNumber); }
}
