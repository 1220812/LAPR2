package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.PropertyAddress;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Store repository.
 */
public class StoreRepository {
    private static List<Store> storeList = new ArrayList<>();

    /**
     * Get stores.
     */

    public static void addStore(Store store){
        if(validateStore(store))
            storeList.add(store);
    }


    public List<Store> getStoreList(){
        return List.copyOf(this.storeList);
    }

    public static Store createStore(String designation, String emailAddress, int phoneNumber, Address address, int ID) {
        Store store = new Store (designation, address, phoneNumber, emailAddress, ID);
        addStore(store);
        return store;
    }

    public List<Store> add(Store store) throws CloneNotSupportedException {

        storeList.add(store);

        Optional<Store> newStore = Optional.empty();
        boolean operationSuccess = false;

        if (validateStore(store)) {
            newStore = Optional.of((Store) store.clone());
            operationSuccess = storeList.add((Store) newStore.get());
        }

        if (!operationSuccess) {
            newStore = Optional.empty();
        }
        return storeList;
    }

    private static boolean validateStore(Store store) {
        boolean isValid = !storeList.contains(store);
        return isValid;
    }
}