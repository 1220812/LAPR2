package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Photographs;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.PropertyType;

import java.util.ArrayList;
import java.util.List;

public class PropertyTypeRepository {
    private final List<PropertyType> propertiesTypeList = new ArrayList<>();
    public void addPropertyType(PropertyType propertyType){
        if(validatePropertyTye(propertyType)){
            propertiesTypeList.add(propertyType);
        }
    }
    public boolean validatePropertyTye(PropertyType propertyType){
        return !this.propertiesTypeList.contains(propertyType);
    }
    public List<PropertyType> getPropertyTypeList(){
        return List.copyOf(propertiesTypeList);
    }

    public static PropertyType CreatePropertyType(double area, double distanceFromCityCenter, double price, ArrayList<Photographs> photographsList, ArrayList<Property> propertyTypeList, Address address){
        return new PropertyType(area,distanceFromCityCenter,price,photographsList,propertyTypeList,address);
    }
}
