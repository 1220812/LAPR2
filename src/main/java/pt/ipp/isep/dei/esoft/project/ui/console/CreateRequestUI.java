package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pt.ipp.isep.dei.esoft.project.domain.*;
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
            Optional<Property> land = controller.createLand(area, distanceFromCityCenter, address, price, photographs);
            System.out.println(land);
            System.out.println();
        } else if (inPutType.equals("House")) {
            requestDataForHouse();
            Optional<Property> house = controller.createHouse(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, airConditioning, centralHeating, basement, sunExposure,inhabitableLoft,price, photographs);
            System.out.println(house);
            System.out.println();
        } else if (inPutType.equals("Apartment")) {
            requestDataForApartment();
            Optional<Property> apartment = controller.createApartment(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, price, photographs, centralHeating, airConditioning);
            System.out.println(apartment);
            System.out.println();
        }
        RequestType requestType = Utils.listAndSelectOne(controller.getRequestTypeList());
        String requestedType = requestType.toString();
        if (requestedType.equalsIgnoreCase("Rent")) {
            int contractDuration = Utils.readIntegerFromConsole("Insert the contract duration: ");
            Optional<Request> rentRequest = controller.createRentRequest(property, requestDate, propertyType, agent, store, owner, contractDuration, price, requestType);
            System.out.println(rentRequest);
        }else if(requestedType.equalsIgnoreCase("Sell")){
            Optional<Request> sellRequest = controller.createSellRequest(property,requestDate,propertyType,agent,store,owner,price,requestType);
            System.out.println(sellRequest);
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
        String flag2 = Utils.readLineFromConsole("Does the house have an air conditioning? (true/false)");
        if(flag2.equalsIgnoreCase("true")){
            airConditioning = true;
        }else{
            airConditioning = false;
        }
        String flag3 = Utils.readLineFromConsole("Does the house have a central heating? (true/false)");
        if(flag3.equalsIgnoreCase("true")){
            centralHeating = true;
        }else{
            centralHeating = false;
        }
    }
    private void requestDataForApartment(){
        numberOfBathrooms = Utils.readIntegerFromConsole("Insert the number of bathrooms: ");
        numberOfBedrooms = Utils.readIntegerFromConsole("Insert the number of bedrooms: ");
        numberOfParkingSpaces = Utils.readIntegerFromConsole("Insert the number of parking spaces: ");
        String flag2 = Utils.readLineFromConsole("Does the house have an air conditioning? (true/false)");
        if(flag2.equalsIgnoreCase("true")){
            airConditioning = true;
        }else{
            airConditioning = false;
        }
        String flag3 = Utils.readLineFromConsole("Does the house have a central heating? (true/false)");
        if(flag3.equalsIgnoreCase("true")){
            centralHeating = true;
        }else{
            centralHeating = false;
        }
    }
    private void requestDataForAddress(){
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
        address = new Address(streetAddress,zipCode,state,district,city);
    }

}
