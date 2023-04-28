package pt.ipp.isep.dei.esoft.project.domain;

public class House extends Residence {

    private boolean basement;
    private String sunEsposure;
    private boolean inhabitableLoft;

    private static final boolean BASEMENT_POR_OMISSAO = false;
    private static final String SUN_ESPOSURE__POR_OMISSAO = "no sun esposure";
    private static final boolean INHABITABLE_LOFT_POR_OMISSAO = false;

    public House(String designation, float area, float distanceCityCenter, float price, String typeOfProperty, int numberOfRooms, int numberOfBathroooms, int numberOfParkingSpace, boolean centralHeating, boolean airCondition, boolean basement, String sunEsposure, boolean inhabitableLoft) {
        super(designation, area, distanceCityCenter, price, typeOfProperty, numberOfRooms, numberOfBathroooms, numberOfParkingSpace, centralHeating, airCondition);
        this.basement = basement;
        this.sunEsposure = sunEsposure;
        this.inhabitableLoft = inhabitableLoft;

    }

    public boolean isBasement() {
        return basement;
    }

    public String getSunEsposure() {
        return sunEsposure;
    }

    public boolean isInhabitableLoft() {
        return inhabitableLoft;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
    }

    public void setSunEsposure(String sunEsposure) {
        this.sunEsposure = sunEsposure;
    }

    public void setInhabitableLoft(boolean inhabitableLoft) {
        this.inhabitableLoft = inhabitableLoft;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "\nHouse:\n" +
                "basement - " + basement + ";\n" +
                "sunEsposure - " + sunEsposure + ";\n" +
                "inhabitableLoft " + inhabitableLoft + ";\n");
    }

}
