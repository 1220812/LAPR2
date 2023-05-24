package pt.ipp.isep.dei.esoft.project.application.controller;



import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

public class CreateRequestController {

    private final RequestRepository requestRepository = Repositories.getInstance().getRequestRepository();
    private AvailableEquipmentRepository availableEquipmentRepository = null;
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

//    public List<PropertyType> getPropertiesTypeList() {
//        return List.of(PropertyType.values());
//    }

    public List<Address> getAddresses() {
        return Repositories.getInstance().getAddressRepository().getAddressList();
    }

    public List<RequestType> getRequestTypeList() {
        return requestTypeRepository.getRequestTypeList();
    }

    public List<PropertyType> getPropertiesTypeList(){
        return Repositories.getInstance().getPropertyTypeRepository().getPropertyType();
    }

    public RequestType createRequestType(String name) {
        requestType = requestTypeRepository.createRequestType(name);
        return requestType;
    }

    public Property createProperty(double area, double distanceFromCityCenter, Address address, double price, List<Photographs> photographsList,Store store, Agent agent,RequestType requestType) {
        return new Property(area, distanceFromCityCenter, address, price, photographsList, store, agent, requestType);
    }
    public Request createRequest(PropertyType propertyType, double price, RequestType requestType, Agent agent, Store store){
        return new Request(propertyType, price, requestType, agent, store);
    }



    public House createHouse(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, List<AvailableEquipment> availableEquipment, boolean basement, SunExposure sunExposure, boolean inhabitableLoft, double price, List<Photographs> photoList, Agent agent, Store store, RequestType requestType) {
        return new House(address, area, distanceFromCityCentre, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, availableEquipment, basement, sunExposure, inhabitableLoft, price, photoList, agent, store, requestType);
    }

    public Residence createResidence(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, double price, List<Photographs> photographsList, List<AvailableEquipment> availableEquipment, Agent agent, Store store, RequestType requestType) {
        return new Residence( address,  area,  distanceFromCityCentre,  numberOfBathrooms,  numberOfBedrooms,  numberOfParkingSpaces,  price,photographsList,availableEquipment,agent, store, requestType);
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


//    public Request createRequest() {
//        return new Request(propertyType, area, distanceFromCityCenter, address, price, photographsList, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, availableEquipment, basement, sunExposure, inhabitableLoft);
//    }

}
