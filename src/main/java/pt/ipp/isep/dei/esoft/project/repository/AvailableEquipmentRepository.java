package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.AvailableEquipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AvailableEquipmentRepository {
    private List<AvailableEquipment> availableEquipmentList = new ArrayList<>();

    public List<AvailableEquipment> addAvailableEquipment(AvailableEquipment availableEquipment){
        availableEquipmentList.add(availableEquipment);
        Optional<AvailableEquipment> newEquipment = Optional.empty();
        boolean operationSuccess = false;
        if (validateAvailableEquipment(availableEquipment)) {
            newEquipment = Optional.of((AvailableEquipment) availableEquipment.clone());
            operationSuccess = availableEquipmentList.add((AvailableEquipment) newEquipment.get());
        }

        if (!operationSuccess) {
            newEquipment = Optional.empty();
        }
        return availableEquipmentList;
    }

    public boolean validateAvailableEquipment(AvailableEquipment availableEquipment) {
        boolean isValid = !availableEquipmentList.contains(availableEquipment);
        return isValid;
    }
    public List<AvailableEquipment> getavailableEquipmentList(){
        return List.copyOf(this.availableEquipmentList);
    }
}
