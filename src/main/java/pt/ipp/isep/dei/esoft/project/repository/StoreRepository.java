package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Store repository.
 */
public class StoreRepository {
    private List<Store> storeList = new ArrayList<>();

    /**
     * Get stores.
     */

    public void addStore(Store store){
        if(validateStore(store))
            storeList.add(store);
    }

    public boolean validateStore(Store store) {
        return !this.storeList.contains(store);
    }

    public List<Store> getStoreList(){
        return List.copyOf(this.storeList);
    }

    public Store createStore(String designation, Address address, int phoneNumber, String emailAddress, int ID) {
        Store store = new Store (designation, address, phoneNumber, emailAddress, ID);
        addStore(store);
        return store;
    }
}