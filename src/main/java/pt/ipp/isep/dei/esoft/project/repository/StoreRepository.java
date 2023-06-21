package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Store repository.
 */
public class StoreRepository implements Serializable {
    private static List<Store> storeList = new ArrayList<>();

    /**
     * Get stores.
     *
     * @param store the store
     */
    public static void addStore(Store store){
        if(validateStore(store))
            storeList.add(store);
    }


    /**
     * Gets store list.
     *
     * @return the store list
     */
    public static List<Store> getStoreList() {
        return storeList;
    }

    /**
     * Create store store.
     *
     * @param designation  the designation
     * @param emailAddress the email address
     * @param phoneNumber  the phone number
     * @param address      the address
     * @param ID           the id
     * @return the store
     */
    public static Store createStore(String designation, String emailAddress, String phoneNumber, Address address, int ID) {
        Store store = new Store (designation, address, phoneNumber, emailAddress, ID);
        addStore(store);
        return store;
    }

    /**
     * Add list.
     *
     * @param store the store
     * @return the list
     * @throws CloneNotSupportedException the clone not supported exception
     */
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