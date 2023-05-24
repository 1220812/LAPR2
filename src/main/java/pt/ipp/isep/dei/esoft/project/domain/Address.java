package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Address {
    String street;
    State state;
    District district;
    City city;
    String zipCode;

    public Address(String street, State state, District district, City city, String zipCode) {
        validate(street, state, district, city, zipCode);
        this.street = street;
        this.state = state;
        this.district = district;
        this.city = city;
        this.zipCode = zipCode;
    }

    private void validate(String street, State state, District district, City city, String zipCode) {
        // TODO: VALIDATE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getState(), address.getState())
                && Objects.equals(getDistrict(), address.getDistrict())
                && Objects.equals(getCity(), address.getCity());
    }

    public State getState() {
        return state;
    }

    public District getDistrict() {
        return district;
    }

    public City getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return String.format("Street: %s | City: %s | District: %s| State: %s | ZipCode: %s",street, city, district, state, zipCode);
    }
}
