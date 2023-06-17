




package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OwnerRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.time.LocalDate;
import java.util.List;

/**
 * Register announcement controller.
 */
public class RegisterAnnouncementController {

    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();

    /**
     * Get property type list.
     *
     * @return the list
     */
    public List<PropertyType> getPropertyType(){
        return Repositories.getInstance().getPropertyTypeRepository().getPropertyType();
    }

    /**
     * Check area.
     *
     * @param area the area
     * @return the boolean
     */
    public boolean checkArea(double area) {return (Property.existsArea(area));}

    /**
     * Check door number.
     *
     * @param doorNumber the door number
     * @return the boolean
     */
    public boolean checkDoorNumber(int doorNumber) {return (Address.existsDoorNumber(doorNumber));}

    /**
     * Check zip code.
     *
     * @param zipCode the zip code
     * @return the boolean
     */
    public boolean checkZipCode(String zipCode) {return (Address.existsZipCode(zipCode));}

    /**
     * Check distance from city center.
     *
     * @param distanceFromCityCenter the distance from city center
     * @return the boolean
     */
    public boolean checkDistanceFromCityCenter(double distanceFromCityCenter) {return (Property.existsDistanceFromCityCenter(distanceFromCityCenter));}

    /**
     * Check price.
     *
     * @param price the price
     * @return the boolean
     */
    public boolean checkPrice(double price) {return (Announcement.existsPrice(price));}

    /**
     * Get addresses list.
     *
     * @return the list
     */
    public List<Address> getAddresses(){
        return Repositories.getInstance().getAddressRepository().getAddressList();
    }

    /**
     * Gets available equipment list.
     *
     * @return the available equipment list
     */
    public List<AvailableEquipment> getAvailableEquipmentList() {
        return Repositories.getInstance().getAvailableEquipmentRepository().getAvailableEquipmentList();
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
     * Create property.
     *
     * @param area                   the area
     * @param distanceFromCityCenter the distance from city center
     * @param address                the address
     * @param propertyType           the property type
     * @param photos                 the photos
     * @return the property
     */
    public Property createProperty(double area, double distanceFromCityCenter, Address address, PropertyType propertyType, List<Photographs> photos){
        return new Property(area, distanceFromCityCenter, address, propertyType, photos);
    }

    /**
     * Create residence.
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
     * Create house.
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
     * Create request type.
     *
     * @param requestType      the request type
     * @param contractDuration the contract duration
     * @return the request type
     */
    public RequestType createRequestType(String requestType, double contractDuration) {
        return new RequestType(requestType, contractDuration);
    }

    /**
     * Create announcement.
     *
     * @param property       the property
     * @param date           the date
     * @param commissionType the commission type
     * @param commission     the commission
     * @param requestType    the request type
     * @param propertyType   the property type
     * @param agent          the agent
     * @param store          the store
     * @param owner          the owner
     * @param price          the price
     * @return the announcement
     */
    public Announcement createAnnouncement(Property property, LocalDate date, String commissionType, double commission , RequestType requestType, PropertyType propertyType, Agent agent, Store store, Owner owner, double price){
        return new Announcement(property, date, commissionType, commission, requestType, agent, price, owner, store);
    }

    /**
     * Register announcement.
     *
     * @param announcement the announcement
     * @return the announcement
     */
    public Announcement registerAnnouncement(Announcement announcement){
        return AnnouncementRepository.addAnnouncement(announcement);
    }

    /**
     * Check owner.
     *
     * @param ownerEmail the owner email
     * @return the boolean
     */
    public boolean checkOwnerExistence(String ownerEmail) {
        return OwnerRepository.checkOwnerEmail(ownerEmail);
    }

    /**
     * Gets current agent.
     *
     * @return the current agent
     */
    public Agent getCurrentAgent() {
        return this.repositories.getAgentRepository().getAgentByUserSession(getCurrentSession());
    }

    /**
     * Gets owner by email.
     *
     * @param ownerEmail the owner email
     * @return the owner by email
     */
    public Owner getOwnerByEmail(String ownerEmail) {
        return this.repositories.getOwnerRepository().getOwnerByEmail(ownerEmail);
    }

    /**
     * 0
     * Get current user session.
     *
     * @return the user session
     */
    public UserSession getCurrentSession(){
        return this.repositories.getAuthenticationRepository().getCurrentUserSession();
    }

    public String getOwnerPhone(Owner owner) {
        return owner.getPhoneNumber();
    }

    public String getAgentPhone(Agent agent) {
        return agent.getPhoneNumber();
    }

    public List<PropertyType> getPropertyType(Announcement announcement){
        return Repositories.getInstance().getPropertyTypeRepository().getPropertyType();
    }

    public Address getAddress(Announcement announcement) {
        return announcement.getProperty().getAddress();
    }

    public String getAgentName(Agent agent) {
        return agent.getName();
    }
}
