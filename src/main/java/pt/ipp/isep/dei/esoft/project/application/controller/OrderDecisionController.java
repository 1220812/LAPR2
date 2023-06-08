package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.AnnouncementDateComparator;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.OrderPriceComparator;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDecisionController {
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    public List<Announcement> getAnnouncementListSortedByDate(List<Announcement> announcementList){
        List<Announcement> sortedAnnouncementList = new ArrayList<>();
        Collections.sort(sortedAnnouncementList, new AnnouncementDateComparator());
        sortedAnnouncementList = announcementList;
        return sortedAnnouncementList;
    }
    public List<Announcement> getAnnouncementList(){
        return announcementRepository.getAnnouncements();
    }
    public List<Order> getOrdersOnAnnouncementSelected(Announcement announcement){
        OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
        return orderRepository.getOrders();
    }
    public List<Order> getOrderListSortedByPrice(List<Order> orderList){
        List<Order> sortedOrderList = new ArrayList<>();
        Collections.sort(sortedOrderList, new OrderPriceComparator());
        sortedOrderList = orderList;
        return sortedOrderList;
    }
}