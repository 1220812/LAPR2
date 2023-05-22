package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;

/**
 * The type Register employee controller.
 */
public class RegisterEmployeeController {
    private RoleRepository roleRepository = Repositories.getInstance().getRoleRepository();
    private AgencyRepository agencyRepository = null;
    private State stateInstance = null;

    /**
     * Register employee controller.
     */
    public void RegisterEmployeeController() {
        Repositories repositories = Repositories.getInstance();
    }

    public List<Role> getRolesList() {
        return roleRepository.getRoleList();
    }

    /**
     * Register employee employee.
     *
     * @param name               the name
     * @param propertyAddress            the address
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
    public Employee RegisterEmployee(String name, String email, String phone, String passportCardNumber, String taxNumber, Address propertyAddress, Role role, Agency agency, Store store, String pass) {
        pass = PasswordGenerator.generatePassword();
        return Employee.newEmployee(name, email, phone, passportCardNumber, taxNumber, propertyAddress, role, agency, store, pass);
    }

    /**
     * Gets user repository.
     */
    public void getUserRepository() {
         Repositories.getInstance().getUserRepository().getEmployeeList();
    }
    public List<City> getCityRepository(){
        return Repositories.getInstance().getCityRepository().getCityList();
    }
    public List<District> getDistrictRepository(){
        return Repositories.getInstance().getDistrictRepository().getDistrictList();
    }

    public List<Address> getAddresses(){
        return Repositories.getInstance().getAddressRepository().getAddressList();
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
    public void setStateInstance(State state) {
        this.stateInstance = state;
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
    public boolean checkTaxNumber(String taxNumber){
        return Employee.existsTaxNumber(taxNumber);
    }

    /**
     * Check passport card number boolean.
     *
     * @param passportCardNumber the passport card number
     * @return the boolean
     */
    public boolean checkPassportCardNumber(String passportCardNumber){
        return Employee.existsPassportCardNumber(passportCardNumber);
    }

    /**
     * Check zip code boolean.
     *
     * @param zipCode the zip code
     * @return the boolean
     */
    public boolean checkZipCode(int zipCode) {
        return Employee.existsZipCode(zipCode);

    }


}
