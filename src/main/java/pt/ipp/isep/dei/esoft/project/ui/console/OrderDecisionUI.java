package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.OrderDecisionController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class OrderDecisionUI implements Runnable{
    private final OrderDecisionController controller = new OrderDecisionController();
    public void run(){
        int selection = showAndSelectAnnouncement();
        Announcement announcement = controller.getAnnouncementListSortedByDate().get(selection);
        listOrders(announcement);
    }
    private int showAndSelectAnnouncement (){
        int selection;
        selection=Utils.showAndSelectIndex(controller.getAnnouncementListSortedByDate(),"Please select one announcement to display the orders on that announcement!");
        while (selection > controller.getAnnouncementListSortedByDate().size() || selection < 0) {
            System.out.println("Invalid option!");
            selection = Utils.readIntegerFromConsole("Please select one announcement to display the orders on that announcement!");
        }
        return selection;
    }
    private void listOrders(Announcement announcement) {
        List<Order> emptyOrderList = new ArrayList<>();
        List<Order> allOrders = controller.getAllOrders();
        List<Order> ordersByAnnouncement = controller.getOrdersByAnnouncement(announcement, allOrders);
        if (ordersByAnnouncement.isEmpty()) {
            System.out.println(emptyOrderList);
        } else {
            int selection = Utils.showAndSelectIndex(controller.getOrderListSortedByPrice(ordersByAnnouncement), "Please select one order!");
            Order order = ordersByAnnouncement.get(selection);
            System.out.println("1 - Accept order");
            System.out.println("2 - Decline order");
            System.out.println("0 - Exit");
            int option = Utils.readIntegerFromConsole("Please choose an option!");
            switch (option) {
                case 1:
                    acceptOrder(order);
                    break;
                case 2:
                    declineOrder(order);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
    private void declineOrder(Order order){
        if(order == null){
            System.out.println("Invalid order ID!");
        } else if(order.getStatus() == Status.DECLINED){
            System.out.println("This order has already been declined");
        } else{
            controller.removeOrder(order);
            System.out.println("Order declined!");
        }
    }
    private void acceptOrder(Order order){
        if(order == null){
            System.out.println("Invalid order ID!");
        } else if(order.getStatus() == Status.ACCEPTED){
            System.out.println("This order has already been accepted");
        } else{
            controller.acceptOrder(order);
            System.out.println("Order accepted!");
        }
    }

}