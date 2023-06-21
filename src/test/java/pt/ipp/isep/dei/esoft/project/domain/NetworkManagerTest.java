package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Network manager test.
 */
class NetworkManagerTest {

    /**
     * Gets name.
     */
    @Test
    void getName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("John Doe", networkManager.getName());
    }

    /**
     * Sets name.
     */
    @Test
    void setName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("John Doe", networkManager.getName());
        networkManager.setName("Jane Doe");
        assertEquals("Jane Doe", networkManager.getName());
    }

    /**
     * Gets phone number.
     */
    @Test
    void getPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("123456789", networkManager.getPhoneNumber());
    }

    /**
     * Sets phone number.
     */
    @Test
    void setPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("123456789", networkManager.getPhoneNumber());
        networkManager.setPhoneNumber("987654321");
        assertEquals("987654321", networkManager.getPhoneNumber());
    }

    /**
     * Gets email address.
     */
    @Test
    void getEmailAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("john@example.com", networkManager.getEmailAddress());
    }

    /**
     * Sets email address.
     */
    @Test
    void setEmailAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("john@example.com", networkManager.getEmailAddress());
        networkManager.setEmailAddress("example");
        assertEquals("example", networkManager.getEmailAddress());
    }

    /**
     * Gets tax number.
     */
    @Test
    void getTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new TaxNumber("123456789"), networkManager.getTaxNumber());
    }

    /**
     * Sets tax number.
     */
    @Test
    void setTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new TaxNumber("123456789"), networkManager.getTaxNumber());
        networkManager.setTaxNumber(new TaxNumber("987654321"));
        assertEquals(new TaxNumber("987654321"), networkManager.getTaxNumber());
    }

    /**
     * Gets passport card number.
     */
    @Test
    void getPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new PassportCardNumber("12345678"), networkManager.getPassportCardNumber());
    }

    /**
     * Sets passport card number.
     */
    @Test
    void setPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new PassportCardNumber("12345678"), networkManager.getPassportCardNumber());
        networkManager.setPassportCardNumber(new PassportCardNumber("98765432"));
        assertEquals(new PassportCardNumber("98765432"), networkManager.getPassportCardNumber());
    }

    /**
     * Gets role.
     */
    @Test
    void getRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new Role("Network Manager"), networkManager.getRole());
    }

    /**
     * Sets role.
     */
    @Test
    void setRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new Role("Network Manager"), networkManager.getRole());
        networkManager.setRole(new Role("Network Manager 2"));
        assertEquals(new Role("Network Manager 2"), networkManager.getRole());
    }

    /**
     * Gets agency.
     */
    @Test
    void getAgency() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), networkManager.getAgency());
    }

    /**
     * Sets agency.
     */
    @Test
    void setAgency() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), networkManager.getAgency());
        networkManager.setAgency(new Agency(2, "Agency 2", address, "test@example", "222-222-222"));
        assertEquals(new Agency(2, "Agency 2", address, "test@example", "222-222-222"), networkManager.getAgency());
    }

    /**
     * Gets pass.
     */
    @Test
    void getPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("password", networkManager.getPass());
    }

    /**
     * Sets pass.
     */
    @Test
    void setPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        NetworkManager networkManager = new NetworkManager("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Network Manager"), agency1, "password");
        assertEquals("password", networkManager.getPass());
        networkManager.setPass("password2");
        assertEquals("password2", networkManager.getPass());
    }

    /**
     * Test clone.
     */
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