package pt.ipp.isep.dei.esoft.project.domain;
import java.util.Objects;

public class Request {
    // ATTRIBUTES
    private Property property;
    private double price;
    private RequestType requestType;

    private Agent agent;
    private Store store;
    private Owner owner;
    // CONSTRUCTORS

    /**
     * Creates a new request with all the attributes
     * @param property property
     * @param price property price
     * @param requestType request type
     * @param agent selected agent
     * @param store selected store
     * @param owner owner
     */
    public Request(Property property, double price, String requestType, Agent agent, Store store, Owner owner) {
        if (property == null){
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
        if(owner == null){
            throw new IllegalArgumentException("Owner must not be null");
        }
        this.property = property;
        this.price = price;
        this.requestType = requestType;
        this.agent = agent;
        this.store = store;
        this.owner = owner;
    }

    /**
     * Method to show the property
     * @return property
     */

    public Property getProperty() {
        return property;
    }

    /**
     * Method to change the property
     * @param property property
     */

    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Method to show the price
     * @return price
     */

    public double getPrice() {
        return price;
    }

    /**
     * Method to change the price
     * @param price
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method to show the type
     * @return type
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Method to change the type
     * @param requestType type
     */

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Double.compare(request.price, price) == 0 && Objects.equals(property, request.property) && Objects.equals(requestType, request.requestType) && Objects.equals(agent, request.agent) && Objects.equals(store, request.store) && Objects.equals(owner, request.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, price, requestType, agent, store, owner);
    }

    @Override
    public String toString() {
        return "Request{" +
                "property=" + property +
                ", price=" + price +
                ", requestType='" + requestType + '\'' +
                ", agent=" + agent +
                ", store=" + store +
                ", owner=" + owner +
                '}';
    }
    public Request clone() {
        return new Request(this.property,this.price,this.requestType,this.agent,this.store,this.owner);
    }
}