package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.AnnouncementDateComparator;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.OrderPriceComparator;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderDecisionController {
    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();

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
     * Method that returns a list of all orders
     * @return list of all orders
     */

    public List<Order> getAllOrders(){
        return orderRepository.getOrders();
    }

    /**
     * Method that accepts an order for an announcement, declines the other orders for the same announcement and removes that announcement from the list of announcements
     * @param order order to be accepted
     */
    public void acceptOrder(Order order){
        orderRepository.acceptOrder(order);
        orderRepository.removeAllOrdersByAnnouncement(order.getAnnouncement());
        announcementRepository.removeAnnouncement(order.getAnnouncement());
    }

    /**
     * Method that shows the email of the logged user
     * @return email of the logged user
     */
    public String getUser(){
        return authenticationRepository.getCurrentUserSession().getUserId().getEmail();
    }
    public void removeOrder(Order order){
        orderRepository.removeOrder(order);
    }
}