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
    /**
     * default street address
     */
    private static final String DEFAULT_STREET="unregistered";
    /**
     * default zip code
     */
    private static final String DEFAULT_ZIPCODE="none";
    /**
     * default city
     */
    private City DEFAULT_CITY = new City();
    /**
     * default district
     */
    private District DEFAULT_DISTRICT = new District();
    /**
     * default state
     */
    private State DEFAULT_STATE = new State();
    /**
     * default floor number
     */
    private static final int DEFAULT_FLOOR_NUMBER = 0;
    /**
     * default door number
     */
    private static final int DEFAULT_DOOR_NUMBER = 0;

    /**
     * Method that creates a new instance of Address
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
    /**
     * Creates a new instance of Address with ãll the attributes by default
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
     * This method creates a new instance of Address with the following parameters:
     * @param streetAddress street address
     * @param zipCode zip code
     * @param state state
     * @param city city
     * @param district district
     */
    public Address(String streetAddress, City city, District district,State state,String zipCode) {
        if (StringUtils.isBlank(streetAddress) || StringUtils.isBlank(zipCode) || state == null || district == null || city == null) {
            throw new IllegalArgumentException("Invalid arguments.");
        }
        if (zipCode.length() != ZIP_CODE_LENGTH || !StringUtils.isNumeric(zipCode)) {
            throw new IllegalArgumentException("Invalid zip code.");
        }
        this.streetAddress = streetAddress;
        this.city = city;
        this.district = district;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * This method creates a new instance of Address with the following parameters:
     * @param streetAddress street address
     * @param zipCode zip code
     * @param state state
     */
    public Address(String streetAddress,City city,  State state,String zipCode) {
        if (StringUtils.isBlank(streetAddress) || StringUtils.isBlank(zipCode) || state == null || city == null) {
            throw new IllegalArgumentException("Invalid arguments.");
        }
        if (zipCode.length() != ZIP_CODE_LENGTH || !StringUtils.isNumeric(zipCode)) {
            throw new IllegalArgumentException("Invalid zip code.");
        }
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
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
     * Method that checks if the zip code exists
     * @param zipCode zip code
     * @return true if the zip code exists, false otherwise
     */
    public static boolean existsZipCode(String zipCode){
        if ((zipCode.length() != ZIP_CODE_LENGTH) || (StringUtils.isBlank(zipCode)) || (!StringUtils.isNumeric(zipCode))) { return false; }
        else return true;
    }
    /**
     * Method that checks if the door number exists
     * @param floorNumber floor number
     * @return true if the door number exists, false otherwise
     */
    public static boolean existsDoorNumber(int floorNumber){
        if (floorNumber < 1) { return false; }
        else return true;
    }
    /**
     * Compares two instances of Address
     * @param o other instance of Address
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return doorNumber == address.doorNumber && floorNumber == address.floorNumber && streetAddress.equals(address.streetAddress) && zipCode.equals(address.zipCode) && state.equals(address.state) && district.equals(address.district) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress, doorNumber, floorNumber, zipCode, state, district, city);
    }

    /**
     * Textual representation of an instance of Address
     */
    @Override
    public String toString() {
        return "state : "+state + ", district : "+district + ", city : "+city  + ", zipcode : "+zipCode + ", street address: "+streetAddress;
    }

    /**
     * This method creates a clone/copy of the created address
     * @return copy of address
     */
    public Address clone(){ return new Address(this.streetAddress, this.doorNumber,this.floorNumber,this.zipCode,this.state,this.district,this.city); }
}