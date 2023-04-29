package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Agent{
    private String name;
    private String emailAddress;
    private int passportCardNumber;
    private TaxNumber taxNumber;
    private Address address;
    private String phoneNumber;
    private Agency agency;

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

    public int hashCode() {
        return Objects.hash(emailAddress);
    }

    public boolean hasEmail(String email) { return email.equalsIgnoreCase(this.emailAddress); }

    public Employee clone() {
        return new Agent(this.name, this.emailAddress, this.passportCardNumber, this.taxNumber, this.address, this.phoneNumber, this.agency ).clone();
    }
}