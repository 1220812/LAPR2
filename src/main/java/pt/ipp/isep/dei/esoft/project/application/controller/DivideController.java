package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.BruteForce;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.io.Serializable;
import java.util.List;

public class DivideController implements Serializable {
    StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
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

    public int getNumberOfProperties(int storeID) {
        return BruteForce.getAnnouncementsByStoreID(storeID).size();
    }

    public int properties(List<Store> storesList) {
        return BruteForce.getTotalNumberOfProperties(storesList);
    }
}