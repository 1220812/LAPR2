package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class CreateRequestController {
    Repositories repositories = Repositories.getInstance();
    private AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();
    private SunExposureRepository sunExposureRepository = Repositories.getInstance().getSunExposureRepository();
    private RequestRepository requestRepository = Repositories.getInstance().getRequestRepository();
    private final RequestTypeRepository requestTypeRepository;

    public CreateRequestController() {
        requestTypeRepository = Repositories.getInstance().getRequestTypeRepository();
    }

    public List<RequestType> getRequestTypeList() {
        return requestTypeRepository.getRequestTypeList();
    }

    public List<PropertyType> getPropertiesTypeList(){
        return Repositories.getInstance().getPropertyTypeRepository().getPropertyType();
    }
    public Property createLand(double area, double distanceFromTheCityCentre, Address address, PropertyType propertyType, List<Photographs> photographsList) {
        return new Property(area, distanceFromTheCityCentre, address, propertyType, photographsList);
    }
    public RequestType createRentRequestType(String requestType, int contractDuration){
        return new RequestType(requestType, contractDuration);
    }
    public RequestType createSellRequestType(String requestType){
        return new RequestType(requestType);
    }
    public House createHouse(Address address, double area, double distanceFromCityCenter, int numberOfBathrooms, int numberOfBedrooms, int parking, boolean basement, SunExposure sunExposure, boolean loft, PropertyType propertyType, List<Photographs> photos, List<AvailableEquipment> equipment) {
        return new House(address, area, distanceFromCityCenter,propertyType, numberOfBathrooms, numberOfBedrooms, parking, basement, sunExposure, loft, photos, equipment);
    }
    public Residence createResidence(Address address, double area, double distanceFromCityCenter, int numberOfBathrooms, int numberOfBedrooms, int parking, PropertyType propertyType, List<Photographs> photos, List<AvailableEquipment> equipment){
        return new Residence(address, area, distanceFromCityCenter,propertyType, numberOfBathrooms, numberOfBedrooms, parking, photos, equipment);
    }
    public Request createRequest(Property property, RequestType requestType, double price, Agent agent, Owner owner, LocalDate requestDate, Store store){
        return new Request(property, requestDate, agent, owner,price, requestType, store);
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
    public Request registerRequest(Request request) {
        return Repositories.getInstance().getRequestRepository().addRequest(request);
    }
    public List<Request> getRequests() {
        return Repositories.getInstance().getRequestRepository().getRequests();
    }
}