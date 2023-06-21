package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * The type Create request controller.
 */
public class CreateRequestController {
    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();
    private AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();
    private SunExposureRepository sunExposureRepository = Repositories.getInstance().getSunExposureRepository();
    private RequestRepository requestRepository = Repositories.getInstance().getRequestRepository();
    private final RequestTypeRepository requestTypeRepository;

    /**
     * Instantiates a new Create request controller.
     */
    public CreateRequestController() {
        requestTypeRepository = Repositories.getInstance().getRequestTypeRepository();
    }

    /**
     * Gets request type list.
     *
     * @return the request type list
     */
    public List<RequestType> getRequestTypeList() {
        return requestTypeRepository.getRequestTypeList();
    }

    /**
     * Get properties type list list.
     *
     * @return the list
     */
    public List<PropertyType> getPropertiesTypeList(){
        return Repositories.getInstance().getPropertyTypeRepository().getPropertyType();
    }

    /**
     * Create land property.
     *
     * @param area                      the area
     * @param distanceFromTheCityCentre the distance from the city centre
     * @param address                   the address
     * @param propertyType              the property type
     * @param photographsList           the photographs list
     * @return the property
     */
    public Property createLand(double area, double distanceFromTheCityCentre, Address address, PropertyType propertyType, List<Photographs> photographsList) {
        return new Property(area, distanceFromTheCityCentre, address, propertyType, photographsList);
    }

    /**
     * Create rent request type request type.
     *
     * @param requestType      the request type
     * @param contractDuration the contract duration
     * @return the request type
     */
    public RequestType createRentRequestType(String requestType, int contractDuration){
        return new RequestType(requestType, contractDuration);
    }

    /**
     * Create sell request type request type.
     *
     * @param requestType the request type
     * @return the request type
     */
    public RequestType createSellRequestType(String requestType){
        return new RequestType(requestType);
    }

    /**
     * Create house house.
     *
     * @param address                the address
     * @param area                   the area
     * @param distanceFromCityCenter the distance from city center
     * @param numberOfBathrooms      the number of bathrooms
     * @param numberOfBedrooms       the number of bedrooms
     * @param parking                the parking
     * @param basement               the basement
     * @param sunExposure            the sun exposure
     * @param loft                   the loft
     * @param propertyType           the property type
     * @param photos                 the photos
     * @param equipment              the equipment
     * @return the house
     */
    public House createHouse(Address address, double area, double distanceFromCityCenter, int numberOfBathrooms, int numberOfBedrooms, int parking, boolean basement, SunExposure sunExposure, boolean loft, PropertyType propertyType, List<Photographs> photos, List<AvailableEquipment> equipment) {
        return new House(address, area, distanceFromCityCenter,propertyType, numberOfBathrooms, numberOfBedrooms, parking, basement, sunExposure, loft, photos, equipment);
    }

    /**
     * Create residence residence.
     *
     * @param address                the address
     * @param area                   the area
     * @param distanceFromCityCenter the distance from city center
     * @param numberOfBathrooms      the number of bathrooms
     * @param numberOfBedrooms       the number of bedrooms
     * @param parking                the parking
     * @param propertyType           the property type
     * @param photos                 the photos
     * @param equipment              the equipment
     * @return the residence
     */
    public Residence createResidence(Address address, double area, double distanceFromCityCenter, int numberOfBathrooms, int numberOfBedrooms, int parking, PropertyType propertyType, List<Photographs> photos, List<AvailableEquipment> equipment){
        return new Residence(address, area, distanceFromCityCenter,propertyType, numberOfBathrooms, numberOfBedrooms, parking, photos, equipment);
    }

    /**
     * Create request request.
     *
     * @param property    the property
     * @param requestType the request type
     * @param price       the price
     * @param agent       the agent
     * @param owner       the owner
     * @param requestDate the request date
     * @param store       the store
     * @return the request
     */
    public Request createRequest(Property property, RequestType requestType, double price, Agent agent, Owner owner, LocalDate requestDate, Store store){
        return new Request(property, requestDate, agent, owner,price, requestType, store);
    }

    /**
     * Gets agencies.
     *
     * @return the agencies
     */
    public List<Agency> getAgencies() {
        return Repositories.getInstance().getAgencyRepository().getAgencyList();
    }

    /**
     * Gets stores.
     *
     * @return the stores
     */
    public List<Store> getStores() {
        return Repositories.getInstance().getStoreRepository().getStoreList();
    }

    /**
     * Gets agent.
     *
     * @return the agent
     */
    public List<Agent> getAgent() {
        return Repositories.getInstance().getAgentRepository().getAgentList();
    }

    /**
     * Gets sun exposures list.
     *
     * @return the sun exposures list
     */
    public List<SunExposure> getSunExposuresList() {
        return Repositories.getInstance().getSunExposureRepository().getSunExposureList();
    }

    /**
     * Register request request.
     *
     * @param request the request
     * @return the request
     */
    public Request registerRequest(Request request) {
        return Repositories.getInstance().getRequestRepository().addRequest(request);
    }

    /**
     * Gets requests.
     *
     * @return the requests
     */
    public List<Request> getRequests() {
        return Repositories.getInstance().getRequestRepository().getRequests();
    }
}