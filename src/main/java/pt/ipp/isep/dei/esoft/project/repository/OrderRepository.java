package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public void add (String email, double orderPrice, Announcement announcement){
        Order order = new Order(announcement, orderPrice, email);
        orders.add(order);
    }

    public boolean validateOrder(Announcement announcement, double orderPrice){
        for (Order order : orders) {
            if(order.getAnnouncement().equals(announcement)){
                if(order.getOrderPrice() == orderPrice){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean orderPriceLimits(Announcement announcement, double orderPrice){
        if (orderPrice > announcement.getPrice() || orderPrice <= 0){
            return false;
        }
        return true;
    }

    public boolean checkForPendingOrder(Announcement announcement){
        String email = CurrentSession.getEmail();
        for (Order order : orders){
            if (order.getEmail().equals(email) && order.getAnnouncement().equals(announcement)){
                if(order.getStatus() == Status.PENDING){
                    return false;
                }
            }
        }
        return true;
    }


}