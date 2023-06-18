package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.math3.analysis.function.Add;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Owner test.
 */
class OwnerTest {

    /**
     * Gets phone number.
     */
    @Test
    void getPhoneNumber() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals("111-111-111", owner.getPhoneNumber());
    }

    /**
     * Sets phone number.
     */
    @Test
    void setPhoneNumber() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals("111-111-111", owner.getPhoneNumber());
        owner.setPhoneNumber("222-222-222");
        assertEquals("222-222-222", owner.getPhoneNumber());
    }

    /**
     * Gets email address.
     */
    @Test
    void getEmailAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals("joe@this.app", owner.getEmailAddress());
    }

    /**
     * Sets email address.
     */
    @Test
    void setEmailAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals("joe@this.app", owner.getEmailAddress());
        owner.setEmailAddress("joe@example");
        assertEquals("joe@example", owner.getEmailAddress());
    }


    /**
     * Gets name.
     */
    @Test
    void getName() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals("Joe Rogan", owner.getName());
    }

    /**
     * Sets name.
     */
    @Test
    void setName() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals("Joe Rogan", owner.getName());
        owner.setName("Jane Rogan");
        assertEquals("Jane Rogan",owner.getName());
    }

    /**
     * Gets tax number.
     */
    @Test
    void getTaxNumber() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals(new TaxNumber("123456789"), owner.getTaxNumber());
    }

    /**
     * Gets passport card number.
     */
    @Test
    void getPassportCardNumber() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals(new PassportCardNumber("12345678"), owner.getPassportCardNumber());
    }

    /**
     * Sets tax number.
     */
    @Test
    void setTaxNumber() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals(new TaxNumber("123456789"), owner.getTaxNumber());
        owner.setTaxNumber(new TaxNumber("987654321"));
        assertEquals(new TaxNumber("987654321"), owner.getTaxNumber());
    }

    /**
     * Sets passport card number.
     */
    @Test
    void setPassportCardNumber() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals(new PassportCardNumber("12345678"), owner.getPassportCardNumber());
        owner.setPassportCardNumber(new PassportCardNumber("98765432"));
        assertEquals(new PassportCardNumber("98765432"), owner.getPassportCardNumber());
    }

    /**
     * Gets address.
     */
    @Test
    void getAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals(address, owner.getAddress());
    }

    /**
     * Sets address.
     */
    @Test
    void setAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals(address, owner.getAddress());
        Address address2 = new Address("124 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        owner.setAddress(address2);
        assertEquals(address2, owner.getAddress());
    }

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Owner owner2 = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals(owner2,owner);
    }

    /**
     * Test hash code.
     */
    @Test
    void testHashCode() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Owner owner2 = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        assertEquals(owner2.hashCode(),owner.hashCode());
    }

    /**
     * Test clone.
     */
    @Test
    void testClone() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Owner owner = new Owner("Joe Rogan","111-111-111", "joe@this.app",address, new TaxNumber("123456789"),new PassportCardNumber("12345678"));
        Owner owner2 = owner.clone();
        assertEquals(owner2.getEmailAddress(),owner.getEmailAddress());
        assertEquals(owner.getAddress(),owner2.getAddress());
        assertEquals(owner.getPassportCardNumber(), owner.getPassportCardNumber());
        assertEquals(owner.getName(), owner2.getName());
        assertEquals(owner.getPhoneNumber(), owner2.getPhoneNumber());
        assertEquals(owner.getTaxNumber(), owner2.getTaxNumber());
    }
}