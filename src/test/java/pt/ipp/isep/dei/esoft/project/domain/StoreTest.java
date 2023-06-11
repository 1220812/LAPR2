package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void getDesignation() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@email", 1);
        assertEquals("Store 1", store.getDesignation());
    }

    @Test
    void setDesignation() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@email", 1);
        assertEquals("Store 1", store.getDesignation());
        store.setDesignation("Store 2");
        assertEquals("Store 2", store.getDesignation());
    }

    @Test
    void setPhoneNumber() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@email", 1);
        assertEquals("111-111-111", store.getPhoneNumber());
        store.setPhoneNumber("222-222-222");
        assertEquals("222-222-222", store.getPhoneNumber());
    }

    @Test
    void getEmailAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@email", 1);
        assertEquals("store@email", store.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@email", 1);
        assertEquals("store@email", store.getEmailAddress());
        store.setEmailAddress("store@test");
        assertEquals("store@test", store.getEmailAddress());
    }

    @Test
    void getID() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@email", 1);
        assertEquals(1, store.getID());
    }

    @Test
    void setID() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@email", 1);
        assertEquals(1, store.getID());
        store.setID(2);
        assertEquals(2, store.getID());
    }

    @Test
    void testEquals() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@email", 1);
        Store store1 = new Store("Store 1", address, "111-111-111", "store@email", 1);
        assertEquals(store, store1);
    }

    @Test
    void testHashCode() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("East"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@email", 1);
        Store store1 = new Store("Store 1", address, "111-111-111", "store@email", 1);
        assertEquals(store.hashCode(), store1.hashCode());
    }

    @Test
    void testClone() {
        Address address = new Address("123 Main St", 1, 2, "12345", new State("California"), new District("West"), new City("Los Angeles"));
        Store store = new Store("Store 1", address, "111-111-111", "store@test", 1);
        Store store1 = store.clone();
        assertEquals(store, store1);
    }
}