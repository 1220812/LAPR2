package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyTypeRepository implements Serializable {
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
}
