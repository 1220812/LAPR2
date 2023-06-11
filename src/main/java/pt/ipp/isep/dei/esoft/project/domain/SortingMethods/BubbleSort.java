package pt.ipp.isep.dei.esoft.project.domain.SortingMethods;

import pt.ipp.isep.dei.esoft.project.domain.Order;

import java.util.List;

public class BubbleSort {
    /**
     * This method sorts a list of orders by ascending property area value
     * @param orderList list of orders to be sorted
     */
    public void ascending(List<Order> orderList){
        int orderListSize = orderList.size();
        boolean swapped;
        for (int i = 0; i < orderListSize - 1 ; i++) {
            swapped = false;
            for (int j = 0; j < orderListSize - 1; j++) {
                if(orderList.get(j).getAnnouncement().getProperty().getArea() > orderList.get(j+1).getAnnouncement().getProperty().getArea()){
                    Order temp = orderList.get(j);
                    orderList.set(j, orderList.get(j+1));
                    orderList.set(j+1, temp);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    /**
     * This method sorts a list of orders by descending property area value
     * @param orderList list of orders to be sorted
     */
    public void descending(List<Order> orderList){
        int orderListSize = orderList.size();
        boolean swapped;
        for (int i = 0; i < orderListSize - 1 ; i++) {
            swapped = false;
            for (int j = 0; j < orderListSize - 1; j++) {
                if(orderList.get(j).getAnnouncement().getProperty().getArea() < orderList.get(j+1).getAnnouncement().getProperty().getArea()){
                    Order temp = orderList.get(j);
                    orderList.set(j, orderList.get(j+1));
                    orderList.set(j+1, temp);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
