package pt.ipp.isep.dei.esoft.project.domain;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class House extends Residence {
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
     * this method creates a house object with all the attributes
     * @param address house address
     * @param area house area
     * @param distanceFromCityCentre distance between the house and the city center
     * @param numberOfBathrooms number of bathrooms
     * @param numberOfBedrooms number of bedrooms
     * @param numberOfParkingSpaces number of parking spaces
     * @param availableEquipment available equipment
     * @param basement basement
     * @param sunExposure house exposure to the sun
     * @param inhabitableLoft inhabitable loft
     * @param price house price
     */
    public House(PropertyAddress address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, List<AvailableEquipment> availableEquipment, boolean basement, SunExposure sunExposure, boolean inhabitableLoft, double price, List<Photographs> photoList) {
        super(address,area,distanceFromCityCentre,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,price,photoList,availableEquipment);
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
     * @param existenceOfABasement basement
     */

    public void setExistenceOfABasement(boolean existenceOfABasement) {
        this.existenceOfABasement = existenceOfABasement;
    }

    /**
     * Method to show the inhabitable loft
     * @return inhabitable loft
     */

    public boolean inhabitableLoft() {
        return inhabitableLoft;
    }

    /**
     * Method to show the inhabitableLoft
     * @param inhabitableLoft inhabitable loft
     */

    public void setInhabitableLoft(boolean inhabitableLoft) {
        this.inhabitableLoft = inhabitableLoft;
    }

    /**
     * Method to show the sun exposure
     * @param sunExposure sun exposure
     */

    public void setSunExposure(SunExposure sunExposure) {
        this.sunExposure = sunExposure;
    }
    /**
     * Method tho show the characteristics from the house
     * @return String characteristics from the house
     */
    @Override
    public String toString() {
        return "House{" +
                "basement='" + existenceOfABasement + '\'' +
                ", sunExposure='" + sunExposure + '\'' +
                ", inhabitableLoft='" + inhabitableLoft + '\'' +
                '}';
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
        House house = (House) o;
        return existenceOfABasement == house.existenceOfABasement && inhabitableLoft == house.inhabitableLoft && sunExposure.equals(house.sunExposure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), existenceOfABasement, sunExposure, inhabitableLoft);
    }
}