package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreRepositoryTest {

    @Test
    void addStore() {
        StoreRepository storeRepository = new StoreRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Store store = new Store("Store", address, "123456789", "store@gmail.com", 1);
        storeRepository.addStore(store);
        List<Store> stores = storeRepository.getStoreList();
        assertTrue(stores.contains(store));
    }

    @Test
    void getStoreList() {
        StoreRepository storeRepository = new StoreRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Store store = new Store("Store", address, "123456789", "store@gmail.com", 1);
        Store store1 = new Store("Store1", address, "123456789", "store1@gmail.com", 2);
        storeRepository.addStore(store);
        storeRepository.addStore(store1);
        List<Store> stores = storeRepository.getStoreList();
        assertTrue(stores.contains(store));
        assertTrue(stores.contains(store1));
    }

    @Test
    void createStore() {
        StoreRepository storeRepository = new StoreRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Store store = storeRepository.createStore("Store", "store@gmail.com", "123456789", address, 1);
        List<Store> stores = storeRepository.getStoreList();
        assertTrue(stores.contains(store));
    }

    @Test
    void add() throws CloneNotSupportedException {
        StoreRepository storeRepository = new StoreRepository();
        Address address = new Address("123 Main St", 1,2, "12345",new State("California"),new District("East"),new City("Los Angeles"));
        Store store = new Store("Store", address, "123456789", "store@gmail.com", 1);
        List<Store> stores = storeRepository.add(store);
        List<Store> storesList = storeRepository.getStoreList();
        assertTrue(storesList.contains(store));
        assertEquals(storesList, stores);
    }
}