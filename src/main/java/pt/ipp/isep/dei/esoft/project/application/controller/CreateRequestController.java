package pt.ipp.isep.dei.esoft.project.application.controller;



import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreateRequestController {
    Repositories repositories = Repositories.getInstance();
    private AgencyRepository agencyRepository;
    private SunExposureRepository sunExposureRepository;
    private PropertyRepository propertyRepository;
    private RequestRepository requestRepository;
    private final RequestTypeRepository requestTypeRepository;


    public CreateRequestController() {
        requestTypeRepository = Repositories.getInstance().getRequestTypeRepository();
        propertyRepository = Repositories.getInstance().getPropertyRepository();
    }

    public List<RequestType> getRequestTypeList() {
        return requestTypeRepository.getRequestTypeList();
    }

    public List<PropertyType> getPropertiesTypeList(){
        return Repositories.getInstance().getPropertyTypeRepository().getPropertyType();
    }
    private PropertyRepository getPropertyRepository() {
        if(propertyRepository == null){
            Repositories repositories = Repositories.getInstance();
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }
    private RequestRepository getRequestRepository() {
        return Repositories.getInstance().getRequestRepository();
    }
    public Optional<Property> createLand(double area, double distanceFromTheCityCentre, Address address, double price, List<Photographs> photographsList) {
        Optional<Property> newProperty = Optional.empty();
        if(getPropertyRepository() !=  null){
            newProperty = getPropertyRepository().createLand(area, distanceFromTheCityCentre, address, price, photographsList);
        }
        return newProperty;
    }
    public Optional <Request> createSellRequest(Property property, LocalDate requestDate, PropertyType propertyType, Agent agent, Store store, Owner owner, double price, RequestType requestType){
        Optional <Request> optionalValue = Optional.empty();
        if(getRequestRepository() != null){
            optionalValue = getRequestRepository().CreateSaleRequest(property, requestDate, propertyType, agent, store, owner, price, requestType);
        }
        return optionalValue;
    }
    public Optional <Request> createRentRequest(Property property, LocalDate requestDate, PropertyType propertyType, Agent agent, Store store, Owner owner, int contractDuration, double price, RequestType requestType){
        Optional <Request> optionalValue = Optional.empty();
        if(getRequestRepository() != null){
            optionalValue = getRequestRepository().CreateRentRequest(property, requestDate, propertyType, agent, store, owner, contractDuration, price,requestType);
        }
        return optionalValue;
    }
    public Optional<Property> createHouse(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, boolean airConditioning , boolean centralHeating , boolean basement, SunExposure sunExposure, boolean inhabitableLoft, double price, List<Photographs> photoList) {
        Optional<Property> newProperty = Optional.empty();
        if(getPropertyRepository() !=  null){
            newProperty = getPropertyRepository().createHouse(address, area, distanceFromCityCentre, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, airConditioning, centralHeating, basement, sunExposure, inhabitableLoft, price, photoList);
        }
        return newProperty;
    }
    public Optional <Property> createApartment(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, double price, List<Photographs> photographsList, boolean centralHeating, boolean airConditioning) {
        Optional<Property> newProperty = Optional.empty();
        if(getPropertyRepository() != null){
            newProperty = getPropertyRepository().createApartment(address, area, distanceFromCityCentre, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, price, photographsList, centralHeating, airConditioning);
        }
        return newProperty;
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
    private final List<Property> properties = new ArrayList<>();
    public void addProperty(Property property) {
        this.properties.add(property);
    }
}
