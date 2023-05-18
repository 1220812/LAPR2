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
    private static ArrayList<Agency> agencyList = new ArrayList<>();
    public static void addAgency(Agency agency){
        agencyList.add(agency);
    }
    public static ArrayList<Agency> getAgencyList(){
        return agencyList;
    }
    public static Agency CreateAgency(int id, String designation, Address address, String emailAddress, int phoneNumber, Employee administrator){
        return new Agency(id, designation, address, emailAddress, phoneNumber, administrator);
    }
}