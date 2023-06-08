package pt.ipp.isep.dei.esoft.project.application.controller;

import java.util.List;
import java.util.Optional;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
public class PublishOrderController {
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    public List<Announcement> getAnnouncements() {
        return announcementRepository.getAnnouncements();
    }

    /**
     * Method to create a new order for a selected announcement
     *
     * @param orderPrice   price of the order
     * @param email        email of the client
     * @param announcement selected announcement
     * @return optional of the new order
     */
    public Optional<Order> createOrder(double orderPrice, String email, Announcement announcement) {
        Optional<Order> newOrder = Optional.empty();
        if (email != null) {
            newOrder = announcement.createOrder(orderPrice, email);
        }
        return newOrder;
    }

    /**
     * Method to verify if the order price is equal or lower than the announced price
     *
     * @param announcement selected announcement
     * @param orderPrice   price of the order
     * @return true if the order price is equal or lower than the announced price, false if it is higher
     */
    public boolean verifyIfAmountIsOnLimits(Announcement announcement, double orderPrice) {
        boolean biggerPrice = false;
        if (orderPrice > announcement.getPrice()) {
            biggerPrice = true;
        }
        return biggerPrice;
    }

    /**
     * Method to verify if the client has already a pending order for the selected announcement
     *
     * @param email  email of the client
     * @param orders list of orders
     * @return true if the client has already a pending order for the selected announcement
     */
    public boolean verifyIfEmailHasOrder(String email, List<Order> orders) {
        boolean hasOrder = false;
        for (Order order : orders) {
            if (email.equals(order.getEmail())) {
                hasOrder = true;
            }
        }
        return hasOrder;
    }

    /**
     * This method verifies if the price of the order is unique, meaning that there is no other order with the same price
     *
     * @param orderPrice price of the order
     * @param orderList  list of orders
     * @return true if the price of the order is unique, false if it is not
     */
    public boolean verifyIfThePriceIsUnique(double orderPrice, List<Order> orderList) {
        boolean exists = false;
        for (Order order : orderList) {
            if (orderPrice == order.getOrderPrice()) {
                exists = true;
            }
        }
        return exists;
    }
}