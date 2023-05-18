package pt.ipp.isep.dei.esoft.project.ui.console;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class CreateRequestUI implements Runnable {

    CreateRequestController controller = new CreateRequestController();
    private int selectedPropertyType;
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
    private String agency;
    private List<String> photographs = new ArrayList<>();
    private List<String> agencyList = new ArrayList<>();
    private List<String> agentList = new ArrayList<>();

    public static final Scanner input = new Scanner(System.in);

    public void run() {

        ArrayList<PropertyType> propertyTypeList;
        CreateRequestController CTRL = new CreateRequestController();
        propertyTypeList = CTRL.getPropertiesTypeList();
        for (int i = 0; i < propertyTypeList.size() ; i++) {
            System.out.printf("%d - %s\n", i, propertyTypeList.get(i));
        }
        System.out.println();
        selectedPropertyType = Utils.readIntegerFromConsole("Please, choose the property type from the list");
        area = Utils.readDoubleFromConsole("Area (squared meters):");
        distanceFromCityCentre = Utils.readDoubleFromConsole("Distance from city centre (Km):");
        price = Utils.readDoubleFromConsole("Price (USD):");

        ArrayList<State> stateList;
        stateList = CTRL.getStateList();
        for (int i = 0; i < stateList.size() ; i++) {
            System.out.printf("%d - %s\n", i, stateList.get(i));
        }
        System.out.println();
        selectedState = Utils.readIntegerFromConsole("Please, insert the number of the state that you want to choose");

        ArrayList<District> districtList;
        districtList = CTRL.getDistrictList();
        for (int i = 0; i < districtList.size() ; i++) {
            System.out.printf("%d - %s\n", i, districtList.get(i));
        }
        System.out.println();
        selectedDistrict = Utils.readIntegerFromConsole("Please, insert the number of the district that you want to choose");

        ArrayList<City> cityList;
        cityList = CTRL.getCityList();
        for (int i = 0; i < cityList.size() ; i++) {
            System.out.printf("%d - %s\n", i, cityList.get(i));
        }
        System.out.println();
        selectedCity = Utils.readIntegerFromConsole("Please, insert the number of the city that you want to choose");
        doorNumber = Utils.readLineFromConsole("Door number:");
        floorNumber = Utils.readLineFromConsole("Floor number:");
        zipCode = Utils.readLineFromConsole("Zip code:");
        street = Utils.readLineFromConsole("Street address:");

        numberOfPhotographs = Utils.readIntegerFromConsole("Number of photos to add (between 1 and 30):");
        if (numberOfPhotographs < 1 || numberOfPhotographs > 30) {
            System.out.println("Please insert a correct value!");
            numberOfPhotographs = Utils.readIntegerFromConsole("Number of photos to add (must be between 1 and 30):");
        }
        for (int i = 1; i <= numberOfPhotographs; i++) {
            photographs.add(Utils.readLineFromConsole("Photograph URI:"));
            System.out.println("Photograph added to the list");
        }

        ArrayList<RequestType> requestTypeList;
        requestTypeList = CTRL.getRequestTypeList();
        for (int i = 0; i < requestTypeList.size() ; i++) {
            System.out.printf("%d - %s\n", i , requestTypeList.get(i));
        }
        System.out.println();
        selectedRequestType = Utils.readIntegerFromConsole("Please, insert the number of the request type that you want to choose");

        if (requestTypeList.get(selectedRequestType).equals("Rent")) {
            contractDuration = Utils.readIntegerFromConsole("Contract duration:");
        }

        if (propertyTypeList.get(selectedPropertyType).equals("Land")) {
            controller.createProperty(area,distanceFromCityCentre,address,price);
        }
        else if(propertyTypeList.get(selectedPropertyType).equals("Apartment")||propertyTypeList.get(selectedPropertyType).equals("House")){
            numberOfBedrooms = Utils.readIntegerFromConsole("Number of bedrooms:");
            numberOfBathrooms = Utils.readIntegerFromConsole("Number of bathrooms:");
            numberOfParkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces:");
            availableEquipment = Utils.readLineFromConsole("Available equipment(yes/nor):");
            controller.createResidence(address,area,distanceFromCityCentre,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,price,availableEquipment);
            if (propertyTypeList.get(selectedPropertyType).equals("House")) {
                existenceOfBasement = Utils.readLineFromConsole("Basement(yes/no):");
                inhabitableLoft = Utils.readLineFromConsole("Inhabitable(yes/no):");
                sunExposure = Utils.readLineFromConsole("Sun Exposure(North, South ,East ,West):");
                controller.createHouse(address,area,distanceFromCityCentre,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,availableEquipment,existenceOfBasement,sunExposure,inhabitableLoft,price);
                System.out.println();
            }
        }
    }
}
