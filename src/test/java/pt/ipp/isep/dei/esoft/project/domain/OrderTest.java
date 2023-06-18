package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Order test.
 */
class OrderTest {
    /**
     * Get announcement.
     */
    @Test
    void getAnnouncement(){
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Order order = new Order(announcement,100000,"joao@gmail.com");
        assertEquals(announcement, order.getAnnouncement());
    }

    /**
     * Sets announcement.
     */
    @Test
    void setAnnouncement() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Announcement announcement1 = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",3,new RequestType("Rent",2),agent,100000,owner,store);
        Order order = new Order(announcement,100000,"test@this.example");
        assertEquals(announcement, order.getAnnouncement());
        order.setAnnouncement(announcement1);
        assertEquals(announcement1, order.getAnnouncement());
    }

    /**
     * Sets order price.
     */
    @Test
    void setOrderPrice() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Order order = new Order(announcement, 100000.0, "test@example.com");
        assertEquals(100000.0, order.getOrderPrice());
        order.setOrderPrice(150000.0);
        assertEquals(150000.0, order.getOrderPrice());
    }

    /**
     * Gets order price.
     */
    @Test
    void getOrderPrice() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Order order = new Order(announcement, 100000.0, "test@this.app");
        assertEquals(100000.0, order.getOrderPrice());
    }

    /**
     * Gets email.
     */
    @Test
    void getEmail() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Order order = new Order(announcement, 100000.0, "test@this.app");
        assertEquals("test@this.app", order.getEmail());
    }

    /**
     * Sets email.
     */
    @Test
    void setEmail() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Order order = new Order(announcement, 100000.0, "test@this.app");
        assertEquals("test@this.app", order.getEmail());
        order.setEmail("test");
        assertEquals("test", order.getEmail());
    }

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Order order = new Order(announcement, 100000.0, "test@this.app");
        Order order1 = new Order(announcement, 100000.0, "test@this.app");
        assertTrue(order.equals(order1));
    }

    /**
     * Test hash code.
     */
    @Test
    void testHashCode() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Order order = new Order(announcement, 100000.0, "test@this.app");
        Order order1 = new Order(announcement, 100000.0, "test@this.app");
        assertEquals(order.hashCode(), order1.hashCode());
    }

    /**
     * Test clone.
     */
    @Test
    void testClone() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs),LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Order order = new Order(announcement, 100000.0, "test@this.app");
        Order order1 = order.clone();
        assertNotSame(order1, order);
        assertEquals(order1, order);
    }

}