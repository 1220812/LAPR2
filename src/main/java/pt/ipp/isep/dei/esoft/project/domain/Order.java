package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Order {
    /**
     * Decision of the agent on the order (Accepted, Declined or Pending(waiting for decision))
     */
    private Status status;
    /**
     * Announcement of the property that is being ordered
     */
    private Announcement announcement;
    /**
     * Amount offered by the client for the property
     */
    private double orderPrice;
    /**
     * Email of the client
     */
    private String email;
    /**
     * Number that identifies the order
     */
    private int orderID;
    private static int orderCounter = 1;

    /**
     * Method that creates a new instance of order
     * @param announcement selected announcement
     * @param orderPrice amount offered by the client
     * @param email client email
     */
    public Order(Announcement announcement, double orderPrice, String email) {
        this.announcement = announcement;
        this.orderPrice = orderPrice;
        this.email = email;
        this.status = Status.PENDING;
        this.orderID = orderCounter++;
    }

    /**
     * Method that returns the selected announcement
     * @return selected announcement
     */
    public Announcement getAnnouncement() {
        return announcement;
    }
    /**
     * Method to change the announcement selected by the client
     * @param announcement new selected announcement
     */
    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    /**
     * Method that returns the offered price
     * @return offered price
     */
    public double getOrderPrice() {
        return orderPrice;
    }

    /**
     * Method to change the order price
     * @param orderPrice new order price
     */
    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * Method that returns the client's email
     * @return client's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to change
     * @param email new client's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method that returns the order status
     * @return order status
     */

    public Status getStatus() {
        return status;
    }

    /**
     * Method to change the order status
     * @param status new order status
     */

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Method that returns the order ID
     * @return orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Method that compares two order instances
     * @param o other order instance
     * @return true if all the attributes of the instances are equal, or false if not
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.orderPrice, orderPrice) == 0 && status == order.status && Objects.equals(announcement, order.announcement) && Objects.equals(email, order.email);
    }

    /**
     * This method generate an unique code for every order instance created
     * @return code
     */
    @Override
    public int hashCode() {
        return Objects.hash(status, announcement, orderPrice, email);
    }

    /**
     * This method creates a clone of the order instance that was created
     * @return order clone
     */
    public Order clone(){
        return new Order(this.announcement,this.orderPrice, this.email);
    }

    /**
     * Method that shows all the information on the order
     * @return order information
     */
    @Override
    public String toString() {
        return "Order : " + "\n" +
                "orderID = " + orderID +
                ", orderPrice = " + orderPrice;
    }
}