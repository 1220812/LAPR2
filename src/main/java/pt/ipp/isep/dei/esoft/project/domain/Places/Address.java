package pt.ipp.isep.dei.esoft.project.domain.Places;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private String district;
    private String state;
    private double zipCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getZipCode() {
        return zipCode;
    }

    public void setZipCode(double zipCode) {
        this.zipCode = zipCode;
    }
    public Address (String city, String street, String district, String state, double zipCode ){
        this.city=city;
        this.district=district;
        this.state=district;
        this.street=street;
        this.zipCode=zipCode;
    }

    @Override
    public String toString() {
        return
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Double.compare(address.zipCode, zipCode) == 0 && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(district, address.district) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, district, state, zipCode);
    }
}
