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
        RoleRepository.getEmployeeRoles();
    }

    public void getAgencyRepository() {
        AgencyRepository.getAgencies();
    }

    public void getStoreRepository() {
        StoreRepository.getStores();
    }

    public Employee RegisterEmployee(String name, String address, int phone, String email, int passportCardNumber, int taxNumber, String role, String agency, String store, String pass) {
        pass = PasswordGenerator.generatePassword();
        return Employee.newEmployee(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
    }

    public void getUserRepository() {
         UserRepository.getUserList();
    }
    public void sendRegisteredUserEmail(String email, String pass){
        pass = PasswordGenerator.generatePassword();
        EmailService.sendEmail(email, pass);
    }


    public boolean checkEmail(String email) {
        return (Employee.existsEmail(email)) ;
    }

    public boolean checkPhone(int phone) {
       return Employee.existsPhone(phone);

    }

    public boolean checkTaxNumber(int taxNumber){
        return Employee.existsTaxNumber(taxNumber);
    }
    public boolean checkPassportCardNumber(int passportCardNumber){
        return Employee.existsPassportCardNumber(passportCardNumber);
    }

    public boolean checkZipCode(int zipCode) {
        return Employee.existsPhone(zipCode);

    }


}
