package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.AvailableEquipment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The type Available equipment repository.
 */
public class AvailableEquipmentRepository implements Serializable {
    private List<AvailableEquipment> availableEquipmentList = new ArrayList<>();

    /**
     * Add optional.
     *
     * @param availableEquipment the available equipment
     * @return the optional
     */
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

    /**
     * Validate available equipment boolean.
     *
     * @param availableEquipment the available equipment
     * @return the boolean
     */
    public boolean validateAvailableEquipment(AvailableEquipment availableEquipment) {
        boolean isValid = !availableEquipmentList.contains(availableEquipment);
        return isValid;
    }

    /**
     * Get available equipment list list.
     *
     * @return the list
     */
    public List<AvailableEquipment> getAvailableEquipmentList(){
        return List.copyOf(this.availableEquipmentList);
    }
}
