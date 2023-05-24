package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class AvailableEquipment {
    /**
     * equipment available
     */
    private String equipment;

    /**
     * Method that creates an AvailableEquipment object
     * @param equipment equipment available
     */

    public AvailableEquipment(String equipment) {
       this.equipment = equipment;
    }
    /**
     * Method to show if the property has equipment
     */
    public String getEquipment() {
        return equipment;
    }
    /**
     * Method to change the truth value of available equipment
     * @param equipment changed value
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
    /**
     * Textual representation of an instance of Owner
     */
    @Override
    public String toString() {
        return equipment;
    }
    /**
     * Compares two instances of Owner
     * @param o other instance of Owner
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailableEquipment that = (AvailableEquipment) o;
        return Objects.equals(equipment, that.equipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipment);
    }

    public AvailableEquipment clone(){
        return new AvailableEquipment(this.equipment);
    }
}