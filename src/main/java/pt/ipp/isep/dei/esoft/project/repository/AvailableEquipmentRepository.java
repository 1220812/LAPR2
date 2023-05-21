package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.AvailableEquipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AvailableEquipmentRepository {
    private List<AvailableEquipment> availableEquipmentList = new ArrayList<>();

    public Optional<AvailableEquipment> add(AvailableEquipment availableEquipment){
        Optional<AvailableEquipment> newEquipment = Optional.empty();
        boolean operationSuccess = false;
        if (validateAvailableEquipment(availableEquipment)) {
            newEquipment = Optional.of(availableEquipment.clone());
            operationSuccess = availableEquipmentList.add(newEquipment.get());
        }
        if (!operationSuccess) {
            newEquipment = Optional.empty();
        }
        return newEquipment;
    }

    public boolean validateAvailableEquipment(AvailableEquipment availableEquipment) {
        boolean isValid = !availableEquipmentList.contains(availableEquipment);
        return isValid;
    }
    public List<AvailableEquipment> getAvailableEquipmentList(){
        return List.copyOf(this.availableEquipmentList);
    }
}
