package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    /**
     * Method that adds an order to the list
     * @param order order to be added
     */

    public void add (Order order){
        orders.add(order);
    }

    /**
     * Method that verifies if the order is valid
     * @param announcement announcement to be ordered
     * @param orderPrice price of the order
     * @return true if the order is valid, false if not
     */
    public boolean validateOrder(Announcement announcement, double orderPrice){
        for (Order order : orders) {
            if(order.getAnnouncement().equals(announcement)){
                if(order.getOrderPrice() == orderPrice){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method that verifies if the order price is within the limits
     * @param announcement announcement to be ordered
     * @param orderPrice price of the order
     * @return true if the order price is within the limits, false if not
     */

    public boolean orderPriceLimits(Announcement announcement, double orderPrice){
        if (orderPrice > announcement.getPrice() || orderPrice <= 0){
            return false;
        }
        return true;
    }

    /**
     * Method to check if the client has a pending order on the same announcement
     * @param announcement announcement to be ordered
     * @return true if the client has no pending order on the same announcement, false if not
     */

    public boolean checkForPendingOrder(Announcement announcement){
        String email = CurrentSession.getEmail();
        for (Order order : orders){
            if (order.getEmail().equals(email) && order.getAnnouncement().equals(announcement)){
                if(order.getStatus() == Status.PENDING){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method that returns a list of orders
     * @return list of orders
     */
    public List<Order> getOrders(){
        return List.copyOf(this.orders);
    }

    /**
     * Method that returns the orders by announcement
     * @param announcement selected announcement
     * @return list of orders on the selected announcement
     */
    public List<Order> getOrdersByAnnouncement(Announcement announcement){
        List<Order> propertyOrders = new ArrayList<>();
        for (Order order : orders){
            if (order.getAnnouncement().equals(announcement)){
                propertyOrders.add(order);
            }
        }
        return propertyOrders;
    }

}