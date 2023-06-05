package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Comparator;

public class OrderComparator implements Comparator<Order> {
    /**
     * Method that compares two orders by date, if the date is the same, it compares by price
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return the value 0 if the first object is equal to the second object; a value less than 0 if the first object is less than the second object; and a value greater than 0 if the first object is greater than the second object.
     */
    public int compare(Order o1, Order o2) {
        Property property1 = o1.getProperty();
        Property property2 = o2.getProperty();
        int difference = property1.compareByDate(property2);
        if (difference != 0) {
            return difference;
        }
        int dateDiff = property1.getDate().compareTo(property2.getDate());
        if (dateDiff != 0) {
            return dateDiff;
        }
        return Double.compare(o1.getOrderPrice(), o2.getOrderPrice());
    }
}
