package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements Serializable {

    private static List<Order> orders = new ArrayList<>();
    private static List<Order> acceptedOrders = new ArrayList<>();
    private static List<Order> requestedOrders = new ArrayList<>();

    /**
     * Method that adds an order to the list
     *
     * @param order order to be added
     */

    public static void addNewOrder(Order order) {
        if (valid(order)) {
            orders.add(order);
        }
    }

    /**
     * Method that verifies if the order is valid
     *
     * @param announcement announcement to be ordered
     * @param orderPrice   price of the order
     * @return true if the order is valid, false if not
     */
    public boolean validateOrder(Announcement announcement, double orderPrice) {
        for (Order order : orders) {
            if (order.getAnnouncement().equals(announcement)) {
                if (order.getOrderPrice() == orderPrice) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method that verifies if a given order is valid
     *
     * @param order order to be verified
     * @return true if the order is valid, false if not
     */
    public static boolean valid(Order order) {
        boolean isValid = !orders.contains(order);
        return isValid;
    }

    /**
     * Method that verifies if the order price is within the limits
     *
     * @param announcement announcement to be ordered
     * @param orderPrice   price of the order
     * @return true if the order price is within the limits, false if not
     */

    public boolean orderPriceLimits(Announcement announcement, double orderPrice) {
        if (orderPrice > announcement.getPrice() || orderPrice <= 0) {
            return false;
        }
        return true;
    }

    /**
     * Method to check if the client has a pending order on the same announcement
     *
     * @param announcement announcement to be ordered
     * @return true if the client has no pending order on the same announcement, false if not
     */

    public boolean checkForPendingOrder(Announcement announcement) {
        String email = CurrentSession.getEmail();
        for (Order order : orders) {
            if (order.getEmail().equals(email)) {
                if (order.getAnnouncement().equals(announcement)) {
                    if (order.getStatus() == Status.PENDING) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Method that returns a list of orders
     *
     * @return list of orders
     */
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    /**
     * Method that returns a list of accepted orders
     *
     * @return list of accepted orders
     */
    public List<Order> getAcceptedOrders() {
        return new ArrayList<>(acceptedOrders);
    }

    /**
     * Method that returns a list of requested orders
     *
     * @return list of requested orders
     */
    public List<Order> getRequestedOrders() {
        return new ArrayList<>(requestedOrders);
    }

    /**
     * Method that returns the orders by announcement
     *
     * @param announcement selected announcement
     * @return list of orders on the selected announcement
     */
    public List<Order> getOrdersByAnnouncement(Announcement announcement) {
        List<Order> propertyOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getAnnouncement().equals(announcement)) {
                propertyOrders.add(order);
            }
        }
        return propertyOrders;
    }

    /**
     * Method to add an order to the list
     *
     * @param order order to be added
     * @return list of orders
     * @throws CloneNotSupportedException exception
     */
    public Order addOrder(Order order) {
        orders.add(order);
        requestedOrders.add(order);
        return order;
    }

    /**
     * Method to add an accepted order to the list of the accepted orders
     * @param order order to be added
     */
    public Order addAcceptedOrder(Order order) {
        order.setStatus(Status.ACCEPTED);
        acceptedOrders.add(order);
        return order;
    }

    /**
     * Method to show a requested order
     *
     * @param clientEmail client email
     * @param ID          order ID
     * @return requested order
     */
    public Order getRequestedOrder(String clientEmail, int ID) {
        for (Order order : requestedOrders) {
            if (order.getEmail().equals(clientEmail) && order.getOrderID() == ID) {
                return order;
            }
        }
        return null;
    }

    /**
     * Method to accept an order and add it to the list of accepted orders
     *
     * @param order order to be accepted
     */
    public void acceptOrder(Order order) {
        order.setStatus(Status.ACCEPTED);
        acceptedOrders.add(order);
    }

    /**
     * Method to decline the orders by announcement except the one who was accepted
     * @param announcement announcement to be ordered
     */
    public void removeAllOrdersByAnnouncement(Announcement announcement) {
        for (int i = 0; i < requestedOrders.size(); i++) {
            if (requestedOrders.get(i).getAnnouncement().equals(announcement)) {
                requestedOrders.get(i).setStatus(Status.DECLINED);
                requestedOrders.remove(i);
            }
        }
    }

    /**
     * Method to remove an order from the list of requested orders
     * @param order order to be removed
     */
    public void removeOrder(Order order) {
        order.setStatus(Status.DECLINED);
        requestedOrders.remove(order);
    }
}