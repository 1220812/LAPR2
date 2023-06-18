package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Request.
 */
public class Request implements Serializable {
    /**
     * Type of request (sale or rent)
     */
    private RequestType requestType;
    /**
     * Price for the property defined by the owner
     */
    private double price;
    /**
     * Agent that was selected by the owner
     */
    private Agent agent;
    /**
     * Owner that made the request
     */
    private Owner owner;
    /**
     * Store selected by the owner
     */
    private Store store;
    /**
     * Date of the request
     */
    private LocalDate requestDate;
    /**
     * Property that is being requested for sale/rent
     */
    private Property property;

    private LocalDate startDate;
   private LocalDate enDate;

    /**
     * Method that creates an instance of request
     *
     * @param property    property that is being requested
     * @param requestDate date of the request
     * @param agent       agent selected by the owner
     * @param owner       owner that made the request
     * @param price       price defined by the owner
     * @param requestType type of request
     * @param store       store selected by the owner
     */
    public Request(Property property, LocalDate requestDate, Agent agent, Owner owner, double price, RequestType requestType, Store store) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (requestType == null) {
            throw new IllegalArgumentException("Invalid property requestType");
        }
        if (agent == null) {
            throw new IllegalArgumentException("Agent must not be null");
        }
        if (owner == null) {
            throw new IllegalArgumentException("Owner must not be null");
        }
        if (requestDate == null) {
            throw new IllegalArgumentException("Request date must not be null");
        }
        if (property == null) {
            throw new IllegalArgumentException("Property must not be null");
        }
        if (store == null) {
            throw new IllegalArgumentException("Store must not be null");
        }
        this.property = property;
        this.requestDate = requestDate;
        this.agent = agent;
        this.owner = owner;
        this.requestType = requestType;
        this.store = store;
        this.price = price;

    }

    /**
     * Instantiates a new Request.
     *
     * @param startDate the start date
     * @param enDate    the en date
     */
    public Request(LocalDate startDate, LocalDate enDate) {
        this.startDate = startDate;
        this.enDate = enDate;
    }

    /**
     * Check visit time boolean.
     *
     * @param newStartTime the new start time
     * @param newEndTime   the new end time
     * @return the boolean
     */
    public static boolean checkVisitTime(LocalDate newStartTime, LocalDate newEndTime) {
        return newEndTime.isAfter(newStartTime);
    }


    /**
     * Method to show the type
     *
     * @return type request type
     */
    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * Method to change the type
     *
     * @param requestType type
     */
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }


    /**
     * Sets request date.
     *
     * @param requestDate the request date
     */
    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets en date.
     *
     * @return the en date
     */
    public LocalDate getEnDate() {
        return enDate;
    }

    /**
     * Sets en date.
     *
     * @param enDate the en date
     */
    public void setEnDate(LocalDate enDate) {
        this.enDate = enDate;
    }

    /**
     * Method to show the agent
     *
     * @return agent agent
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Method to show the owner
     *
     * @return owner owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Method to show request date
     *
     * @return request date
     */
    public LocalDate getRequestDate() {
        return requestDate;
    }

    /**
     * Method to show the property
     *
     * @return property property
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Method to show the price
     *
     * @return price price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method to change the owner
     *
     * @param owner the owner
     * @return changed owner
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Method to change the price
     *
     * @param price changed value of price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method to change the agent
     *
     * @param agent changed value of agent
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    /**
     * Method to change the property
     *
     * @param property changed property
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Equals method that verifies if the request already exists in the system
     *
     * @param o object to compare with
     * @return true if the request already exists, false if it doesn't
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Double.compare(request.price, price) == 0 && Objects.equals(requestType, request.requestType) && Objects.equals(agent, request.agent) && Objects.equals(owner, request.owner) && Objects.equals(requestDate, request.requestDate) && Objects.equals(property, request.property);
    }

    /**
     * Method that returns an unique code that identifies the request
     *
     * @return hash code for the request
     */
    @Override
    public int hashCode() {
        return Objects.hash(requestType, price, agent, owner, requestDate, property);
    }

    /**
     * Method that returns a string with the information of the request
     *
     * @return string with the information of the request
     */
    @Override
    public String toString() {
        return "Request : " + "\n" +
                requestType +
                ", price = " + price +
                ", agent = " + agent +
                ", owner = " + owner +
                ", requestDate = " + requestDate +
                ", property : " + property +
                ", store = " + store;
    }

    /**
     * Method that creates an exact copy of the request
     *
     * @return copy of the request
     */
    public Request clone() {
        return new Request(this.property, this.requestDate, this.agent, this.owner, this.price, this.requestType, this.store);
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
     * Gets requests.
     *
     * @param RequestList the request list
     * @param startDate   the start date
     * @param endDate     the end date
     * @return the requests
     */
    public static List<Request> getRequests(List<Request> RequestList, LocalDate startDate, LocalDate endDate) {
        List<Request> filteredRequests = new ArrayList<>();

        for (Request request : RequestList) {
            LocalDate requestDate = request.getRequestDate();

            if (requestDate.compareTo(startDate) >= 0 && requestDate.compareTo(endDate) <= 0) {
                filteredRequests.add(request);
            }
        }

        return filteredRequests;
    }

    /**
     * Check day boolean.
     *
     * @param startDay the start day
     * @return the boolean
     */
    public static boolean checkDay(int startDay) {
        return startDay >= 1 && startDay <= 31;
    }

    /**
     * Check month boolean.
     *
     * @param startMonth the start month
     * @return the boolean
     */
    public static boolean checkMonth(int startMonth) {
        return startMonth >= 1 && startMonth <= 12;
    }

    /**
     * Check year boolean.
     *
     * @param startYear the start year
     * @return the boolean
     */
    public static boolean checkYear(int startYear) {
        return startYear >= 0;
    }



}