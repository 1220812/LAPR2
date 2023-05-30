package pt.ipp.isep.dei.esoft.project.domain;

public class NetworkManager {


    private String name;

    private String phoneNumber;

    private String emailAddress;

    private TaxNumber taxNumber;

    private PassportCardNumber passportCardNumber;

    private Address address;
    private Role role;
    private Agency agency;
    private String pass;

    public NetworkManager(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, String pass) {
        this.name=name;
        this.emailAddress=email;
        this.phoneNumber=phone;
        this.passportCardNumber=passportCardNumber;
        this.taxNumber=taxNumber;
        this.address=address;
        this.role=role;
        this.agency=agency;
        this.pass=pass;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public PassportCardNumber getPassportCardNumber() {
        return passportCardNumber;
    }

    public void setPassportCardNumber(PassportCardNumber passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }



    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "NetworkManager{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", taxNumber=" + taxNumber +
                ", passportCardNumber=" + passportCardNumber +
                ", address=" + address +
                ", role=" + role +
                ", agency=" + agency +
                ", pass='" + pass + '\'' +
                '}';
    }
    public NetworkManager clone(){ return new NetworkManager(this.name,this.emailAddress,this.phoneNumber,this.passportCardNumber,this.taxNumber,this.address,this.role, this.agency, this.pass); }

}
