package pt.ipp.isep.dei.esoft.project.domain;
import java.util.Objects;

public class Request {
    // ATTRIBUTES
    private PropertyType propertyType;
    private double price;
    private RequestType requestType;

    private Agent agent;
    private Store store;
    private Owner owner;
    // CONSTRUCTORS

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
        return Double.compare(request.price, price) == 0 && Objects.equals(propertyType, request.propertyType) && Objects.equals(requestType, request.requestType) && Objects.equals(agent, request.agent) && Objects.equals(store, request.store) && Objects.equals(owner, request.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyType, price, requestType, agent, store, owner);
    }

    @Override
    public String toString() {
        return "Request{" +
                "property=" + propertyType +
                ", price=" + price +
                ", requestType='" + requestType + '\'' +
                ", agent=" + agent +
                ", store=" + store +
                ", owner=" + owner +
                '}';
    }
    public Request clone() {
        return new Request(this.propertyType,this.price,this.requestType,this.agent,this.store);
    }
}