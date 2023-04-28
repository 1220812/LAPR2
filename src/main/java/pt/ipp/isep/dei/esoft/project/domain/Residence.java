package pt.ipp.isep.dei.esoft.project.domain;

public class Residence extends Property {

    private int numberOfRooms;
    private int numberOfBathroooms;
    private int numberOfParkingSpace;
    private boolean centralHeating;
    private boolean airCondition;

    private static final int NUMBER_OF_ROOMS_POR_OMISSAO = 0;
    private static final int NUMBER_OF_BATHROOMS_POR_OMISSAO = 0;
    private static final int NUMBER_OF_PARKING_SPACE_POR_OMISSAO = 0;
    private static final boolean CENTRAL_HEATING_POR_OMISSAO = false;
    private static final boolean AIR_CONDITION_POR_OMISSAO = false;

    public Residence() {
        super();
        numberOfRooms = NUMBER_OF_ROOMS_POR_OMISSAO;
        numberOfBathroooms = NUMBER_OF_BATHROOMS_POR_OMISSAO;
        numberOfParkingSpace = NUMBER_OF_PARKING_SPACE_POR_OMISSAO;
        centralHeating = CENTRAL_HEATING_POR_OMISSAO;
        airCondition = AIR_CONDITION_POR_OMISSAO;
    }

    public Residence(String designation, float area, float distanceCityCenter, float price, String typeOfProperty, int numberOfRooms, int numberOfBathroooms, int numberOfParkingSpace, boolean centralHeating, boolean airCondition) {
        super(designation, area, distanceCityCenter, price, typeOfProperty, typeOfBusiness);
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathroooms = numberOfBathroooms;
        this.numberOfParkingSpace = numberOfParkingSpace;
        this.centralHeating = centralHeating;
        this.airCondition = airCondition;
    }

    public Residence(int numberOfRooms, String typeOfBussines, String typeOfProperty) {
        super(typeOfBussines, typeOfProperty);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfBathroooms() {
        return numberOfBathroooms;
    }

    public int getNumberOfParkingSpace() {
        return numberOfParkingSpace;
    }

    public boolean getCentralHeating() {
        return centralHeating;
    }

    public boolean getAirCondition() {
        return airCondition;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setNumberOfBathroooms(int numberOfBathroooms) {
        this.numberOfBathroooms = numberOfBathroooms;
    }

    public void setNumberOfParkingSpace(int numberOfParkingSpace) {
        this.numberOfParkingSpace = numberOfParkingSpace;
    }

    public void setCentralHeating(boolean centralHeating) {
        this.centralHeating = centralHeating;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "\nResidence:\n" +
                "numberOfRooms - " + numberOfRooms + ";\n" +
                "numberOfBathroooms - " + numberOfBathroooms + ";\n" +
                "numberOfParkingSpace - " + numberOfParkingSpace + ";\n" +
                "centralHeating - " + centralHeating + ";\n" +
                "airCondition - " + airCondition + ";\n");
    }



}
