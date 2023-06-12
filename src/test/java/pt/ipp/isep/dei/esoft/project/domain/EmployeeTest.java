package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void getName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("John Doe", agent.getName());
    }

    @Test
    void setName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("John Doe", agent.getName());
        agent.setName("Jane Doe");
        assertEquals("Jane Doe", agent.getName());
    }

    @Test
    void getPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("123456789", agent.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("123456789", agent.getPhoneNumber());
        agent.setPhoneNumber("987654321");
        assertEquals("987654321", agent.getPhoneNumber());
    }

    @Test
    void getPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new PassportCardNumber("12345678"), agent.getPassportCardNumber());
    }

    @Test
    void setPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new PassportCardNumber("12345678"), agent.getPassportCardNumber());
        agent.setPassportCardNumber(new PassportCardNumber("87654321"));
        assertEquals(new PassportCardNumber("87654321"), agent.getPassportCardNumber());
    }

    @Test
    void getTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new TaxNumber("123456789"), agent.getTaxNumber());
    }

    @Test
    void setTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new TaxNumber("123456789"), agent.getTaxNumber());
        agent.setTaxNumber(new TaxNumber("987654321"));
        assertEquals(new TaxNumber("987654321"), agent.getTaxNumber());
    }

    @Test
    void getRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Role("Agent"), agent.getRole());
    }

    @Test
    void setRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Role("Agent"), agent.getRole());
        agent.setRole(new Role("Manager"));
        assertEquals(new Role("Manager"), agent.getRole());
    }

    @Test
    void getAgency() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), agent.getAgency());
    }

    @Test
    void setAgency() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), agent.getAgency());
        agent.setAgency(new Agency(2, "Agency 2", address, "test@example.com", "222-222-222"));
        assertEquals(new Agency(2, "Agency 2", address, "test@example.com", "222-222-222"), agent.getAgency());
    }

    @Test
    void getStore() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals( new Store("Store1", 1), agent.getStore());
    }

    @Test
    void setStore() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals( new Store("Store1", 1), agent.getStore());
        agent.setStore(new Store("Store2", 2));
        assertEquals(new Store("Store2", 2), agent.getStore());
    }

    @Test
    void getPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals( "password", agent.getPass());
    }

    @Test
    void setPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals( "password", agent.getPass());
        agent.setPass("newPassword");
        assertEquals("newPassword", agent.getPass());
    }

    @Test
    void testHashCode() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Employee agent = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        Employee agent2 = new Employee("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(agent.hashCode(), agent2.hashCode());
    }
}