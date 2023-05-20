package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.District;

import java.util.ArrayList;

public class DistrictRepository {
    /**
     * Creating a list with the property types
     */
    private static ArrayList<District> districtList = new ArrayList<>();
    /**
     * Method to add new district to the list
     * @param district district
     */
    public static void addDistrict(District district) {
        districtList.add(district);
    }
    /**
     * Method to show the properties type list
     * @return properties type list
     */
    public static ArrayList<District> getDistrictList() {
        return districtList;
    }

    public static District CreateDistrict(String name) {
        return new District(name);
    }
}
