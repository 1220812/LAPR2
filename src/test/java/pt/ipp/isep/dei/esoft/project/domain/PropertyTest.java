package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    @Test
    void getDistanceFromTheCityCenter() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        assertEquals(100, property.getDistanceFromTheCityCenter());
    }

    @Test
    void getArea() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        assertEquals(1000, property.getArea());
    }

    @Test
    void setArea() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        property.setArea(2000);
        assertEquals(2000, property.getArea());
    }

    @Test
    void getAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        assertEquals(address, property.getAddress());
    }

    @Test
    void setAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        Address address2 = new Address("124 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        property.setAddress(address2);
        assertEquals(address2, property.getAddress());
    }

    @Test
    void setDistanceFromTheCityCenter() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        property.setDistanceFromTheCityCenter(2000);
        assertEquals(2000, property.getDistanceFromTheCityCenter());
    }

    @Test
    void getPropertyType() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        property.setArea(2000);
        assertEquals(propertyType, property.getPropertyType());
    }

    @Test
    void setPropertyType() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        PropertyType propertyType1 = new PropertyType("House");
        property.setPropertyType(propertyType1);
        assertEquals(propertyType1, property.getPropertyType());
    }

    @Test
    void testEquals() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");

        Property property1 = new Property(1000, 100, address, propertyType, photographsList);
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        Property property2 = new Property(500, 100, address, propertyType, photographsList);

        Assertions.assertEquals(property1, property);
        Assertions.assertNotEquals(property1, property2);
    }

    @Test
    void testHashCode() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");

        Property property1 = new Property(1000, 100, address, propertyType, photographsList);
        Property property = new Property(1000, 100, address, propertyType, photographsList);
        Property property2 = new Property(500, 100, address, propertyType, photographsList);

        Assertions.assertEquals(property1.hashCode(), property.hashCode());
        Assertions.assertNotEquals(property1.hashCode(), property2.hashCode());
    }

    @Test
    void testClone() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");

        Property property1 = new Property(1000, 100, address, propertyType, photographsList);
        Property property = property1.clone();
        assertEquals(property1, property);
    }
}