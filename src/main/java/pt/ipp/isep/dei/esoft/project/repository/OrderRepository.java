package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Order;

import java.util.ArrayList;

/**
 * The type Orders repository.
 */
public class OrderRepository {
    /**
     * List of orders
     */
    ArrayList<Order> ordersList = new ArrayList<>();
    /**
     * Method to sort the orders list by age from the oldest one to the youngest one
     * Creates an array of integers with the ages of the orders and then sort that list
     * @param orders orders list
     * @return the orders list sorted by age
     */
    public ArrayList<Order> sortByAge(ArrayList<Order> orders) {
        int[] ageArray = new int[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            ageArray[i] = orders.get(i).getAge();
        }
        for (int j = 0; j < ageArray.length - 1; j++) {
            for (int k = 1; k < ageArray.length; k++) {
                if (ageArray[k] > ageArray[j]) {
                    int copy = ageArray[j];
                    Order copy2 = orders.get(j);
                    ageArray[j] = ageArray[k];
                    orders.set(j, orders.get(k));
                    orders.set(k, copy2);
                    ageArray[k] = copy;
                }
            }

        }
        return orders;
    }
    /**
     * Method to sort the orders list by the amount
     * @param ordersAmount list of the orders amount
     * @return sorted list of the orders by the amount from the biggest to the smallest
     */
    public ArrayList<Double> sortByAmount(ArrayList<Double> ordersAmount){
        for (int j = 0; j < ordersAmount.size() - 1; j++) {
            for (int k = 1; k < ordersAmount.size(); k++) {
                if (ordersAmount.get(k)>ordersAmount.get(j)){
                    Double copy = ordersAmount.get(j);
                    ordersAmount.set(j, ordersAmount.get(k));
                    ordersAmount.set(k, copy);
                }
            }
        }
        return ordersAmount;
    }
    /**
     * Method that returns the list of orders
     * @return list of orders
     */
    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }
    /**
     * Method to change the list of orders
     * @param property the property
     */
    public void setOrdersList(Order property){
        this.ordersList.add(property);
    }
    /**
     * Method to remove all the offers from the list except the one that was accepted
     * @param orderAcceptedIndex the orderAcceptedIndex
     * @param propertyCode the propertyCode
     */
    public void removeOffers(int orderAcceptedIndex, int propertyCode){
        ArrayList<Double> offers = ordersList.get(propertyCode).getAmount();
        for(int i = offers.size() - 1; i >= 0; i--){
            if(i != orderAcceptedIndex){
                offers.remove(i);
            }
        }
        ordersList.get(propertyCode).setAmount(offers);
    }
    /**
     * Method to remove an order that was declined from the list
     * @param orderDeclinedIndex the index of the declined order
     * @param propertyCode code of the property
     */
    public void removeOffer(int orderDeclinedIndex, int propertyCode){
        ArrayList<Double> offers = ordersList.get(propertyCode).getAmount();
        offers.remove(orderDeclinedIndex);
        ordersList.get(propertyCode).setAmount(offers);
    }
}