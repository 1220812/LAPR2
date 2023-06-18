package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * The type Network manager.
 */
public class NetworkManager implements Serializable {
    /**
     * Name of the Network Manager
     */
    private String name;
    /**
     * Phone Number of the Network Manager
     */
    private String phoneNumber;
    /**
     * Email Address of the Network Manager
     */
    private String emailAddress;
    /**
     * Tax Number of the Network Manager
     */
    private TaxNumber taxNumber;
    /**
     * Passport Card Number of the Network Manager
     */
    private PassportCardNumber passportCardNumber;
    /**
     * Address of the Network Manager
     */
    private Address address;
    /**
     * Role of the Network Manager
     */
    private Role role;
    /**
     * Agency of the Network Manager
     */
    private Agency agency;
    /**
     * Password of the Network Manager
     */
    private String pass;

    /**
     * This method creates a new instance of Network Manager
     *
     * @param name               Name of the Network Manager
     * @param email              Email Address of the Network Manager
     * @param phone              phone Number of the Network Manager
     * @param passportCardNumber Passport Card Number of the Network Manager
     * @param taxNumber          Tax Number of the Network Manager
     * @param address            Address of the Network Manager
     * @param role               Role of the Network Manager
     * @param agency             Agency of the Network Manager
     * @param pass               Password of the Network Manager
     */
    public NetworkManager(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, String pass) {
        this.name = name;
        this.emailAddress = email;
        this.phoneNumber = phone;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.role = role;
        this.agency = agency;
        this.pass = pass;

    }

    /**
     * This method returns the name of the Network Manager
     *
     * @return name of the Network Manager
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of the Network Manager
     *
     * @param name name of the Network Manager
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the phone number of the Network Manager
     *
     * @return phone number of the Network Manager
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method sets the phone number of the Network Manager
     *
     * @param phoneNumber phone number of the Network Manager
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method returns the email address of the Network Manager
     *
     * @return email address of the Network Manager
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * This method sets the email address of the Network Manager
     *
     * @param emailAddress email address of the Network Manager
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * This method returns the tax number of the Network Manager
     *
     * @return tax number of the Network Manager
     */
    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    /**
     * This method sets the tax number of the Network Manager
     *
     * @param taxNumber tax number of the Network Manager
     */
    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * This method returns the passport card number of the Network Manager
     *
     * @return passport card number of the Network Manager
     */
    public PassportCardNumber getPassportCardNumber() {
        return passportCardNumber;
    }

    /**
     * This method sets the passport card number of the Network Manager
     *
     * @param passportCardNumber passport card number of the Network Manager
     */
    public void setPassportCardNumber(PassportCardNumber passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }

    /**
     * This method returns the address of the Network Manager
     *
     * @return address of the Network Manager
     */
    public Address getAddress() {
        return address;
    }

    /**
     * This method sets the address of the Network Manager
     *
     * @param address address of the Network Manager
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * This method returns the role of the Network Manager
     *
     * @return role of the Network Manager
     */
    public Role getRole() {
        return role;
    }

    /**
     * This method sets the role of the Network Manager
     *
     * @param role role of the Network Manager
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * This method returns the agency of the Network Manager
     *
     * @return agency of the Network Manager
     */
    public Agency getAgency() {
        return agency;
    }

    /**
     * This method sets the agency of the Network Manager
     *
     * @param agency agency of the Network Manager
     */
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    /**
     * This method returns the password of the Network Manager
     *
     * @return password of the Network Manager
     */
    public String getPass() {
        return pass;
    }

    /**
     * This method sets the password of the Network Manager
     *
     * @param pass password of the Network Manager
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * This method returns the string representation of the Network Manager, with all Network Manager characteristics
     * @return string representation of the Network Manager
     */

    @Override
    public String toString() {
        return "NetworkManager : " + "\n" +
                "name = " + name + '\'' +
                ", phoneNumber = " + phoneNumber + '\'' +
                ", emailAddress = " + emailAddress + '\'' +
                ", taxNumber = " + taxNumber +
                ", passportCardNumber = " + passportCardNumber +
                ", address = " + address +
                ", role = " + role +
                ", agency = " + agency +
                ", pass = " + pass;
    }

    /**
     * Method that creates a clone of the Network Manager
     * @return clone of the Network Manager
     */
    public NetworkManager clone() {
        return new NetworkManager(this.name, this.emailAddress, this.phoneNumber, this.passportCardNumber, this.taxNumber, this.address, this.role, this.agency, this.pass);
    }

}
