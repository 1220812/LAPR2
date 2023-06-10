package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    private static List<Order> orders = new ArrayList<>();

    /**
     * Method that adds an order to the list
     * @param order order to be added
     */

    public static void  addNewOrder(Order order){
        if(valid(order)){
            orders.add(order);
        }
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
     * Method that verifies if a given order is valid
     * @param order order to be verified
     * @return true if the order is valid, false if not
     */
    public static boolean valid(Order order){
        boolean isValid = !orders.contains(order);
        return isValid;
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

    /**
     * Method to add an order to the list
     * @param order order to be added
     * @return list of orders
     * @throws CloneNotSupportedException exception
     */
    public List<Order> add(Order order) throws CloneNotSupportedException{
        orders.add(order);
        Optional<Order> newOrder = Optional.empty();
        boolean success = false;
        if(valid(order)){
            newOrder = Optional.of((Order) order.clone());
            success = orders.add((Order) newOrder.get());
        }
        if(!success){
            newOrder = Optional.empty();
        }
        return orders;
    }

}