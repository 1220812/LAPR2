package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Order {
    /**
     * Status of the order (pending (waiting for decision), accepted or rejected)
     */
    private Status status;
    /**
     * Price offered by the client
     */
    private double orderPrice;
    /**
     * Email of the client that is ordering the property
     */
    private String email;
    /**
     * This method creates a new instance of order
     * @param orderPrice  price offered by the client
     * @param email email of the client that is ordering the property
     */
    public Order(double orderPrice, String email) {
        this.orderPrice = orderPrice;
        this.email = email;
        this.status = Status.PENDING;
    }

    /**
     * Method that shows the order price
     * @return order price
     */
    public double getOrderPrice() {
        return orderPrice;
    }

    /**
     * Method that changes the order price
     * @param orderPrice changed order price
     */
    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * Method that shows the email of the client that is ordering the property
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method that changes the email of the client that is ordering the property
     * @param email changed email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method that shows the status of the order
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Method that changes the status of the order
     * @param status changed status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Method that compares two instances of order
     * @param o other instance of order
     * @return true if they are equal, false if they are not
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.orderPrice, orderPrice) == 0 && status == order.status && Objects.equals(email, order.email);
    }

    /**
     * This method creates unique codes for each instance of order
     * @return unique code
     */
    @Override
    public int hashCode() {
        return Objects.hash(orderPrice, email);
    }

    /**
     * This method creates clones of the created order instances
     * @return cloned order
     */

    public Order clone(){
        return new Order(this.orderPrice, this.email);
    }

    /**
     * Method that shows the order information
     * @return order information
     */

    @Override
    public String toString() {
        return "Order : " + "\n" +
                ", orderPrice = " + orderPrice +
                ", client email = " + email;
    }
}