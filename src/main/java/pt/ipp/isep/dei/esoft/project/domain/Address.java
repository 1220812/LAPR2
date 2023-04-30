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
     * Method to show the postal code
     * @return postal code
     */

    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Method to show the state
     * @return state
     */

    public State getState() {
        return state;
    }

    /**
     * Method to show the street
     * @param street
     */

    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Method to change the door number
     * @param doorNumber
     */

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    /**
     * Method to change the floor number
     * @param floorNumber
     */

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    /**
     * Method to change the postal code
     * @param postalCode
     */

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Method to change the state
     * @param state
     */

    public void setState(State state) {
        this.state = state;
    }

    /**
     * Method to compare the attributes of the current object with those of another object
     * @param o object that will be compared with
     * @return boolean
     */

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

    /**
     * Method to return a hash code for the object in order to ensure that this hash code will not collide with the others
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getDoorNumber(), getFloorNumber(), getPostalCode(), getState());
    }

    /**
     * Method to show the Address characteristics
     * @return String with te Address characteristics
     */
    @Override
    public String toString() {
        return "Address\n\tStreet='" + street + '\'' + "\n\tDoorNumber='" + doorNumber + "\n\tFloorNumber=" +
                floorNumber + "\n\tPostalCode='" + postalCode + "\n\tState=" + state + "\n";
    }

    /**
     * This method creates a new instance of the address object and initializes its attributes with the exact same values of the original object
     * @return a clone of the address object
     */

    public Address clone() {
        return new Address(this.street, this.doorNumber, this.floorNumber, this.postalCode, this.state);
    }

}