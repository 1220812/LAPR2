package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.OrderDecisionController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class OrderDecisionUI implements Runnable{
    private final OrderDecisionController controller = new OrderDecisionController();
    private List<Announcement> announcements= new ArrayList<>();
    public List<Order> orders = new ArrayList<>();
    public void run(){
        int selection = displayAnnouncementListSortedByDate();
    }
    public int displayAnnouncementListSortedByDate(){
        announcements = controller.getAnnouncements();
        int selection = Utils.showAndSelectIndex(announcements, "Choose the announcement you want to publish an order for: ");
        return selection;
    }
    public int displayOrdersByAnnouncement(){
        orders = controller.getOrderListSortedByPrice(orders);
        int selection = Utils.showAndSelectIndex(orders, "Choose the order you want to accept: ");
        return selection;
    }
}