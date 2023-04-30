package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.PropertyType;
import pt.ipp.isep.dei.esoft.project.domain.User;

public class AnnouncementRepository {

    public Announcement createAnnouncement(PropertyType propertyType, User user, String descriptionOfProperty, String street, String state, String city, String district, String zipCodeEnd, String zipCodeStart, double distanceFromCityCenter, double area, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, String availableEquipment, boolean inhabitableLoft, boolean basement, String sunExposureLevel, int priceOfSale, int comissionType, double comissionValue,) {
        Announcement announcement = new Announcement(propertyType, user, descriptionOfProperty, street, state, city, district, zipCodeEnd, zipCodeStart, distanceFromCityCenter, area, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, availableEquipment, inhabitableLoft, basement, sunExposureLevel, priceOfSale, comissionValue);
        return announcement;
    }
}
