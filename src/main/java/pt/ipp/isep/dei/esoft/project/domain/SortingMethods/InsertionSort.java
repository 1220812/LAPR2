package pt.ipp.isep.dei.esoft.project.domain.SortingMethods;

import pt.ipp.isep.dei.esoft.project.domain.Order;

import java.util.List;

public class InsertionSort {
    /**
     * This method uses the insertion sort algorithm to sort the list of orders by ascending order of the area of the property announced
     * @param orderList list of orders to be sorted
     */
    public void ascending(List<Order> orderList){
        int sizeList = orderList.size();
        for (int i = 1; i < sizeList; ++i) {
            Order order = orderList.get(i);
            int j = i-1;
            while (j >= 0 && orderList.get(j).getAnnouncement().getProperty().getArea() > order.getAnnouncement().getProperty().getArea()){
                orderList.set(j+1, orderList.get(j));
                j = j-1;
            }
            orderList.set(j+1, order);
        }
    }

    /**
     * This method uses the insertion sort algorithm to sort the list of orders by descending order of the area of the property announced
     * @param orderList list of orders to be sorted
     */
    public void descending(List<Order> orderList){
        int sizeList = orderList.size();
        for (int i = 1; i < sizeList; ++i) {
            Order order = orderList.get(i);
            int j = i-1;
            while (j >= 0 && orderList.get(j).getAnnouncement().getProperty().getArea() < order.getAnnouncement().getProperty().getArea()){
                orderList.set(j+1, orderList.get(j));
                j = j-1;
            }
            orderList.set(j+1, order);
        }
    }
}
