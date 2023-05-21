package pt.ipp.isep.dei.esoft.project.domain;

public class User {

    // ATTRIBUTES

    private String name;
    private String emailAddress;

    private String phoneNumber;
    private String password;

    private final String NAME_BY_DEFAULT = "[NO DATA]";

    private final String PHONE_NUMBER_BY_DEFAULT = "000-000-000";
    private final String EMAIL_ADDRESS_BY_DEFAULT = "[NO DATA]";
    private final String PASSWORD_BY_DEFAULT = "[NO DATA]";

    // CONSTRUCTORS

    public User() {
        this.name = NAME_BY_DEFAULT;
        this.emailAddress = EMAIL_ADDRESS_BY_DEFAULT;
        this.password = PASSWORD_BY_DEFAULT;
        this.phoneNumber = PHONE_NUMBER_BY_DEFAULT;
    }

    /**
     *
     * @param name
     * @param emailAddress
     * @param password
     */
    public User(String name, String emailAddress, String password, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
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
     * @param name
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
     * @param emailAddress email address
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
     * @param password
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
     * @param phoneNumber
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
        return "User{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                ", NAME_BY_DEFAULT='" + NAME_BY_DEFAULT + '\'' +
                ", PHONE_NUMBER=" + PHONE_NUMBER_BY_DEFAULT +
                ", EMAIL_ADDRESS_BY_DEFAULT='" + EMAIL_ADDRESS_BY_DEFAULT + '\'' +
                ", PASSWORD_BY_DEFAULT='" + PASSWORD_BY_DEFAULT + '\'' +
                '}';
    }
    public User clone(){
        return new User(this.name,this.emailAddress,this.password,this.phoneNumber);
    }
}