package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

public class User implements Serializable {

    // ATTRIBUTES

    private String name;
    private String emailAddress;

    private String phoneNumber;
    private String password;

    private final String NAME_BY_DEFAULT = "[NO DATA]";

    private final String PHONE_NUMBER_BY_DEFAULT = "000-000-0000";
    private final String EMAIL_ADDRESS_BY_DEFAULT = "[NO DATA]";
    private final String PASSWORD_BY_DEFAULT = "[NO DATA]";
    private PassportCardNumber passportCardNumber;
    private TaxNumber taxNumber;

    // CONSTRUCTORS

    public User() {
        this.name = NAME_BY_DEFAULT;
        this.emailAddress = EMAIL_ADDRESS_BY_DEFAULT;
        this.password = PASSWORD_BY_DEFAULT;
        this.phoneNumber = PHONE_NUMBER_BY_DEFAULT;
    }

    /**
     *
     * @param name name
     * @param emailAddress email
     * @param password pwd
     */
    public User(String name, String emailAddress, String password, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method creates a new instance of User with the following parameters
     * @param name name of the user
     * @param emailAddress email address
     * @param passportCardNumber passport card number
     * @param taxNumber tax number
     * @param phoneNumber phone number
     */
    public User(String name, String emailAddress, PassportCardNumber passportCardNumber, TaxNumber taxNumber, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.passportCardNumber = passportCardNumber;
        this.phoneNumber = phoneNumber;
        this.taxNumber = taxNumber;
    }
    // SETS AND GETS

    /**
     * Method to show the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to change the name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
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
     * @param emailAddress email
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Method to show the password
     * @return password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Method to change the password
     * @param password pwd
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to show the phoneNumber
     * @return phone number
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to change the phoneNumber
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    // TOSTRING

    /**
     * Method to show a String with the user characteristics
     * @return user characteristics
     */
    @Override
    public String toString() {
        return "User" +
                " name : " + name + '\'' +
                " emailAddress='" + emailAddress + '\'' +
                " phoneNumber=" + phoneNumber;
    }
    public User clone(){
        return new User(this.name,this.emailAddress,this.password,this.phoneNumber);
    }

    public static boolean existsEmail(String email) {
        if (!(email.contains("@") && email.contains("."))) {
            return false;
        }
        return true;
    }
    public String getEmail() {
        return this.emailAddress;
    }
}