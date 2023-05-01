package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Arrays;
import java.util.List;

public class Residence extends Property{

    // ATTRIBUTES
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private String availableEquipment;

    // CONSTRUCTORS

    public Residence (Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, List<String>photographs, String availableEquipment, double price) {
        super(area, distanceFromCityCentre, address, photographs,price);
        if (numberOfBedrooms < 0 | numberOfBathrooms < 0 | numberOfParkingSpaces < 0) {
            throw new IllegalArgumentException("Provide the actual number of Bathrooms, Bedrooms and Parking Spaces" +
                    "(>=0)");
        }
        this.numberOfBedrooms = numberOfBathrooms;
        this.numberOfBathrooms = numberOfBedrooms;
        this.numberOfParkingSpaces = numberOfParkingSpaces;
        this.availableEquipment = availableEquipment;
    }

    /**
     * Method to show the number of bedrooms
     * @return number of bedrooms
     */

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Method to change the number of bedrooms
     * @param numberOfBedrooms
     */

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    /**
     * Method to show the number of bathrooms
     * @return number of bathrooms
     */

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    /**
     * Method to change the number of bathrooms
     * @param numberOfBathrooms number of bathrooms
     */

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    /**
     * Method to show the number of parking spaces
     * @return numberOfParkingSpaces number of parking spaces
     */

    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }

    /**
     * Method to change the number of parking spaces
     * @param numberOfParkingSpaces number of parking spaces
     */

    public void setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }

    /**
     * Method to show the available equipment
     * @return available equipment
     */
    public String getAvailableEquipment(){
        return availableEquipment;
    }

    /**
     * Method to change the available equipment
     * @param availableEquipment available equipment
     */
    public void setAvailableEquipment(String availableEquipment) {
        this.availableEquipment = availableEquipment;
    }

    /**
     * Method to show the characteristics of a residence
     * @return String with the residence characteristics
     */
    @Override
    public String toString() {
        return super.toString() + "Residence\n\tNrBedrooms=" + numberOfBedrooms + "\n\tNrBathrooms=" + numberOfBathrooms +
                "\n\tNrParkingSpaces=" + numberOfParkingSpaces + "\n\tavailableEquipment='" + availableEquipment + "\n";
    }
}
