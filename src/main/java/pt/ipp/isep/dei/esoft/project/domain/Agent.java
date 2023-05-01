package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Agent{
    // ATTRIBUTES
    private String name;
    private String emailAddress;
    private int passportCardNumber;
    private TaxNumber taxNumber;
    private Address address;
    private String phoneNumber;
    private Agency agency;

    // CONSTRUCTORS

    public Agent(String name, String emailAddress, int passportCardNumber, TaxNumber taxNumber, Address address, String phoneNumber, Agency agency){
        this.name = name;
        this.emailAddress = emailAddress;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.agency = agency;
    }

    public Agent(String emailAddress){
        this.emailAddress = emailAddress;
    }

    /**
     * Method to compare the attributes of the current object with those of another object
     * @param o object that will be compared with
     * @return boolean
     */


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Agent)) {
            return false;
        }
        Agent agent = (Agent) o;
        return emailAddress.equals(agent.emailAddress);
    }

    /**
     * Method to return a hash code for the object in order to ensure that this hash code will not collide with the others
     * @return
     */

    public int hashCode() {
        return Objects.hash(emailAddress);
    }

    /**
     * Method to verify the email of the agent
     * @param email email agent
     * @return email
     */

    public boolean hasEmail(String email) { return email.equalsIgnoreCase(this.emailAddress); }

    /**
     * This method creates a new instance of the agent object and initializes its attributes with the exact same values of the original object
     * @return a clone of the agent object
     */
    public Employee clone() {
        return new Agent(this.name, this.emailAddress, this.passportCardNumber, this.taxNumber, this.address, this.phoneNumber, this.agency ).clone();
    }
}