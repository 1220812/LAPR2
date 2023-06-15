package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {

    @Test
    void getRequestType() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(new RequestType("Sell"), request.getRequestType());
    }

    @Test
    void setRequestType() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(new RequestType("Sell"), request.getRequestType());
        request.setRequestType(new RequestType("Rent"));
        assertEquals(new RequestType("Rent"), request.getRequestType());
    }

    @Test
    void getAgent() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456"), request.getAgent());
    }

    @Test
    void getOwner() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), request.getOwner());
    }

    @Test
    void getRequestDate() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(LocalDate.of(2021, 1, 1), request.getRequestDate());
    }

    @Test
    void getProperty() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Property property1 = new  Property(1000, 5, address, new PropertyType("House"), photographs);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(property1, LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(property1, request.getProperty());
    }

    @Test
    void getPrice() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(100000, request.getPrice());
    }

    @Test
    void setOwner() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), request.getOwner());
        request.setOwner(new Owner("Joao", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")));
        assertEquals(new Owner("Joao", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), request.getOwner());
    }

    @Test
    void setPrice() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(100000, request.getPrice());
        request.setPrice(200000);
        assertEquals(200000, request.getPrice());
    }

    @Test
    void setAgent() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456"), request.getAgent());
        request.setAgent(new Agent("Joao", "912445678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456"));
        assertEquals(new Agent("Joao", "912445678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456"), request.getAgent());
    }

    @Test
    void setProperty() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        Property property1 = new  Property(1000, 5, address, new PropertyType("House"), photographs);
        request.setProperty(property1);
        assertEquals(property1, request.getProperty());
    }

    @Test
    void testClone() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        Request request1 = request.clone();
        assertEquals(request1, request);
    }

    @Test
    void getStore() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(new Store("Store1", 1), request.getStore());
    }

    @Test
    void setStore() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        List<Photographs> photographs = new ArrayList<>();
        Store store = new Store("Store1", 1);
        Owner owner = new Owner("Maria", "987654321", "maria@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Agent agent = new Agent("Joao", "912345678", "joao@gmail.com", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), new Agency(1, "agency1", address, "agency1@gmail.com", "123456789"), store, "123456");
        Request request = new Request(new Property(1000, 5, address, new PropertyType("House"), photographs), LocalDate.of(2021, 1, 1), agent, owner, 100000, new RequestType("Sell"), store);
        assertEquals(new Store("Store1", 1), request.getStore());
        request.setStore(new Store("Store2", 2));
        assertEquals(new Store("Store2", 2), request.getStore());
    }
}