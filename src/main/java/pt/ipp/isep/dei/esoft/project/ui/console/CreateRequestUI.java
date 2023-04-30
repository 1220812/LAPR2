package pt.ipp.isep.dei.esoft.project.ui.console;

import jdk.jshell.execution.Util;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create Task UI (console). This option is only available for administrators for demonstration purposes.
 */
public class CreateRequestUI implements Runnable {

    CreateRequestController controller = new CreateRequestController();
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
    private int numberOfPhotographs;
    private String availableEquipment;
    private String existenceOfBasement;
    private String inhabitableLoft;
    private String sunExposure;
    private int contractDuration;
    private String agency;
    private List<String> photographs = new ArrayList<>();
    private List<String> agencyList = new ArrayList<>();
    private List<String> agentList = new ArrayList<>();

    public static final Scanner input = new Scanner(System.in);

    public void run() {
        //Property type data verification:
        requestType = Utils.readLineFromConsole("Choose a type : Sell or Rent");
        if (requestType.equalsIgnoreCase("Rent")) {
            contractDuration = Utils.readIntegerFromConsole("Contract duration:");
        }
        area = Utils.readDoubleFromConsole("Area (squared meters):");
        distanceFromCityCentre = Utils.readDoubleFromConsole("Distance from city centre (Km):");
        price = Utils.readDoubleFromConsole("Price (USD):");
        doorNumber = Utils.readLineFromConsole("Door number:");
        floorNumber = Utils.readLineFromConsole("Floor number:");
        postalCode = Utils.readLineFromConsole("Postal code:");
        street = Utils.readLineFromConsole("Street:");
        auxState = Utils.readLineFromConsole("State:");
        numberOfPhotographs = Utils.readIntegerFromConsole("Number of photos to add (between 1 and 30):");
        if (numberOfPhotographs < 1 || numberOfPhotographs > 30) {
            System.out.println("Please insert a correct value!");
            numberOfPhotographs = Utils.readIntegerFromConsole("Number of photos to add (between 1 and 30):");
        }
        for (int i = 1; i <= numberOfPhotographs; i++) {
            photographs.add(Utils.readLineFromConsole("Photograph URI:"));
            System.out.println("Photograph added to the list");
        }
        controller.createState(auxState);
        controller.createAddress(street, floorNumber, postalCode);
        controller.createProperty(area, distanceFromCityCentre, price, photographs);
        propertyType = Utils.readLineFromConsole("Choose a type: Land, Apartment or house");
        if (propertyType.equalsIgnoreCase("Apartment") || propertyType.equalsIgnoreCase("House")) {
            numberOfBedrooms = Utils.readIntegerFromConsole("Number of bedrooms:");
            numberOfBathrooms = Utils.readIntegerFromConsole("Number of bathrooms:");
            numberOfParkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces:");
            availableEquipment = Utils.readLineFromConsole("Available equipment(yes/nor):");
            controller.createResidence(numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, availableEquipment, distanceFromCityCentre, area, photographs, price);
            if (propertyType.equalsIgnoreCase("House")) {
                existenceOfBasement = Utils.readLineFromConsole("Basement(yes/no):");
                inhabitableLoft = Utils.readLineFromConsole("Inhabitable(yes/no):");
                sunExposure = Utils.readLineFromConsole("Sun Exposure(North, South ,East ,West):");
                controller.createHouse(numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, availableEquipment, distanceFromCityCentre, area, photographs, price, inhabitableLoft, existenceOfBasement, sunExposure);
                System.out.println();
            }
        }
        agencyList=controller.getAgencyList();
        System.out.println(agencyList + "Please, select one agency");
        int selection = input.nextInt();
        agency = controller.getAgencyList().get(selection);

    }
}
