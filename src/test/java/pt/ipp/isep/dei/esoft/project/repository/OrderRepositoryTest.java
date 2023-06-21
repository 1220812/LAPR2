package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Order repository test.
 */
class OrderRepositoryTest {

    /**
     * Add new order.
     */
    @Test
    void addNewOrder() {
        OrderRepository orderRepository = new OrderRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));
        Order order = new Order(announcement, 100000, "john2example");
        orderRepository.addNewOrder(order);
        assertTrue(orderRepository.getOrders().contains(order));
    }

    /**
     * Validate order.
     */
    @Test
    void validateOrder() {
        OrderRepository orderRepository = new OrderRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));
        boolean valid = orderRepository.validateOrder(announcement, 100000);
        assertTrue(valid);
    }

    /**
     * Gets orders.
     *
     * @Test void valid() {OrderRepository orderRepository = new OrderRepository();Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));PropertyType propertyType = new PropertyType("Apartment");RequestType requestType = new RequestType("Rent", 2);LocalDate date = LocalDate.of(2020, 1, 1);Property property = new Property(100, 1000, address, propertyType, 200000, date);Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));Order order = new Order(announcement, 100000, "john2example");orderRepository.addNewOrder(order);boolean valid = orderRepository.valid(order);assertTrue(valid);}
     */
    @Test
    void getOrders() {
        OrderRepository orderRepository = new OrderRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));
        Order order = new Order(announcement, 100000, "john2example");
        orderRepository.addNewOrder(order);
        List<Order> orders = orderRepository.getOrders();
        assertTrue(orders.contains(order));
    }

    /**
     * Gets orders by announcement.
     */
    @Test
    void getOrdersByAnnouncement() {
        OrderRepository orderRepository = new OrderRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));
        Order order = new Order(announcement, 100000, "john2example");
        orderRepository.addNewOrder(order);
        List<Order> orders = orderRepository.getOrdersByAnnouncement(announcement);
        assertTrue(orders.contains(order));
    }
}