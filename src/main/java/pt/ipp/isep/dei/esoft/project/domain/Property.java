package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
public abstract class Property {


    private String designation;
    private float area;
    private float distanceCityCenter;
    private float price;
    private String typeOfProperty;

    private String typeOfBusiness;

    private static final String DESIGNATION_POR_OMISSAO = "no designation";
    private static final float AREA_POR_OMISSAO = 0;
    private static final float DISTANCE_CITY_CENTER_POR_OMISSAO = 0;
    private static final float PRICE_POR_OMISSAO = 0;
    private static final String TYPE_OF_PROPERTY_POR_OMISSAO = "no type of property";
    private static final String TYPE_OF_BUSINESS = "no type of business";


    public Property(String designation, float area, float distanceCityCenter, float price, String typeOfProperty, String typeOfBusiness) {
        this.designation = designation;
        this.area = area;
        this.distanceCityCenter = distanceCityCenter;
        this.price = price;
        this.typeOfProperty = typeOfProperty;
        this.typeOfBusiness = typeOfBusiness;
    }

    public Property() {
        super();
        designation = DESIGNATION_POR_OMISSAO;
        area = AREA_POR_OMISSAO;
        distanceCityCenter = DISTANCE_CITY_CENTER_POR_OMISSAO;
        price = PRICE_POR_OMISSAO;
        typeOfProperty = TYPE_OF_PROPERTY_POR_OMISSAO;
        typeOfBusiness = TYPE_OF_BUSINESS;
    }

    public Property(String typeOfBusiness, String typeOfProperty) {
        this.typeOfBusiness = typeOfBusiness;
        this.typeOfProperty = typeOfProperty;
    }

    public String getDesignation() {
        return designation;
    }

    public float getArea() {
        return area;
    }

    public float getDistanceCityCenter() {
        return distanceCityCenter;
    }

    public float getPrice() {
        return price;
    }

    public String getTypeOfProperty() {
        return typeOfProperty;
    }

    public String getTypeOfBusiness(){
        return typeOfBusiness;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void setDistanceCityCenter(float distanceCityCenter) {
        this.distanceCityCenter = distanceCityCenter;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTypeOfProperty(String typeOfProperty) {
        this.typeOfProperty = typeOfProperty;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "\nProperty:\n" +
                "designation - " + designation + ";\n" +
                "area - " + area + ";\n" +
                "distance City Center - " + distanceCityCenter + ";\n" +
                "price - " + price + ";\n" +
                "type Of Property - " + typeOfProperty + ";\n" +
                "type Of Bussines - " + typeOfBusiness + ";\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Property)) {
            return false;
        }
        Property that = (Property) o;
        return designation.equals(that.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }

}
