package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Address {
    State state;
    District district;
    City city;

    public Address(State state, District district, City city) {
        this.state = state;
        this.district = district;
        this.city = city;
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
}
