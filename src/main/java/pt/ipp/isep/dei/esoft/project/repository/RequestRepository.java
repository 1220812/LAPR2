package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;

public class RequestRepository {
    /**
     * List of property types that exists in the system
     */
    private static List<String> propertyTypeList = new ArrayList<>() {
        {
            add("1. land");
            add("2. apartment");
            add("3. house");
        }
    };
    /**
     * Get property types
     */
    public static void getPropertyType() {
        for (String item : propertyTypeList) {
            System.out.println(item);
        }
    }
    private final List<PropertyType> propertyTypeeList = new ArrayList<>();
    public List<PropertyType> getPropertyTypeList(){
        return List.copyOf(propertyTypeeList);
    }
    /**
     * List of requests types that exists in the system
     */
    private static List<String> requestTypeList = new ArrayList<>() {
        {
            add("1. rent");
            add("2. sale");
        }
    };
    /**
     * Get requests types by name
     */
    public static void getRequestType() {
        for (String item : requestTypeList) {
            System.out.println(item);
        }
    }
}
