package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Property{
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
    private List<Photographs> photographsList = new ArrayList<>();

   public Property (double area, double distanceFromTheCityCenter, Address address, PropertyType propertyType, List<Photographs> photographsList) {
       this.area = area;
       this.distanceFromTheCityCenter = distanceFromTheCityCenter;
       this.address = address;
       this.propertyType = propertyType;
       this.photographsList = photographsList;
   }

    public double getDistanceFromTheCityCenter() {
        return distanceFromTheCityCenter;
    }


    /**
     * Method to show the area
     * @return area
     */
    public double getArea() {
        return area;
    }

    /**
     * Method to change the area
     * @param area changed area
     */

    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Method to show the distance
     * @return distance from the city center
     */
    public double getDistance() {
        return distanceFromTheCityCenter;
    }

    /**
     * Method to change the distance from the city center
     * @param distanceFromTheCityCentre distance from the city center
     */
    public void setDistance(double distanceFromTheCityCentre) {
        this.distanceFromTheCityCenter = distanceFromTheCityCentre;
    }


    /**
     * Method to show the address of the property
     * @return address
     */
    public Address getAddress() {
        return address;
    }
    /**
     * Method to change the address of the property
     * @param address changed address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Method to change the distance from the city center
     * @param distanceFromTheCityCenter changed distance from the city center
     */
    public void setDistanceFromTheCityCenter(double distanceFromTheCityCenter) {
        this.distanceFromTheCityCenter = distanceFromTheCityCenter;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.area, area) == 0 && Double.compare(property.distanceFromTheCityCenter, distanceFromTheCityCenter) == 0 && Objects.equals(address, property.address) && Objects.equals(photographsList, property.photographsList);
    }
    @Override
    public int hashCode() {
        return Objects.hash(area, distanceFromTheCityCenter, address, photographsList);
    }

    /**
     * Textual representation of an instance of Owner
     */

    @Override
    public String toString() {
        return "Property{" +
                "area=" + area +
                ", distanceFromTheCityCenter=" + distanceFromTheCityCenter +
                ", address=" + address +
                ", propertyType=" + propertyType +
                ", photographsList=" + photographsList +
                '}';
    }

    /**
     * This method creates a new instance of the property object and initializes its attributes with the exact same values of the original object
     * @return a clone of the property object
     */
    public Property clone(){ return new Property(this.area, this.distanceFromTheCityCenter, this.address, this.propertyType, this.photographsList); }

    /**
     * Method to show the property type
     * @return property type
     */
    public PropertyType getPropertyType() {
        return propertyType;
    }

    /**
     * Method to change the property type
     * @param propertyType changed property type
     */
    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * Method to verify if that exists area
     * @param area area of the property
     * @return true if the area exists, false if not
     */
    public static boolean existsArea(double area){
        if (area < 1) { return false; }
        else return true;
    }
    /**
     * Method to verify if that exists a price
     * @param price property price
     * @return true if the price exists, false if not
     */
    public static boolean existsPrice(double price){
        if (price <= 0) { return false; }
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

}