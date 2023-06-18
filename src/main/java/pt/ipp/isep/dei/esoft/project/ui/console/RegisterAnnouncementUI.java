package pt.ipp.isep.dei.esoft.project.ui.console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.Photographs;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

/**
 * The type Register announcement ui.
 */
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
    private int floorNumber = 0;
    private int distanceFromCityCenter;
    private double price;
    private State state;

    private Announcement announcement;
    private List<Photographs> photos = new ArrayList<>();
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int parking;
    private int numberOfPhotos;
    private Property property;
    private boolean basement;
    private boolean loft;
    private String streetAddress;
    private District district;
    private City city;
    private RequestType requestType;
    private String zipCode;
    private SunExposure sunExposure;
    private String commissionType;
    private boolean dataConfirmation;
    private double commission;
    private final String DEFAULT_REQUESTTYPE = "Sell";
    private final double DEFAULT_CONTRACTDURATION = 0;
    /**
     * The Available equipment list.
     */
    List<AvailableEquipment> availableEquipmentList = new ArrayList<>();

    private PropertyType propertyType;
    private Agent agent;
    private Store store;
    private Owner owner;

    private boolean airConditioning;

    private boolean centralHeating;

    public void run() {
        Scanner ler = new Scanner(System.in);

        System.out.println("\nPlease write the owner's email:");
        ownerEmail = ler.nextLine();
        if (!controller.checkOwnerExistence(ownerEmail)) {
            System.out.println("Owner not registed, please register Owner.");
        } else {
            System.out.println("Property type:");
            propertyType = Utils.listAndSelectOne(controller.getPropertyType());
            if (propertyType == null) return;

            String inputPropertyType = propertyType.toString();

            area = Utils.readIntegerFromConsole("Area in m2:");
            while (!controller.checkArea(area)) {
                area = Utils.readIntegerFromConsole("Please write a valid area.");
            }


            streetAddress = Utils.readLineFromConsole("Insert the street address:");
            while (streetAddress == null) {
                streetAddress = Utils.readLineFromConsole("Please insert a valid street address.");
            }


            city = new City(Utils.readLineFromConsole("Insert the city: "));


            district = new District(Utils.readLineFromConsole("Insert the district: "));


            state = new State(Utils.readLineFromConsole("Insert the state:"));


            zipCode = Utils.readLineFromConsole("Insert the zip code: ");
            while (zipCode == null || zipCode.length() != 5) {
                zipCode = Utils.readLineFromConsole("Please insert a valid zip code.");
            }

            if (inputPropertyType.equalsIgnoreCase("Apartment")) {
                floorNumber = Utils.readIntegerFromConsole("Floor number:");
                while (!controller.checkDoorNumber(floorNumber)) {
                    floorNumber = Utils.readIntegerFromConsole("Please write a valid floor number.");
                }
            }

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
            for (int i = 0; i < numberOfPhotos; i++) {
                String photoURI = Utils.readLineFromConsole("Insert the photo URI:");
                Photographs photo = new Photographs(photoURI);
                photos.add(photo);
                System.out.println("Photograph added");
            }


            if (inputPropertyType.equalsIgnoreCase("House") || inputPropertyType.equalsIgnoreCase("Apartment")) {

                numberOfBedrooms = Utils.readIntegerFromConsole("Number of bedrooms:");
                while (numberOfBedrooms < 0) {
                    numberOfBathrooms = Utils.readIntegerFromConsole("Please select a valid number of bedrooms.");
                }

                numberOfBathrooms = Utils.readIntegerFromConsole("Number of bathrooms:");
                while (numberOfBathrooms < 0) {
                    numberOfBathrooms = Utils.readIntegerFromConsole("Please select a valid number of bathrooms.");
                }

                parking = Utils.readIntegerFromConsole("Number of parking spaces:");
                while (parking < 0) {
                    parking = Utils.readIntegerFromConsole("Please select a valid number of parking spaces.");
                }

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


                if (inputPropertyType.equalsIgnoreCase("House")) {
                    basement = Utils.readBooleanFromConsole("Does the house have a basement? (y/n)");

                    loft = Utils.readBooleanFromConsole("Does the house have an inhabitable loft? (y/n)");

                    sunExposure = Utils.listAndSelectOne(controller.getSunExposuresList());

                }
            }


            commissionType = Utils.readLineFromConsole("Commission Type:\n- Percentage\n- Value");
            while (!commissionType.equalsIgnoreCase("Percentage") && !commissionType.equalsIgnoreCase("Value")) {
                commissionType = Utils.readLineFromConsole("Please write a valid option.");
            }


            commission = Utils.readDoubleFromConsole("Commission:");
            while (commission < 0) {
                commission = Utils.readDoubleFromConsole("Please write a valid commission:");
            }


            date = LocalDate.now();

            agent = controller.getCurrentAgent();

            owner = controller.getOwnerByEmail(ownerEmail);

            store = agent.getStore();

            address = new Address(streetAddress, doorNumber, floorNumber, zipCode, state, district, city);

            requestType = controller.createRequestType(DEFAULT_REQUESTTYPE, DEFAULT_CONTRACTDURATION);

            if (inputPropertyType.equalsIgnoreCase("Land")) {
                property = controller.createProperty(area, distanceFromCityCenter, address, propertyType, photos);
            } else if (inputPropertyType.equalsIgnoreCase("Apartment")) {
                property = controller.createResidence(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, parking, propertyType, photos, availableEquipmentList);
            } else if (inputPropertyType.equalsIgnoreCase("House")) {
                property = controller.createHouse(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, parking, basement, sunExposure, loft, propertyType, photos, availableEquipmentList);
            }
            announcement = controller.createAnnouncement(property, date, commissionType, commission, requestType, propertyType, agent, store, owner, price);

            System.out.println(announcement.toString());

            String flag = Utils.readLineFromConsole("Confirm data? (y/n)");
            while (!flag.equalsIgnoreCase("y") && !flag.equalsIgnoreCase("n"))
                flag = Utils.readLineFromConsole("Insert valid option. (y/n)");
            if (flag.equalsIgnoreCase("y")) {
                controller.registerAnnouncement(announcement);
                String path = "src\\main\\java\\pt\\ipp\\isep\\dei\\esoft\\project\\application\\notification\\sms";

                String replyMessage =
                        "Subject: Announcement request registed"
                                + "\nFrom: " + controller.getAgentPhone(agent)
                                + "\nTo: " + controller.getOwnerPhone(owner)
                                + "\nBody:"
                                + "\nProperty info:"
                                + "\nProperty type: " + controller.getPropertyTypeByAnnouncement(announcement)
                                + "\nAddress: \n" + controller.getAddress(announcement)
                                + "\nAgent info:"
                                + "\nName: " + controller.getAgentName(agent)
                                + "\nReply date: " + date;

                File newFile = new File(path);
                PrintWriter printWriter;
                try {
                    printWriter = new PrintWriter(newFile);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                printWriter.write(replyMessage);
                printWriter.close();

                System.out.println("Announcement registered and sms sent successfully");
            } else if (flag.equalsIgnoreCase("n")) {
                System.out.println("Operation canceled");
            }
        }
    }
}

