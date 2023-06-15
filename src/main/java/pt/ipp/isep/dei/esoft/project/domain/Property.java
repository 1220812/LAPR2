package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Property {
    /**
     * area of the property
     */
    private double area;
    /**
     * distance between the property and the city center
     */
    private double distanceFromTheCityCenter;
    /**
     * property address
     */
    private Address address;
    /**
     * type of property
     */
    private PropertyType propertyType;
    /**
     * List of photographs of the property
     */
    private List<Photographs> photographsList = new ArrayList<>();
    /**
     * final price of the property (price of sell/rent of the property)
     */
    private double finalPrice;
    /**
     * business date (date of the sell/rent of the property)
     */
    private LocalDate businessDate;

    /**
     * Method that creates a new instance of property
     *
     * @param area                      area of the property
     * @param distanceFromTheCityCenter distance between the property and the city center
     * @param address                   property address
     * @param propertyType              type of property
     * @param photographsList           list of photographs of the property
     */
    public Property(double area, double distanceFromTheCityCenter, Address address, PropertyType propertyType, List<Photographs> photographsList) {
        if (area <= 0) {
            throw new IllegalArgumentException("Area must be greater than 0");
        }
        if (distanceFromTheCityCenter <= 0) {
            throw new IllegalArgumentException("Distance from the city center must be greater than 0");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address must not be null");
        }
        if (propertyType == null) {
            throw new IllegalArgumentException("Property type must not be null");
        }
        this.area = area;
        this.distanceFromTheCityCenter = distanceFromTheCityCenter;
        this.address = address;
        this.propertyType = propertyType;
        this.photographsList = photographsList;
    }

    /**
     * This method creates a new instance of property with the given parameters:
     * @param area area of the property
     * @param distanceFromTheCityCenter distance between the property and the city center
     * @param address property address
     * @param propertyType type of property
     * @param finalPrice final price of the property (price of sell/rent of the property)
     * @param businessDate business date (date of the sell/rent of the property)
     */
    public Property(double area, double distanceFromTheCityCenter, Address address, PropertyType propertyType, double finalPrice, LocalDate businessDate) {
        if (area <= 0) {
            throw new IllegalArgumentException("Area must be greater than 0");
        }
        if (distanceFromTheCityCenter <= 0) {
            throw new IllegalArgumentException("Distance from the city center must be greater than 0");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address must not be null");
        }
        if (propertyType == null) {
            throw new IllegalArgumentException("Property type must not be null");
        }
        if(finalPrice <= 0){
            throw new IllegalArgumentException("Final price must be greater than 0");
        }
        this.area = area;
        this.distanceFromTheCityCenter = distanceFromTheCityCenter;
        this.address = address;
        this.propertyType = propertyType;
        this.finalPrice = finalPrice;
        this.businessDate = businessDate;
    }

    /**
     * Method that shows the distance from the city center
     *
     * @return distance from the city center
     */
    public double getDistanceFromTheCityCenter() {
        return distanceFromTheCityCenter;
    }

    /**
     * Method to show the area
     *
     * @return area
     */
    public double getArea() {
        return area;
    }

    /**
     * Method to change the area
     *
     * @param area changed area
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Method to show the address of the property
     *
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Method to change the address of the property
     *
     * @param address changed address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Method to change the distance from the city center
     *
     * @param distanceFromTheCityCenter changed distance from the city center
     */
    public void setDistanceFromTheCityCenter(double distanceFromTheCityCenter) {
        this.distanceFromTheCityCenter = distanceFromTheCityCenter;
    }
    /**
     * Method to show the property type
     *
     * @return property type
     */
    public PropertyType getPropertyType() {
        return propertyType;
    }

    /**
     * Method to change the property type
     *
     * @param propertyType changed property type
     */
    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * Method that verifies if the property has area
     * @param area area of the property
     * @return true if the property has area, false if not
     */
    public static boolean existsArea(double area){
        if (area < 1) { return false; }
        else return true;
    }
    /**
     * Method to verify if that exists a distance from the city center
     * @param distanceFromTheCityCenter distance from the city center
     * @return  true if the distance from the city center exists, false if not
     */
    public static boolean existsDistanceFromCityCenter(double distanceFromTheCityCenter){
        if (distanceFromTheCityCenter < 1) { return false; }
        else return true;
    }
    /**
     * Equals method that verifies if the property already exists in the system
     *
     * @param o object to compare with
     * @return true if the property already exists, false if it doesn't
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.area, area) == 0 && Double.compare(property.distanceFromTheCityCenter, distanceFromTheCityCenter) == 0 && Objects.equals(address, property.address) && Objects.equals(propertyType, property.propertyType) && Objects.equals(photographsList, property.photographsList);
    }
    /**
     * Method that returns a unique code that identifies the property
     *
     * @return hash code for the property
     */
    @Override
    public int hashCode() {
        return Objects.hash(area, distanceFromTheCityCenter, address, propertyType, photographsList);
    }
    /**
     * Textual representation of an instance of property
     */
    @Override
    public String toString() {
        return "\nArea = " + area +
                "\nDistance from the city center = " + distanceFromTheCityCenter +
                "\n" + address +
                "\nProperty type = " + propertyType +
                "\nPhotographs list = " + photographsList;
    }
    /**
     * Method that creates an exact copy of the property object
     *
     * @return a clone of the property object
     */
    public Property clone() {
        return new Property(this.area, this.distanceFromTheCityCenter, this.address, this.propertyType, this.photographsList);
    }
}