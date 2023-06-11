package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnnouncementTest {

    @Test
    void getDate() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(LocalDate.of(2021,1,1),announcement.getDate());
    }

    @Test
    void setDate() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(LocalDate.of(2021,1,1),announcement.getDate());
        announcement.setDate(LocalDate.of(2021,1,2));
        assertEquals(LocalDate.of(2021,1,2),announcement.getDate());
    }

    @Test
    void getCommission() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(5,announcement.getCommission());
    }

    @Test
    void setCommission() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(5,announcement.getCommission());
        announcement.setCommission(10);
        assertEquals(10,announcement.getCommission());
    }

    @Test
    void getCommissionType() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals("per",announcement.getCommissionType());
    }

    @Test
    void setCommissionType() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals("per",announcement.getCommissionType());
        announcement.setCommissionType("fix");
        assertEquals("fix",announcement.getCommissionType());
    }

    @Test
    void getRequestType() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(new RequestType("Rent",2),announcement.getRequestType());
    }

    @Test
    void setRequestType() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(new RequestType("Rent",2),announcement.getRequestType());
        announcement.setRequestType(new RequestType("Sell"));
        assertEquals(new RequestType("Sell"),announcement.getRequestType());
    }

    @Test
    void getPrice() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(100000,announcement.getPrice());
    }

    @Test
    void setPrice() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(100000,announcement.getPrice());
        announcement.setPrice(200000);
        assertEquals(200000,announcement.getPrice());
    }

    @Test
    void getStore() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(new Store("Store1",1),announcement.getStore());
    }

    @Test
    void setOwner() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678")),announcement.getOwner());
        announcement.setOwner(new Owner("Joao","987654321","joao@gmail.com",address, new TaxNumber("123466789"),new PassportCardNumber("12745678")));
        assertEquals(new Owner("Joao","987654321","joao@gmail.com",address, new TaxNumber("123466789"),new PassportCardNumber("12745678")),announcement.getOwner());
    }

    @Test
    void setAgent() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456"),announcement.getAgent());
        announcement.setAgent(new Agent("Maria","987654321","maria@gmail.com",new PassportCardNumber("12745678"),new TaxNumber("123466789"),address,new Role("Agent"),new Agency(1,"agency1",address,"agency@gamil.com","123456789"),store,"123456"));
        assertEquals(new Agent("Maria","987654321","maria@gmail.com",new PassportCardNumber("12745678"),new TaxNumber("123466789"),address,new Role("Agent"),new Agency(1,"agency1",address,"agency@gamil.com","123456789"),store,"123456"),announcement.getAgent());
    }

    @Test
    void getOwner() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678")),announcement.getOwner());
    }

    @Test
    void getAgent() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456"),announcement.getAgent());
    }

    @Test
    void setStore() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        assertEquals(new Store("Store1",1),announcement.getStore());
        announcement.setStore(new Store("Store2",2));
        assertEquals(new Store("Store2",2),announcement.getStore());
    }

    @Test
    void existsPrice() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        boolean result = announcement.existsPrice(100000);
        assertTrue(result);
    }

    @Test
    void testClone() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1",1);
        Owner owner = new Owner("Maria","987654321","maria@gmail.com",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678","joao@gmail.com",new PassportCardNumber("12345678"),new TaxNumber("123456789"), address,new Role("Agent"),new Agency(1,"agency1",address,"agency1@gmail.com","123456789"),store,"123456");
        Announcement announcement = new Announcement(new Property(1000,5,address, new PropertyType("House"),photographs), LocalDate.of(2021,1,1),"per",5,new RequestType("Rent",2),agent,100000,owner,store);
        Announcement clonedAnnouncement = announcement.clone();
        assertEquals(announcement.getProperty(), clonedAnnouncement.getProperty());
        assertEquals(announcement.getDate(), clonedAnnouncement.getDate());
        assertEquals(announcement.getCommissionType(), clonedAnnouncement.getCommissionType());
        assertEquals(announcement.getCommission(), clonedAnnouncement.getCommission());
        assertEquals(announcement.getRequestType(), clonedAnnouncement.getRequestType());
        assertEquals(announcement.getAgent(), clonedAnnouncement.getAgent());
        assertEquals(announcement.getPrice(), clonedAnnouncement.getPrice());
        assertEquals(announcement.getOwner(), clonedAnnouncement.getOwner());
        assertEquals(announcement.getStore(), clonedAnnouncement.getStore());
    }
}