package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Address {
    String street;
    State state;
    District district;
    City city;
    String zipCode;

    private static final int ZIP_CODE_LENGTH = 5;

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

    @Override
    public String toString() {
        return String.format("City: %s | District: %s| State: %s", city, district, state);
    }

    public static boolean existsZipCode(String zipCode){
        if ((zipCode.length() != ZIP_CODE_LENGTH) || (StringUtils.isBlank(zipCode)) || (!StringUtils.isNumeric(zipCode))) { return false; }
        else return true;
    }

    public static boolean existsDoorNumber(int floorNumber){
        if (floorNumber < 1) { return false; }
        else return true;
    }
}
