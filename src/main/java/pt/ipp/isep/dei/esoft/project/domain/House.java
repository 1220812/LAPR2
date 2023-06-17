package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * The type House.
 */
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
     * @param propertyType           the property type
     * @param numberOfBathrooms      number of bathrooms
     * @param numberOfBedrooms       number of bedrooms
     * @param numberOfParkingSpaces  number of parking spaces
     * @param basement               basement
     * @param sunExposure            house exposure to the sun
     * @param inhabitableLoft        inhabitable loft
     * @param photoList              the photo list
     * @param availableEquipmentList the available equipment list
     */
    public House(Address address, double area, double distanceFromCityCentre, PropertyType propertyType, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, boolean basement, SunExposure sunExposure, boolean inhabitableLoft, List<Photographs> photoList, List<AvailableEquipment> availableEquipmentList) {
        super(address, area, distanceFromCityCentre, propertyType, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, photoList, availableEquipmentList);
        this.existenceOfABasement = basement;
        this.inhabitableLoft = inhabitableLoft;
        this.sunExposure = sunExposure;
    }

    /**
     * Instantiates a new House.
     *
     * @param address                the address
     * @param area                   the area
     * @param distanceFromCityCentre the distance from city centre
     * @param propertyType           the property type
     * @param numberOfBathrooms      the number of bathrooms
     * @param numberOfBedrooms       the number of bedrooms
     * @param numberOfParkingSpaces  the number of parking spaces
     * @param airConditioning        the air conditioning
     * @param centralHeating         the central heating
     * @param basement               the basement
     * @param sunExposure            the sun exposure
     * @param inhabitableLoft        the inhabitable loft
     * @param finalPrice             the final price
     * @param businessDate           the business date
     */
    public House(Address address, double area, double distanceFromCityCentre, PropertyType propertyType, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, boolean airConditioning, boolean centralHeating, boolean basement, SunExposure sunExposure, boolean inhabitableLoft, double finalPrice, LocalDate businessDate) {
        super(address, area, distanceFromCityCentre, propertyType,numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, airConditioning, centralHeating, finalPrice, businessDate);
        this.existenceOfABasement = basement;
        this.inhabitableLoft = inhabitableLoft;
        this.sunExposure = sunExposure;
    }

    /**
     * Method to show the basement
     *
     * @return the boolean
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
        return super.toString() +
                "\nBasement :" + existenceOfABasement +
                "\nSun exposure : " + sunExposure +
                "\nInhabitable loft : " + inhabitableLoft;
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