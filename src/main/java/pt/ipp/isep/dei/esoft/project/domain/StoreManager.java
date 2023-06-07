package pt.ipp.isep.dei.esoft.project.domain;

public class StoreManager {
    /**
     * name of the store manager
     */
    private String name;
    /**
     * phone number of the store manager
     */
    private String phoneNumber;
    /**
     * email address of the store manager
     */
    private String emailAddress;
    /**
     * tax number of the store manager
     */
    private TaxNumber taxNumber;
    /**
     * passport card number of the store manager
     */
    private PassportCardNumber passportCardNumber;
    /**
     * address of the store manager
     */
    private Address address;
    /**
     * role of the store manager
     */
    private Role role;
    /**
     * agency of the store manager
     */
    private Agency agency;
    /**
     * store of the store manager
     */
    private Store store;
    /**
     * password of the store manager
     */
    private String pass;

    /**
     * This method creates a new instance of StoreManager
     *
     * @param name               name of the store manager
     * @param email              email address of the store manager
     * @param phone              phone number of the store manager
     * @param passportCardNumber passport card number of the store manager
     * @param taxNumber          tax number of the store manager
     * @param address            address of the store manager
     * @param role               role of the store manager
     * @param agency             agency of the store manager
     * @param store              store of the store manager
     * @param pass               password of the store manager
     */
    public StoreManager(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, Store store, String pass) {
        this.name = name;
        this.emailAddress = email;
        this.phoneNumber = phone;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.role = role;
        this.agency = agency;
        this.store = store;
        this.pass = pass;

    }
    /**
     * This method shows the name of the store manager
     * @return name of the store manager
     */
    public String getName() {
        return name;
    }
    /**
     * This method changes the name of the store manager
     * @param name name of the store manager
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method shows the phone number of the store manager
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * This method changes the phone number of the store manager
     * @param phoneNumber phone number of the store manager
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * This method shows the email address of the store manager
     * @return email address of the store manager
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
     * This method changes the email address of the store manager
     * @param emailAddress email address of the store manager
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /**
     * This method shows the tax number of the store manager
     * @return tax number of the store manager
     */
    public TaxNumber getTaxNumber() {
        return taxNumber;
    }
    /**
     * This method changes the tax number of the store manager
     * @param taxNumber tax number of the store manager
     */
    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }
    /**
     * This method shows the passport card number of the store manager
     * @return passport card number of the store manager
     */
    public PassportCardNumber getPassportCardNumber() {
        return passportCardNumber;
    }
    /**
     * This method changes the passport card number of the store manager
     * @param passportCardNumber passport card number of the store manager
     */
    public void setPassportCardNumber(PassportCardNumber passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }
    /**
     * This method shows the address of the store manager
     * @return address of the store manager
     */
    public Address getAddress() {
        return address;
    }
    /**
     * This method changes the address of the store manager
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    /**
     * This method shows the role of the store manager
     * @return role of the store manager
     */
    public Role getRole() {
        return role;
    }
    /**
     * This method changes the role of the store manager
     * @param role role of the store manager
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * This method shows the agency of the store manager
     * @return agency of the store manager
     */
    public Agency getAgency() {
        return agency;
    }

    /**
     * This method changes the agency of the store manager
     * @param agency agency of the store manager
     */
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    /**
     * This method shows the store of the store manager
     * @return store of the store manager
     */
    public Store getStore() {
        return store;
    }
    /**
     * This method changes the store of the store manager
     * @param store store of the store manager
     */
    public void setStore(Store store) {
        this.store = store;
    }
    /**
     * This method shows the password of the store manager
     * @return password of the store manager
     */
    public String getPass() {
        return pass;
    }

    /**
     * This method changes the password of the store manager
     * @param pass password of the store manager
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Method to print the store manager characteristics
     * @return store manager characteristics
     */
    @Override
    public String toString() {
        return "StoreManager : " + "\n" +
                "name = " + name + '\'' +
                ", phoneNumber = " + phoneNumber + '\'' +
                ", emailAddress = " + emailAddress + '\'' +
                ", taxNumber = " + taxNumber +
                ", passportCardNumber = " + passportCardNumber +
                ", address = " + address +
                ", role = " + role +
                ", agency = " + agency +
                ", store = " + store +
                ", pass = " + pass;
    }

    /**
     * This method clones the store manager
     * @return clone of the store manager
     */
    public StoreManager clone() {
        return new StoreManager(this.name, this.emailAddress, this.phoneNumber, this.passportCardNumber, this.taxNumber, this.address, this.role, this.agency, this.store, this.pass);
    }
}
