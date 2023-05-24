package pt.ipp.isep.dei.esoft.project.ui.console;

import java.io.Closeable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.Photographs;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class RegisterAnnouncementUI implements Runnable {

    private final RegisterAnnouncementController controller = new RegisterAnnouncementController();

    private RegisterAnnouncementController getController() {
        return controller;
    }

    private PropertyType propertyType;
    private String ownerEmail;
    private double area;
    private Address address;
    private String street;
    private int doorNumber;
    private int floorNumber;
    private State state;
    private String zipCode;
    private int distanceFromCityCenter;
    private double price;
    private Photographs photos;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int parking;

    private boolean basement;
    private boolean loft;
    private SunExposure sunExposure;
    private String comissionType;
    private boolean dataConfirmation;
    private double comission;
    List<AvailableEquipment> availableEquipment = new ArrayList<>();

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
        System.out.println("1. Percentage");
        System.out.println("2. Value");
        comissionType = ler.next();
        while (!comissionType.equals("Percentage") && !comissionType.equals("Value")) {
            System.out.println("Please select a valid option.");
            comissionType = ler.next();
        }

        System.out.println("Comission:");
        comission = ler.nextDouble();
        while (comission < 0) {
            System.out.println("Please select a valid comission.");
            comission = ler.nextInt();
        }
        System.out.println("Property type = " + propertyType);
        System.out.println("Address= "+ address);
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
        System.out.println("Comission type = " + comissionType);
        System.out.println("Comission = " + comission);
        System.out.println();

        dataConfirmation = Utils.readBooleanFromConsole("Confirm data? (y/n)");

        if(dataConfirmation) {
            if (inputPropertyType.equals("Land")) {
                controller.createProperty(area, distanceFromCityCenter, address, price, photos, requestType);
            }
            else if (inputPropertyType.equals("Apartment")) {
                controller.createResidence(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, parking, availableEquipment, price, photos, requestType);
            }
            else if (inputPropertyType.equals("House")) {
                controller.createHouse(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, parking, availableEquipment, basement, sunExposure, loft, price, photos, requestType);
            }
            controller.createAnnouncement(property, date, comissionType, requestType);
        }
    }

//    public boolean ownerVerification() {
//        Scanner ler = new Scanner(System.in);
//
//        System.out.println("Please write the owner's email:");
//        ownerEmail = ler.nextLine();
//
//        if(controller.checkEmail(ownerEmail))
//            return false;
//
//        if(controller.)
//
//
//    }
}
