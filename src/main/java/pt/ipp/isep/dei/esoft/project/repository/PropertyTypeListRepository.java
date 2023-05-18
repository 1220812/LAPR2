package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.PropertyType;

import java.util.ArrayList;

public class PropertyTypeListRepository {
    /**
     * Creating a list with the property types
     */
    private static ArrayList<PropertyType> propertiesTypeList = new ArrayList<>();
    /**
     * Method to add new properties to the list
     * @param propertyType property type
     */
    public static void addPropertyType(PropertyType propertyType) {
        propertiesTypeList.add(propertyType);
    }
    /**
     * Method to show the properties type list
     * @return properties type list
     */
    public static ArrayList<PropertyType> getPropertiesTypeList() {
        return propertiesTypeList;
    }

    public static PropertyType CreatePropertyType(String name) {
        return new PropertyType(name);
    }
}
