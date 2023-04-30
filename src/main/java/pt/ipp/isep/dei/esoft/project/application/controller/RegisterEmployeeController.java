package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.EmailService;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.PasswordGenerator;
import pt.ipp.isep.dei.esoft.project.repository.*;

public class RegisterEmployeeController {
    public void RegisterEmployeeController() {
        Repositories repositories = Repositories.getInstance();


    }

    public void getRoleRepository() {
        roleRepository.getEmployeeRoles();
    }

    public void getAgencyRepository() {
        agencyRepository.getAgencies();
    }

    public void getStoreRepository() {
        storeRepository.getStores();
    }

    public Employee RegisterEmployee(String name, String address, int phone, String email, int passportCardNumber, int taxNumber, String role, String agency, String store, String pass) {
        pass = PasswordGenerator.generatePassword();
        return Employee.newEmployee(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
    }

    public void getUserRepository() {
         userRepository.getUserList();
    }
    public void sendRegisteredUserEmail(String email, String pass){
        pass = PasswordGenerator.generatePassword();
        EmailService.sendEmail(email, pass);
    }


}
