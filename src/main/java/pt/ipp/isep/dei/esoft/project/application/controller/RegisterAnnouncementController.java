package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OwnerRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class RegisterAnnouncementController {

    Repositories repositories = Repositories.getInstance();

    public List<PropertyType> getPropertyType(){
        return Repositories.getInstance().getPropertyTypeRepository().getPropertyType();
    }


   public boolean checkArea(double area) {return (Property.existsArea(area));}

    public boolean checkDoorNumber(int doorNumber) {return (Address.existsDoorNumber(doorNumber));}

    public boolean checkZipCode(String zipCode) {return (Address.existsZipCode(zipCode));}

    public boolean checkDistanceFromCityCenter(double distanceFromCityCenter) {return (Property.existsDistanceFromCityCenter(distanceFromCityCenter));}

    public boolean checkPrice(double price) {return (Announcement.existsPrice(price));}

    public List<Address> getAddresses(){
        return Repositories.getInstance().getAddressRepository().getAddressList();
    }

    public List<AvailableEquipment> getAvailableEquipmentList() {
        return Repositories.getInstance().getAvailableEquipmentRepository().getAvailableEquipmentList();
    }

    public List<SunExposure> getSunExposuresList() {
        return Repositories.getInstance().getSunExposureRepository().getSunExposureList();
    }

    public Property createProperty(double area, double distanceFromCityCenter, Address address, PropertyType propertyType, List<Photographs> photos){
        return new Property(area, distanceFromCityCenter, address, propertyType, photos);
    }

    public Residence createResidence(Address address, double area, double distanceFromCityCenter, int numberOfBathrooms, int numberOfBedrooms, int parking, PropertyType propertyType, List<Photographs> photos,  boolean airConditioning, boolean centralHeating){
        return new Residence(address, area, distanceFromCityCenter, propertyType,numberOfBathrooms, numberOfBedrooms, parking, photos, airConditioning, centralHeating);
    }

    public House createHouse(Address address, double area, double distanceFromCityCenter, int numberOfBathrooms, int numberOfBedrooms, int parking,  boolean airConditioning, boolean centralHeating, boolean basement, SunExposure sunExposure, boolean loft, PropertyType propertyType, List<Photographs> photos, RequestType requestType) {
        return new House(address, area, distanceFromCityCenter,propertyType, numberOfBathrooms, numberOfBedrooms, parking, airConditioning, centralHeating, basement, sunExposure, loft, photos);
    }

    public RequestType createRequestType(String requestType, double contractDuration) {
        return new RequestType(requestType, contractDuration);
    }

    public Announcement createAnnouncement(Property property, LocalDate date, String commissionType, double commission , RequestType requestType, PropertyType propertyType, Agent agent, Store store, Owner owner, double price){
        return new Announcement(property, date, commissionType, commission, requestType, agent, price, owner, store);
    }

    public Announcement registerAnnouncement(Announcement announcement){
        return AnnouncementRepository.addAnnouncement(announcement);
    }

    public boolean checkOwnerExistence(String ownerEmail) {
        return OwnerRepository.checkOwnerEmail(ownerEmail);
    }

}
