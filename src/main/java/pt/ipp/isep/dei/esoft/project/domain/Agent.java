package pt.ipp.isep.dei.esoft.project.domain;

//import pt.ipp.isep.dei.esoft.project.repository.AgentRepository;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Agent.
 */
public class Agent implements Serializable {
/**
 * The type Agent.
 */
    /**
     * name of the agent
     */
    private String name;
    /**
     * phone number of the agent
     */
    private String phoneNumber;
    /**
     * email address of the agent
     */
    private String emailAddress;
    /**
     * tax number of the agent
     */
    private TaxNumber taxNumber;
    /**
     * passport card number of the agent
     */
    private PassportCardNumber passportCardNumber;
    /**
     * address of the agent
     */
    private Address address;
    private Role role;
    private Agency agency;
    private Store store;
    private String pass;

    /**
     * Instantiates a new Agent.
     *
     * @param name               the name
     * @param email              the email
     * @param phone              the phone
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param address            the address
     * @param role               the role
     * @param agency             the agency
     * @param store              the store
     * @param pass               the pass
     */
    public Agent(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, Store store, String pass) {
        this.name=name;
        this.emailAddress=email;
        this.phoneNumber=phone;
        this.passportCardNumber=passportCardNumber;
        this.taxNumber=taxNumber;
        this.address=address;
        this.role=role;
        this.agency=agency;
        this.store=store;
        this.pass=pass;

    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets agency.
     *
     * @return the agency
     */
    public Agency getAgency() {
        return agency;
    }

    /**
     * Sets agency.
     *
     * @param agency the agency
     */
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    /**
     * Gets store.
     *
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * Sets store.
     *
     * @param store the store
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Gets pass.
     *
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets pass.
     *
     * @param pass the pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Method that shows the phone number
     *
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to change the phone number
     *
     * @param phoneNumber changed phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * Method to change the email address
     *
     * @param emailAddress changed email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Method to show the name
     *
     * @return name name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to change the name
     *
     * @param name changed name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to show the tax number
     *
     * @return tax number
     */
    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    /**
     * Method to show the passport card number
     *
     * @return passport card number
     */
    public PassportCardNumber getPassportCardNumber() {
        return passportCardNumber;
    }

    /**
     * Method to change the tax number
     *
     * @param taxNumber changed tax number
     */
    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * Method to change the passport card number
     *
     * @param passportCardNumber changed passport card number
     */
    public void setPassportCardNumber(PassportCardNumber passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }

    /**
     * Method to show the address
     *
     * @return address address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Method to change the address
     *
     * @param address changed address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * This method creates an owner with name, phone number and email address
     *
     * @param name               name of the owner
     * @param phoneNumber        phone number of the owner
     * @param emailAddress       email address of the owner
     * @param address            the address
     * @param taxNumber          the tax number
     * @param passportCardNumber the passport card number
     */
    public Agent(String name, String phoneNumber, String emailAddress, Address address, TaxNumber taxNumber, PassportCardNumber passportCardNumber){
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
        Agent agent = (Agent) o;
        return phoneNumber.equals(agent.phoneNumber) && Objects.equals(name, agent.name) && Objects.equals(emailAddress, agent.emailAddress) && Objects.equals(taxNumber, agent.taxNumber) && Objects.equals(passportCardNumber, agent.passportCardNumber) && Objects.equals(address, agent.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, emailAddress, taxNumber, passportCardNumber, address);
    }

    @Override
    public String toString() {
        return name;
    }
    /**
     * Textual representation of an instance of Owner
     */
    @Override


    /**
     * This method creates a new instance of the agent object and initializes its attributes with the exact same values of the original object
     * @return a clone of the agent object
     */
    public Agent clone(){ return new Agent(this.name,this.phoneNumber, this.emailAddress,this.address,this.taxNumber,this.passportCardNumber); }

    /**
     * New agent agent.
     *
     * @param name               the name
     * @param phoneNumber        the phone number
     * @param emailAddress       the email address
     * @param address            the address
     * @param taxNumber          the tax number
     * @param passportCardNumber the passport card number
     * @return the agent
     */
    public static Agent newAgent(String name, String phoneNumber, String emailAddress, Address address, TaxNumber taxNumber, PassportCardNumber passportCardNumber){
        Agent newAgent = newAgent(name, phoneNumber, emailAddress, address, taxNumber, passportCardNumber);
        return newAgent;
    }


}