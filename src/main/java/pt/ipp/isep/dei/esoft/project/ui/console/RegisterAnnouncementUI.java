package pt.ipp.isep.dei.esoft.project.ui.console;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.Photographs;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class RegisterAnnouncementUI implements Runnable {

    private final RegisterAnnouncementController controller = new RegisterAnnouncementController();

    private RegisterAnnouncementController getController() {
        return controller;
    }

    private String ownerEmail;
    private double area;
    private LocalDate date;
    private Address address;
    private int doorNumber;
    private int floorNumber;
    private int distanceFromCityCenter;
    private double price;
    private Announcement announcement;
    private List<Photographs> photos;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int parking;
    private int numberOfPhotos;
    private Property property;
    private boolean basement;
    private boolean loft;
    private RequestType requestType;
    private SunExposure sunExposure;
    private String commissionType;
    private boolean dataConfirmation;
    private double commission;
    private final String DEFAULT_REQUESTTYPE = "Sell";
    private final double DEFAULT_CONTRACTDURATION = 0;
    List<AvailableEquipment> availableEquipment = new ArrayList<>();

    private PropertyType propertyType;
    private Agent agent = null;
    private Store store = null;
    private Owner owner = null;

    private boolean airConditioning;

    private boolean centralHeating;

    public void run() {
        Scanner ler = new Scanner(System.in);

//        if (!ownerVerification()) {
//            System.out.println("Owner not registed, please register Owner.");
//        }
//        else {


        propertyType = Utils.listAndSelectOne(controller.getPropertyType());
        if (propertyType == null) return;


        area = Utils.readIntegerFromConsole("Area in m2:");
        while (!controller.checkArea(area)) {
            area = Utils.readIntegerFromConsole("Please write a valid area.");
        }

        address = Utils.listAndSelectOne(controller.getAddresses());
        if (address == null) return;
        System.out.println(address);

        doorNumber = Utils.readIntegerFromConsole("Door number:");
        while (!controller.checkDoorNumber(doorNumber)) {
            doorNumber = Utils.readIntegerFromConsole("Please write a valid door number.");
        }


        distanceFromCityCenter = Utils.readIntegerFromConsole("Distance from city centre:");
        while (!controller.checkDistanceFromCityCenter(distanceFromCityCenter)) {
            distanceFromCityCenter = Utils.readIntegerFromConsole("Please write a valid distance.");
        }


        price = Utils.readIntegerFromConsole("Price:");
        while (!controller.checkPrice(price)) {
            price = Utils.readIntegerFromConsole("Please write a valid price.");
        }

        numberOfPhotos = Utils.readIntegerFromConsole("Insert the number of photos: ");
        while (numberOfPhotos < 1 || numberOfPhotos > 30) {
            System.out.println("please insert a number between 1 and 30");
            numberOfPhotos = Utils.readIntegerFromConsole("Insert the number of photos: ");
        }

        String inputPropertyType;
        inputPropertyType = propertyType.toString();


        if (inputPropertyType.equals("House") || inputPropertyType.equals("Apartment")) {

            System.out.println("Number of numberOfBedrooms:");
            numberOfBedrooms = ler.nextInt();
            while (numberOfBedrooms < 0) {
                System.out.println("Please select a valid number of numberOfBedrooms.");
                numberOfBedrooms = ler.nextInt();
            }

            System.out.println("Number of numberOfBathrooms:");
            numberOfBathrooms = ler.nextInt();
            while (numberOfBathrooms < 0) {
                System.out.println("Please select a valid number of numberOfBathrooms.");
                numberOfBathrooms = ler.nextInt();
            }

            System.out.println("Number of parking spaces:");
            parking = ler.nextInt();
            while (parking < 0) {
                System.out.println("Please select a valid number of parking spaces.");
                parking = ler.nextInt();
            }

            availableEquipment = Utils.listAndSelectMany(controller.getAvailableEquipmentList());


            if (inputPropertyType.equals("House")) {
                basement = Utils.readBooleanFromConsole("Does the house have a basement? (y/n)");

                loft = Utils.readBooleanFromConsole("Does the house have an inhabitable loft? (y/n)");

                sunExposure = Utils.listAndSelectOne(controller.getSunExposuresList());

            }
        }

        System.out.println("Comission Type:");
        System.out.println("- Percentage");
        System.out.println("- Value");
        commissionType = ler.next();
        while (!commissionType.equals("Percentage") && !commissionType.equals("Value")) {
            System.out.println("Please write a valid option.");
            commissionType = ler.next();
        }

        System.out.println("Comission:");
        commission = ler.nextDouble();
        while (commission < 0) {
            System.out.println("Please select a valid comission.");
            commission = ler.nextInt();
        }
        System.out.println("Property type = " + propertyType);
        System.out.println("Address= " + address);
        System.out.println("Floor number = " + floorNumber);
        System.out.println("Distance from city centre = " + distanceFromCityCenter);
        System.out.println("Requested Price = " + price);
        System.out.println("Area = " + area);
        if (inputPropertyType.equals("House") || inputPropertyType.equals("Apartment")) {
            System.out.println("Number of numberOfBedrooms = " + numberOfBedrooms);
            System.out.println("Number of numberOfBathrooms = " + numberOfBathrooms);
            System.out.println("Number of parking space = " + parking);
            System.out.println("Available equipment = " + availableEquipment);
            if (inputPropertyType.equals("House")) {
                System.out.println("Basement existence = " + basement);
                System.out.println("Inhabitable loft existence = " + loft);
                System.out.println("Sun exposure = " + sunExposure);
            }
        }
        System.out.println("Comission type = " + commissionType);
        System.out.println("Comission = " + commission);
        System.out.println();

        String flag = Utils.readLineFromConsole("Confirm data? (y/n)");

        if (flag.equalsIgnoreCase("y")) {
            requestType = controller.createRequestType(DEFAULT_REQUESTTYPE, DEFAULT_CONTRACTDURATION);
            if (inputPropertyType.equals("Land")) {
                property = controller.createProperty(area, distanceFromCityCenter, address, propertyType, photos);
            } else if (inputPropertyType.equals("Apartment")) {
                property = controller.createResidence(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, parking, propertyType, photos, airConditioning, centralHeating);
            } else if (inputPropertyType.equals("House")) {
                property = controller.createHouse(address, area, distanceFromCityCenter,numberOfBathrooms, numberOfBedrooms, parking, airConditioning, centralHeating, basement, sunExposure, loft,propertyType, photos, requestType);
            }
            announcement = controller.createAnnouncement(property, date, commissionType, commission, requestType, propertyType,agent,store, owner,price);
            controller.registerAnnouncement(announcement);
            System.out.println("Announcement registered successfully");
        }
    }
}
