package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Residence test.
 */
class ResidenceTest {

    /**
     * Test constructor and getters.
     */
    @Test
    public void testConstructorAndGetters() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");

        List<AvailableEquipment> availableEquipmentList = new ArrayList<>();

        Residence residence = new Residence(address, 100.0, 5.0, propertyType, 3, 3, 1, photographsList,availableEquipmentList);

        Assertions.assertEquals(address, residence.getAddress());
        Assertions.assertEquals(100.0, residence.getArea());
        Assertions.assertEquals(propertyType, residence.getPropertyType());
        Assertions.assertEquals(5.0, residence.getDistanceFromTheCityCenter());
        Assertions.assertEquals(3, residence.getNumberOfBathrooms());
        Assertions.assertEquals(3, residence.getNumberOfBedrooms());
        Assertions.assertEquals(1, residence.getNumberOfParkingSpaces());
    }

    /**
     * Test setters.
     */
    @Test
    public void testSetters() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        PropertyType propertyType = new PropertyType("Apartment");
        List<AvailableEquipment> availableEquipmentList = new ArrayList<>();
        List<Photographs> photographsList = new ArrayList<>();
        Residence residence = new Residence(address, 100.0, 5.0, propertyType, 2, 3, 1, photographsList,availableEquipmentList);

        residence.setNumberOfBathrooms(3);
        residence.setNumberOfBedrooms(4);
        residence.setNumberOfParkingSpaces(2);
        residence.setAirConditioning(true);
        residence.setCentralHeating(true);

        Assertions.assertEquals(3, residence.getNumberOfBathrooms());
        Assertions.assertEquals(4, residence.getNumberOfBedrooms());
        Assertions.assertEquals(2, residence.getNumberOfParkingSpaces());
    }

    /**
     * Test equals and hash code.
     */
    @Test
    public void testEqualsAndHashCode() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        List<Photographs> photographsList = new ArrayList<>();
        List<AvailableEquipment> availableEquipmentList = new ArrayList<>();
        PropertyType propertyType = new PropertyType("Apartment");

        Residence residence1 = new Residence(address, 100.0, 5.0, propertyType, 2, 3, 1, photographsList, availableEquipmentList);
        Residence residence2 = new Residence(address, 100.0, 5.0, propertyType, 2, 3, 1, photographsList, availableEquipmentList);
        Residence residence3 = new Residence(address, 200.0, 10.0, propertyType, 3, 4, 2, photographsList,availableEquipmentList );

        Assertions.assertEquals(residence1, residence2);
        Assertions.assertNotEquals(residence1, residence3);

        Assertions.assertEquals(residence1.hashCode(), residence2.hashCode());
        Assertions.assertNotEquals(residence1.hashCode(), residence3.hashCode());
    }

}