package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class House extends Property {

    private int numberOfBedrooms;

    private int numberOfBathrooms;

    private int numberOfParkingSpaces;

    private static final List<String> SUN_EXPOSURE = Arrays.asList("North", "South", "East", "West", "not specified");
    private String sunExposure;

    private String basement;

    private String inhabitableLoft;

    public House(Person desiredAgent, Person currentOwner, double area, double distanceFromTheCityCentre,
                 Address address, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces,
                 String sunExposure, String basement,
                 String inhabitableLoft) {
        super(area, distanceFromTheCityCentre, address);

        if (!SUN_EXPOSURE.contains(sunExposure) || sunExposure == null) {
            throw new IllegalArgumentException("Sun Exposure must be defined (North, South, East, West or not specified)");
        }
        if (numberOfBathrooms < 0 | numberOfBedrooms < 0 | numberOfParkingSpaces < 0) {
            throw new IllegalArgumentException("Invalid arguments, please provide the real values");
        }

        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfParkingSpaces = numberOfParkingSpaces;
        this.sunExposure = sunExposure;
        this.basement = basement;
        this.inhabitableLoft = inhabitableLoft;
    }

    public int getNrBedrooms() {
        return numberOfBedrooms;
    }

    public void setNrBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNrBathrooms() {
        return numberOfBathrooms;
    }

    public void setNrBathrooms(int nrBathrooms) {
        this.numberOfBathrooms = nrBathrooms;
    }

    public int getNrParkingSpaces() {
        return numberOfParkingSpaces;
    }

    public void setNrParkingSpaces(int nrParkingSpaces) {
        this.numberOfParkingSpaces = nrParkingSpaces;
    }

    public String getSunExposure() {
        return sunExposure;
    }

    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    public String isBasement() {
        return basement;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public String isInhabitableLoft() {
        return inhabitableLoft;
    }

    public void setInhabitableLoft(String inhabitableLoft) {
        this.inhabitableLoft = inhabitableLoft;
    }

    @Override
    public String toString() {
        return super.toString() + "House\n\tNrBedrooms=" + numberOfBedrooms + "\n\tNrBathrooms=" + numberOfBathrooms +
                "\n\tNrParkingSpaces=" + numberOfParkingSpaces + "\n\tSunExposure='" + sunExposure + "\n";
    }
}