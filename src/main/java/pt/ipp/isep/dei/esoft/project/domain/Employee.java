package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Employee {

    private String emailAddress;
    private String name;
    private String role;
    private int phoneNumber;
    private int passportCardNumber;
    private int vatNumber;
    private String city;
    private String street;
    private String district;
    private String state;
    private int zipCode;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getPassportCardNumber() {
        return passportCardNumber;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public int getZipCode() {
        return zipCode;
    }

    public Employee(String emailAddress, String name, String role, int phoneNumber, int passportCardNumber, int vatNumber, String street, String city, String district, String state, int zipCode) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.passportCardNumber = passportCardNumber;
        this.vatNumber = vatNumber;
        this.street = street;
        this.city = city;
        this.district = district;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return emailAddress.equals(employee.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }

    public boolean hasEmail(String email) {
        return this.emailAddress.equals(email);
    }

    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public Employee clone() {
        return new Employee(emailAddress, name, role, phoneNumber, passportCardNumber, vatNumber, street, city, district, state, zipCode);
    }
}