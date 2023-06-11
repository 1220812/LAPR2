package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    public void createValidAddress() {
        State state = new State("California");
        District district = new District("Los Angeles");
        City city = new City("Beverly Hills");

        Address address = new Address("123 Main St", 1, 5, "90210", state, district, city);

        assertEquals("123 Main St", address.getStreetAddress());
        assertEquals(1, address.getDoorNumber());
        assertEquals(5, address.getFloorNumber());
        assertEquals("90210", address.getZipCode());
        assertEquals(state, address.getState());
        assertEquals(district, address.getDistrict());
        assertEquals(city, address.getCity());
    }

    @Test
    public void createAddressWithInvalidZipCode() {
        State state = new State("California");
        District district = new District("Los Angeles");
        City city = new City("Beverly Hills");

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("123 Main St", 1, 5, "invalid", state, district, city));
    }

    @Test
    public void createAddressWithInvalidDoorNumber() {
        State state = new State("California");
        District district = new District("Los Angeles");
        City city = new City("Beverly Hills");

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("123 Main St", -1, 5, "90210", state, district, city));
    }

    @Test
    public void setAddressAttributes() {
        Address address = new Address();

        address.setStreetAddress("456 Elm St");
        address.setDoorNumber(2);
        address.setFloorNumber(3);
        address.setZipCode("12345");
        State state = new State("New York");
        address.setState(state);
        District district = new District("Manhattan");
        address.setDistrict(district);
        City city = new City("New York City");
        address.setCity(city);

        assertEquals("456 Elm St", address.getStreetAddress());
        assertEquals(2, address.getDoorNumber());
        assertEquals(3, address.getFloorNumber());
        assertEquals("12345", address.getZipCode());
        assertEquals(state, address.getState());
        assertEquals(district, address.getDistrict());
        assertEquals(city, address.getCity());
    }

    @Test
    public void testExistsZipCode() {
        assertTrue(Address.existsZipCode("90210"));
        assertFalse(Address.existsZipCode("invalid"));
        assertFalse(Address.existsZipCode("123456"));
    }

    @Test
    public void testExistsDoorNumber() {
        assertTrue(Address.existsDoorNumber(1));
        assertFalse(Address.existsDoorNumber(0));
        assertFalse(Address.existsDoorNumber(-1));
    }

    @Test
    public void testNotEquals() {
        State state1 = new State("California");
        District district1 = new District("Los Angeles");
        City city1 = new City("Beverly Hills");
        Address address1 = new Address("123 Main St", 1, 5, "90210", state1, district1, city1);

        State state2 = new State("California");
        District district2 = new District("Los Angeles");
        City city2 = new City("Hollywood");
        Address address2 = new Address("123 Main St", 1, 5, "90210", state2, district2, city2);

        Assertions.assertNotEquals(address1, address2);
    }
    @Test
    public void testEquals_SameInstance_ReturnsTrue() {
        Address address = new Address("Street 1", 123, 1, "12345", new State(), new District(), new City());
        assertTrue(address.equals(address));
    }

    @Test
    public void testEquals_NullObject_ReturnsFalse() {
        Address address = new Address("Street 1", 123, 1, "12345", new State(), new District(), new City());
        assertFalse(address.equals(null));
    }

    @Test
    public void testEquals_DifferentClass_ReturnsFalse() {
        Address address = new Address("Street 1", 123, 1, "12345", new State(), new District(), new City());
        String differentClass = "not an Address object";
        assertFalse(address.equals(differentClass));
    }

    @Test
    public void testEquals_DifferentStreet_ReturnsFalse() {
        Address address1 = new Address("Street 1", 123, 1, "12345", new State(), new District(), new City());
        Address address2 = new Address("Street 2", 123, 1, "12345", new State(), new District(), new City());
        assertFalse(address1.equals(address2));
    }

    // Additional tests for other attributes

    @Test
    public void testHashCode_DifferentStreet_ReturnsDifferentHashCode() {
        Address address1 = new Address("Street 1", 123, 1, "12345", new State(), new District(), new City());
        Address address2 = new Address("Street 2", 123, 1, "12345", new State(), new District(), new City());
        assertNotEquals(address1.hashCode(), address2.hashCode());
    }
}