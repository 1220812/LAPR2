package pt.ipp.isep.dei.esoft.project.domain;

public class SystemAdministrator extends Employee {
    public SystemAdministrator(String name, String email, String phoneNumber, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Role role, Address address, String pass ) {
        super(name, email, phoneNumber, passportCardNumber, taxNumber, address, role, pass);
    }

    public SystemAdministrator(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, String pass) {
        super(name, email, phone, passportCardNumber, taxNumber, address, role, pass);
    }

    @Override
    public Employee clone() {
        return new SystemAdministrator(super.getName(),super.getEmail(),super.getPhoneNumber(),super.getPassportCardNumber(),super.getTaxNumber(), super.getRole(), super.getAddress(), super.getPass());
    }

}
