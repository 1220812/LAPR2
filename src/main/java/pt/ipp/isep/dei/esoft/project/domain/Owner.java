package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Owner {
    /**
     * name of the owner
     */
    private String name;
    /**
     * phone number of the owner
     */
    private int phoneNumber;
    /**
     * email address of the owner
     */
    private String emailAddress;
    /**
     * tax number of the owner
     */
    private TaxNumber taxNumber;
    /**
     * passport card number of the owner
     */
    private PassportCardNumber passportCardNumber;
    /**
     * address of the owner
     */
    private Address address;
    /**
     * Method that shows the phone number
     * @return phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Method to change the phone number
     * @param phoneNumber changed phone number
     */
    public void setPhoneNumber(int phoneNumber) {
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
     * This method creates an owner with name, phone number and email address
     * @param name name of the owner
     * @param phoneNumber phone number of the owner
     * @param emailAddress email address of the owner
     */

    public Owner(String name, int phoneNumber, String emailAddress, Address address, TaxNumber taxNumber, PassportCardNumber passportCardNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.taxNumber = taxNumber;
        this.passportCardNumber = passportCardNumber;
    }
    /**
     * Compares two instances of Owner
     * @param o other instance of Owner
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return phoneNumber == owner.phoneNumber && Objects.equals(name, owner.name) && Objects.equals(emailAddress, owner.emailAddress) && Objects.equals(taxNumber, owner.taxNumber) && Objects.equals(passportCardNumber, owner.passportCardNumber) && Objects.equals(address, owner.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, emailAddress, taxNumber, passportCardNumber, address);
    }

    /**
     * Textual representation of an instance of Owner
     */
    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", taxNumber=" + taxNumber +
                ", passportCardNumber=" + passportCardNumber +
                ", address=" + address +
                '}';
    }
}
