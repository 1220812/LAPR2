package pt.ipp.isep.dei.esoft.project.domain;

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
     * property photos list
     */
    private List<String> photographs;
    /**
     * property address
     */
    private Address address;
    /**
     * Type of the property
     */
    private PropertyType propertyType;

    /**
     * Method that creates a Property with all the attributes
     * @param area area of property
     * @param distanceFromTheCityCentre distance between the property and the city center
     * @param address address of property
     * @param photographs photo list of the property
     * @param price price of the property
     */
    public Property(double area, double distanceFromTheCityCentre, Address address, List<String> photographs, double price, PropertyType propertyType) {
        if (area <= 0)
            throw new IllegalArgumentException("Inserted value for area must be greater than 0");
        if (distanceFromTheCityCentre <= 0)
            throw new IllegalArgumentException("Inserted value for distanceFromTheCityCentre from the city centre must be greater than 0");
        if (address == null)
            throw new IllegalArgumentException("Address must not be null");
        if(price<=0){
            throw new IllegalArgumentException("The price must be greater than 0");
        }
        this.area = area;
        this.distanceFromTheCityCenter = distanceFromTheCityCentre;
        this.photographs = photographs;
        this.address = address;
        this.price = price;
        this.propertyType = propertyType;
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
     * Method to show the list of photos
     * @return list of photos
     */
    public List<String> getPhotos() {
        return photographs;
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
     * Method to add property photos to the list
     * @param photographs photo added to the list
     */
    public void setPhotos(List<String> photographs) {
        this.photographs = photographs;
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

    /**
     * Method to change the type of property
     * @param typeOfProperty changed type of property
     */
    public void setTypeOfProperty(PropertyType typeOfProperty) {
        this.propertyType = typeOfProperty;
    }
    /**
     * Compares two instances of Owner
     * @param o other instance of Owner
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.area, area) == 0 && Double.compare(property.price, price) == 0 && Double.compare(property.distanceFromTheCityCenter, distanceFromTheCityCenter) == 0 && Objects.equals(photographs, property.photographs) && Objects.equals(address, property.address) && Objects.equals(property, property.propertyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, price, distanceFromTheCityCenter, photographs, address, propertyType);
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
                ", photographs=" + photographs +
                ", address=" + address +
                ", typeOfProperty=" + propertyType +
                '}';
    }
}