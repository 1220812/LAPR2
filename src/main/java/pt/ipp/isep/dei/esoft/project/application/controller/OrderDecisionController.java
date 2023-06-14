package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.AnnouncementDateComparator;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.OrderPriceComparator;
import pt.ipp.isep.dei.esoft.project.domain.EmailService;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderDecisionController {
    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    EmailService emailService = new EmailService();

    /**
     * Method that returns the list of announcements sorted by date of creation
     * @return list of announcements sorted by date of creation
     */
    public List<Announcement> getAnnouncementListSortedByDate() {
        List<Announcement> announcementList = new ArrayList<>(announcementRepository.getAnnouncementsList());
        announcementList.sort(new AnnouncementDateComparator());
        return announcementList;
    }
    public List<Order> getOrderListSortedByPrice(List<Order> orderList){
        orderList.sort(new OrderPriceComparator().reversed());
        return orderList;
    }

    /**
     * Method that returns a list of properties with their corresponding purchase orders.
     * The properties are sorted from oldest to most recent, and for each property, the
     * purchase orders are sorted by the amount offered (highest offer first).
     *
     * @return list of properties with their purchase orders
     */

    public List<Order> getOrdersByAnnouncement(Announcement announcement, List<Order> orders) {
        List<Order> announcementOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getAnnouncement().toString().equals(announcement.toString())) {
                announcementOrders.add(order);
            }
        }
        return announcementOrders;
    }

    /**
     * Method to accept a purchase order for a property.
     * When a purchase order is accepted, all other orders for the same property are declined,
     * @param order the purchase order to accept
     */
    public void acceptPurchaseOrder(Order order) {
        declineOtherOrders(order);
        String clientEmail = order.getEmail();
        String message = "Your offer for the property with the order number " + order.getOrderID() +
                " has been accepted. Congratulations!";
        emailService.sendMessage(clientEmail, message);
    }

    /**
     * Method to decline a purchase order for an announcement.
     *
     * @param order the purchase order to be declined
     */
    public void declinePurchaseOrder(Order order) {
        Announcement announcement = order.getAnnouncement();
        List<Order> orderList = orderRepository.getOrdersByAnnouncement(announcement);
        orderList.remove(order);
        String clientEmail = order.getEmail();
        String message = "Your offer for the property with the order number " + order.getOrderID() +
                " has been declined. We apologize for any inconvenience caused.";
        emailService.sendMessage(clientEmail, message);
    }

    /**
     * Method that returns a list of all orders
     * @return list of all orders
     */

    public List<Order> getAllOrders(){
        return orderRepository.getOrders();
    }

    /**
     * Method that declines all other orders for the same property when one is accepted
     * @param acceptedOrder accepted order
     */
    private void declineOtherOrders(Order acceptedOrder) {
        List<Order> orders = orderRepository.getOrdersByAnnouncement(acceptedOrder.getAnnouncement());
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (!order.equals(acceptedOrder)) {
                order.setStatus(Status.DECLINED);
                iterator.remove();
                String clientEmail = order.getEmail();
                String message = "Your offer for the property with the order number " + order.getOrderID() +
                        " has been declined. We apologize for any inconvenience caused.";
                emailService.sendMessage(clientEmail, message);
            }
        }
    }
}