package pt.ipp.isep.dei.esoft.project.domain;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.time.LocalDate;
import java.util.Objects;

public class Request {
    // ATTRIBUTES
    private RequestType requestType;
    private double price;

    private Agent agent;
    private Owner owner;

    private LocalDate requestDate;
    private Property property;


    // CONSTRUCTORS

    public Request(Property property, LocalDate requestDate, Agent agent, Owner owner, double price, RequestType requestType) {
        if (price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (requestType == null ){
            throw new IllegalArgumentException("Invalid property requestType");
        }
        if(agent == null){
            throw new IllegalArgumentException("Agent must not be null");
        }
        this.property = property;
        this.requestDate = requestDate;
        this.agent = agent;
        this.owner = owner;
        this.requestType = requestType;
    }



    /**
     * Method to show the type
     * @return type
     */
    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * Method to change the type
     * @param requestType type
     */

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Double.compare(request.price, price) == 0 && Objects.equals(requestType, request.requestType) && Objects.equals(agent, request.agent) && Objects.equals(owner, request.owner) && Objects.equals(requestDate, request.requestDate) && Objects.equals(property, request.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestType, price, agent, owner, requestDate, property);
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestType=" + requestType +
                ", price=" + price +
                ", agent=" + agent +
                ", owner=" + owner +
                ", requestDate=" + requestDate +
                ", property=" + property +
                '}';
    }

    public Request clone() {
        return new Request(this.property, this.requestDate, this.agent, this.owner, this.price, this.requestType);
    }

    public Agent getAgent() {
        return agent;
    }

    public Owner getOwner() {
        return owner;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public Property getProperty() {
        return property;
    }

    public double getPrice() {
        return price;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
}