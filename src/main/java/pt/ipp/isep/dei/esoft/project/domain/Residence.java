package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Arrays;
import java.util.List;

public class Residence extends Property{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private String availableEquipment;

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

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }

    public void setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }
    public String getAvailableEquipment(){
        return availableEquipment;
    }
    public void setAvailableEquipment(String availableEquipment) {
        this.availableEquipment = availableEquipment;
    }
    @Override
    public String toString() {
        return super.toString() + "Residence\n\tNrBedrooms=" + numberOfBedrooms + "\n\tNrBathrooms=" + numberOfBathrooms +
                "\n\tNrParkingSpaces=" + numberOfParkingSpaces + "\n\tavailableEquipment='" + availableEquipment + "\n";
    }
}
