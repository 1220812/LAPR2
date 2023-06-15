package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * The type System administrator.
 */
public class SystemAdministrator extends Employee implements Serializable {
    /**
     * Instantiates a new System administrator.
     *
     * @param name               the name
     * @param email              the email
     * @param phoneNumber        the phone number
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param role               the role
     * @param address            the address
     * @param pass               the pass
     */
    public SystemAdministrator(String name, String email, String phoneNumber, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Role role, Address address, String pass ) {
        super(name, email, phoneNumber, passportCardNumber, taxNumber, address, role, pass);
    }

    /**
     * Instantiates a new System administrator.
     *
     * @param name               the name
     * @param email              the email
     * @param phone              the phone
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param address            the address
     * @param role               the role
     * @param pass               the pass
     */
    public SystemAdministrator(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, String pass) {
        super(name, email, phone, passportCardNumber, taxNumber, address, role, pass);
    }

    @Override
    public Employee clone() {
        return new SystemAdministrator(super.getName(),super.getEmail(),super.getPhoneNumber(),super.getPassportCardNumber(),super.getTaxNumber(), super.getRole(), super.getAddress(), super.getPass());
    }

}
