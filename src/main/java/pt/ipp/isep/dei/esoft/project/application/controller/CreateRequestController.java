package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.List;

public class CreateRequestController {

    private final RequestRepository requestRepository = Repositories.getInstance().getRequestRepository();
    private AvailableEquipmentRepository availableEquipmentRepository = Repositories.getInstance().getAvailableEquipmentRepository();
    private AgencyRepository agencyRepository = null;
    private SunExposureRepository sunExposureRepository = null;

    Repositories repositories = Repositories.getInstance();
    private final RequestTypeRepository requestTypeRepository;


    public CreateRequestController() {
        requestTypeRepository = Repositories.getInstance().getRequestTypeRepository();
    }

    private PropertyType propertyType;
    private City city;
    private District district;
    private State state;

    private RequestType requestType;

    public List<PropertyType> getPropertiesTypeList() {
        return Repositories.getInstance().getPropertyTypeRepository().getPropertyType();
    }
    public List<Address> getAddresses() {
        return Repositories.getInstance().getAddressRepository().getAddressList();
    }
    public List<RequestType> getRequestTypeList() {
        return requestTypeRepository.getRequestTypeList();
    }

    public RequestType createRequestType(String name) {
        requestType = requestTypeRepository.createRequestType(name);
        return requestType;
    }
    public Property createProperty(double area, double distanceFromCityCenter, PropertyAddress address, double price, List<Photographs> photographsList) {
        return new Property(area, distanceFromCityCenter, address, price, photographsList);
    }
    public House createHouse(PropertyAddress address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, List<AvailableEquipment> availableEquipment, boolean basement, SunExposure sunExposure, boolean inhabitableLoft, double price, List<Photographs> photoList) {
        return new House(address, area, distanceFromCityCentre, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, availableEquipment, basement, sunExposure, inhabitableLoft, price, photoList);
    }

    public Residence createResidence(PropertyAddress address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, double price, List<AvailableEquipment> availableEquipment, List<Photographs> photoList) {
        return new Residence(address, area, distanceFromCityCentre, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, price, photoList, availableEquipment);
    }
    public RequestTypeRepository getRequestTypeRepository() {
        if (requestTypeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            RequestTypeRepository rep = repositories.getRequestTypeRepository();
        }
        return requestTypeRepository;
    }

    public List<Agency> getAgencies() {
        return Repositories.getInstance().getAgencyRepository().getAgencyList();
    }

    public List<Store> getStores() {
        return Repositories.getInstance().getStoreRepository().getStoreList();
    }
    public List<Agent> getAgent() {
        return Repositories.getInstance().getAgentRepository().getAgentList();
    }

    public List<SunExposure> getSunExposuresList() {
        return Repositories.getInstance().getSunExposureRepository().getSunExposureList();
    }

    public List<AvailableEquipment> getAvailableEquipmentList() {
        return Repositories.getInstance().getAvailableEquipmentRepository().getAvailableEquipmentList();
    }

    public Request createRequest() {
        List<Photographs> a = new ArrayList<>();
        return new Request(new Property(2, 2, new PropertyAddress("a", "2", new State("a"), new District("a"), new City("a")), 2, a), 2,  new RequestType("a"), new Agent("a", "a", "a", new Address("a", new State("a"), new District("a"), new City("a"), "12345"), new TaxNumber("a"), new PassportCardNumber("z")), new Store(), new Owner("a", "a", "a", new Address("a", new State("a"), new District("a"), new City("a"), "12345"), new TaxNumber("a"), new PassportCardNumber("a") ));
    }

}
