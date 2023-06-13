package pt.ipp.isep.dei.esoft.project.domain.SortingMethods;

import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.Request;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {


    public List<Request> sortByDate(List<Request> requestList) {
        List<Request> tempList = new ArrayList<>(requestList);

        int n = tempList.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (tempList.get(j).getRequestDate().isAfter(tempList.get(j + 1).getRequestDate())) {
                    Request temp = tempList.get(j);
                    tempList.set(j, tempList.get(j + 1));
                    tempList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return tempList;
    }


    public void ascending(List<Order> orderList) {
        int orderListSize = orderList.size();
        boolean swapped;
        for (int i = 0; i < orderListSize - 1; i++) {
            swapped = false;
            for (int j = 0; j < orderListSize - 1; j++) {
                if (orderList.get(j).getAnnouncement().getProperty().getArea() > orderList.get(j + 1).getAnnouncement().getProperty().getArea()) {
                    Order temp = orderList.get(j);
                    orderList.set(j, orderList.get(j + 1));
                    orderList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * This method sorts a list of orders by descending property area value
     *
     * @param orderList list of orders to be sorted
     */
    public void descending(List<Order> orderList) {
        int orderListSize = orderList.size();
        boolean swapped;
        for (int i = 0; i < orderListSize - 1; i++) {
            swapped = false;
            for (int j = 0; j < orderListSize - 1; j++) {
                if (orderList.get(j).getAnnouncement().getProperty().getArea() < orderList.get(j + 1).getAnnouncement().getProperty().getArea()) {
                    Order temp = orderList.get(j);
                    orderList.set(j, orderList.get(j + 1));
                    orderList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
