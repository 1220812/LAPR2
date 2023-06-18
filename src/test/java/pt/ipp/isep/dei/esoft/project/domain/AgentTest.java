package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Agent test.
 */
class AgentTest {

    /**
     * Gets role.
     */
    @Test
    void getRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Role("Agent"), agent.getRole());
    }

    /**
     * Sets role.
     */
    @Test
    void setRole() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
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
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), agent.getAgency());
    }

    /**
     * Sets agency.
     */
    @Test
    void setAgency() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111"), agent.getAgency());
        Agency agency2 = new Agency(2, "Agency 2", address, "test1@example.com", "111-111-111");
        agent.setAgency(agency2);
        assertEquals(new Agency(2, "Agency 2", address, "test1@example.com", "111-111-111"), agent.getAgency());
    }

    /**
     * Gets store.
     */
    @Test
    void getStore() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Store("Store1", 1), agent.getStore());
    }

    /**
     * Sets store.
     */
    @Test
    void setStore() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new Store("Store1", 1), agent.getStore());
        Store store2 = new Store("Store2", 2);
        agent.setStore(store2);
        assertEquals(new Store("Store2",2), agent.getStore());
    }

    /**
     * Gets pass.
     */
    @Test
    void getPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("password", agent.getPass());
    }

    /**
     * Sets pass.
     */
    @Test
    void setPass() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("password", agent.getPass());
        agent.setPass("newPassword");
        assertEquals("newPassword", agent.getPass());
    }

    /**
     * Gets phone number.
     */
    @Test
    void getPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("123456789", agent.getPhoneNumber());
    }

    /**
     * Sets phone number.
     */
    @Test
    void setPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("123456789", agent.getPhoneNumber());
        agent.setPhoneNumber("987654321");
        assertEquals("987654321", agent.getPhoneNumber());
    }

    /**
     * Gets email address.
     */
    @Test
    void getEmailAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("john@example.com", agent.getEmailAddress());
    }

    /**
     * Sets email address.
     */
    @Test
    void setEmailAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("john@example.com", agent.getEmailAddress());
        agent.setEmailAddress("test@example.com");
        assertEquals("test@example.com", agent.getEmailAddress());
    }

    /**
     * Gets name.
     */
    @Test
    void getName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("John Doe", agent.getName());
    }

    /**
     * Sets name.
     */
    @Test
    void setName() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals("John Doe", agent.getName());
        agent.setName("Jane Doe");
        assertEquals("Jane Doe", agent.getName());
    }

    /**
     * Gets tax number.
     */
    @Test
    void getTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new TaxNumber("123456789"), agent.getTaxNumber());
    }

    /**
     * Gets passport card number.
     */
    @Test
    void getPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new PassportCardNumber("12345678"), agent.getPassportCardNumber());
    }

    /**
     * Sets tax number.
     */
    @Test
    void setTaxNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new TaxNumber("123456789"), agent.getTaxNumber());
        agent.setTaxNumber(new TaxNumber("987654321"));
        assertEquals(new TaxNumber("987654321"), agent.getTaxNumber());
    }

    /**
     * Sets passport card number.
     */
    @Test
    void setPassportCardNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(new PassportCardNumber("12345678"), agent.getPassportCardNumber());
        agent.setPassportCardNumber(new PassportCardNumber("98765432"));
        assertEquals(new PassportCardNumber("98765432"), agent.getPassportCardNumber());
    }

    /**
     * Gets address.
     */
    @Test
    void getAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(address, agent.getAddress());
    }

    /**
     * Sets address.
     */
    @Test
    void setAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(address, agent.getAddress());
        Address address2 = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("West"), new City("Los Angeles"));
        agent.setAddress(address2);
        assertEquals(address2, agent.getAddress());
    }

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Agency agency1 = new Agency(1, "Agency 1", address, "test1@example.com", "111-111-111");
        Agent agent = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        Agent agent1 = new Agent("John Doe", "john@example.com", "123456789", new PassportCardNumber("12345678"), new TaxNumber("123456789"), address, new Role("Agent"), agency1, new Store("Store1", 1), "password");
        assertEquals(agent1, agent);
    }

    /**
     * Test hash code.
     */
    @Test
    public void testHashCode() {
        Agent agent1 = new Agent("John Doe", "john@example.com", "123456789", null, null, null, null, null, null, "password");
        Agent agent2 = new Agent("John Doe", "john@example.com", "123456789", null, null, null, null, null, null, "password");
        assertEquals(agent1.hashCode(), agent2.hashCode());
    }

    /**
     * Test clone.
     */
    @Test
    public void testClone() {
        Agent originalAgent = new Agent("John Doe", "john@example.com", "123456789", null, null, null, null, null, null, "password");
        Agent clonedAgent = originalAgent.clone();
        assertEquals(originalAgent.getName(), clonedAgent.getName());
        assertEquals(originalAgent.getPhoneNumber(), clonedAgent.getPhoneNumber());
        assertEquals(originalAgent.getEmailAddress(), clonedAgent.getEmailAddress());
        assertEquals(originalAgent.getAddress(), clonedAgent.getAddress());
        assertEquals(originalAgent.getTaxNumber(), clonedAgent.getTaxNumber());
        assertEquals(originalAgent.getPassportCardNumber(), clonedAgent.getPassportCardNumber());
    }
}