package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Property {
    private double area;
    private double distanceFromTheCityCentre;
    private int numberOfPhotos;
    private List<String> photographs;
    private Address address;
    private float price;
    private String typeOfProperty;

    private String typeOfBusiness;

    private static final float AREA_POR_OMISSAO = 0;
    private static final float DISTANCE_CITY_CENTER_POR_OMISSAO = 0;
    private static final int N_OF_PHOTOS_POR_OMISSAO = 0;
    private static Address ADRESS_POR_OMISSAO;
    private static final float PRICE_POR_OMISSAO = 0;
    private static final String TYPE_OF_PROPERTY_POR_OMISSAO = "no type of property";

    public Property(double area, double distanceFromTheCityCentre, Address address, List<String> photographs) {
        if (area <= 0)
            throw new IllegalArgumentException("Inputed value for area must be greater than 0");
        if (distanceFromTheCityCentre <= 0)
            throw new IllegalArgumentException("Inputed value for distanceFromTheCityCentre from the city centre must be greater than 0");
        if (address == null)
            throw new IllegalArgumentException("Address must not be null");
        if( numberOfPhotos < 1 || numberOfPhotos >= 30){
            throw new IllegalArgumentException("The number of photos to insert must be between 1 and 30");
        }
        this.area = area;
        this.distanceFromTheCityCentre = distanceFromTheCityCentre;
        this.numberOfPhotos = numberOfPhotos;
        this.photographs = new ArrayList<>();
        this.address = address;
    }

    public Property() {
        area = AREA_POR_OMISSAO;
        distanceFromTheCityCentre = DISTANCE_CITY_CENTER_POR_OMISSAO;
        numberOfPhotos = N_OF_PHOTOS_POR_OMISSAO;
        address = ADRESS_POR_OMISSAO;
        price = PRICE_POR_OMISSAO;
        typeOfProperty = TYPE_OF_PROPERTY_POR_OMISSAO;
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