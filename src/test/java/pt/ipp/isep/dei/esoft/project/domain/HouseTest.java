package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type House test.
 */
class HouseTest {

    /**
     * Test constructor and getters.
     */
    @Test
    public void testConstructorAndGetters() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("House");
        List<AvailableEquipment> availableEquipmentList = new ArrayList<>();

        House house = new House(address,100.0, 5.0, propertyType, 3, 3, 1, true,new SunExposure("North"), true,photographsList, availableEquipmentList);

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

    /**
     * Test setters.
     */
    @Test
    public void testSetters() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("House");
        List<AvailableEquipment> availableEquipmentList = new ArrayList<>();

        House house = new House(address,100.0, 5.0, propertyType, 3, 3, 1, true,new SunExposure("North"), false,photographsList, availableEquipmentList);

        house.setNumberOfBathrooms(3);
        house.setNumberOfBedrooms(4);
        house.setNumberOfParkingSpaces(2);

        Assertions.assertEquals(3, house.getNumberOfBathrooms());
        Assertions.assertEquals(4, house.getNumberOfBedrooms());
        Assertions.assertEquals(2, house.getNumberOfParkingSpaces());

    }

    /**
     * Test equals and hash code.
     */
    @Test
    public void testEqualsAndHashCode() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");
        List<AvailableEquipment> availableEquipmentList = new ArrayList<>();

        House residence1 = new House(address,100.0, 5.0, propertyType, 3, 3, 1, true,new SunExposure("North"), false,photographsList, availableEquipmentList);
        House residence2 = new House(address,100.0, 5.0, propertyType, 3, 2, 1, true,new SunExposure("North"), false,photographsList, availableEquipmentList);
        House residence3 = new House(address,100.0, 5.0, propertyType, 3, 3, 1, true,new SunExposure("North"), false,photographsList, availableEquipmentList);

        Assertions.assertEquals(residence1, residence3);
        Assertions.assertNotEquals(residence2, residence3);

        Assertions.assertNotEquals(residence2.hashCode(), residence3.hashCode());
    }
}