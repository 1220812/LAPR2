package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Address {
     // ATTRIBUTES
    private String street;
    private String doorNumber;
    private String floorNumber;
    private String postalCode;
    private State state;
    private static final int POSTAL_CODE_LENGTH = 5;

    // CONSTRUCTORS

    /**
     *This method creates the Address object with attributes and verifies if the attributes inserted are valid
     * @param street street
     * @param doorNumber door number
     * @param floorNumber floor number
     * @param postalCode postal code
     * @param state state
     */
    public Address(String street, String doorNumber, String floorNumber, String postalCode, State state) {
        if (StringUtils.isBlank(street) || StringUtils.isBlank(doorNumber) || StringUtils.isBlank(postalCode) ||
                state == null) {
            throw new IllegalArgumentException("Invalid arguments.");
        }
        if (postalCode.length() != POSTAL_CODE_LENGTH || !StringUtils.isNumeric(postalCode)) {
            throw new IllegalArgumentException("Invalid postal code.");
        }
        if(!StringUtils.isNumeric(doorNumber)) {
            throw new IllegalArgumentException("Door Number must contain only numbers.");
        }
        if(!StringUtils.isNumeric(floorNumber)) {
            throw new IllegalArgumentException("Floor Number must contain only numbers.");
        }
        this.street = street;
        this.doorNumber = doorNumber;
        this.floorNumber = floorNumber;
        this.postalCode = postalCode;
        this.state = state;
    }

    /**
     * Method to show the street
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Method to show the door number
     * @return door number
     */
    public String getDoorNumber() {
        return doorNumber;
    }

    /**
     * Method to show the floor number
     * @return floor number
     */

    public String getFloorNumber() {
        return floorNumber;
    }

    /**
     * Method to show the po
     * @return
     */

    public String getPostalCode() {
        return postalCode;
    }

    public State getState() {
        return state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getDoorNumber(), address.getDoorNumber()) &&
                Objects.equals(getFloorNumber(), address.getFloorNumber()) &&
                Objects.equals(getPostalCode(), address.getPostalCode()) &&
                Objects.equals(getState(), address.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getDoorNumber(), getFloorNumber(), getPostalCode(), getState());
    }

    @Override
    public String toString() {
        return "Address\n\tStreet='" + street + '\'' + "\n\tDoorNumber='" + doorNumber + "\n\tFloorNumber=" +
                floorNumber + "\n\tPostalCode='" + postalCode + "\n\tState=" + state + "\n";
    }

    public Address clone() {
        return new Address(this.street, this.doorNumber, this.floorNumber, this.postalCode, this.state);
    }

}