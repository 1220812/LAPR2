package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.AnnouncementDateComparator;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.OrderPriceComparator;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.ArrayList;
import java.util.List;

public class OrderDecisionController {
    Repositories repositories = Repositories.getInstance();
    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();

    /**
     * Gets current agent.
     *
     * @return the current agent
     */
    public Agent getCurrentAgent() {
        return this.repositories.getAgentRepository().getAgentByUserSession(getCurrentSession());
    }

    /**
     * Get current session user session.
     *
     * @return the user session
     */
    public UserSession getCurrentSession(){
        return this.repositories.getAuthenticationRepository().getCurrentUserSession();
    }
    /**
     * Method that returns the list of announcements sorted by date of creation
     * @return list of announcements sorted by date of creation
     */
    public List<Announcement> getAnnouncementAssignedList(Agent agent){
        return this.repositories.getAnnouncementRepository.getAnnouncementAssignedList(agent);
    }
    public List<Announcement> getAnnouncementListSortedByDate(Agent agent) {
        List<Announcement> announcementList = new ArrayList<>(getAnnouncementAssignedList(agent));
        announcementList.sort(new AnnouncementDateComparator());
        return announcementList;
    }

    /**
     * Method that returns the list orders sorted by price
     * @param orderList list of orders
     * @return list of orders sorted by price
     */
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
    public void acceptOrder(Order order, Announcement announcement){
        orderRepository.acceptOrder(order);
        orderRepository.removeAllOrdersByAnnouncement(order.getAnnouncement());
        announcementRepository.removeAnnouncement(announcement);
        announcementRepository.addFinishedAnnouncement(announcement);
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