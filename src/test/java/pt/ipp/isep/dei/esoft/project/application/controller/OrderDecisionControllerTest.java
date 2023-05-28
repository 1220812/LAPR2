package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OrderDecisionControllerTest {
    private final OrderRepository orderRepository = new OrderRepository();
    /**
     * This method tests if the method sortByAge() is working correctly, creating some new order samples and verifying if the list will be sorted correctly.
     */
    @Test
    void sortByAge() {
        //Create some new orders samples
        Order order1 = new Order("Property1", 25);
        Order order2 = new Order("Property2", 30);
        Order order3 = new Order("Property3", 20);
        // Add orders to the repository
        orderRepository.setOrdersList(order1);
        orderRepository.setOrdersList(order2);
        orderRepository.setOrdersList(order3);
        // Sort orders by age
        ArrayList<Order> sortedOrders = orderRepository.sortByAge(orderRepository.getOrdersList());
        // Check if the orders are sorted correctly
        List<Order> expectedOrder = Arrays.asList(order2, order1, order3);
        // Compares the expected order list with the sorted one
        Assertions.assertEquals(expectedOrder, sortedOrders);
    }

    /**
     * This method tests if the method sortByAmount is working correctly, creating some new order amounts samples and verifying if the list will be sorted correctly.
     */
    @Test
    void sortByAmount() {
        // Create a list of order amounts samples
        ArrayList<Double> orderAmounts = new ArrayList<>(Arrays.asList(100.0, 50.0, 75.0));
        // Sort order amounts
        ArrayList<Double> sortedAmounts = orderRepository.sortByAmount(orderAmounts);
        // Check if the amounts are sorted correctly
        List<Double> expectedAmounts = Arrays.asList(100.0, 75.0, 50.0);
        // Compares the expected order list with the sorted one
        Assertions.assertEquals(expectedAmounts, sortedAmounts);
    }
    /**
     * This method tests if the method removeOffers is working correctly, creating some new order samples and verifying if orders will be correctly removed.
     */
    @Test
    void removeOffers() {
        // Create sample order with offers
        Order order = new Order("Property1", 25);
        order.setAmount(new ArrayList<>(Arrays.asList(100.0, 50.0, 75.0)));
        orderRepository.setOrdersList(order);
        // Remove offers except the one that was accepted
        orderRepository.removeOffers(1, 0);
        // Check if the offers are removed correctly
        List<Double> expectedOffers = Arrays.asList(50.0);
        // Compares the expected order list with the one that results from the removal
        Assertions.assertEquals(expectedOffers, order.getAmount());
    }
    @Test
    void removeOffer() {
        // Create sample order with offers
        Order order = new Order("Property1", 25);
        order.setAmount(new ArrayList<>(Arrays.asList(100.0, 50.0, 75.0)));
        orderRepository.setOrdersList(order);
        // Remove the declined offer
        orderRepository.removeOffer(1, 0);
        // Check if the offer is removed correctly
        List<Double> expectedOffers = Arrays.asList(100.0, 75.0);
        // Compares the expected order list with the one that results from the removal
        Assertions.assertEquals(expectedOffers, order.getAmount());
    }
}