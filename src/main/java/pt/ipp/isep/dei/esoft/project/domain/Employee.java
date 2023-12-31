package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

import  pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

/**
 * The type Employee.
 */
public class Employee implements Serializable{
    /**
     * The name of the employee.
     */
    private String name;
    /**
     * The email address of the employee.
     */
    private String email;
    /**
     * The phone number of the employee.
     */
    private String phoneNumber;
    /**
     * The passport or card number of the employee.
     */
    private PassportCardNumber passportCardNumber;
    /**
     * The tax number of the employee.
     */
    private TaxNumber taxNumber;
    /**
     * The role of the employee.
     */
    private Role role;
    /**
     * The address of the employee.
     */
    private Address address;
    /**
     * The agency of the employee.
     */
    private Agency agency;
    /**
     * The store of the employee.
     */
    private Store store;
/**
     * The password of the employee.
     */
    private String pass;

    /**
     * Creates a new Employee object with the given attributes.
     *
     * @param name               The name of the employee.
     * @param email              The email address of the employee.
     * @param phoneNumber        The phone number of the employee.
     * @param passportCardNumber The passport or card number of the employee.
     * @param taxNumber          The tax number of the employee.
     * @param address            The address of the employee.
     * @param role               The role of the employee.
     * @param agency             The agency of the employee.
     * @param store              The store of the employee.
     * @param pass               The password of the employee.
     */
    public Employee(String name, String email, String phoneNumber, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, Store store, String pass) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.role = role;
        this.agency = agency;
        this.store = store;
        this.pass = pass;
    }

    /**
     * Instantiates a new Employee.
     *
     * @param name               the name
     * @param email              the email
     * @param phoneNumber        the phone number
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param address            the address
     * @param role               the role
     * @param agency             the agency
     * @param pass               the pass
     */
    public Employee(String name, String email, String phoneNumber, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, String pass) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.role = role;
        this.agency = agency;
        this.pass = pass;
    }

    /**
     * Instantiates a new Employee.
     *
     * @param name               the name
     * @param email              the email
     * @param phoneNumber        the phone number
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param address            the address
     * @param role               the role
     * @param pass               the pass
     */
    public Employee(String name, String email, String phoneNumber, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, String pass) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.role = role;
        this.pass = pass;
    }

    /**
     * Creates a new Employee object with the given attributes.
     *
     * @param email The email address of the employee.
     */
    public Employee(String email) {
        this.email = email;
    }

    /**
     * Creates a new Employee object with the given information and returns it.
     *
     * @param name               the name of the employee
     * @param email              the email address of the employee
     * @param phoneNumber        the phone number of the employee
     * @param passportCardNumber the passport or card number of the employee
     * @param taxNumber          the tax number of the employee
     * @param address            the address of the employee
     * @param role               the role of the employee in the company
     * @param agency             the agency the employee is associated with
     * @param store              the store the employee works in
     * @param pass               the password for the employee account
     * @return a new Employee object with the given information
     */
    public static Employee newEmployee(String name, String email, String phoneNumber, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, Store store, String pass) {
        Employee newEmployee = new Employee(name, email, phoneNumber, passportCardNumber, taxNumber, address, role, agency, store, pass);
        EmployeeRepository rep = Repositories.getInstance().getEmployeeRepository();

        rep.addNewEmployee(newEmployee);
        return newEmployee;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets passport card number.
     *
     * @return the passport card number
     */
    public PassportCardNumber getPassportCardNumber() {
        return passportCardNumber;
    }

    /**
     * Sets passport card number.
     *
     * @param passportCardNumber the passport card number
     */
    public void setPassportCardNumber(PassportCardNumber passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }

    /**
     * Gets tax number.
     *
     * @return the tax number
     */
    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    /**
     * Sets tax number.
     *
     * @param taxNumber the tax number
     */
    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) { this.address = address;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets agency.
     *
     * @return the agency
     */
    public Agency getAgency() {
        return agency;
    }

    /**
     * Sets agency.
     *
     * @param agency the agency
     */
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    /**
     * Gets store.
     *
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * Gets store.
     *
     * @return the store
     */
    public String getStoreName() {
        if (store != null) {
            return store.getDesignation();
        }
        return "";
    }


    /**
     * Sets store.
     *
     * @param store the store
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Gets pass.
     *
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets pass.
     *
     * @param pass the pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Employee:"  + "\nname : "+name + "\nemail : "+email + "\nphoneNumber : "+phoneNumber + "\npassportCardNumber : "+passportCardNumber + "\ntaxNumber : "+taxNumber + "\nrole : "+role + "\naddress : "+address + "\nagency : "+agency + "\nstore : "+store + "\npass : "+pass;
    }

    /**
     * Returns a string representation of the Employee object, including all of its fields.
     *
     * @return a string representation of the Employee object
     */



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return phoneNumber == employee.phoneNumber && taxNumber == employee.taxNumber && Objects.equals(name, employee.name) && Objects.equals(email, employee.email) && Objects.equals(passportCardNumber, employee.passportCardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    /**
     * Has email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean hasEmail(String email) {
        return this.email.equals(this.email);
    }

    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public Employee clone() {
        return null;
    }


    /**
     * Chech if email is valid
     *
     * @param email the email of the employee
     * @return boolean boolean
     */
    public static boolean existsEmail(String email) {
        if (!(email.contains("@") && email.contains("."))) {
            return false;
        }
        return true;
    }

    /**
     * Chech if phone number is valid
     *
     * @param phone the phone number of the employee
     * @return boolean boolean
     */
    public static boolean existsPhone(String phone) {
        if (phone.length() < 9 || phone.length() > 10) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Chech if tax number is valid
     *
     * @param taxNumber the tax Number of the employee
     * @return boolean boolean
     */
    public static boolean existsTaxNumber(String taxNumber) {
        return taxNumber.matches("[0-9]{9}");
    }

    /**
     * Chech if passport number  is valid
     *
     * @param passportCardNumber the passport number of the employee
     * @return boolean boolean
     */
    public static boolean existsPassportCardNumber(String passportCardNumber) {
      return passportCardNumber.length() == 8 && StringUtils.isNumeric(passportCardNumber);
    }

    /**
     * Chech if zipCode  is valid
     *
     * @param zipCode the zipCode of the employee
     * @return boolean boolean
     */
    public static boolean existsZipCode(int zipCode) {
        if (zipCode < 1000 || zipCode > 100000) {
            return false;
        } else {
            return true;
        }
    }




}
