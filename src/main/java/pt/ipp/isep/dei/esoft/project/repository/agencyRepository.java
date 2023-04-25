package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Places.Agency;


import java.util.ArrayList;
import java.util.List;

public class agencyRepository {
    private List<Agency> listOfAgencies;



    public agencyRepository(){
        listOfAgencies = new ArrayList<>();
    }
    public List<Agency> getListOfStores() {
        return listOfAgencies;
    }
}
