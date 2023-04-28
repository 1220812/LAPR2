package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Places.Store;

import java.util.ArrayList;
import java.util.List;

public class storeRepository {
    private List<Store> listOfStores;

    public void setListOfStores(List<Store> listOfStores) {
        this.listOfStores = listOfStores;
    }


    public storeRepository(){
        listOfStores = new ArrayList<>();
    }
    public List<Store> getListOfStores() {
        return listOfStores;
    }

    public void registerStore(Store store) {
        if (validateStore(store)) {
            listOfStores.add(store);
        } else {
            throw new IllegalArgumentException("Store is not valid");
        }
    }

    private boolean validateStore(Store store) {
        return true;
    }
}
