package pt.ipp.isep.dei.esoft.project.ui.console;
import java.io.Closeable;
import java.sql.SQLOutput;
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
    private AvailableEquipment availableEquipment;
    private String basement;
    private String loft;
    private SunExposure sunExposure;
    private String comissionType;
    private int dataConfirmation;
    private double comission;

    public void run() {
        /*Scanner ler = new Scanner(System.in);

        if (!ownerVerification()) {
            System.out.println("User not registed, please register user.");
        }
        else {

            System.out.println("Select property type:");
            System.out.println("1 - Land");
            System.out.println("2 - House");
            System.out.println("3 - Appartment");
            propertyType = ler.nextInt();
            while (propertyType > 3 || propertyType < 1) {
                System.out.println("Please select a valid property type.");
                propertyType = ler.nextInt();
            }

            area = Utils.readIntegerFromConsole("Area in m2:");
            while (!controller.checkArea(area)) {
                area = Utils.readIntegerFromConsole("Please write a valid area.");
            }

            System.out.println("Street:");
            ler.nextLine();
            street = ler.nextLine();

            doorNumber = Utils.readIntegerFromConsole("Door number:");
            while (!controller.checkDoorNumber(doorNumber)) {
                doorNumber = Utils.readIntegerFromConsole("Please write a valid door number.");
            }

            zipCode = Utils.readLineFromConsole("Zip code:");
            while (!controller.checkZipCode(zipCode)) {
                zipCode = Utils.readLineFromConsole("Please write a valid zip code.");
            }

            System.out.println("State:");
            ler.nextLine();
            state = ler.nextLine();

            distanceFromCityCenter = Utils.readIntegerFromConsole("Distance from city centre:");
            while (!controller.checkDistanceFromCityCenter(distanceFromCityCenter)) {
                distanceFromCityCenter = Utils.readIntegerFromConsole("Please write a valid distance.");
            }

            price = Utils.readIntegerFromConsole("Price:");
            while (!controller.checkPrice(price)) {
                price = Utils.readIntegerFromConsole("Please write a valid price.");
            }

            price = Utils.readIntegerFromConsole("Price:");
            while (!controller.checkPrice(price)) {
                price = Utils.readIntegerFromConsole("Please write a valid price.");
            }

            if (propertyType == 2 || propertyType == 3) {
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

                System.out.println("Available equipment:");
                ler.nextLine();
                equipment = ler.nextLine();

                if (propertyType == 3) {
                    System.out.println("Existence of basement:");
                    basement = ler.nextLine();
                    while (!(basement.equals("yes") || basement.equals("no"))) {
                        System.out.println("Please select a valid answer.");
                        basement = ler.nextLine();
                    }

                    System.out.println("Existence of inhabitable loft:");
                    loft = ler.nextLine();
                    while (!(loft.equals("yes") || loft.equals("no"))) {
                        System.out.println("Please select a valid answer.");
                        loft = ler.nextLine();
                    }

                    System.out.println("Sun exposure:");
                    sun = ler.nextLine();
                    while (!(sun.equals("N") || sun.equals("S") || sun.equals("W") || sun.equals("E"))) {
                        System.out.println("Please select a valid answer.");
                        sun = ler.nextLine();
                    }
                }
                if (propertyType)
            }
            System.out.println("Comission Type:");
            System.out.println("1. Percentage");
            System.out.println("2. Value");
            comissionType = ler.nextInt();
            while (comissionType < 1 || comissionType > 2) {
                System.out.println("Please select a valid option.");
                comissionType = ler.nextInt();
            }

            System.out.println("Comission:");
            comission = ler.nextDouble();
            while (comission < 0) {
                System.out.println("Please select a valid comission.");
                comission = ler.nextInt();
            }
            System.out.println("Property type = " + propertyType);
            System.out.println("Street = " + street);
            System.out.println("Door number = " + doorNumber);
            System.out.println("Floor number = " + floorNumber);
            System.out.println("State = " + state);
            System.out.println("Postal code = " + postalCode);
            System.out.println("Floor number = " + floorNumber);
            System.out.println("Distance from city centre = " + distance);
            System.out.println("Requested Price = " + price);
            System.out.println("Area = " + area);
            if (propertyType == 2 || propertyType == 3) {
                System.out.println("Number of numberOfBedrooms = " + numberOfBedrooms);
                System.out.println("Number of numberOfBathrooms = " + numberOfBathrooms);
                System.out.println("Number of parking space = " + parking);
                System.out.println("Available equipment = " + equipment);
                if (propertyType == 3) {
                    System.out.println("Basement existence = " + basement);
                    System.out.println("Inhabitable loft existence = " + loft);
                    System.out.println("Sun exposure = " + sun);
                }
            }
            System.out.println("Comission type = " + comissionType);
            System.out.println("Comission = " + comission);
            System.out.println();
            System.out.println("Confirm data?");
            System.out.println("0 - NO");
            System.out.println("1 - YES");
            dataConfirmation = ler.nextInt();
            while (dataConfirmation < 0 || dataConfirmation > 1) {
                System.out.println("Please select a valid answer.");
                dataConfirmation = ler.nextInt();
            }
            getController();
        }
    }

    public boolean ownerVerification() {
        Scanner ler = new Scanner(System.in);

        System.out.println("Please write the owner's email:");
        ownerEmail = ler.nextLine();

        if(controller.checkEmail(ownerEmail))
            return false;

        if(controller.)

         */
    }
}