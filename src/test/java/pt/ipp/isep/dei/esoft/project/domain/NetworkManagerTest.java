package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkManagerTest {

    @Test
    void getName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("John Doe", networkManager.getName());
    }

    @Test
    void setName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("John Doe", networkManager.getName());
        networkManager.setName("Jane Doe");
        assertEquals("Jane Doe", networkManager.getName());
    }

    @Test
    void getPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("123456789", networkManager.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("123456789", networkManager.getPhoneNumber());
        networkManager.setPhoneNumber("987654321");
        assertEquals("987654321", networkManager.getPhoneNumber());
    }

    @Test
    void getEmailAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("john@example.com", networkManager.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("john@example.com", networkManager.getEmailAddress());
        networkManager.setEmailAddress("example");
        assertEquals("example", networkManager.getEmailAddress());
    }

    @Test
    void getTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new TaxNumber("123456789"), networkManager.getTaxNumber());
    }

    @Test
    void setTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new TaxNumber("123456789"), networkManager.getTaxNumber());
        networkManager.setTaxNumber(new TaxNumber("987654321"));
        assertEquals(new TaxNumber("987654321"), networkManager.getTaxNumber());
    }

    @Test
    void getPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new PassportCardNumber("12345678"), networkManager.getPassportCardNumber());
    }

    @Test
    void setPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new PassportCardNumber("12345678"), networkManager.getPassportCardNumber());
        networkManager.setPassportCardNumber(new PassportCardNumber("98765432"));
        assertEquals(new PassportCardNumber("98765432"), networkManager.getPassportCardNumber());
    }

    @Test
    void getRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new Role("Network Manager"), networkManager.getRole());
    }

    @Test
    void setRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new Role("Network Manager"), networkManager.getRole());
        networkManager.setRole(new Role("Network Manager 2"));
        assertEquals(new Role("Network Manager 2"), networkManager.getRole());
    }

    @Test
    void getAgency() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), networkManager.getAgency());
    }

    @Test
    void setAgency() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), networkManager.getAgency());
        networkManager.setAgency(new Agency(2, "Agency 2", address, "test@example", "222-222-222"));
        assertEquals(new Agency(2, "Agency 2", address, "test@example", "222-222-222"), networkManager.getAgency());
    }

    @Test
    void getPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("password", networkManager.getPass());
    }

    @Test
    void setPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("password", networkManager.getPass());
        networkManager.setPass("password2");
        assertEquals("password2", networkManager.getPass());
    }

    @Test
    void testClone() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager original = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        NetworkManager clone = original.clone();
        assertEquals(original.getAgency(), clone.getAgency());
        assertEquals(original.getAddress(), clone.getAddress());
        assertEquals(original.getEmailAddress(), clone.getEmailAddress());
        assertEquals(original.getName(), clone.getName());
        assertEquals(original.getPass(), clone.getPass());
        assertEquals(original.getPassportCardNumber(), clone.getPassportCardNumber());
        assertEquals(original.getPhoneNumber(), clone.getPhoneNumber());
        assertEquals(original.getRole(), clone.getRole());
        assertEquals(original.getTaxNumber(), clone.getTaxNumber());
    }
}