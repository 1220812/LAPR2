package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.util.ArrayList;
import java.util.List;

public class DistrictRepository {
    /**
     * Creating a list with the property types
     */
    private List<District> districtList = new ArrayList<>();
    public void addDistrict(District district) {
        if(validateDistrict(district)){
            districtList.add(district);
        }
    }
    public boolean validateDistrict(District district){
        return !this.districtList.contains(district);
    }
    public List<District> getDistrictList(){
        return List.copyOf(this.districtList);
    }
    public static District CreateDistrict(String name){
        return new District(name);
    }


}
