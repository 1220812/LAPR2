package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class House extends Residence implements Serializable {
    /**
     * existence of a basement
     */
    private boolean existenceOfABasement;
    /**
     * house sun exposure
     */
    private SunExposure sunExposure;
    /**
     * existence of an inhabitable loft
     */
    private boolean inhabitableLoft;

    /**
     * this method creates a new instance of house
     *
     * @param address                house address
     * @param area                   house area
     * @param distanceFromCityCentre distance between the house and the city center
     * @param numberOfBathrooms      number of bathrooms
     * @param numberOfBedrooms       number of bedrooms
     * @param numberOfParkingSpaces  number of parking spaces
     * @param airConditioning        air conditioning
     * @param centralHeating         central heating
     * @param basement               basement
     * @param sunExposure            house exposure to the sun
     * @param inhabitableLoft        inhabitable loft
     */
    public House(Address address, double area, double distanceFromCityCentre, PropertyType propertyType, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, boolean airConditioning, boolean centralHeating, boolean basement, SunExposure sunExposure, boolean inhabitableLoft, List<Photographs> photoList) {
        super(address, area, distanceFromCityCentre, propertyType, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, photoList, airConditioning, centralHeating);
        this.existenceOfABasement = basement;
        this.inhabitableLoft = inhabitableLoft;
        this.sunExposure = sunExposure;
    }
    public House(Address address, double area, double distanceFromCityCentre, PropertyType propertyType, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, boolean airConditioning, boolean centralHeating, boolean basement, SunExposure sunExposure, boolean inhabitableLoft, double finalPrice, LocalDate businessDate) {
        super(address, area, distanceFromCityCentre, propertyType,numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, airConditioning, centralHeating, finalPrice, businessDate);
        this.existenceOfABasement = basement;
        this.inhabitableLoft = inhabitableLoft;
        this.sunExposure = sunExposure;
    }

    /**
     * Method to show the basement
     */
    public boolean basement() {
        return existenceOfABasement;
    }

    /**
     * Method to change the basement
     *
     * @param existenceOfABasement basement
     */

    public void setExistenceOfABasement(boolean existenceOfABasement) {
        this.existenceOfABasement = existenceOfABasement;
    }

    /**
     * Method to show the inhabitable loft
     *
     * @return inhabitable loft
     */

    public boolean inhabitableLoft() {
        return inhabitableLoft;
    }

    /**
     * Method to show the inhabitableLoft
     *
     * @param inhabitableLoft inhabitable loft
     */

    public void setInhabitableLoft(boolean inhabitableLoft) {
        this.inhabitableLoft = inhabitableLoft;
    }

    /**
     * Method to show the sun exposure
     *
     * @param sunExposure sun exposure
     */

    public void setSunExposure(SunExposure sunExposure) {
        this.sunExposure = sunExposure;
    }

    /**
     * Method tho show the characteristics from the house
     *
     * @return String characteristics from the house
     */

    @Override
    public String toString() {
        return super.toString() + "House:" +
                ", basement :" + existenceOfABasement +
                ", sunExposure : " + sunExposure +
                ", inhabitableLoft : " + inhabitableLoft;
    }

    /**
     * Equals method that verifies if the house already exists in the system
     *
     * @param o object to compare with
     * @return true if the property already exists, false if it doesn't
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        House house = (House) o;
        return existenceOfABasement == house.existenceOfABasement && inhabitableLoft == house.inhabitableLoft && sunExposure.equals(house.sunExposure);
    }
    /**
     * Method that returns a unique code that identifies the house
     *
     * @return hash code for the house
     */

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), existenceOfABasement, sunExposure, inhabitableLoft);
    }
}