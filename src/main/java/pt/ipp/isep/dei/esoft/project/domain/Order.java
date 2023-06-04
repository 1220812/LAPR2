package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    /**
     * Announcement of the order.
     */
    private Announcement announcement;
    /**
     * Price of the order.
     */
    private int orderPrice;
    /**
     * Order number.
     */
    private Property property;
    /**
     * Client of the order.
     */
    private User client;
    /**
     * Date of the order.
     */
    private LocalDate date;
    /**
     * Decision of the order.
     */
    private Boolean decision; // null = pending, true = accepted, false = declined
    private int orderNumber;

    public Order(Announcement announcement, int orderPrice, Property property, User client, LocalDate date, Boolean decision, int orderNumber) {
        this.announcement = announcement;
        this.orderPrice = orderPrice;
        this.property = property;
        this.client = client;
        this.date = date;
        this.decision = decision;
        this.orderNumber = orderNumber;
    }

    public Order(Announcement announcement, int orderPrice, User client, LocalDate date) {
        this.announcement = announcement;
        this.orderPrice = orderPrice;
        this.client = client;
        this.date = date;
    }
    /**
     * @param property
     * @param orderPrice
     */
    public Order(Property property, int orderPrice, LocalDate date, Announcement announcement){
        this.property = property;
        this.orderPrice = orderPrice;
        this.announcement = announcement;
        this.date = date;
    }
    public Announcement getAnnouncement() {
        return announcement;
    }
    public int getOrderPrice() {
        return orderPrice;
    }
    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }
    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Order: " +
                announcement +
                ", orderPrice = " + orderPrice +
                ", client = " + client.getName() +
                ", date : " + date +
                ", property code = " + announcement.getProperty().getCode();
    }

    /**
     * makes a decision on an order.
     * @param decision
     */
    public void makeDecision(boolean decision) {
        this.decision = decision ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * Gets the name of the owner of the order.
     * @return
     */
    public String getClientName() {
        return client.getName();
    }
    /**
     * Sends an email to the client of the order rejecting the order.
     */
    public void reject() {
        this.decision = Boolean.FALSE;
    }
    /**
     * Verifies if the property has a code.
     * @param propertyCode property code
     * @return true if the property has a code, false if not
     */
    public  boolean hasPropertyCode(String propertyCode) {
        return announcement.getProperty().hasCode(propertyCode);
    }
    /**
     * Verifies if the order has a decision made.
     * @return true if the order has a decision made, false if not
     */
    public boolean hasDecision() {
        return decision != null;
    }

    /**
     * Gets the property of the order.
     * @return property of the order
     */
    public Property getProperty() {
        return announcement.getProperty();
    }
    public Boolean getDecision() {
        return decision;
    }

    public User getClient() {
        return client;
    }
    public boolean contains(Order order) {
        return this.equals(order);
    }

    public Property getPropertyAnnouncement() {
        return this.announcement.getProperty();
    }
    public boolean hasOrderNumber(int orderNumber){
        return this.orderNumber == orderNumber;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public Order clone() {
        return new Order(this.announcement, this.orderPrice, this.property,this.client,  this.date, this.decision, this.orderNumber);
    }
}