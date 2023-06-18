package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AnnouncementRepositoryTest {

    @Test
    void getAnnouncements() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        AnnouncementRepository announcementRepository = new AnnouncementRepository();
        Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));
        announcementRepository.addAnnouncement(announcement);
        List<Announcement> announcements = announcementRepository.getAnnouncements();
        assertTrue(announcements.contains(announcement));
    }

    @Test
    void add() throws CloneNotSupportedException {
        AnnouncementRepository announcementRepository = new AnnouncementRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));
        List<Announcement> addedAnnouncement = announcementRepository.add(announcement);
        assertTrue(addedAnnouncement.contains(announcement));
    }

    @Test
    void validateAnnouncement() {
        AnnouncementRepository announcementRepository = new AnnouncementRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));
        boolean valid = announcementRepository.validateAnnouncement(announcement);
        assertTrue(valid);
        announcementRepository.addAnnouncement(announcement);
        boolean valid1 = announcementRepository.validateAnnouncement(announcement);
        assertFalse(valid1);
    }

    @Test
    void getAnnouncementsList() {
        AnnouncementRepository announcementRepository = new AnnouncementRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));
        announcementRepository.addAnnouncement(announcement);
        List<Announcement> announcements = announcementRepository.getAnnouncementsList();
        assertTrue(announcements.contains(announcement));
    }

    @Test
    void addAnnouncement() {
        AnnouncementRepository announcementRepository = new AnnouncementRepository();
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        RequestType requestType = new RequestType("Rent", 2);
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Announcement announcement = new Announcement(property, date, 5, requestType, 100000, new Owner("John", "912345678", "john@test.com", address, new TaxNumber("123456789"), new PassportCardNumber("12345678")), new Store("Store", 1));
        announcementRepository.addAnnouncement(announcement);
        List<Announcement> announcements = announcementRepository.getAnnouncements();
        assertTrue(announcements.contains(announcement));
    }
}