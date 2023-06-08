package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.AnnouncementDateComparator;
import pt.ipp.isep.dei.esoft.project.domain.Comparators.OrderPriceComparator;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderDecisionController {
    private AnnouncementRepository announcementRepository = new AnnouncementRepository();

    private List<Order> orderList = new ArrayList<>();

    /**
     * Method that returns a list of announcements sorted by date
     *
     * @param announcementList list of announcements
     * @return list of announcements sorted by date
     */
    public List<Announcement> getAnnouncementListSortedByDate(List<Announcement> announcementList) {
        List<Announcement> announcementListSortedByDate = new ArrayList<>(announcementList);
        announcementListSortedByDate.sort(new AnnouncementDateComparator());
        return announcementListSortedByDate;
    }
    public List<Announcement> getAnnouncements(){
        return announcementRepository.getAnnouncements();
    }

    /**
     * Method that returns a list of orders sorted by price
     *
     * @param orderList list of orders
     * @return list of orders sorted by price
     */
    public List<Order> getOrderListSortedByPrice(List<Order> orderList) {
        List<Order> orderListSortedByPrice = new ArrayList<>(orderList);
        orderListSortedByPrice.sort(new OrderPriceComparator());
        return orderListSortedByPrice;
    }

    /**
     * Method to verify if there are orders that are already accepted in the list
     *
     * @param orderList list of orders
     * @return true if there are orders that are already accepted in the list, false if not
     */
    public boolean checkIfOrderListHasAcceptedOrders(List<Order> orderList) {
        for (Order order : orderList) {
            if (order.getStatus() == (Status.ACCEPTED)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to verify if there are orders that hasn't been analyzed by the agent
     *
     * @param orderList list of orders
     * @return true if there are orders that hasn't been analyzed by the agent, false if not
     */
    public boolean checkIfOrderListHasPendingOrders(List<Order> orderList) {
        for (Order order : orderList) {
            if (order.getStatus() == (Status.PENDING)) {
                return true;
            }
        }
        return false;
    }

    public List<Order> getOrderListWithStatus(List<Order> orderListSortedByPrice, int i, int orderOption) {
        orderList = orderListSortedByPrice;
        if (orderListSortedByPrice != null) {
            if (orderOption == 1) {
                    int j = 1;
                    for (Order order : orderListSortedByPrice) {
                        if (order.getStatus() == (Status.PENDING)) {
                            if (j - 1 != i) {
                                order.setStatus(Status.DECLINED);
                            } else {
                                order.setStatus(Status.ACCEPTED);
                            }
                        }
                        j++;
                    }
                } else if (orderOption == 2) {
                    orderList.get(i).setStatus(Status.DECLINED);
                }
            }
        return orderList;
    }

}