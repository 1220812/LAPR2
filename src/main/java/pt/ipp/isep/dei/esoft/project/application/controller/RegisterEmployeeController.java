package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.EmailService;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.PasswordGenerator;
import pt.ipp.isep.dei.esoft.project.repository.*;

/**
 * The type Register employee controller.
 */
public class RegisterEmployeeController {
    /**
     * Register employee controller.
     */
    public void RegisterEmployeeController() {
        Repositories repositories = Repositories.getInstance();


    }

    /**
     * Gets role repository.
     */
    public void getRoleRepository() {
        RoleRepository.getEmployeeRoles();
    }

    /**
     * Gets agency repository.
     */
    public void getAgencyRepository() {
        AgencyRepository.getAgencies();
    }

    /**
     * Gets store repository.
     */
    public void getStoreRepository() {
        StoreRepository.getStores();
    }

    /**
     * Register employee employee.
     *
     * @param name               the name
     * @param address            the address
     * @param phone              the phone
     * @param email              the email
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param role               the role
     * @param agency             the agency
     * @param store              the store
     * @param pass               the pass
     * @return the employee
     */
    public Employee RegisterEmployee(String name, String address, int phone, String email, int passportCardNumber, int taxNumber, String role, String agency, String store, String pass) {
        pass = PasswordGenerator.generatePassword();
        return Employee.newEmployee(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
    }

    /**
     * Gets user repository.
     */
    public void getUserRepository() {
         UserRepository.getUserList();
    }

    /**
     * Send registered user email.
     *
     * @param email the email
     * @param pass  the pass
     */
    public void sendRegisteredUserEmail(String email, String pass){
        pass = PasswordGenerator.generatePassword();
        EmailService.sendEmail(email, pass);
    }


    /**
     * Check email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean checkEmail(String email) {
        return (Employee.existsEmail(email)) ;
    }

    /**
     * Check phone boolean.
     *
     * @param phone the phone
     * @return the boolean
     */
    public boolean checkPhone(int phone) {
       return Employee.existsPhone(phone);

    }

    /**
     * Check tax number boolean.
     *
     * @param taxNumber the tax number
     * @return the boolean
     */
    public boolean checkTaxNumber(int taxNumber){
        return Employee.existsTaxNumber(taxNumber);
    }

    /**
     * Check passport card number boolean.
     *
     * @param passportCardNumber the passport card number
     * @return the boolean
     */
    public boolean checkPassportCardNumber(int passportCardNumber){
        return Employee.existsPassportCardNumber(passportCardNumber);
    }

    /**
     * Check zip code boolean.
     *
     * @param zipCode the zip code
     * @return the boolean
     */
    public boolean checkZipCode(int zipCode) {
        return Employee.existsPhone(zipCode);

    }


}
