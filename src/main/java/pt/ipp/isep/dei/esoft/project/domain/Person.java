package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;
import pt.isep.lei.esoft.auth.domain.model.Email;
import pt.isep.lei.esoft.auth.domain.model.Password;
import pt.isep.lei.esoft.auth.domain.model.User;

import java.util.Objects;

/**
 * Represents a Person.
 */

public class Person extends User {

    private final String password;
    /**
     * Attributes
     */
    private String passportCardNumber;
    private String taxNumber;
    private String phoneNumber;
    private Address address;

    /**
     * The password of the Person.
     */
    private static final int PASSPORT_NUMBER_LENGTH = 8;
    private static final int TAX_NUMBER_LENGTH = 9;

    /**
     * Constructor of a Person instance with parameters.
     * @param id             Email of the Person
     * @param password            Password of the Person
     * @param name           Name of the Person
     * @param passportNumber Passport number of the Person
     * @param taxNumber      Tax number of the Person
     * @param phoneNumber    Phone number of the Person
     * @param address        Address of the Person
     * @throws IllegalArgumentException in case the parameters are not valid
     */

    public Person(Email id, String password, String name, String passportNumber, String taxNumber, String phoneNumber,
                  Address address) {
        super(id, new Password(password), name);
        if (!validatePassword(password))
            throw new IllegalArgumentException("Password must contain at least 3 capital letters and 2 numbers and be at least 7 characters long");
        if (passportNumber == null || taxNumber == null || phoneNumber == null || address == null)
            throw new IllegalArgumentException("Attributes cannot be null");
        if (passportNumber.length() != PASSPORT_NUMBER_LENGTH || !StringUtils.isNumeric(passportNumber))
            throw new IllegalArgumentException("Passport number must contain " + PASSPORT_NUMBER_LENGTH +
                    " digits and be all numerics digits");
        if (!phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}"))
            throw new IllegalArgumentException("Phone number must be in the format (xxx) xxx-xxxx");
        if (taxNumber.length() != TAX_NUMBER_LENGTH || !StringUtils.isNumeric(taxNumber))
            throw new IllegalArgumentException("Tax number must contain " + TAX_NUMBER_LENGTH +
                    " digits and be all numberics digits");

        this.passportCardNumber = passportNumber;
        this.taxNumber = taxNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
    }

    /**
     * @return the passport number of the Person
     */
    public String getPassportCardNumber() {
        return passportCardNumber;
    }

    /**
     * Sets the passport number of the Person
     * @param passportCardNumber the passport number of the Person
     */
    public void setPassportCardNumber(String passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }

    /**
     * @return the tax number of the Person
     */

    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * Sets the tax number of the Person
     * @param taxNumber the tax number of the Person
     */

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * @return the phone number of the Person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the Person
     * @param phoneNumber the phone number of the Person
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getaddress() {
        return address;
    }

    public void setaddress(Address address) {
        this.address = address;
    }

    /**
     * Validates the password of the Person
     * @param password
     * @return true if the password is valid, false otherwise
     */
    public boolean validatePassword(String password) {
        if (password.length() < 7)
            return false;
        int countCapitalLetters = 0;
        int countNumbers = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i)))
                countCapitalLetters++;
            if (Character.isDigit(password.charAt(i)))
                countNumbers++;
        }
        if (countCapitalLetters < 3 || countNumbers < 2)
            return false;
        return true;
    }

    /**
     * Clones an instance of Person
     * @return the new instance of Person
     */
    public Person clone() {
        return new Person(this.getId(), this.password, this.getName(), this.passportCardNumber,
                this.taxNumber, this.phoneNumber, this.address);
    }

    /**
     * Compares two instances of Person
     * @param o the other instance of Person
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(passportCardNumber, person.passportCardNumber) || Objects.equals(taxNumber, person.taxNumber) ||
                Objects.equals(phoneNumber, person.phoneNumber) || Objects.equals(address, person.address) ||
                Objects.equals(this.getId(), person.getId());
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passportCardNumber, taxNumber, phoneNumber, address, password);
    }

    /**
     * @return the textual representation of an instance of Person
     */
    @Override
    public String toString() {
        return "Person\n\tpassportNumber=" + passportCardNumber + "\n\ttaxNumber='" + taxNumber + "\n\tphoneNumber=" +
                phoneNumber + "\n\taddress=" + address + "\n";
    }
}