package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.RequestType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Agency repository.
 */
public class AgencyRepository {
    private List<Agency> agencyList = new ArrayList<>();

    public void addAgency(Agency agency){
        if(validateAgency(agency))
            agencyList.add(agency);
    }

    public boolean validateAgency(Agency agency) {
        return !this.agencyList.contains(agency);
    }

    public List<Agency> getAgencyList(){
        return List.copyOf(this.agencyList);
    }

    public static Agency CreateAgency (int id, String designation, Address address, String emailAddress, String phoneNumber){
        return new Agency(id, designation, address, emailAddress, phoneNumber);
    }
}