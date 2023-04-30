package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Employee {
    private String name;
    private String email;
    private int phoneNumber;
    private int passportCardNumber;
    private int taxNumber;
    private String role;
    private String Address;

    private String agency;

    private String store;
    private String pass;


    private static final String DEFAULT_NOME = "No name";
    private static final String DEFAULT_EMAIL = "No email";
    private static final int DEFAULT_PHONENUMBER = 0;
    private static final int DEFAULT_PASSPORTNUMBER = 0;
    private static final int DEFAULT_TAXNUMBER = 0;

    private static final String DEFAULT_ROLE = "No role";

    private static final String DEFAULT_AGENCY = "No agency";
    private static final String DEFAULT_STORE = "No store";
    private static final String DEFAULT_ADDRESS = "No passport";

    private static final String DEFAULT_PASSWORD = "No password";

    /**
     Creates a new Employee object with the given attributes.
     @param name The name of the employee.
     @param email The email address of the employee.
     @param phoneNumber The phone number of the employee.
     @param passportCardNumber The passport or card number of the employee.
     @param taxNumber The tax number of the employee.
     @param address The address of the employee.
     @param role The role of the employee.
     @param agency The agency of the employee.
     @param store The store of the employee.
     @param pass The password of the employee.
     */

    public Employee(String name, String email, int phoneNumber, int passportCardNumber, int taxNumber, String address, String role, String agency, String store, String pass) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
        this.Address = address;
        this.role = role;
        this.agency = agency;
        this.store = store;
        this.pass = pass;
    }

    /**
     Creates a new Employee object with the given attributes.
     @param email The email address of the employee.
     */
    public Employee(String email) {
        this.email = email;
    }

    /**
     Creates a new Employee object with no attributes.
     */
    public Employee() {
        this.name = DEFAULT_NOME;
        this.email = DEFAULT_EMAIL;
        this.phoneNumber = DEFAULT_PHONENUMBER;
        this.passportCardNumber = DEFAULT_PASSPORTNUMBER;
        this.taxNumber = DEFAULT_TAXNUMBER;
        this.Address = DEFAULT_ADDRESS;
        this.role = DEFAULT_ROLE;
        this.agency=DEFAULT_AGENCY;
        this.store=DEFAULT_STORE;
        this.pass=DEFAULT_PASSWORD;
    }
    /**
     Creates a new Employee object with the given information and returns it.
     @param name the name of the employee
     @param email the email address of the employee
     @param phoneNumber the phone number of the employee
     @param passportCardNumber the passport or card number of the employee
     @param taxNumber the tax number of the employee
     @param address the address of the employee
     @param role the role of the employee in the company
     @param agency the agency the employee is associated with
     @param store the store the employee works in
     @param pass the password for the employee account
     @return a new Employee object with the given information
     */
    public static Employee newEmployee(String name, String email, int phoneNumber, int passportCardNumber, int taxNumber, String address, String role, String agency, String store, String pass) {
        Employee newEmployee= new Employee(name, email, phoneNumber, passportCardNumber, taxNumber, address, role, agency, store, pass);
        return newEmployee;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPassportCardNumber() {
        return passportCardNumber;
    }

    public void setPassportCardNumber(int passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    /**

     Returns a string representation of the Employee object, including all of its fields.
     @return a string representation of the Employee object
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", passportCardNumber=" + passportCardNumber +
                ", taxNumber=" + taxNumber +
                ", role='" + role + '\'' +
                ", Address='" + Address + '\'' +
                ", agency='" + agency + '\'' +
                ", store='" + store + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

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

}
