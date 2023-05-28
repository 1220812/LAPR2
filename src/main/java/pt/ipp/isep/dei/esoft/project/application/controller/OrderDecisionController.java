package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
public class OrderDecisionController{
    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
    public ArrayList<Order> sortOrdersByAge(ArrayList<Order> properties){
        return orderRepository.sortByAge(properties);
    }
    public ArrayList<Order> getProperties(){
        return orderRepository.getOrdersList();
    }
    public ArrayList<Double> getOrders(Order propertyOrder){
        return propertyOrder.getAmount();
    }
    public ArrayList<Double> sortOrdersByAmount(ArrayList<Double> Offers){
        return orderRepository.sortByAmount(Offers);
    }
    public void removeOffers(int accepted, int property){
        orderRepository.removeOffers(accepted, property);
    }
    public void removeOffer(int declined, int property){
        orderRepository.removeOffer(declined, property);
    }
}