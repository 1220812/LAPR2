package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Arrays;
import java.util.List;

public class House extends Residence {

    private static final List<String> SUN_EXPOSURE = Arrays.asList("North", "South", "East", "West", "not specified");

    private String basement;
    private String sunExposure;
    private String inhabitableLoft;

    public House(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, List<String> photographs, String availableEquipment, String basement, String sunExposure, String inhabitableLoft) {
        super(address, area, distanceFromCityCentre, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, photographs, availableEquipment);
        this.basement = basement;
        this.sunExposure = sunExposure;
        this.inhabitableLoft = inhabitableLoft;
    }

    public String basement() {
        return basement;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public String inhabitableLoft() {
        return inhabitableLoft;
    }

    public void setInhabitableLoft(String inhabitableLoft) {
        this.inhabitableLoft = inhabitableLoft;
    }

    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    @Override
    public String toString() {
        return "House{" +
                "basement='" + basement + '\'' +
                ", sunExposure='" + sunExposure + '\'' +
                ", inhabitableLoft='" + inhabitableLoft + '\'' +
                '}';
    }
}