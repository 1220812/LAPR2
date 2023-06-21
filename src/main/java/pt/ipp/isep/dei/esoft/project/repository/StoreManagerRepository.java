package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Store manager repository.
 */
public class StoreManagerRepository implements Serializable {
    private static List<StoreManager> storeManagerList = new ArrayList<>();

    /**
     * Create store manager store manager.
     *
     * @param name               the name
     * @param email              the email
     * @param phone              the phone
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param address            the address
     * @param role               the role
     * @param agency             the agency
     * @param store              the store
     * @param pass               the pass
     * @return the store manager
     */
    public static StoreManager createStoreManager(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, Store store, String pass) {
        StoreManager storeManager = new StoreManager(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
        addStoreManager(storeManager);
        return storeManager;
    }

    /**
     * Get stores.
     *
     * @param storeManager the store manager
     */
    public static void addStoreManager(StoreManager storeManager) {
        if (validateStoreManager(storeManager))
            storeManagerList.add(storeManager);
    }


    /**
     * Gets store manager list.
     *
     * @return the store manager list
     */
    public static List<StoreManager> getStoreManagerList() {
        return List.copyOf(storeManagerList);
    }


    /**
     * Add list.
     *
     * @param storeManager the store manager
     * @return the list
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public List<StoreManager> add(StoreManager storeManager) throws CloneNotSupportedException {

        storeManagerList.add(storeManager);

        Optional<StoreManager> newStoreManager = Optional.empty();
        boolean operationSuccess = false;

        if (validateStoreManager(storeManager)) {
            newStoreManager = Optional.of((StoreManager) storeManager.clone());
            operationSuccess = storeManagerList.add((StoreManager) newStoreManager.get());
        }

        if (!operationSuccess) {
            newStoreManager = Optional.empty();
        }
        return storeManagerList;
    }

    private static boolean validateStoreManager(StoreManager storeManager) {
        boolean isValid = !storeManagerList.contains(storeManager);
        return isValid;
    }

}
