package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Scanner;

/**
 * Create Task UI (console). This option is only available for administrators for demonstration purposes.
 */
public class CreateRequestUI implements Runnable {
    private String propertyType;
    private String requestType;
    private Double area;
    private String floorNumber;
    private String auxState;
    private String doorNumber;
    private String street;
    private String postalCode;
    private State state;
    private Address address;
    private Double distanceFromCityCentre;
    private Double price;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private Boolean availableEquipment;
    private Boolean existenceOfBasement;
    private Boolean inhabitableLoft;
    private String sunExposure;
    CreateRequestController controller = new CreateRequestController();

    public void run() {
        //Property type data verification:
        requestType = Utils.readLineFromConsole("Choose a type : Sell or Rent");
        propertyType = Utils.readLineFromConsole("Choose a type: Land, Apartment or house");
        area = Utils.readDoubleFromConsole("Area (squared meters):");
        distanceFromCityCentre = Utils.readDoubleFromConsole("Distance from city centre (Km):");
        price = Utils.readDoubleFromConsole("Price (USD):");
        doorNumber = Utils.readLineFromConsole("Door number:");
        floorNumber = Utils.readLineFromConsole("Floor number:");
        postalCode = Utils.readLineFromConsole("Postal code:");
        street = Utils.readLineFromConsole("Street:");
        auxState = Utils.readLineFromConsole("State:");
        controller.createState(auxState);
        controller.createAddress(doorNumber,floorNumber,street,state,postalCode);
    }
}
