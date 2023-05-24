package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Residence extends Property{
    /**
     * Number of bedrooms
     */
    private int numberOfBedrooms;
    /**
     * Number of bathrooms
     */
    private int numberOfBathrooms;
    /**
     * Number of parking spaces
     */
    private int numberOfParkingSpaces;
    /**
     * available equipment
     */
    private List<AvailableEquipment> availableEquipment = new ArrayList<>();

    /**
     *
     * @param address residence address
     * @param area residence area
     * @param distanceFromCityCentre distance between the residence and the city center
     * @param numberOfBathrooms number of bathrooms
     * @param numberOfBedrooms number of bedrooms
     * @param numberOfParkingSpaces number of parking spaces
     * @param availableEquipment available equipment
     * @param price price
     */

    public Residence (Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, double price, List<Photographs> photographsList, List<AvailableEquipment> availableEquipment, Agent agent, Store store, RequestType requestType) {
        super(area, distanceFromCityCentre, address,price, photographsList, store, agent, requestType );
        this.numberOfBedrooms = numberOfBathrooms;
        this.numberOfBathrooms = numberOfBedrooms;
        this.numberOfParkingSpaces = numberOfParkingSpaces;
        this.availableEquipment = availableEquipment;
    }

    public Residence (Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, double price, List<Photographs> photographsList, List<AvailableEquipment> availableEquipment, RequestType requestType) {
        super(area, distanceFromCityCentre, address,price, photographsList, requestType );
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
     * @param numberOfBedrooms changed number of bedrooms
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
     * Method to show the characteristics of a residence
     * @return String with the residence characteristics
     */
    @Override
    public String toString() {
        return super.toString() + "Residence\n\tNrBedrooms=" + numberOfBedrooms + "\n\tNrBathrooms=" + numberOfBathrooms +
                "\n\tNrParkingSpaces=" + numberOfParkingSpaces + "\n\tavailableEquipment='" + availableEquipment + "\n";
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
        if (!super.equals(o)) return false;
        Residence residence = (Residence) o;
        return numberOfBedrooms == residence.numberOfBedrooms && numberOfBathrooms == residence.numberOfBathrooms && numberOfParkingSpaces == residence.numberOfParkingSpaces && Objects.equals(availableEquipment, residence.availableEquipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, availableEquipment);
    }
}
