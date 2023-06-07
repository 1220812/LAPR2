package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Order {
    private Announcement announcement;
    private double orderPrice;
    private User client;
    public Order(Announcement announcement, double orderPrice,User client) {
        this.announcement = announcement;
        this.orderPrice = orderPrice;
        this.client = client;
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

    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.orderPrice, orderPrice) == 0 && Objects.equals(announcement, order.announcement) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(announcement, orderPrice);
    }
    public Order clone(){
        return new Order(this.announcement,this.orderPrice, this.client);
    }
    @Override
    public String toString() {
        return "Order{" +
                "announcement=" + announcement +
                ", orderPrice=" + orderPrice +
                ", client=" + client +
                '}';
    }
}