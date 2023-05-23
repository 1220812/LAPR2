package pt.ipp.isep.dei.esoft.project.domain;

//import pt.ipp.isep.dei.esoft.project.repository.AgentRepository;

import java.util.Objects;

public class Agent {
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
     * This method creates an owner with name, phone number and email address
     * @param name name of the owner
     * @param phoneNumber phone number of the owner
     * @param emailAddress email address of the owner
     */

    public Agent(String name, String phoneNumber, String emailAddress,Address address, TaxNumber taxNumber, PassportCardNumber passportCardNumber){
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
        return phoneNumber == agent.phoneNumber && Objects.equals(name, agent.name) && Objects.equals(emailAddress, agent.emailAddress) && Objects.equals(taxNumber, agent.taxNumber) && Objects.equals(passportCardNumber, agent.passportCardNumber) && Objects.equals(address, agent.address);
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
        return "Agent{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", taxNumber=" + taxNumber +
                ", passportCardNumber=" + passportCardNumber +
                ", address=" + address +
                '}';
    }

    /**
     * This method creates a new instance of the agent object and initializes its attributes with the exact same values of the original object
     * @return a clone of the agent object
     */
    public Agent clone(){ return new Agent(this.name,this.phoneNumber, this.emailAddress,this.address,this.taxNumber,this.passportCardNumber); }

    public static Agent newAgent(String name, String phoneNumber, String emailAddress,Address address, TaxNumber taxNumber, PassportCardNumber passportCardNumber){
        Agent newAgent = newAgent(name, phoneNumber, emailAddress, address, taxNumber, passportCardNumber);
        return newAgent;
    }
}