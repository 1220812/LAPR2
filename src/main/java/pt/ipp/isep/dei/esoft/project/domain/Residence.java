package pt.ipp.isep.dei.esoft.project.domain;

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


     private boolean airConditioning;

    private boolean centralHeating;


    /**
     *
     * @param address residence address
     * @param area residence area
     * @param distanceFromCityCentre distance between the residence and the city center
     * @param numberOfBathrooms number of bathrooms
     * @param numberOfBedrooms number of bedrooms
     * @param numberOfParkingSpaces number of parking spaces
     * @param airConditioning air conditioning
     * @param centralHeating central heating
     */

    public Residence (Address address, double area, double distanceFromCityCentre, PropertyType propertyType, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, List<Photographs> photographsList, boolean centralHeating, boolean airConditioning) {
        super(area, distanceFromCityCentre, address, propertyType, photographsList);
        this.numberOfBedrooms = numberOfBathrooms;
        this.numberOfBathrooms = numberOfBedrooms;
        this.numberOfParkingSpaces = numberOfParkingSpaces;
        this.airConditioning = airConditioning;
        this.centralHeating = centralHeating;
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
        return super.toString() + ", number of bedrooms = " + numberOfBedrooms + ", number of bathrooms = " + numberOfBathrooms +
                "\nparking spaces="  + numberOfParkingSpaces + ", air conditioning = " + airConditioning + ", central heating = " + centralHeating + "\n  ";
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
        return numberOfBedrooms == residence.numberOfBedrooms && numberOfBathrooms == residence.numberOfBathrooms && numberOfParkingSpaces == residence.numberOfParkingSpaces && Objects.equals(airConditioning, residence.airConditioning) && Objects.equals(centralHeating, residence.centralHeating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces,airConditioning,centralHeating);
    }
}
