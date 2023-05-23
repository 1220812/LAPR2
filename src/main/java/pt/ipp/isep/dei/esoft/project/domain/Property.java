package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Property {
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
    private PropertyAddress address;
    /**
     * photograph list of the property
     */
    /**
     * type of property
     */
    private String propertyType;
    private List<Photographs> photographsList = new ArrayList<>();
    /**
     * Method that creates a Property with all the attributes
     * @param area area of property
     * @param distanceFromTheCityCentre distance between the property and the city center
     * @param address address of property
     * @param price price of the property
     */

    public Property(double area,
                    double distanceFromTheCityCentre,
                    PropertyAddress address,
                    double price,
                    List<Photographs> photographsList) {
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
    public PropertyAddress getAddress() {
        return address;
    }
    /**
     * Method to change the address of the property
     * @param address changed address
     */
    public void setAddress(PropertyAddress address) {
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
        return "Property{" +
                "area=" + area +
                ", price=" + price +
                ", distanceFromTheCityCenter=" + distanceFromTheCityCenter +
                ", address=" + address +
                ", propertyType='" + propertyType + '\'' +
                ", photographsList=" + photographsList +
                '}';
    }

    /**
     * This method creates a new instance of the property object and initializes its attributes with the exact same values of the original object
     * @return a clone of the property object
     */
    public Property clone(){ return new Property(this.area, this.distanceFromTheCityCenter,this.address,this.price, this.photographsList); }


    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public static boolean existsArea(double area){
        if (area < 1) { return false; }
        else return true;
    }

    public static boolean existsPrice(double price){
        if (price <= 0) { return false; }
        else return true;
    }

    public static boolean existsDistanceFromCityCenter(double distanceFromTheCityCenter){
        if (distanceFromTheCityCenter < 1) { return false; }
        else return true;
    }
}