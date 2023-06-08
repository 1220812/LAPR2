package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Order {
    private Status status;
    private Announcement announcement;
    private double orderPrice;
    private String email;
    private static int orderCounter = 1;
    public Order(Announcement announcement, double orderPrice,String email) {
        this.announcement = announcement;
        this.orderPrice = orderPrice;
        this.email = email;
        this.status = Status.PENDING;
        orderCounter++;
    }
    public Announcement getAnnouncement() {
        return announcement;
    }
    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }
    public double getOrderPrice() {
        return orderPrice;
    }
    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.orderPrice, orderPrice) == 0 && status == order.status && Objects.equals(announcement, order.announcement) && Objects.equals(email, order.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, announcement, orderPrice, email);
    }

    public Order clone(){
        return new Order(this.announcement,this.orderPrice, this.email);
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", announcement=" + announcement +
                ", orderPrice=" + orderPrice +
                ", email=" + email +
                '}';
    }
}