package pt.ipp.isep.dei.esoft.project.domain;

public class SystemAdministrator extends Employee {
    public SystemAdministrator(String name, String email, int phoneNumber, int passportCardNumber, int taxNumber, String role, String agency, String store, String address, String pass ) {
        super(name, email, phoneNumber, passportCardNumber, taxNumber, role, agency, store, address, pass );

    }
    @Override
    public Employee clone() {
        return new SystemAdministrator(super.getName(),super.getEmail(),super.getPhoneNumber(),super.getPassportCardNumber(),super.getTaxNumber(), super.getRole(), super.getAgency(), super.getStore(), super.getAddress(), super.getPass());
    }

}
