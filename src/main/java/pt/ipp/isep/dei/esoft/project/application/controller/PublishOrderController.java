package pt.ipp.isep.dei.esoft.project.application.controller;

import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.CurrentSession;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class PublishOrderController {
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();

    AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();


    /**
     * used to register the order
     * @param order the order to be registered
     */
    public Order registerOrder(Order order){
        return orderRepository.addOrder(order);
    }
    public Order createOrder(Announcement announcement, double orderPrice){
        return new Order(announcement,orderPrice,CurrentSession.getEmail());
    }
    /**
     * used to get the announcements
     *
     * @return the announcements registered on the app
     */
    public List <Announcement> getAnnouncements(){
        return announcementRepository.getAnnouncementsList();
    }

    /**
     * used for checking if the order is able to be registered
     *
     * @param announcement the announcement which the order regards to
     * @param orderPrice the ammount offered
     * @return true if the order is good to be published, or else it returns false
     */
    public boolean validateOrder(Announcement announcement, double orderPrice){
        return Repositories.getInstance().getOrderRepository().validateOrder(announcement,orderPrice);
    }
    /**
     * used for checking if the order ammount is within the price limits
     *
     * @param announcement the announcement which the order regards to
     * @param orderPrice the ammount offered
     * @return true if the ammount offered is within the price limits, or else it returns false
     */
    public boolean orderPriceLimits(Announcement announcement, double orderPrice){
        return Repositories.getInstance().getOrderRepository().orderPriceLimits(announcement,orderPrice);
    }

    /**
     * used for checking if the current customer has already registered an order for the same announcement
     *
     * @param announcement the announcement which the order regards to
     * @return true if the customer didn't already have a pending order for the same announcement, or else it returns false
     */
    public boolean checkIfOrderIsPending(Announcement announcement){
        return orderRepository.checkForPendingOrder(announcement);
    }

    /**
     * Method to show the user email
     * @return the user email
     */
    public String getUser(){
        return authenticationRepository.getCurrentUserSession().getUserId().getEmail();
    }
    public List<Order> orders(){
        return orderRepository.getRequestedOrders();
    }
}