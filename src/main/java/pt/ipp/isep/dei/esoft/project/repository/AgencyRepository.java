package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Agency;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Agency repository.
 */
public class AgencyRepository implements Serializable {
    private final List<Agency> agencyList = new ArrayList<>();

    /**
     * Add agency list.
     *
     * @param agency the agency
     * @return the list
     */
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

    /**
     * Validate agency boolean.
     *
     * @param agency the agency
     * @return the boolean
     */
    public boolean validateAgency(Agency agency) {
        boolean isValid = !agencyList.contains(agency);
        return isValid;
    }

    /**
     * Get agency list list.
     *
     * @return the list
     */
    public List<Agency> getAgencyList(){
        return List.copyOf(this.agencyList);
    }

    /**
     * Create agency agency.
     *
     * @param id           the id
     * @param designation  the designation
     * @param address      the address
     * @param emailAddress the email address
     * @param phoneNumber  the phone number
     * @return the agency
     */
    public static Agency CreateAgency (int id, String designation, Address address, String emailAddress, String phoneNumber){
        return new Agency(id, designation, address, emailAddress, phoneNumber);
    }

}