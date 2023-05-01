package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Arrays;
import java.util.List;

public class House extends Residence {
    /**
     * List of the possible values that the sun exposure can have
     */

    private static final List<String> SUN_EXPOSURE = Arrays.asList("North", "South", "East", "West", "not specified");

    // ATTRIBUTES

    private String basement;
    private String sunExposure;
    private String inhabitableLoft;

    // CONSTRUCTORS
    public House(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, List<String> photographs, String availableEquipment, String basement, String sunExposure, String inhabitableLoft,double price) {
        super(address, area, distanceFromCityCentre, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, photographs, availableEquipment,price);
        this.basement = basement;
        this.sunExposure = sunExposure;
        this.inhabitableLoft = inhabitableLoft;
    }

    /**
     * Method to show the basement
     * @return
     */

    public String basement() {
        return basement;
    }

    /**
     * Method to change the basement
     * @param basement basement
     */

    public void setBasement(String basement) {
        this.basement = basement;
    }

    /**
     * Method to show the inhabitable loft
     * @return inhabitable loft
     */

    public String inhabitableLoft() {
        return inhabitableLoft;
    }

    /**
     * Method to show the inhabitableLoft
     * @param inhabitableLoft inhabitable loft
     */

    public void setInhabitableLoft(String inhabitableLoft) {
        this.inhabitableLoft = inhabitableLoft;
    }

    /**
     * Method to show the sun exposure
     * @param sunExposure sun exposure
     */

    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    /**
     * Method tho show the characteristics from the house
     * @return String characteristics from the house
     */
    @Override
    public String toString() {
        return "House{" +
                "basement='" + basement + '\'' +
                ", sunExposure='" + sunExposure + '\'' +
                ", inhabitableLoft='" + inhabitableLoft + '\'' +
                '}';
    }
}