package pt.ipp.isep.dei.esoft.project.domain;

public class Residence extends Property {
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;

    public Residence(int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces) {
        super();
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }

    public int getNumberBeds() {
        return numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }

    public void setNumberBeds(int numberBeds) {
        this.numberOfBedrooms = numberBeds;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public void setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }
}