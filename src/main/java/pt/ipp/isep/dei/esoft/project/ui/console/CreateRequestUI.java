package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RequestRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
public class CreateRequestUI implements Runnable {
    CreateRequestController controller = new CreateRequestController();

    double area = 0;
    double distanceFromCityCenter = 0;
    double price = 0;
    int numberOfBathrooms = 0;

    int numberOfBedrooms = 0;

    int numberOfParkingSpaces = 0;

    int numberOfPhotos = 0;

    private Boolean inhabitableLoft;

    private Boolean basement;

    private Agent agent;

    private Store store;
    private SunExposure sunExposure;
    private List<Photographs> photographs = new ArrayList<>();
    private boolean airConditioning;

    private boolean centralHeating;
    private String photoURI;
    private String streetAddress;

    private String zipCode;
    private  Property property;
    private Address address;
    public LocalDate requestDate = LocalDate.now();
    private Owner owner;
    private int doorNumber;
    private int floorNumber;
    private RequestType requestType;
    List<AvailableEquipment> availableEquipmentList = new ArrayList<>();
    private RequestRepository requestRepository = Repositories.getInstance().getRequestRepository();

    public void run() {
        String ownerName = Utils.readLineFromConsole("Insert the owner name: ");
        while (ownerName.isEmpty()) {
            System.out.println("please insert a valid name");
            ownerName = Utils.readLineFromConsole("Insert the owner name: ");
        }
        owner = new Owner(ownerName);
        requestOverallData();
        requestDataForAddress();
        numberOfPhotos = Utils.readIntegerFromConsole("Insert the number of photos: ");
        while (numberOfPhotos < 1 || numberOfPhotos > 30) {
            System.out.println("please insert a number between 1 and 30");
            numberOfPhotos = Utils.readIntegerFromConsole("Insert the number of photos: ");
        }
        for (int i = 0; i < numberOfPhotos; i++) {
            photoURI = Utils.readLineFromConsole("Insert the photo URI:");
            Photographs photo = new Photographs(photoURI);
            photographs.add(photo);
            System.out.println("photo added");
        }
        store = Utils.listAndSelectOne(controller.getStores());
        agent = Utils.listAndSelectOne(controller.getAgent());
        PropertyType propertyType = Utils.listAndSelectOne(controller.getPropertiesTypeList());
        String inPutType;
        inPutType = propertyType.toString();
        System.out.println(propertyType);
        if (inPutType.equals("Land")) {
            property = controller.createLand(area, distanceFromCityCenter, address, propertyType, photographs);
        } else if (inPutType.equals("House")) {
            requestDataForHouse();
            property = controller.createHouse(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, basement, sunExposure, inhabitableLoft, propertyType, photographs, availableEquipmentList);
        } else if (inPutType.equals("Apartment")) {
            requestDataForApartment();
            property = controller.createResidence(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, propertyType, photographs, availableEquipmentList);
        }
        System.out.println("Please select on of the request types:");
        System.out.println("1 - Rent");
        System.out.println("2 - Sell");
        String requestType = Utils.readLineFromConsole("Insert the request type: ");
        while (!requestType.equalsIgnoreCase("Rent") && !requestType.equalsIgnoreCase("Sell")){
            System.out.println("please insert a valid request type");
            requestType = Utils.readLineFromConsole("Insert the request type: ");
        }
        if (requestType.equalsIgnoreCase("Rent")) {
            int contractDuration = Utils.readIntegerFromConsole("Insert the contract duration: ");
            if(contractDuration <= 0){
                System.out.println("please insert a valid number");
                contractDuration = Utils.readIntegerFromConsole("Insert the contract duration: ");
            }
            RequestType rentRequestType = controller.createRentRequestType(requestType, contractDuration);
            Request request = controller.createRequest(property, rentRequestType, price, agent,owner, requestDate, store);
            controller.registerRequest(request);
            System.out.println("Request created successfully");
        }else if(requestType.equalsIgnoreCase("Sell")){
            RequestType sellRequestType = controller.createSellRequestType(requestType);
            Request request = controller.createRequest(property, sellRequestType, price, agent,owner, requestDate, store);
            controller.registerRequest(request);
            System.out.println();
            System.out.println("<<<<Request created successfully>>>>");
        }
    }
    private void requestOverallData(){
        area = Utils.readDoubleFromConsole("Insert the area of the property: ");
        while (area <= 0){
            System.out.println("please insert a valid number");
            area = Utils.readDoubleFromConsole("Insert the area of the property: ");
        }
        distanceFromCityCenter = Utils.readDoubleFromConsole("Insert the distance from the city center: ");
        while (distanceFromCityCenter <= 0){
            System.out.println("please insert a valid number");
            distanceFromCityCenter = Utils.readDoubleFromConsole("Insert the distance from the city center: ");
        }
        price = Utils.readDoubleFromConsole("Insert the price of the property: ");
        while (price <= 0){
            System.out.println("please insert a valid number");
            price = Utils.readDoubleFromConsole("Insert the price of the property: ");
        }
    }
    private void requestDataForHouse(){
        numberOfBathrooms = Utils.readIntegerFromConsole("Insert the number of bathrooms: ");
        while (numberOfBathrooms <= 0){
            System.out.println("please insert a valid number");
            numberOfBathrooms = Utils.readIntegerFromConsole("Insert the number of bathrooms: ");
        }
        numberOfBedrooms = Utils.readIntegerFromConsole("Insert the number of bedrooms: ");
        while (numberOfBedrooms <= 0){
            System.out.println("please insert a valid number");
            numberOfBathrooms = Utils.readIntegerFromConsole("Insert the number of bedrooms: ");
        }
        numberOfParkingSpaces = Utils.readIntegerFromConsole("Insert the number of parking spaces: ");
        while (numberOfParkingSpaces <= 0){
            System.out.println("please insert a valid number");
            numberOfBathrooms = Utils.readIntegerFromConsole("Insert the number of parking spaces: ");
        }
        String flag = Utils.readLineFromConsole("Does the house have an inhabitable loft? (true/false)");
        if(flag.equalsIgnoreCase("true")){
            inhabitableLoft = true;
        }else{
            inhabitableLoft = false;
        }
        String flag1 = Utils.readLineFromConsole("Does the house have an basement? (true/false)");
        if(flag1.equalsIgnoreCase("true")){
            basement = true;
        }else{
            basement = false;
        }
        System.out.println("Please select the direction of the sun exposure:");
        System.out.println();
        sunExposure = Utils.listAndSelectOne(controller.getSunExposuresList());
        String equipment = Utils.readLineFromConsole("Insert the available equipment: (enter 0 to exit)");
        if (!(equipment.equals("0"))) {
            AvailableEquipment availableEquipment = new AvailableEquipment(equipment);
            availableEquipmentList.add(availableEquipment);
            System.out.println("Equipment added");
        }
        while (!(equipment.equals("0"))) {
            equipment = Utils.readLineFromConsole("Insert the available equipment: (enter 0 to exit)");
            if (!(equipment.equals("0"))) {
                AvailableEquipment availableEquipment = new AvailableEquipment(equipment);
                availableEquipmentList.add(availableEquipment);
                System.out.println("Equipment added");
            }
        }
    }
    private void requestDataForApartment() {
        numberOfBathrooms = Utils.readIntegerFromConsole("Insert the number of bathrooms: ");
        numberOfBedrooms = Utils.readIntegerFromConsole("Insert the number of bedrooms: ");
        numberOfParkingSpaces = Utils.readIntegerFromConsole("Insert the number of parking spaces: ");
        String equipment = Utils.readLineFromConsole("Insert the available equipment: (enter 0 to exit)");
        if (!(equipment.equals("0"))) {
            AvailableEquipment availableEquipment = new AvailableEquipment(equipment);
            availableEquipmentList.add(availableEquipment);
            System.out.println("Equipment added");
        }
        while (!(equipment.equals("0"))) {
            equipment = Utils.readLineFromConsole("Insert the available equipment: (enter 0 to exit)");
            if (!(equipment.equals("0"))) {
                AvailableEquipment availableEquipment = new AvailableEquipment(equipment);
                availableEquipmentList.add(availableEquipment);
                System.out.println("Equipment added");
            }
        }
    }
    private void requestDataForAddress(){
        floorNumber = Utils.readIntegerFromConsole("Insert the floor number: ");
        while (floorNumber <= 0){
            System.out.println("please insert a valid number");
            floorNumber = Utils.readIntegerFromConsole("Insert the floor number: ");
        }
        doorNumber = Utils.readIntegerFromConsole("Insert the door number: ");
        while (doorNumber <= 0){
            System.out.println("please insert a valid number");
            doorNumber = Utils.readIntegerFromConsole("Insert the door number: ");
        }
        streetAddress = Utils.readLineFromConsole("Insert the street address: ");
        while (streetAddress == null) {
            System.out.println("please insert a valid street address");
            streetAddress = Utils.readLineFromConsole("Insert the street address: ");
        }
        zipCode = Utils.readLineFromConsole("Insert the zip code: ");
        while (zipCode==null || zipCode.length() != 5){
            System.out.println("please insert a valid zip code");
            zipCode = Utils.readLineFromConsole("Insert the zip code: ");
        }
        State state = new State(Utils.readLineFromConsole("Insert the state: "));
        District district = new District(Utils.readLineFromConsole("Insert the district: "));
        City city = new City(Utils.readLineFromConsole("Insert the city: "));
        address = new Address(streetAddress,doorNumber,floorNumber,zipCode,state,district,city);
    }
}
