package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Property {
    private double area;
    private double price;
    private double distanceFromTheCityCentre;
    private int numberOfPhotos;
    private List<String> photographs;
    private Address address;

    public Property(double area, double distanceFromTheCityCentre, Address address, List<String> photographs, double price) {
        if (area <= 0)
            throw new IllegalArgumentException("Inputed value for area must be greater than 0");
        if (distanceFromTheCityCentre <= 0)
            throw new IllegalArgumentException("Inputed value for distanceFromTheCityCentre from the city centre must be greater than 0");
        if (address == null)
            throw new IllegalArgumentException("Address must not be null");
        if(price<0){
            throw new IllegalArgumentException("The price must be greater than 0");
        }
        this.area = area;
        this.distanceFromTheCityCentre = distanceFromTheCityCentre;
        this.numberOfPhotos = numberOfPhotos;
        this.photographs = new ArrayList<>();
        this.address = address;
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getDistance() {
        return distanceFromTheCityCentre;
    }

    public void setDistance(double distanceFromTheCityCentre) {
        this.distanceFromTheCityCentre = distanceFromTheCityCentre;
    }

    public List<String> getPhotos() {
        return photographs;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public void setPhotos(List<String> photographs) {
        this.photographs = photographs;
    }

    public int getNumberOfPhotos() {
        return numberOfPhotos;
    }

    public void setNumberOfPhotos(int numberOfPhotos) {
        this.numberOfPhotos = numberOfPhotos;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Property)) return false;
        Property property = (Property) o;
        return address.equals(property.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, distanceFromTheCityCentre, photographs, address);
    }

    @Override
    public String toString() {
        return "Property{" +
                "area=" + area +
                ", distanceFromTheCityCentre=" + distanceFromTheCityCentre +
                ", numberOfPhotos=" + numberOfPhotos +
                ", photographs=" + photographs +
                ", address=" + address +
                '}';
    }
}