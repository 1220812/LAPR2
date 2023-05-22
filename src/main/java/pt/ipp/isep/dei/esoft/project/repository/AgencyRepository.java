package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.PropertyAddress;
import pt.ipp.isep.dei.esoft.project.domain.Agency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Agency repository.
 */
public class AgencyRepository {
    private final List<Agency> agencyList = new ArrayList<>();

    public List<Agency> addAgency(Agency agency){
        agencyList.add(agency);
        Optional<Agency> newAgency = Optional.empty();
        boolean operationSuccess = false;
        if(validateAgency(agency)){
            newAgency = Optional.of(agency.clone());
            operationSuccess = agencyList.add(newAgency.get());
        }
        if(!operationSuccess){
            newAgency = Optional.empty();
        }
        return agencyList;
    }

    public boolean validateAgency(Agency agency) {
        boolean isValid = !agencyList.contains(agency);
        return isValid;
    }

    public List<Agency> getAgencyList(){
        return List.copyOf(this.agencyList);
    }

    public static Agency CreateAgency (int id, String designation, PropertyAddress propertyAddress, String emailAddress, String phoneNumber){
        return new Agency(id, designation, propertyAddress, emailAddress, phoneNumber);
    }





}