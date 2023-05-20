package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.PropertyType;

import java.util.ArrayList;
import java.util.List;

public class PropertyTypeRepository {
    /**
     * Creating a list with the property types
     */
    private final List<PropertyType> propertiesTypeList = new ArrayList<>();
    /**
     * Method to show the property type list
     */
    public List<PropertyType> getPropertyTypeList(){
        return List.copyOf(propertiesTypeList);
    }

    /**
     * Method to add a new property type to the list
     *
     */
    public List<PropertyType> add(PropertyType propertyType){
        getPropertyTypeList().add(propertyType);
        return propertiesTypeList;
    }
}
