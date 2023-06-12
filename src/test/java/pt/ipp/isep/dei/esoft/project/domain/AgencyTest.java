package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgencyTest {

    @Test
    void testEquals() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agency agency2 = new Agency(1, "Agency 2", address, "test2@example.com", "222-222-222");
        assertEquals(agency1, agency2);
    }

    @Test
    void getID() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals(1, agency1.getID());
    }

    @Test
    void getDesignation() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals("Agency 1", agency1.getDesignation());
    }

    @Test
    void getAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals(address, agency1.getAddress());
    }

    @Test
    void getPhoneNumber() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals("111-111-111", agency1.getPhoneNumber());
    }

    @Test
    void getEmailAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals("test1@example.com", agency1.getEmailAddress());
    }

    @Test
    void setAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Address address1 = new Address("124 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals("test1@example.com", agency1.getEmailAddress());
        agency1.setAddress(address1);
        assertEquals(address1, agency1.getAddress());
    }

    @Test
    void setDesignation() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals("Agency 1", agency1.getDesignation());
        agency1.setDesignation("Agency 2");
        assertEquals("Agency 2", agency1.getDesignation());
    }

    @Test
    void setEmailAddress() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals("test1@example.com", agency1.getEmailAddress());
        agency1.setEmailAddress("test2");
        assertEquals("test2", agency1.getEmailAddress());
    }

    @Test
    void setId() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals(1, agency1.getID());
        agency1.setId(2);
        assertEquals(2, agency1.getID());
    }

    @Test
    void setPhoneNumber() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        assertEquals("111-111-111", agency1.getPhoneNumber());
        agency1.setPhoneNumber("111-222-333");
        assertEquals("111-222-333", agency1.getPhoneNumber());
    }

    @Test
    void testHashCode() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agency agency2 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Assertions.assertEquals(agency1, agency2);
        Assertions.assertEquals(agency1.hashCode(), agency2.hashCode());
    }

    @Test
    void testClone() {
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Agency agency = new Agency(1, "Agency", address, "test@example.com", "111-111-111");
        Agency agencyClone = agency.clone();
        Assertions.assertEquals(agency, agencyClone);
    }
}