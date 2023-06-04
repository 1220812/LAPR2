package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Order repository.
 */
public class OrderRepository {
    /**
     * List of orders.
     */
    private static final List<Order> orders = new ArrayList<>();
    /**
     * Property code.
     */
    private String propertyCode;
    /**
     * Order number.
     */
    private int orderNumber;

    /**
     *  Instantiates a new Order repository.
     */

    public void saveOrder(Order order) {
        orders.add(order);
    }

    /**
     * Gets the order repository list.
     * @param propertyCode property code
     * @param orderNumber order number
     * @return list of orders
     */
    public static List<Order> getOrderRepositoryList(String propertyCode, int orderNumber) {
        return List.copyOf(orders);
    }

    /**
     * Method that adds an order to the list.
     * @param order order to be added to the list
     */
    public static void addOrder(Order order) {
        orders.add(order);
    }
    /**
     * Removes the order.
     */
    public void removeOrder() {
        orders.remove(orders);
    }
    /**
     * Updates the order.
     */
    public void updateOrder() {
        orders.set(orders.indexOf(orders), orders.get(orders.indexOf(orders)));
    }
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Gets the order.
     */
    public void getOrder() {
        orders.get(orders.indexOf(orders));
    }
    /**
     * Gets the orders by property.
     * @return list of orders by property
     */
    public List<Order> getOrdersByProperty() {
        return OrderRepository.getOrderRepositoryList(propertyCode, orderNumber);
    }
    /**
     * Gets the orders by property and order number.
     * @param propertyCode property code
     * @param orderNumber order number
     * @return list of orders by property and order number
     */
    public Order getOrderByPropertyCodeOrderNumber(String propertyCode, int orderNumber) {
        for (Order order : orders) {
            if (order.hasPropertyCode(propertyCode) && order.hasOrderNumber(orderNumber)) {
                return order;
            }
        }
        return null;
    }

    /**
     * Gets the undecided property order.
     * @param propertyCode property code
     * @return list of undecided property order
     */
    public List<Order> getUndecidedPropertyOrder(String propertyCode) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.hasPropertyCode(propertyCode) && !order.hasDecision()) {
                result.add(order);
            }
        }
        return result;
    }
    /**
     * Gets the properties sorted by age.
     * @param properties list of orders on a properties
     * @return list of orders sorted by age
     */
    public ArrayList<Order> sortByAge(ArrayList<Order> properties) {
        LocalDate[] ageArray = new LocalDate[properties.size()];
        for (int i = 0; i < properties.size(); i++) {
            ageArray[i] = properties.get(i).getAnnouncement().getDate();
        }
        for (int j = 0; j < ageArray.length - 1; j++) {
            for (int k = j; k < ageArray.length; k++) {
                if (ageArray[j].compareTo(ageArray[k]) > 0) {
                    LocalDate copy = ageArray[j];
                    Order copyNumber2 = properties.get(j);
                    ageArray[j] = ageArray[k];
                    properties.set(j, properties.get(k));
                    properties.set(k, copyNumber2);
                    ageArray[k] = copy;
                }
            }
        }
        return properties;
    }
}