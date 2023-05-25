package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.PropertyResourceBundle;

public class RegisterAnnouncementController {

    Repositories repositories = Repositories.getInstance();

    public boolean checkEmail(String email) {
        return (User.existsEmail(email));
    }

    public List<PropertyType> getPropertyType(){
        return Repositories.getInstance().getPropertyTypeRepository().getPropertyType();
    }


   public boolean checkArea(double area) {return (Property.existsArea(area));}

    public boolean checkDoorNumber(int doorNumber) {return (Address.existsDoorNumber(doorNumber));}

    public boolean checkZipCode(String zipCode) {return (Address.existsZipCode(zipCode));}

    public boolean checkDistanceFromCityCenter(double distanceFromCityCenter) {return (Property.existsDistanceFromCityCenter(distanceFromCityCenter));}

    public boolean checkPrice(double price) {return (Property.existsPrice(price));}

    public List<Address> getAddresses(){
        return Repositories.getInstance().getAddressRepository().getAddressList();
    }

    public List<AvailableEquipment> getAvailableEquipmentList() {
        return Repositories.getInstance().getAvailableEquipmentRepository().getAvailableEquipmentList();
    }

    public List<SunExposure> getSunExposuresList() {
        return Repositories.getInstance().getSunExposureRepository().getSunExposureList();
    }

    public Property createProperty(double area, double distanceFromCityCenter, Address address, double price, List<Photographs> photos, RequestType requestType){
        return new Property(area, distanceFromCityCenter, address, price, photos, requestType);
    }

    public Residence createResidence(Address address, double area, double distanceFromCityCenter, int numberOfBathrooms, int numberOfBedrooms, int parking, List<AvailableEquipment> availableEquipment, double price, List<Photographs> photos, RequestType requestType){
        return new Residence(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, parking, price, photos, availableEquipment, requestType);
    }

    public House createHouse(Address address, double area, double distanceFromCityCenter, int numberOfBathrooms, int numberOfBedrooms, int parking, List<AvailableEquipment> availableEquipment, boolean basement, SunExposure sunExposure, boolean loft, double price, List<Photographs> photos, RequestType requestType) {
        return new House(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, parking, availableEquipment, basement, sunExposure, loft, price, photos, requestType);
    }

    public RequestType createRequestType(String requestType, double contractDuration) {
        return new RequestType(requestType, contractDuration);
    }

    public Announcement createAnnouncement(Property property, LocalDate date,String comissionType,double comission ,RequestType requestType) {
        return new Announcement(property, date, comissionType, comission, requestType);
    }

    public Announcement registerAnnouncement(Announcement announcement){
        return AnnouncementRepository.addAnnouncement(announcement);
    }

}
