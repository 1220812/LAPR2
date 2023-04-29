package pt.ipp.isep.dei.esoft.project.domain;

public class SystemAdministrator extends Employee {
    public SystemAdministrator(String name, String email, int phoneNumber, int passportCardNumber, int taxNumber) {
        super(name, email, phoneNumber, passportCardNumber, taxNumber);

    }
    @Override
    public Employee clone() {
        return new SystemAdministrator(super.getName(),super.getEmail(),super.getPhoneNumber(),super.getPassportCardNumber(),super.getTaxNumber());
    }

}
