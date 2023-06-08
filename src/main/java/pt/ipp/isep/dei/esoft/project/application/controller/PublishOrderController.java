package pt.ipp.isep.dei.esoft.project.application.controller;

import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.CurrentSession;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class PublishOrderController {
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
    public void registerOrder(Announcement announcement, double orderPrice){
        String email = CurrentSession.getEmail();
        orderRepository.add(email, orderPrice, announcement);
    }
    public List <Announcement> getAnnouncements(){
        return announcementRepository.getAnnouncements();
    }
    public boolean validateOrder(Announcement announcement, double orderPrice){
        return Repositories.getInstance().getOrderRepository().validateOrder(announcement,orderPrice);
    }
    public boolean orderPriceLimits(Announcement announcement, double orderPrice){
        return Repositories.getInstance().getOrderRepository().orderPriceLimits(announcement,orderPrice);
    }
    public boolean checkIfOrderIsPending(Announcement announcement){
        return orderRepository.checkForPendingOrder(announcement);
    }
}
