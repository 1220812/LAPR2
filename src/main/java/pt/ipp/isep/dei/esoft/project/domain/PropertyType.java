package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class PropertyType extends Property{
    private List<Property> propertyTypeList = new ArrayList<>();

    /**
     * Creates a new Property type with all the attributes
     * @param area property area
     * @param distanceFromCityCenter distance from the city center
     * @param price property price
     * @param photographsList photographs list
     * @param propertyTypeList property type list
     * @param address property address
     */
    public PropertyType (double area, double distanceFromCityCenter, double price, ArrayList<Photographs> photographsList, ArrayList<Property> propertyTypeList, Address address){
        super(area,distanceFromCityCenter,address,price,photographsList);
        this.propertyTypeList = propertyTypeList;
    }
}