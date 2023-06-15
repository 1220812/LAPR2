package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RequestRepositoryTest {

    @Test
    void getRequests() {
        RequestRepository requestRepository = new RequestRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        Agent agent = new Agent("John", "913456456", "913456456", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Owner owner = new Owner("Jane", "912345674", "jane@gmail.com", new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Store store = new Store("Store", 1);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Request request = new Request(property, date, agent, owner, 100000, requestType, store);
        requestRepository.addRequest(request);
        List<Request> requests = requestRepository.getRequests();
        assertTrue(requests.contains(request));
    }

    @Test
    void add() {
        RequestRepository requestRepository = new RequestRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        Agent agent = new Agent("John", "913456456", "913456456", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Owner owner = new Owner("Jane", "912345674", "jane@gmail.com", new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Store store = new Store("Store", 1);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Request request = new Request(property, date, agent, owner, 100000, requestType, store);
        boolean result = requestRepository.add(request);
        assertTrue(result);
    }

    @Test
    void addRequest() {
        RequestRepository requestRepository = new RequestRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        Agent agent = new Agent("John", "913456456", "913456456", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Owner owner = new Owner("Jane", "912345674", "jane@gmail.com", new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Store store = new Store("Store", 1);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Request request = new Request(property, date, agent, owner, 100000, requestType, store);
        Request addRequest = requestRepository.addRequest(request);
        assertEquals(request, addRequest);
    }

    @Test
    void removeRequest() {
        RequestRepository requestRepository = new RequestRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        Agent agent = new Agent("John", "913456456", "913456456", address, new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Owner owner = new Owner("Jane", "912345674", "jane@gmail.com", new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        Store store = new Store("Store", 1);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Request request = new Request(property, date, agent, owner, 100000, requestType, store);
        requestRepository.removeRequest(request);
        List<Request> requests = requestRepository.getRequests();
        assertFalse(requests.contains(request));
    }

    @Test
    void getRequestAssignedList() throws IOException {
        RequestRepository requestRepository = new RequestRepository();
        List<Request> requests = new ArrayList<>();
        List<Request> sortedList = requestRepository.getRequestsSorted(requests);
        assertNotNull(sortedList);
        assertEquals(requests.size(), sortedList.size());
    }

    @Test
    void getRequestsSorted() throws IOException {
        RequestRepository requestRepository = new RequestRepository();
        List<Request> requests = new ArrayList<>();
        List<Request> requests1 = requestRepository.getRequestsSorted(requests);
        assertNotNull(requests1);
        assertEquals(requests.size(), requests1.size());
    }

    @Test
    void getAgentList() {
        RequestRepository requestRepository = new RequestRepository();
        List<Request> requests = new ArrayList<>();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Agent agent = new Agent("John", "123456789", "john@email", new Address("Street", 2, 3, "12345", new State("California"), new District("East"), new City("San Francisco")), new TaxNumber("123456789"), new PassportCardNumber("123456789"));
        Owner owner = new Owner("Jane", "123456789", "jane@gmail.com", address, new TaxNumber("123456789"), new PassportCardNumber("123456789"));
        Request assigned = new Request(property, date, agent, owner, 200000, requestType, new Store("Store", 1));
        assigned.setAgent(agent);
        requests.add(assigned);
        List<Request> agentList = requestRepository.getRequestAssignedList(agent);
        assertEquals(1, requests.size());
    }
}