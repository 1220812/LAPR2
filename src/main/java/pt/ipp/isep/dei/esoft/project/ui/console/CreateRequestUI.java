package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

/**
 * The type Create request ui.
 */
public class CreateRequestUI implements Runnable {


    CreateRequestController controller = new CreateRequestController();

    double area = 0;
    double distanceFromCityCenter = 0;
    double price = 0;
    int numberOfBathrooms = 0;

    int numberOfBedrooms = 0;

    int numberOfParkingSpaces = 0;
    Address address = null;

    int numberOfPhotos = 0;

    Boolean inhabitableLoft = null;

    Boolean basement = null;

    Agent agent = null;

    Store store = null;
    RequestType requestType = null;

    SunExposure sunExposure = null;
    private List<Photographs> photographs = new ArrayList<>();
    List<AvailableEquipment> availableEquipment = new ArrayList<>();


    PropertyType propertyType = null;


    public void run() {

        area = Utils.readDoubleFromConsole("Insert the area of the property: ");
        distanceFromCityCenter = Utils.readDoubleFromConsole("Insert the distance from the city center: ");
        price = Utils.readDoubleFromConsole("Insert the price of the property: ");

        address = Utils.listAndSelectOne(controller.getAddresses());

        numberOfPhotos = Utils.readIntegerFromConsole("Insert the number of photos: ");
        while (numberOfPhotos < 1 || numberOfPhotos > 30) {
            System.out.println("please insert a number between 1 and 30");
            numberOfPhotos = Utils.readIntegerFromConsole("Insert the number of photos: ");
        }
//        for (int i = 0; i < numberOfPhotos; i++) {
//            photographs.add(Utils.readLineFromConsole("Insert the photo URI:"));
//            System.out.println("photo added");
//        }

        store = Utils.listAndSelectOne(controller.getStores());

        agent = Utils.listAndSelectOne(controller.getAgent());

        requestType = Utils.listAndSelectOne(controller.getRequestTypeList());


        PropertyType propertyType = Utils.listAndSelectOne(controller.getPropertiesTypeList());
        String inPutType = null;
        inPutType = propertyType.toString();
        System.out.println(propertyType);
        if (inPutType.equals("Land")) {


            controller.createProperty(area, distanceFromCityCenter, address, price, photographs, store, agent, requestType);
            System.out.println(controller.createRequest(propertyType, price, requestType, agent, store));


        } else if (inPutType.equals("House")) {
            numberOfBathrooms = Utils.readIntegerFromConsole("Insert the number of bathrooms: ");
            numberOfBedrooms = Utils.readIntegerFromConsole("Insert the number of bedrooms: ");
            numberOfParkingSpaces = Utils.readIntegerFromConsole("Insert the number of parking spaces: ");
            basement = Utils.readBooleanFromConsole("Does the house have a basement? (y/n)");
            inhabitableLoft = Utils.readBooleanFromConsole("Does the house have an inhabitable loft? (y/n)");
            sunExposure = Utils.listAndSelectOne(controller.getSunExposuresList());
            availableEquipment = Utils.listAndSelectMany(controller.getAvailableEquipmentList());


            controller.createProperty(area, distanceFromCityCenter, address, price, photographs, store, agent, requestType);
            System.out.println(controller.createHouse(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, availableEquipment, basement, sunExposure, inhabitableLoft, price, photographs, agent, store, requestType));


        } else if (inPutType.equals("Apartment")) {
            numberOfBathrooms = Utils.readIntegerFromConsole("Insert the number of bathrooms: ");
            numberOfBedrooms = Utils.readIntegerFromConsole("Insert the number of bedrooms: ");
            numberOfParkingSpaces = Utils.readIntegerFromConsole("Insert the number of parking spaces: ");
            availableEquipment = Utils.listAndSelectMany(controller.getAvailableEquipmentList());

            controller.createProperty(area, distanceFromCityCenter, address, price, photographs, store, agent, requestType);
            System.out.println(controller.createResidence(address, area, distanceFromCityCenter, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, price, photographs, availableEquipment, agent, store, requestType));

        }


    }

}


