package pt.ipp.isep.dei.esoft.project.domain.Comparators;

import pt.ipp.isep.dei.esoft.project.domain.Order;

import java.util.Comparator;

public class OrderPriceComparator implements Comparator<Order> {
/**
     * This method compares the price of two orders.
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return the value 0 if the price of the first order is equal to the price of the second order; a value less than 0 if the price of the first order is less than the price of the second order; and a value greater than 0 if the price of the first order is greater than the price of the second order.
     */
    @Override
    public int compare(Order o1, Order o2) {
        if (o1.getOrderPrice() > o2.getOrderPrice())
            return 1;
        else if (o1.getOrderPrice() < o2.getOrderPrice())
            return -1;
        else
            return 0;
    }
}
