package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.BubbleSort;
import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.InsertionSort;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class ListDealsController {
    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
    BubbleSort bubbleSort = new BubbleSort();
    InsertionSort insertionSort = new InsertionSort();
    /**
     * Method that shows the sorting methods
     * @return list of sorting methods
     */
    public List<String> showSortingMethods(){
        List<String> sortingMethods = new ArrayList<>();
        sortingMethods.add("Bubble Sort");
        sortingMethods.add("Insertion Sort");
        return sortingMethods;
    }

    /**
     * Method that shows the sorting order
     * @return list of sorting order
     */
    public List<String> showSortingOrder(){
        List<String> sortingOrder = new ArrayList<>();
        sortingOrder.add("Ascending");
        sortingOrder.add("Descending");
        return sortingOrder;
    }
    /**
     * This method returns a list of the all the accepted orders(deals) on the system
     * @return list of accepted orders
     */
    public List<Order> dealsList(){
        return orderRepository.getAcceptedOrders();
    }
    /**
     * Method that sorts the deals by the selected sorting method and order
     * @param dealsList list of deals
     * @param sortingMethod selected sorting method
     * @param sortingOrder selected sorting order
     * @return list of deals sorted
     */
    public List <Order> sortDeals(List<Order> dealsList, int sortingMethod, int sortingOrder){
        if(sortingMethod == 1){
            if(sortingOrder == 1){
                bubbleSort.ascending(dealsList);
            }
            else{
                bubbleSort.descending(dealsList);
            }
        }
        else{
            if(sortingOrder == 1){
                insertionSort.ascending(dealsList);
            }
            else{
                insertionSort.descending(dealsList);
            }
        }
        return dealsList;
    }
}
