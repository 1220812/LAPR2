package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    public void testConstructorAndGetters() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("House");

        House house = new House(address, 100.0, 5.0, propertyType, 3, 3, 1, true, false, true, new SunExposure("North"),true, photographsList);

        Assertions.assertEquals(address, house.getAddress());
        Assertions.assertEquals(100.0, house.getArea());
        Assertions.assertEquals(propertyType, house.getPropertyType());
        Assertions.assertEquals(5.0, house.getDistanceFromTheCityCenter());
        Assertions.assertEquals(3, house.getNumberOfBathrooms());
        Assertions.assertEquals(3, house.getNumberOfBedrooms());
        Assertions.assertEquals(1, house.getNumberOfParkingSpaces());
        Assertions.assertEquals(true, house.inhabitableLoft());
        Assertions.assertEquals(true, house.basement());
    }

    @Test
    public void testSetters() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("House");

        House house = new House(address, 100.0, 5.0, propertyType, 3, 3, 1, true, false, true, new SunExposure("North"),true, photographsList);

        house.setNumberOfBathrooms(3);
        house.setNumberOfBedrooms(4);
        house.setNumberOfParkingSpaces(2);

        Assertions.assertEquals(3, house.getNumberOfBathrooms());
        Assertions.assertEquals(4, house.getNumberOfBedrooms());
        Assertions.assertEquals(2, house.getNumberOfParkingSpaces());

    }

    @Test
    public void testEqualsAndHashCode() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");

        House residence1 = new House(address, 100.0, 5.0, propertyType, 3, 3, 1, true, false, true, new SunExposure("North"),true, photographsList);
        House residence2 = new House(address, 130.0, 5.0, propertyType, 3, 3, 1, true, false, true, new SunExposure("North"),true, photographsList);
        House residence3 = new House(address, 100.0, 5.0, propertyType, 3, 3, 1, true, false, true, new SunExposure("North"),true, photographsList);

        Assertions.assertEquals(residence1, residence3);
        Assertions.assertNotEquals(residence2, residence3);

        Assertions.assertNotEquals(residence2.hashCode(), residence3.hashCode());
    }
}