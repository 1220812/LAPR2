package pt.ipp.isep.dei.esoft.project.domain;

public class StoreManager {

    private String name;

    private String phoneNumber;

    private String emailAddress;

    private TaxNumber taxNumber;

    private PassportCardNumber passportCardNumber;

    private Address address;
    private Role role;
    private Agency agency;
    private Store store;
    private String pass;
    public StoreManager(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, Store store, String pass) {
        this.name=name;
        this.emailAddress=email;
        this.phoneNumber=phone;
        this.passportCardNumber=passportCardNumber;
        this.taxNumber=taxNumber;
        this.address=address;
        this.role=role;
        this.agency=agency;
        this.store=store;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "StoreManager{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", taxNumber=" + taxNumber +
                ", passportCardNumber=" + passportCardNumber +
                ", address=" + address +
                ", role=" + role +
                ", agency=" + agency +
                ", store=" + store +
                ", pass='" + pass + '\'' +
                '}';
    }
    public StoreManager clone(){ return new StoreManager(this.name,this.emailAddress, this.phoneNumber, this.passportCardNumber, this.taxNumber, this.address, this.role, this.agency, this.store,this.pass); }
}