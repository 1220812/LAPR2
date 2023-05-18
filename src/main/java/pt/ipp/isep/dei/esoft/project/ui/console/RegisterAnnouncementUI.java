package pt.ipp.isep.dei.esoft.project.ui.console;
import java.io.Closeable;
import java.sql.SQLOutput;
import java.util.Scanner;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Photographs;
import pt.ipp.isep.dei.esoft.project.domain.Photographs;
import pt.ipp.isep.dei.esoft.project.domain.Address;

public class RegisterAnnouncementUI implements Runnable{

    private final RegisterAnnouncementController controller = new RegisterAnnouncementController();
    private RegisterAnnouncementController getController() {
        return controller;
    }
    private int propertyType;
    private String ownerName;
    private double area;
    private String street;
    private int doorNumber;
    private int floorNumber;
    private String state;
    private int postalCode;
    private int distance;
    private double price;
    private String photos;
    private int bedrooms;
    private int bathrooms;
    private int parking;
    private String equipment;
    private String basement;
    private String loft;
    private String sun;
    private int comissionType;
    private int dataConfirmation;
    private double comission;
    public void run() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Select property type:");
        System.out.println("1 - Land");
        System.out.println("2 - House");
        System.out.println("3 - Appartment");
        propertyType = ler.nextInt();
        while (propertyType > 3 || propertyType < 1) {
            System.out.println("Please select a valid property type.");
            propertyType = ler.nextInt();
        }

        System.out.println("Please write the owner's name:");
        ownerName = ler.nextLine();

        System.out.println("Area in m2:");
        area = ler.nextInt();
        while (area < 1) {
            System.out.println("Please select a valid area.");
            area = ler.nextInt();
        }

        System.out.println("Street:");
        ler.nextLine();
        street = ler.nextLine();

        System.out.println("Door Number:");
        doorNumber = ler.nextInt();
        while (doorNumber < 1) {
            System.out.println("Please select a valid door number.");
            doorNumber = ler.nextInt();
        }

        System.out.println("Floor Number:");
        floorNumber = ler.nextInt();

        System.out.println("Postal Code:");
        postalCode = ler.nextInt();
        while (postalCode > 99999) {
            System.out.println("Please select a valid postal code.");
            propertyType = ler.nextInt();
        }

        System.out.println("State:");
        ler.nextLine();
        state = ler.nextLine();

        System.out.println("Distance from city centre:");
        distance = ler.nextInt();
        while (distance < 0) {
            System.out.println("Please select a valid distance.");
            distance = ler.nextInt();
        }

        System.out.println("Requested price:");
        price = ler.nextInt();
        while (price < 1) {
            System.out.println("Please select a valid price.");
            price = ler.nextInt();
        }

        System.out.println("Photographs:");
        ler.nextLine();
        photos = ler.nextLine();

        if(propertyType == 2 || propertyType == 3) {
            System.out.println("Number of bedrooms:");
            bedrooms = ler.nextInt();
            while (bedrooms < 0) {
                System.out.println("Please select a valid number of bedrooms.");
                bedrooms = ler.nextInt();
            }

            System.out.println("Number of bathrooms:");
            bathrooms = ler.nextInt();
            while (bathrooms < 0) {
                System.out.println("Please select a valid number of bathrooms.");
                bathrooms = ler.nextInt();
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

            if(propertyType == 3) {
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
        System.out.println("Street = "+ street);
        System.out.println("Door number = "+ doorNumber);
        System.out.println("Floor number = "+ floorNumber);
        System.out.println("State = "+ state);
        System.out.println("Postal code = "+ postalCode);
        System.out.println("Floor number = "+ floorNumber);
        System.out.println("Distance from city centre = "+ distance);
        System.out.println("Requested Price = "+ price);
        System.out.println("Area = "+ area);
        if(propertyType == 2 || propertyType == 3){
            System.out.println("Number of bedrooms = "+ bedrooms);
            System.out.println("Number of bathrooms = "+ bathrooms);
            System.out.println("Number of parking space = "+ parking);
            System.out.println("Available equipment = "+ equipment);
            if(propertyType == 3) {
                System.out.println("Basement existence = "+ basement);
                System.out.println("Inhabitable loft existence = "+ loft);
                System.out.println("Sun exposure = "+ sun);
            }
        }
        System.out.println("Comission type = "+ comissionType);
        System.out.println("Comission = "+ comission);
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