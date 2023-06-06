package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StoreManagerReposiotry {
    private static List<StoreManager> storeManagerList = new ArrayList<>();

    public static StoreManager createStoreManager(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, Store store, String pass) {
        StoreManager storeManager = new StoreManager(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
        addStoreManager(storeManager);
        return storeManager;
    }

    /**
     * Get stores.
     */

    public static void addStoreManager(StoreManager storeManager) {
        if (validateStoreManager(storeManager))
            storeManagerList.add(storeManager);
    }


    public static List<StoreManager> getStoreManagerList() {
        return List.copyOf(storeManagerList);
    }


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
