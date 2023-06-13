package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RequestTypeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateRequestControllerTest {
    private CreateRequestController createRequestController = new CreateRequestController();
    RequestTypeRepository requestTypeRepository = Repositories.getInstance().getRequestTypeRepository();


    @Test
    void getRequestTypeList() {
        List<RequestType> expectedRequestTypes = new ArrayList<>();
        expectedRequestTypes.add(new RequestType("Rent", 12));
        expectedRequestTypes.add(new RequestType("Sell"));

        List<RequestType> actualRequestTypes = createRequestController.getRequestTypeList();

        assertEquals(expectedRequestTypes.size(), actualRequestTypes.size());
        assertEquals(expectedRequestTypes.get(0).getRequestType(), actualRequestTypes.get(0).getRequestType());
        assertEquals(expectedRequestTypes.get(0).getContractDuration(), actualRequestTypes.get(0).getContractDuration());
        assertEquals(expectedRequestTypes.get(1).getRequestType(), actualRequestTypes.get(1).getRequestType());
        assertEquals(expectedRequestTypes.get(1).getContractDuration(), actualRequestTypes.get(1).getContractDuration());
    }

    @Test
    void getPropertiesTypeList() {
    }

    @Test
    void createLand() {
        double area = 500.0;
        double distance = 10.0;
        Address address = new Address("123 Street",1,1, "12345", new State("California"), new District("North"),new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Land");
        List<Photographs> photographsList = new ArrayList<>();

        Property land = createRequestController.createLand(area, distance, address, propertyType, photographsList);

        assertEquals(area, land.getArea());
        assertEquals(distance, land.getDistanceFromTheCityCenter());
        assertEquals(address, land.getAddress());
        assertEquals(propertyType, land.getPropertyType());
    }

    /**void createRentRequestType() {
        RequestType requestType = new RequestType("Rent", 12);
        RequestType registeredRequestType = createRequestController.registerRequest(requestType);

        assertEquals(requestType, registeredRequestType);
        assertEquals(registeredRequestType, createRequestController.getRequestTypeList().get(0));
    }      */

    @Test
    void createSellRequestType() {
    }

    @Test
    void createHouse() {
        List<Photographs> photographsList = new ArrayList<>();
        House property = new House(new Address("123 Street",1,1, "12345",new State("California"), new District("Easthern"), new City("Los Angeles")), 250, 10, new PropertyType("House"), 3,2,1,true,true,true,new SunExposure("North"), true,photographsList);
        RequestType requestType = new RequestType("Rent", 12);
        double price = 1000.0;
        Agent agent = new Agent("John Doe","test@example", "111-111-111",new Address("123 Street",1,1, "12345",new State("California"), new District("Easthern"), new City("Los Angeles")), new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Owner owner = new Owner("Jane Smith");
        LocalDate requestDate = LocalDate.now();
        Store store = new Store("Store1", 1);

        Request request = createRequestController.createRequest(property, requestType, price, agent, owner, requestDate, store);
        Request registeredRequest = createRequestController.registerRequest(request);

        assertEquals(request, registeredRequest);
        assertEquals(registeredRequest, createRequestController.getRequests().get(0));
    }

    @Test
    void createApartment() {
    }

    @Test
    void createRequest() {
    }

    @Test
    void getAgencies() {
    }

    @Test
    void getStores() {
    }

    @Test
    void getAgent() {
    }

    @Test
    void getSunExposuresList() {
    }

    @Test
    void registerRequest() {
        Property property = new Property(500.0, 10.0, new Address("123 Street",1,1, "12345",new State("California"), new District("Easthern"), new City("Los Angeles")), new PropertyType("Land"), new ArrayList<>());
        RequestType requestType = new RequestType("Rent", 12);
        double price = 1000.0;
        Agent agent = new Agent("John Doe","test@example", "111-111-111",new Address("123 Street",1,1, "12345",new State("California"), new District("Easthern"), new City("Los Angeles")), new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Owner owner = new Owner("Jane Smith");
        LocalDate requestDate = LocalDate.now();
        Store store = new Store("Store1", 1);

        Request request = createRequestController.createRequest(property, requestType, price, agent, owner, requestDate, store);
        Request registeredRequest = createRequestController.registerRequest(request);

        assertEquals(request, registeredRequest);
        assertEquals(registeredRequest, createRequestController.getRequests().get(0));
    }
}