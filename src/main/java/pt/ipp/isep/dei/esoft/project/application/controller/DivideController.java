package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.BruteForce;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.io.Serializable;
import java.util.List;

/**
 * The type Divide controller.
 */
public class DivideController implements Serializable {
    /**
     * The Store repository.
     */
    StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
    /**
     * The Brute force.
     */
    BruteForce bruteForce = new BruteForce();

    /**
     * Method that gets the list of stores.
     *
     * @return list of stores.
     */
    public List<Store> getStores() {
        return storeRepository.getStoreList();
    }

    /**
     * Method that divides the stores into the number of stores given by the user.
     *
     * @param numberOfStores number of stores given by the user.
     */
    public void divideStores(int numberOfStores) {
        bruteForce.storesDivisor(storeRepository.getStoreList(), numberOfStores);
    }

    /**
     * Gets number of properties.
     *
     * @param storeID the store id
     * @return the number of properties
     */
    public int getNumberOfProperties(int storeID) {
        return BruteForce.getAnnouncementsByStoreID(storeID).size();
    }

    /**
     * Properties int.
     *
     * @param storesList the stores list
     * @return the int
     */
    public int properties(List<Store> storesList) {
        return BruteForce.getTotalNumberOfProperties(storesList);
    }
}