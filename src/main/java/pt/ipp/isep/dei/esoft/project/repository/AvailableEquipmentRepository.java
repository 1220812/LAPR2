package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.AvailableEquipment;

import java.util.ArrayList;
import java.util.List;

public class AvailableEquipmentRepository {
    private List<AvailableEquipment> availableEquipmentList = new ArrayList<>();

    public void addAvailableEquipment(AvailableEquipment availableEquipment){
        if(validateAvailableEquipment(availableEquipment))
            availableEquipmentList.add(availableEquipment);
    }

    public boolean validateAvailableEquipment(AvailableEquipment availableEquipment) {
        return !this.availableEquipmentList.contains(availableEquipment);
    }

    public List<AvailableEquipment> getavailableEquipmentList(){
        return List.copyOf(this.availableEquipmentList);
    }

}
