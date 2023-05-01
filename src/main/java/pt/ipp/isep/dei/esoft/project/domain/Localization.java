package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * The Location class represents a location.
 */
public class Localization {

    private String city;
    private String floorNumber;
    private String doorNumber;
    private String state;
    private String street;
    private String postalCode;
    private String district;
    /**
     * The postal code length constant represents the length of a valid postal code.
     */

    private static final int POSTAL_CODE_LENGTH = 5;

    /**
     * Constructs a new Location object with the given parameters.
     *
     * @param street      The street of the location.
     * @param doorNumber  The doorNumber of the location.
     * @param floorNumber The floorNumber of the location.
     * @param postalCode  The postalCode of the location.
     * @param city        The city of the location.
     * @param district    The district of the location.
     * @param state       The state of the location.
     * @throws IllegalArgumentException If any of the required parameters are blank or null, or if the postal code is invalid or the door/floor numbers contain non-numeric characters.
     */
    public Localization(String street, String doorNumber, String floorNumber, String postalCode, String city, String district, String state) {
        if (StringUtils.isBlank(street) || StringUtils.isBlank(doorNumber) || StringUtils.isBlank(postalCode) || city == null || district == null || state == null) {
            throw new IllegalArgumentException("Invalid arguments.");
        }
        if (postalCode.length() != POSTAL_CODE_LENGTH || !StringUtils.isNumeric(postalCode)) {
            throw new IllegalArgumentException("Invalid postal code");
        }
        if (!StringUtils.isNumeric(doorNumber)) {
            throw new IllegalArgumentException("Door Number must contain only numbers.");
        }
        if (!StringUtils.isNumeric(floorNumber)) {
            throw new IllegalArgumentException("Floor Number must contain only numbers.");
        }
        this.street = street;
        this.doorNumber = doorNumber;
        this.floorNumber = floorNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.district = district;
        this.state = state;
    }

    /**
     * Returns the city of the location.
     *
     * @return The city of the location.
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the district of the location.
     *
     * @return The district of the location.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Returns the state of the location.
     *
     * @return The state of the location.
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the street of the location.
     *
     * @return The street of the location.
     */

    public String getStreet() {
        return street;
    }

    /**
     * Returns the floor number of the location.
     *
     * @return The floor number of the location.
     */

    public String getFloorNumber() {
        return floorNumber;
    }

    /**
     * Returns the door number of the location.
     *
     * @return The door number of the location.
     */
    public String getDoornumber() {
        return doorNumber;
    }

    /**
     * Sets the city of the location.
     *
     * @param city The new city of the location.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the floor number of the location.
     *
     * @param floorNumber The new floor number of the location.
     */

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    /**
     * Sets the door number of the location.
     *
     * @param doorNumber The new door number of the location.
     */

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    /**
     * Sets the state of the location.
     *
     * @param state The new state of the location.
     */

    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the street of the location.
     *
     * @param street The new street of the location.
     */

    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Sets the postal code of the location.
     *
     * @param postalCode The new postal code of the location.
     */

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Sets the district of the location.
     *
     * @param district The new district of the location.
     */

    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Returns a string representation of the Location object.
     *
     * @return a string representation of the Location object.
     */

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", doorNumber='" + doorNumber + '\'' +
                ", floorNumber='" + floorNumber + '\'' +
                ", postalCode=" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    /**
     * Generates a hash code for the Location object based on its attributes.
     *
     * @return a hash code for the Location object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(street, doorNumber, floorNumber, postalCode, city, district, state);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * * @param obj the reference object with which to compare.
     *
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Localization localization = (Localization) obj;
        return Objects.equals(street, localization.street) && Objects.equals(doorNumber, localization.doorNumber) && Objects.equals(floorNumber, localization.floorNumber) && Objects.equals(postalCode, localization.postalCode) && Objects.equals(city, localization.state) && Objects.equals(district, localization.district) && Objects.equals(state, localization.state);
    }

    /**
     * Creates and returns a copy of the Location object.
     *
     * @return a copy of the Location object.
     * @throws CloneNotSupportedException if the object's class does not support the clone.
     */
    @Override
    protected Localization clone() throws CloneNotSupportedException {
        return new Localization(this.street, this.doorNumber, this.floorNumber, this.postalCode, this.city, this.district, this.state);
    }
}