package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void testConstructorWithValidArguments() {
        Address address = new Address("Example", "123", "2º Left", "12345", new State("NY"));
        Assertions.assertEquals("Rua do Exemplo", address.getStreetAddress());
        Assertions.assertEquals("123", address.getDoorNumber());
        Assertions.assertEquals("2º Esquerdo", address.getFloorNumber());
        Assertions.assertEquals("12345", address.getZipCode());
        Assertions.assertEquals(new State("NY"), address.getState());
    }

    @Test
    public void testConstructorWithInvalidArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Address address = new Address(null, null, null, null, null);
        });
    }

    @Test
    public void testConstructorWithInvalidPostalCode() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Address address = new Address("Example", "123", "2º Left", "ABCDE", new State("NY"));
        });
    }

    @Test
    public void testConstructorWithInvalidDoorNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Address address = new Address("Example", "abc", "2º Left", "12345", new State("NY"));
        });
    }

    @Test
    public void testConstructorWithInvalidFloorNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Address address = new Address("Example", "123", "2º Left", "12345", new State("NY"));
        });
    }

    @Test
    public void testEquals() {
        Address address1 = new Address("Example", "123", "2º Left", "12345", new State("NY"));
        Address address2 = new Address("Example", "123", "2º Left", "12345", new State("NY"));
        Address address3 = new Address("Example", "123", "2º Left", "54321", new State("NY"));
        Assertions.assertEquals(address1, address2);
        Assertions.assertNotEquals(address1, address3);
    }

    @Test
    public void testHashCode() {
        Address address1 = new Address("Example", "123", "2º Left", "12345", new State("NY"));
        Address address2 = new Address("Example", "123", "2º Left", "12345", new State("NY"));
        Address address3 = new Address("Example", "123", "2º Left", "54321", new State("NY"));
        Assertions.assertEquals(address1.hashCode(), address2.hashCode());
        Assertions.assertNotEquals(address1.hashCode(), address3.hashCode());
    }

    @Test
    public void testClone() {
        Address address1 = new Address("Example", "123", "2º Left", "12345", new State("NY"));
        Address address2 = address1.clone();
        Assertions.assertEquals(address1, address2);
    }
}