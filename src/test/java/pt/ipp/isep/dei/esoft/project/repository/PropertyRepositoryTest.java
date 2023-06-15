package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PropertyRepositoryTest {

    @Test
    void add() {
        PropertyRepository propertyRepository = new PropertyRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Optional<Property> addedProperty = propertyRepository.add(property);
        assertTrue(addedProperty.isPresent());
        assertEquals(property, addedProperty.get());
        List<Property> properties = propertyRepository.getProperties();
        assertTrue(properties.contains(property));
    }

    @Test
    void createLand() {
        PropertyRepository propertyRepository = new PropertyRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Land");
        List<Photographs> photographsList = new ArrayList<>();
        Optional<Property> property = propertyRepository.createLand(100, 1000, address, propertyType, photographsList);
        assertTrue(property.isPresent());
        List<Property> properties = propertyRepository.getProperties();
        assertTrue(properties.contains(property.get()));
    }

    @Test
    void createApartment() {
        PropertyRepository propertyRepository = new PropertyRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Land");
        List<Photographs> photographsList = new ArrayList<>();
        Optional<Property> property = propertyRepository.createApartment(address, 100,10,1,2,3,propertyType,photographsList,true,true);
        assertTrue(property.isPresent());
        List<Property> properties = propertyRepository.getProperties();
        assertTrue(properties.contains(property.get()));
    }

    @Test
    void createHouse() {
        PropertyRepository propertyRepository = new PropertyRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Land");
        List<Photographs> photographsList = new ArrayList<>();
        Optional<Property> property = propertyRepository.createHouse(address, 100,10,1,2,3,true,true, false, new SunExposure("N"), true, propertyType, photographsList);
        assertTrue(property.isPresent());
        List<Property> properties = propertyRepository.getProperties();
        assertTrue(properties.contains(property.get()));
    }

    @Test
    void validateProperty() {
        PropertyRepository propertyRepository = new PropertyRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        boolean isValid1 = propertyRepository.validateProperty(property);
        assertTrue(isValid1);
        propertyRepository.addProperty(property);
        boolean isValid2 = propertyRepository.validateProperty(property);
        assertFalse(isValid2);
        Property property2 = new Property(10, 10, address, propertyType, 205600, date);
        boolean isValid3 = propertyRepository.validateProperty(property2);
        assertTrue(isValid3);
    }

    @Test
    void addProperty() {
        PropertyRepository propertyRepository = new PropertyRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        boolean added = propertyRepository.addProperty(property);
        assertTrue(added);
        List<Property> properties = propertyRepository.getProperties();
        assertTrue(properties.contains(property));
    }

    @Test
    void getProperties() {
        PropertyRepository propertyRepository = new PropertyRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        LocalDate date = LocalDate.of(2020, 1, 1);
        Property property = new Property(100, 1000, address, propertyType, 200000, date);
        Property property2 = new Property(10, 10, address, propertyType, 205600, date);
        propertyRepository.addProperty(property);
        propertyRepository.addProperty(property2);
        List<Property> retrievedProperties = propertyRepository.getProperties();
        assertNotSame(retrievedProperties, propertyRepository.getProperties());
        assertTrue(retrievedProperties.contains(property));
        assertTrue(retrievedProperties.contains(property2));
    }
}