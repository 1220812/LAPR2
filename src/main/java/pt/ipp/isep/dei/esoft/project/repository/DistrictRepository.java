package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type District repository.
 */
public class DistrictRepository implements Serializable {
    /**
     * Creating a list with the property types
     */
    private List<District> districtList = new ArrayList<>();

    /**
     * Add district.
     *
     * @param district the district
     */
    public void addDistrict(District district) {
        if(validateDistrict(district)){
            districtList.add(district);
        }
    }

    /**
     * Validate district boolean.
     *
     * @param district the district
     * @return the boolean
     */
    public boolean validateDistrict(District district){
        return !this.districtList.contains(district);
    }

    /**
     * Get district list list.
     *
     * @return the list
     */
    public List<District> getDistrictList(){
        return List.copyOf(this.districtList);
    }

    /**
     * Create district district.
     *
     * @param name the name
     * @return the district
     */
    public static District CreateDistrict(String name){
        return new District(name);
    }


}
