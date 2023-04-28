package pt.ipp.isep.dei.esoft.project.domain;

public class AvailableEquipment extends Residence {

    private String equipement;
    private static final String EQUIPEMENT_POR_OMISSAO = "without equipement";

    public AvailableEquipement() {
        super();
        equipement = EQUIPEMENT_POR_OMISSAO;
    }

    public AvailableEquipement(String designation, float area, float distanceCityCenter, float price, String typeOfProperty, String date, int numberOfRooms, int numberOfBathroooms, int numberOfParkingSpace, boolean centralHeating, boolean airCondition, String equipement) {
        super(designation, area, distanceCityCenter, price, typeOfProperty, numberOfRooms, numberOfBathroooms, numberOfParkingSpace, centralHeating, airCondition);
        this.equipement = equipement;
    }

    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "\nAvailableEquipement:\n" +
                "equipement - " + equipement + ";\n");
    }


}
