package pt.ipp.isep.dei.esoft.project.domain;

public class EmployeeDto {
    private String name;
    private int phone;
    private int taxNumber;
    private String address;
    private String country;
    private String city;
    private String state;
    private String zipCode;
    private String district;
    private String email;
    private int passportCardNumber;
    private String role;
    private String password;

    private String store;
    private String agency;

    public String getPassword() {
        return password;
    }

    public EmployeeDto(String name,int phone, String address, String email, int passportCardNumber, String city, String role, String password, int taxNumber, String agency, String store) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.passportCardNumber = passportCardNumber;
        this.city = city;
        this.role = role;
        this.password = password;
        this.zipCode=zipCode;
        this.state=state;
        this.district=district;
        this.taxNumber=taxNumber;
        this.country=country;
        this.store=store;
        this.agency=agency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public double getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassportCardNumber() {
        return passportCardNumber;
    }

    public void setPassportCardNumber(int passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
