package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.PasswordGenerator;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.agencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.roleRepository;
import pt.ipp.isep.dei.esoft.project.repository.storeRepository;

public class RegisterEmployeeController {
    public void RegisterEmployeeController() {
        Repositories repositories = Repositories.getInstance();


    }

    public void getRoleRepository(){
        roleRepository.getEmployeeRoles();
    }
    public void getAgencyRepository(){
        agencyRepository.getAgencies();
    }
    public void getStoreRepository(){
        storeRepository.getStores();
    }

    public Employee RegisterEmployee(String name, String address, int phone, String email, int passportCardNumber, String s, String inputRole, String inputAgency, String inputStore){
        PasswordGenerator.generatePassword();
        return null;
    }

}
