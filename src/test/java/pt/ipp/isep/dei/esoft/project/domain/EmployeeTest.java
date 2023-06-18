package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Employee test.
 */
public class EmployeeTest {

    /**
     * Gets name.
     */
    @Test
    void getName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("John Doe", agent.getName());
    }

    /**
     * Sets name.
     */
    @Test
    void setName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("John Doe", agent.getName());
        agent.setName("Jane Doe");
        assertEquals("Jane Doe", agent.getName());
    }

    /**
     * Gets phone number.
     */
    @Test
    void getPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("123456789", agent.getPhoneNumber());
    }

    /**
     * Sets phone number.
     */
    @Test
    void setPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("123456789", agent.getPhoneNumber());
        agent.setPhoneNumber("987654321");
        assertEquals("987654321", agent.getPhoneNumber());
    }

    /**
     * Gets passport card number.
     */
    @Test
    void getPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new PassportCardNumber("12345678"), agent.getPassportCardNumber());
    }

    /**
     * Sets passport card number.
     */
    @Test
    void setPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new PassportCardNumber("12345678"), agent.getPassportCardNumber());
        agent.setPassportCardNumber(new PassportCardNumber("87654321"));
        assertEquals(new PassportCardNumber("87654321"), agent.getPassportCardNumber());
    }

    /**
     * Gets tax number.
     */
    @Test
    void getTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new TaxNumber("123456789"), agent.getTaxNumber());
    }

    /**
     * Sets tax number.
     */
    @Test
    void setTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new TaxNumber("123456789"), agent.getTaxNumber());
        agent.setTaxNumber(new TaxNumber("987654321"));
        assertEquals(new TaxNumber("987654321"), agent.getTaxNumber());
    }

    /**
     * Gets role.
     */
    @Test
    void getRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Role("Agent"), agent.getRole());
    }

    /**
     * Sets role.
     */
    @Test
    void setRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Role("Agent"), agent.getRole());
        agent.setRole(new Role("Manager"));
        assertEquals(new Role("Manager"), agent.getRole());
    }

    /**
     * Gets agency.
     */
    @Test
    void getAgency() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), agent.getAgency());
    }

    /**
     * Sets agency.
     */
    @Test
    void setAgency() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), agent.getAgency());
        agent.setAgency(new Agency(2, "Agency 2", address, "test@example.com", "222-222-222"));
        assertEquals(new Agency(2, "Agency 2", address, "test@example.com", "222-222-222"), agent.getAgency());
    }

    /**
     * Gets store.
     */
    @Test
    void getStore() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals( new Store("Store1", 1), agent.getStore());
    }

    /**
     * Sets store.
     */
    @Test
    void setStore() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals( new Store("Store1", 1), agent.getStore());
        agent.setStore(new Store("Store2", 2));
        assertEquals(new Store("Store2", 2), agent.getStore());
    }

    /**
     * Gets pass.
     */
    @Test
    void getPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals( "password", agent.getPass());
    }

    /**
     * Sets pass.
     */
    @Test
    void setPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals( "password", agent.getPass());
        agent.setPass("newPassword");
        assertEquals("newPassword", agent.getPass());
    }

    /**
     * Test hash code.
     */
    @Test
    void testHashCode() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        Employee agent2 = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(agent.hashCode(), agent2.hashCode());
    }
}