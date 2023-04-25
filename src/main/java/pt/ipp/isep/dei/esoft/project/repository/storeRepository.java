package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Places.Store;

import java.util.ArrayList;
import java.util.List;

public class storeRepository {
    private List<Store> listOfStores;



    public storeRepository(){
        listOfStores = new ArrayList<>();
    }
    public List<Store> getListOfStores() {
        return listOfStores;
    }
}
