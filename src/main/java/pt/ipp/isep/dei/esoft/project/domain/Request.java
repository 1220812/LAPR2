package pt.ipp.isep.dei.esoft.project.domain;
import java.time.LocalDate;
import java.util.Objects;

public class Request {
    // ATTRIBUTES
    private PropertyType propertyType;
    private RequestType requestType;

    private Agent agent;
    private Store store;
    private Owner owner;

    private LocalDate requestDate;
    private Property property;


    // CONSTRUCTORS

    public Request(Property property, LocalDate requestDate, PropertyType propertyType, Agent agent, Store store, Owner owner) {
        this.property = property;
        this.requestDate = requestDate;
        this.agent = agent;
        this.owner = owner;
        this.propertyType = propertyType;
        this.store = store;
    }

    /**
     * Creates a new request with all the attributes
     * @param propertyType property
     * @param price property price
     * @param requestType request type
     * @param agent selected agent
     * @param store selected store
     */


    public Request(PropertyType propertyType, double price, RequestType requestType, Agent agent, Store store) {
        if (propertyType == null){
            throw new IllegalArgumentException("Property must not be null");
        }
        if (price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (requestType == null ){
            throw new IllegalArgumentException("Invalid property requestType");
        }
        if(agent == null){
            throw new IllegalArgumentException("Agent must not be null");
        }
        if(store == null){
            throw new IllegalArgumentException("Store must not be null");
        }

        this.propertyType = propertyType;
        this.requestType = requestType;
        this.agent = agent;
        this.store = store;
        this.owner = owner;
    }

    /**
     * Method to show the property
     * @return property
     */

    public PropertyType getPropertyType() {
        return propertyType;
    }

    /**
     * Method to change the property
     * @param propertyType property
     */

    public void setProperty(PropertyType propertyType) {
        this.propertyType = propertyType;
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
        return Objects.equals(propertyType, request.propertyType) && Objects.equals(requestType, request.requestType) && Objects.equals(agent, request.agent) && Objects.equals(store, request.store) && Objects.equals(owner, request.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyType, requestType, agent, store, owner);
    }


    @Override
    public String toString() {
        return "Request{" +
                "propertyType=" + propertyType +
                ", requestType=" + requestType +
                ", agent=" + agent +
                ", store=" + store +
                '}';
    }

    public Request clone() {
        return new Request(this.property, this.requestDate, this.propertyType, this.agent, this.store, this.owner);
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

    public Store getStore() {
        return store;
    }

}