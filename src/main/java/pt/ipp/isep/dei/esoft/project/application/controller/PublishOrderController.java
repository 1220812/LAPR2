package pt.ipp.isep.dei.esoft.project.application.controller;

import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class PublishOrderController {

    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    public void registerOrder(Order order) {
        OrderRepository repository = Repositories.getInstance().getOrderRepository();
        repository.addOrder(order);
    }

    public List<Announcement> getAnnouncements() {
        return announcementRepository.getAnnouncements();
    }

    public boolean validateOrder(Order order) {
        return Repositories.getInstance().getOrderRepository().validateOrder(order);
    }

    /**
     * need a method for checking if there is any pending offer on the same announcement
     */

}
