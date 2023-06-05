package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Property implements Comparable<Property>{
    /**
     * area of the property
     */
    private double area;
    /**
     * price of the property
     */
    private double price;
    /**
     * distance between the property and the city center
     */
    private double distanceFromTheCityCenter;
    /**
     * property address
     */
    private Address address;
    private Store store;
    /**
     * type of property
     */
    private String propertyType;
    private List<Photographs> photographsList = new ArrayList<>();

    private String propertyCode;
    private Date date;

    /**
     * Method that creates a Property with all the attributes
     * @param area area of property
     * @param distanceFromTheCityCentre distance between the property and the city center
     * @param address address of property
     * @param price price of the property
     */
    public Property(double area, double distanceFromTheCityCentre, Address address, double price, List<Photographs> photographsList) {
        if (area <= 0)
            throw new IllegalArgumentException("Inserted value for area must be greater than 0");
        if (distanceFromTheCityCentre <= 0)
            throw new IllegalArgumentException("Inserted value for distance from the city center from the city centre must be greater than 0");
        if (address == null)
            throw new IllegalArgumentException("Address must not be null");
        if(price<=0){
            throw new IllegalArgumentException("The price must be greater than 0");
        }
        this.area = area;
        this.distanceFromTheCityCenter = distanceFromTheCityCentre;
        this.address = address;
        this.price = price;
        this.photographsList = photographsList;
    }
    public Property (double price, Address address, double area, double distanceFromTheCityCenter) {
        this.price = price;
        this.address = address;
        this.area = area;
        this.distanceFromTheCityCenter = distanceFromTheCityCenter;
    }
    public Property(String propertyCode,double price, Address address, double area, double distanceFromTheCityCenter) {
        this.price = price;
        this.address = address;
        this.area = area;
        this.distanceFromTheCityCenter = distanceFromTheCityCenter;
        this.propertyCode = propertyCode;
        this.date = new Date();
    }

    public double getDistanceFromTheCityCenter() {
        return distanceFromTheCityCenter;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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
     * Method to change the price
     * @param price changed property price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method to show the price
     * @return price
     */
    public double getPrice() {
        return price;
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
        return Double.compare(property.area, area) == 0 && Double.compare(property.price, price) == 0 && Double.compare(property.distanceFromTheCityCenter, distanceFromTheCityCenter) == 0 && Objects.equals(address, property.address) && Objects.equals(photographsList, property.photographsList);
    }
    @Override
    public int hashCode() {
        return Objects.hash(area, price, distanceFromTheCityCenter, address, photographsList);
    }

    /**
     * Textual representation of an instance of Owner
     */

    @Override
    public String toString() {
        return "Property:" +
                " area = " + area +
                ", price = " + price +
                ", distance from the city center = " + distanceFromTheCityCenter + address + ", property code = " + propertyCode;
    }

    /**
     * This method creates a new instance of the property object and initializes its attributes with the exact same values of the original object
     * @return a clone of the property object
     */
    public Property clone(){ return new Property(this.area, this.distanceFromTheCityCenter,this.address,this.price, this.photographsList); }

    /**
     * Method to show the property type
     * @return property type
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * Method to change the property type
     * @param propertyType changed property type
     */
    public void setPropertyType(String propertyType) {
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
    /**
     * Method to verify if that exists a property type
     * @param propertyCode property code
     * @return true if the property type exists, false if not
     */
    public boolean hasCode(String propertyCode) {
        if(propertyCode == null){
            return false;
        }
        return true;
    }
    /**
     * Method to show the code
     * @return code
     */
    public String getCode(){
        return propertyCode;
    }
    /**
     * Method that shows the publishing date
     * @return publishing date
     */
    public Date getDate() {
        if(date == null){
            return new Date();
        }
        return date;
    }
    /**
     * Method that changes the publishing date
     * @param date changed publishing date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Compares this property to another property based on their prices.
     * @param other The other property to compare to.
     * @return -1 if this property is cheaper than the other property, 0 if they have the same price, 1 otherwise.
     */
    public int compareTo(Property other) {
        if (price < other.getPrice()) {
            return -1;
        }
        if (price > other.getPrice()) {
            return 1;
        }
        return 0;
    }
    /**
     * Method that compares the properties by date
     * @param property property
     * @return value that represents the comparison
     */
    public int compareByDate(Property property) {
        int dateComparison = this.getDate().compareTo(property.getDate());
        if (dateComparison != 0) {
            return dateComparison;
        }
        String thisCode = this.getCode();
        String otherCode = property.getCode();
        if (thisCode == null && otherCode == null) {
            return 0;
        } else if (thisCode == null) {
            return -1;
        } else if (otherCode == null) {
            return 1;
        } else {
            return thisCode.compareTo(otherCode);
        }
    }
}