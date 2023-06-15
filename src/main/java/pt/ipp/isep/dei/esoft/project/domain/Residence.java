package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Residence extends Property implements Serializable {
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
     * air conditioning
     */
    private boolean airConditioning;
    /**
     * central heating
     */
    private boolean centralHeating;

    /**
     * Method that creates a new instance of Residence
     *
     * @param address                residence address
     * @param area                   residence area
     * @param distanceFromCityCentre distance between the residence and the city center
     * @param numberOfBathrooms      number of bathrooms
     * @param numberOfBedrooms       number of bedrooms
     * @param numberOfParkingSpaces  number of parking spaces
     * @param airConditioning        air conditioning
     * @param centralHeating         central heating
     */

    public Residence(Address address, double area, double distanceFromCityCentre, PropertyType propertyType, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, List<Photographs> photographsList, boolean centralHeating, boolean airConditioning) {
        super(area, distanceFromCityCentre, address, propertyType, photographsList);
        if (numberOfBathrooms < 0) {
            throw new IllegalArgumentException("The number of bathrooms must be positive.");
        }
        if (numberOfBedrooms < 0) {
            throw new IllegalArgumentException("The number of bedrooms must be positive.");
        }
        if (numberOfParkingSpaces < 0) {
            throw new IllegalArgumentException("The number of parking spaces must be positive.");
        }
        this.numberOfBedrooms = numberOfBathrooms;
        this.numberOfBathrooms = numberOfBedrooms;
        this.numberOfParkingSpaces = numberOfParkingSpaces;
        this.airConditioning = airConditioning;
        this.centralHeating = centralHeating;
    }
    /**
     * Method that creates a new instance of Residence with the given parameters:
     * @param address residence address
     * @param area residence area
     * @param distanceFromCityCentre distance between the residence and the city center
     * @param propertyType type of property
     * @param numberOfBathrooms number of bathrooms
     * @param numberOfBedrooms number of bedrooms
     * @param numberOfParkingSpaces number of parking spaces
     * @param centralHeating central heating
     * @param airConditioning air conditioning
     */
    public Residence(Address address, double area, double distanceFromCityCentre, PropertyType propertyType, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, boolean centralHeating, boolean airConditioning, double finalPrice, LocalDate businessDate) {
        super(area, distanceFromCityCentre, address, propertyType, finalPrice, businessDate);
        if (numberOfBathrooms < 0) {
            throw new IllegalArgumentException("The number of bathrooms must be positive.");
        }
        if (numberOfBedrooms < 0) {
            throw new IllegalArgumentException("The number of bedrooms must be positive.");
        }
        if (numberOfParkingSpaces < 0) {
            throw new IllegalArgumentException("The number of parking spaces must be positive.");
        }
        this.numberOfBedrooms = numberOfBathrooms;
        this.numberOfBathrooms = numberOfBedrooms;
        this.numberOfParkingSpaces = numberOfParkingSpaces;
        this.airConditioning = airConditioning;
        this.centralHeating = centralHeating;
    }
    /**
     * Method to show the number of bedrooms
     *
     * @return number of bedrooms
     */

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Method to change the number of bedrooms
     *
     * @param numberOfBedrooms changed number of bedrooms
     */

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    /**
     * Method to show the number of bathrooms
     *
     * @return number of bathrooms
     */

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    /**
     * Method to change the number of bathrooms
     *
     * @param numberOfBathrooms number of bathrooms
     */

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    /**
     * Method to show the number of parking spaces
     *
     * @return numberOfParkingSpaces number of parking spaces
     */

    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }

    /**
     * Method to change the number of parking spaces
     *
     * @param numberOfParkingSpaces number of parking spaces
     */

    public void setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }

    /**
     * Method to change the truth value of the existence of air conditioning
     * @param airConditioning true if there is air conditioning, false otherwise
     */

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    /**
     * Method to change the truth value of the existence of central heating
     * @param centralHeating true if there is central heating, false otherwise
     */

    public void setCentralHeating(boolean centralHeating) {
        this.centralHeating = centralHeating;
    }
    /**
     * Equals method that verifies if the residence already exists in the system
     *
     * @param o object to compare with
     * @return true if the residence already exists, false if it doesn't
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Residence residence = (Residence) o;
        return numberOfBedrooms == residence.numberOfBedrooms && numberOfBathrooms == residence.numberOfBathrooms && numberOfParkingSpaces == residence.numberOfParkingSpaces && Objects.equals(airConditioning, residence.airConditioning) && Objects.equals(centralHeating, residence.centralHeating);
    }
    /**
     * Method that returns a unique code that identifies the residence
     *
     * @return hash code for the residence
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, airConditioning, centralHeating);
    }

    /**
     * Method to show the characteristics of a residence
     *
     * @return String with the residence characteristics
     */
    @Override
    public String toString() {
        return super.toString() + "\nNumber of bedrooms = " + numberOfBedrooms + "\nNumber of bathrooms = " + numberOfBathrooms + "\nParking spaces =" + numberOfParkingSpaces;
    }
}
