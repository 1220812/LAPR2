package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

/**
 * The type Create request ui.
 */
public class CreateRequestUI implements Runnable {


    /**
     * The Ctrl.
     */
    CreateRequestController ctrl = new CreateRequestController();
    private String selectedPropertyType;
    private int selectedCity;
    private int selectedState;
    private int selectedDistrict;
    private int selectedRequestType;
    private Double area;
    private String floorNumber;
    private String auxState;
    private String doorNumber;
    private String street;
    private String zipCode;
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
    private Agency agency;
    private Store store;
    private List<String> photographs = new ArrayList<>();
    private List<String> agencyList = new ArrayList<>();
    private List<String> agentList = new ArrayList<>();

    /**
     * The constant input.
     */
    public static final Scanner input = new Scanner(System.in);

    public void run() {

        PropertyType pt = Utils.listAndSelectOne(ctrl.getPropertiesTypeList());

        area = Utils.readDoubleFromConsole("Area (squared meters):");
        distanceFromCityCentre = Utils.readDoubleFromConsole("Distance from city centre (Km):");
        price = Utils.readDoubleFromConsole("Price (USD):");

        Address address1 = Utils.listAndSelectOne(ctrl.getAddresses());

        numberOfPhotographs = Utils.readIntegerFromConsole("Number of photos to add (between 1 and 30):");
        if (numberOfPhotographs < 1 || numberOfPhotographs > 30) {
            System.out.println("Please insert a correct value!");
            numberOfPhotographs = Utils.readIntegerFromConsole("Number of photos to add (must be between 1 and 30):");
        }
        for (int i = 1; i <= numberOfPhotographs; i++) {
            photographs.add(Utils.readLineFromConsole("Photograph URI:"));
            System.out.println("Photograph added to the list");
        }

        List<RequestType> requestTypeList = ctrl.getRequestTypeList();
        for (int i = 0; i < requestTypeList.size(); i++) {
            System.out.printf("%d - %s\n", i, requestTypeList.get(i));
        }
        System.out.println();
        selectedRequestType = Utils.readIntegerFromConsole("Please, insert the number of the request type that you want to choose");
        if (requestTypeList.get(selectedRequestType).equals("Rent")) {
            contractDuration = Utils.readIntegerFromConsole("Contract duration:");
        }
        if(requestTypeList.get(selectedRequestType).equals("Rent")){
            requestContractDuration();
        }
        if(selectedPropertyType.equals("Apartment") || selectedPropertyType.equals("House")){
            requestNumberOfBedrooms();
            requestNumberOfBathrooms();
            requestNumberOfParkingSpaces();
            //inserir equipamento
            if)(selectedPropertyType.equals("House")){
                requestExistenceOfBasement();
                requestInhabitableLoft();
            }
        }
    }

    private void requestData() {
        requestArea();
        requestDistanceFromCityCentre();
        requestPrice();
        requestNumberOfBedrooms();
        requestNumberOfBathrooms();
        requestNumberOfParkingSpaces();
        requestPhotographs();
        selectsAgency();
        requestContractDuration();
        selectsAgency();
        selectsStore();
       // requestAvailableEquipment();
       // requestExistenceOfBasement();
    }

    private int requestNumberOfBedrooms() {
        numberOfBedrooms = Utils.readIntegerFromConsole("Number of bedrooms:");
        return numberOfBedrooms;
    }

    private int requestNumberOfBathrooms() {
        numberOfBathrooms = Utils.readIntegerFromConsole("Number of bathrooms:");
        return numberOfBathrooms;
    }

    private int requestNumberOfParkingSpaces() {
        numberOfParkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces:");
        return numberOfParkingSpaces;
    }

    private double requestArea() {
        area = Utils.readDoubleFromConsole("Area (squared meters):");
        return area;
    }

    private double requestDistanceFromCityCentre() {
        distanceFromCityCentre = Utils.readDoubleFromConsole("Distance from city centre (Km):");
        return distanceFromCityCentre;
    }

    private double requestPrice() {
        price = Utils.readDoubleFromConsole("Price (USD):");
        return price;
    }
    private Agency selectsAgency(){
        agency = Utils.listAndSelectOne(ctrl.getAgencies());
        return agency;
    }
    private Store selectsStore(){
        store = Utils.listAndSelectOne(ctrl.getStores());
        return store;
    }


/*
    private AvailableEquipment requestAvailableEquipment() {
        List<AvailableEquipment> availableEquipmentList = new ArrayList<>();
        int listSize = Utils.readIntegerFromConsole("Insert the number of available equipment to add:");
        String equipment;
        for (int i = 0; i < listSize; i++) {
            //System.out.printf("%d - %s\n", i, availableEquipmentList.get(i));
            equipment = Utils.readLineFromConsole("Insert the equipment to add to the list: ");
            availableEquipmentList.add(new AvailableEquipment(equipment));
        }
        return availableEquipmentList;
    }

    //AvailableEquipment availableEquipment = Utils.listAndSelectOne(ctrl.getAvailableEquipmentList());
*/

    private void requestPhotographs() {
        numberOfPhotographs = Utils.readIntegerFromConsole("Number of photos to add (between 1 and 30):");
        if (numberOfPhotographs < 1 || numberOfPhotographs > 30) {
            System.out.println("Please insert a correct value!");
            numberOfPhotographs = Utils.readIntegerFromConsole("Number of photos to add (must be between 1 and 30):");
        }
        for (int i = 1; i <= numberOfPhotographs; i++) {
            photographs.add(Utils.readLineFromConsole("Photograph URI:"));
            System.out.println("Photograph added to the list");
        }
    }
    private int requestContractDuration(){
        contractDuration = Utils.readIntegerFromConsole("Contract duration:");
        return contractDuration;
    }
    private boolean requestExistenceOfBasement(){
        existenceOfBasement = Utils.readLineFromConsole("Basement(yes/no):");
        return existenceOfBasement;
    }

}

/**
 * else if(propertyTypeList.get(selectedPropertyType).equals("Apartment")||propertyTypeList.get(selectedPropertyType).equals("House")){
 * numberOfBedrooms = Utils.readIntegerFromConsole("Number of bedrooms:");
 * numberOfBathrooms = Utils.readIntegerFromConsole("Number of bathrooms:");
 * numberOfParkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces:");
 * availableEquipment = Utils.readLineFromConsole("Available equipment(yes/nor):");
 * controller.createResidence(address,area,distanceFromCityCentre,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,price,availableEquipment);
 * if (propertyTypeList.get(selectedPropertyType).equals("House")) {
 * existenceOfBasement = Utils.readLineFromConsole("Basement(yes/no):");
 * inhabitableLoft = Utils.readLineFromConsole("Inhabitable(yes/no):");
 * sunExposure = Utils.readLineFromConsole("Sun Exposure(North, South ,East ,West):");
 * controller.createHouse(address,area,distanceFromCityCentre,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,availableEquipment,existenceOfBasement,sunExposure,inhabitableLoft,price);
 * System.out.println();
 * }
 * }
 **/



