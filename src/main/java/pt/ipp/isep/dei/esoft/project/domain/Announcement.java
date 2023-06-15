package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Announcement {
    /**
     * announcement property
     */
    private Property property;
    /**
     * announcement commission type
     */
    private String commissionType;
    /**
     * announcement commission
     */
    private double commission;
    /**
     * request type (sell or rent)
     */
    private RequestType requestType;
    /**
     * agent responsible for the announcement
     */
    private Agent agent;
    /**
     * announcement publish date
     */
    private LocalDate date;
    /**
     * announced price for the property
     */
    private double price;
    /**
     * Owner of the property announced
     */
    private Owner owner;
    /**
     * Store selected by the owner
     */
    private Store store;

    /**
     * Method that creates an instance of Announcement
     *
     * @param property       property to announce
     * @param date           date of the announcement
     * @param commissionType commission type
     * @param commission     commission
     * @param requestType    request type
     * @param agent          agent responsible for the announcement
     * @param price          announced price
     * @param owner          owner of the property announced
     */

    public Announcement(Property property, LocalDate date, String commissionType, double commission, RequestType requestType, Agent agent, double price, Owner owner, Store store) {
        if (property == null) {
            throw new IllegalArgumentException("Property can't be null");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date can't be null");
        }
        if (commissionType == null) {
            throw new IllegalArgumentException("Commission type can't be null");
        }
        if (requestType == null) {
            throw new IllegalArgumentException("Request type can't be null");
        }
        if (agent == null) {
            throw new IllegalArgumentException("Agent can't be null");
        }
        if (owner == null) {
            throw new IllegalArgumentException("Owner can't be null");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price can't be negative or zero");
        }
        if (store == null) {
            throw new IllegalArgumentException("Store can't be null");
        }
        this.property = property;
        this.date = date;
        this.commissionType = commissionType;
        this.commission = commission;
        this.requestType = requestType;
        this.agent = agent;
        this.price = price;
        this.owner = owner;
        this.store = store;
    }

    /**
     * Method that creates an instance of Announcement with the given parameters:
     * @param property property to announce
     * @param date date of the announcement
     * @param commission commission
     * @param requestType request type
     * @param price announced price
     * @param owner owner of the property announced
     * @param store store selected by the owner
     */
    public Announcement(Property property, LocalDate date, double commission, RequestType requestType, double price, Owner owner, Store store) {
        if (property == null) {
            throw new IllegalArgumentException("Property can't be null");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date can't be null");
        }
        if (requestType == null) {
            throw new IllegalArgumentException("Request type can't be null");
        }
        if (owner == null) {
            throw new IllegalArgumentException("Owner can't be null");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price can't be negative or zero");
        }
        if (store == null) {
            throw new IllegalArgumentException("Store can't be null");
        }
        this.property = property;
        this.date = date;
        this.commission = commission;
        this.requestType = requestType;
        this.price = price;
        this.owner = owner;
        this.store = store;
    }
    /**
     * Method that shows the date of the announcement
     *
     * @return date of the announcement
     */

    public LocalDate getDate() {
        return date;
    }

    /**
     * Method that changes the date of the announcement
     *
     * @param date new date of the announcement
     */

    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Method that shows the announced property
     *
     * @return announced property
     */

    public Property getProperty() {
        return property;
    }

    /**
     * Method to change the announced property
     *
     * @param property new announced property
     */

    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Method that shows the commission of the announcement
     *
     * @return commission of the announcement
     */
    public double getCommission() {
        return commission;
    }

    /**
     * Method that changes the commission of the announcement
     *
     * @param commission new commission of the announcement
     */
    public void setCommission(double commission) {
        this.commission = commission;
    }

    /**
     * Method that shows the commission type of the announcement
     *
     * @return commission type of the announcement
     */
    public String getCommissionType() {
        return commissionType;
    }

    /**
     * Method that changes the commission type of the announcement
     *
     * @param commissionType new commission type of the announcement
     */
    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
    }

    /**
     * Method that shows the request type of the announcement
     * @return request type of the announcement
     */

    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * Method that changes the request type of the announcement
     * @param requestType new request type of the announcement
     */

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    /**
     * Method that shows the announced price
     * @return announced price
     */

    public double getPrice() {
        return price;
    }

    /**
     * Method that changes the announced price
     * @param price new announced price
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method that shows the store selected by the owner
     * @return store selected by the owner
     */

    public Store getStore() {
        return store;
    }

    /**
     * Method that changes owner of the property announced
     * @param owner new owner of the property announced
     */

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Method that changes the agent selected by the owner
     * @param agent new agent selected by the owner
     */

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    /**
     * Method that shows the owner of the property announced
     * @return owner of the property announced
     */

    public Owner getOwner() {
        return owner;
    }

    /**
     * Method that shows the agent selected by the owner
     * @return agent selected by the owner
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Method that changes the store selected by the owner
     * @param store new store selected by the owner
     */
    public void setStore(Store store) {
        this.store = store;
    }
    /**
     * Method that verifies if exists a property price
     * @return true if exists a property price, false if not
     */
    public static boolean existsPrice(double price){
        if (price < 1) { return false; }
        else return true;
    }
    /**
     * Method that creates a string with the information of the announcement
     * @return string with the information of the announcement
     */
    @Override
    public String toString() {
        return "Announcement : " +
                property +
                "\nCommission type = " + commissionType +
                "\nCommission = " + commission +
                "\n" + requestType +
                "\nAgent = " + agent +
                "\nDate = " + date +
                "\nPrice = " + price +
                "\nOwner = "  + owner +
                "\nStore = " + store;
    }

    /**
     * Method that creates a clone of the announcement
     * @return clone of the announcement
     */
    public Announcement clone() {
        return new Announcement(this.property, this.date, this.commissionType, this.commission, this.requestType, this.agent, this.price, this.owner, this.store);
    }

    /**
     * Method that compares two announcements
     * @param o announcement to be compared
     * @return true if the announcements are equal, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Announcement that = (Announcement) o;
        return Double.compare(that.commission, commission) == 0 && Double.compare(that.price, price) == 0 && property.equals(that.property) && commissionType.equals(that.commissionType) && requestType.equals(that.requestType) && agent.equals(that.agent) && date.equals(that.date) && owner.equals(that.owner) && store.equals(that.store);
    }

    /**
     * Method that creates a hash code for the announcement
     * @return hash code for the announcement
     */
    @Override
    public int hashCode() {
        return Objects.hash(property, commissionType, commission, requestType, agent, date, price, owner, store);
    }
}
