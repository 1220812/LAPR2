package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Property type repository.
 */
public class PropertyTypeRepository implements Serializable {
    private final List<PropertyType> propertiesTypeList = new ArrayList<>();

    /**
     * Add property type.
     *
     * @param propertyType the property type
     */
    public void addPropertyType(PropertyType propertyType){
        if(validatePropertyType(propertyType)){
            propertiesTypeList.add(propertyType);
        }
    }

    /**
     * Validate property type boolean.
     *
     * @param propertyType the property type
     * @return the boolean
     */
    public boolean validatePropertyType(PropertyType propertyType){
        return !this.propertiesTypeList.contains(propertyType);
    }

    /**
     * Get property type list.
     *
     * @return the list
     */
    public List<PropertyType> getPropertyType(){
        return List.copyOf(propertiesTypeList);
    }
}
