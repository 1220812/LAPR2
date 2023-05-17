package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.Objects;
public class Announcement {

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
    private Property property = new Property(area, distanceFromTheCityCenter, address,price);

    private String date;
    private static final String DATE_POR_OMISSAO = "no date";

    public Announcement(Property property, String date) {
        this.property = property;
        this.date = date;
    }

    public Announcement() {
        date = DATE_POR_OMISSAO;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Property getProperty() {
        return property;
    }

    @Override
    public String toString() {
        return (property.toString() +
                "date - " + date + "\n");
    }



}
