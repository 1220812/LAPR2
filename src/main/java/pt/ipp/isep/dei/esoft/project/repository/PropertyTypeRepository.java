package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyTypeRepository {
    private final List<PropertyType> propertiesTypeList = new ArrayList<>();
    public void addPropertyType(PropertyType propertyType){
        if(validatePropertyType(propertyType)){
            propertiesTypeList.add(propertyType);
        }
    }
    public boolean validatePropertyType(PropertyType propertyType){
        return !this.propertiesTypeList.contains(propertyType);
    }
    public List<PropertyType> getPropertyType(){
        return List.copyOf(propertiesTypeList);
    }


    /*
    public static PropertyType CreatePropertyType(double area, double distanceFromCityCenter, double price, ArrayList<Photographs> photographsList, PropertyType propertyType, Address address){
        return new PropertyType(area, distanceFromCityCenter ,price ,photographsList ,propertyType, address);
    }
    */
}
