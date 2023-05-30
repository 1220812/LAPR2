package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Address {
    /**
     * street address
     */
    private String streetAddress;
    /**
     * door number
     */
    private int doorNumber;
    /**
     * floor number
     */
    private int floorNumber;
    /**
     * zip code
     */
    private String zipCode;
    /**
     * state
     */
    private State state;
    /**
     * district
     */
    private District district;
    /**
     * city
     */
    private City city;
    /**
     * zip code length
     */
    private static final int ZIP_CODE_LENGTH = 5;
    private static final String DEFAULT_STREET="unregistered";
    private static final String DEFAULT_ZIPCODE="none";
    private City DEFAULT_CITY = new City();
    private District DEFAULT_DISTRICT = new District();
    private State DEFAULT_STATE = new State();
    private static final int DEFAULT_FLOOR_NUMBER = 0;
    private static final int DEFAULT_DOOR_NUMBER = 0;




    // CONSTRUCTORS

    /**
     * This method creates an Address object with all attributes and verifies if all the attributes inserted are valid
     * @param streetAddress street address
     * @param doorNumber door number
     * @param floorNumber floor number
     * @param zipCode zip code
     * @param state state
     * @param district district
     * @param city city
     */
    public Address(String streetAddress, int doorNumber, int floorNumber, String zipCode, State state, District district, City city) {
        if (StringUtils.isBlank(streetAddress) || StringUtils.isBlank(zipCode) || state == null || district == null || city == null) {
            throw new IllegalArgumentException("Invalid arguments.");
        }
        if (zipCode.length() != ZIP_CODE_LENGTH || !StringUtils.isNumeric(zipCode)) {
            throw new IllegalArgumentException("Invalid zip code.");
        }
        if(doorNumber<=0) {
            throw new IllegalArgumentException("Door Number must be a positive value");
        }
        if(floorNumber<=0) {
            throw new IllegalArgumentException("Floor Number must be a positive value");
        }
        this.streetAddress = streetAddress;
        this.doorNumber = doorNumber;
        this.floorNumber = floorNumber;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.district = district;
    }
    public Address(String streetAddress, String zipCode, State state, District district, City city) {
        if (StringUtils.isBlank(streetAddress) || StringUtils.isBlank(zipCode) || state == null || district == null || city == null) {
            throw new IllegalArgumentException("Invalid arguments.");
        }
        if (zipCode.length() != ZIP_CODE_LENGTH || !StringUtils.isNumeric(zipCode)) {
            throw new IllegalArgumentException("Invalid zip code.");
        }


        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.district = district;
    }

    /**
     * Creates a new instance of Address with attributes by default
     */
    public Address(){
        this.district = DEFAULT_DISTRICT;
        this.city = DEFAULT_CITY;
        this.state = DEFAULT_STATE;
        this.zipCode = DEFAULT_ZIPCODE;
        this.floorNumber = DEFAULT_FLOOR_NUMBER;
        this.streetAddress = DEFAULT_STREET;
        this.doorNumber = DEFAULT_DOOR_NUMBER;


    }

    /**
     * Method to show the street
     * @return street
     */
    public String getStreetAddress() {
        return streetAddress;
    }
    /**
     * Method to show the door number
     * @return door number
     */
    public int getDoorNumber() {
        return doorNumber;
    }
    /**
     * Method to show the floor number
     * @return floor number
     */
    public int getFloorNumber() {
        return floorNumber;
    }
    /**
     * Method to show the zip code
     * @return zip code
     */
    public String getZipCode() {
        return zipCode;
    }
    /**
     * Method to show the state
     * @return state
     */
    public State getState() {
        return state;
    }
    /**
     * Method to show the city
     * @return city
     */
    public City getCity() {
        return city;
    }
    /**
     * Method to show the district
     * @return district
     */
    public District getDistrict() {
        return district;
    }
    /**
     * Method to change the street address
     * @param streetAddress changed street address
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    /**
     * Method to change the door number
     * @param doorNumber changed door number
     */
    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }
    /**
     * Method to change the floor number
     * @param floorNumber changed floor number
     */
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    /**
     * Method to change the zip code
     * @param zipCode changed zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    /**
     * Method to change the state
     * @param state changed state
     */
    public void setState(State state) {
        this.state = state;
    }
    /**
     * Method to change the city
     * @param city changed city
     */
    public void setCity(City city) {
        this.city = city;
    }
    /**
     * Method to change the district
     * @param district changed district
     */
    public void setDistrict(District district) {
        this.district = district;
    }
    /**
     * Compares two instances of Address
     * @param o other instance of Address
     * @return true if the instances are equal, false otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getStreetAddress(), address.getStreetAddress()) &&
                Objects.equals(getDoorNumber(), address.getDoorNumber()) &&
                Objects.equals(getFloorNumber(), address.getFloorNumber()) &&
                Objects.equals(getZipCode(), address.getZipCode()) &&
                Objects.equals(getState(), address.getState());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getStreetAddress(), getDoorNumber(), getFloorNumber(), getZipCode(), getState(), getCity(), getDistrict());
    }
    /**
     * Textual representation of an instance of Address
     */
    @Override
    public String toString() {
        return "Address\n\tStreet='" + streetAddress + '\'' + "\n\tDoorNumber='" + doorNumber + "\n\tFloorNumber=" +
                floorNumber + "\n\tPostalCode='" + zipCode + "\n\tState=" + state + "\n";
    }

    /**
     * This method creates a clone/copy of the created address
     * @return copy of address
     */
    public Address clone(){ return new Address(this.streetAddress, this.doorNumber,this.floorNumber,this.zipCode,this.state,this.district,this.city); }
    public static boolean existsZipCode(String zipCode){
        if ((zipCode.length() != ZIP_CODE_LENGTH) || (StringUtils.isBlank(zipCode)) || (!StringUtils.isNumeric(zipCode))) { return false; }
        else return true;
    }

    public static boolean existsDoorNumber(int floorNumber){
        if (floorNumber < 1) { return false; }
        else return true;
    }
}