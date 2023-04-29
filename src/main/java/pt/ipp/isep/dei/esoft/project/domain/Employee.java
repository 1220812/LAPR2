package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Employee {
    private String name;
    private String email;
    private int phoneNumber;
    private int passportCardNumber;
    private int taxNumber;


    private static final String DEFAULT_NOME = "No name";
    private static final String DEFAULT_EMAIL = "No email";
    private static final int DEFAULT_PHONENUMBER = 0;
    private static final int DEFAULT_PASSPORTNUMBER = 0;
    private static final int DEFAULT_TAXNUMBER = 0;


    public Employee(String name, String emailAddress, int phoneNumber, int PassportCardNumber, int taxNumber) {
        this.name = name;
        this.email = emailAddress;
        this.phoneNumber = phoneNumber;
        this.passportCardNumber = passportCardNumber;
        this.taxNumber = taxNumber;
    }


    public Employee() {
        this.name = DEFAULT_NOME;
        this.email = DEFAULT_EMAIL;
        this.phoneNumber = DEFAULT_PHONENUMBER;
        this.passportCardNumber = DEFAULT_PASSPORTNUMBER;
        this.taxNumber = DEFAULT_TAXNUMBER;
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
