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


    CreateRequestController controller = new CreateRequestController();

    double area = 0;
    double distanceFromCityCenter = 0;
    double price = 0;
    int numberOfBathrooms = 0;

    int numberOfBedrooms = 0;

    int numberOfParkingSpaces = 0;
    PropertyAddress address;

    int numberOfPhotos = 0;

    Boolean inhabitableLoft = null;

    Boolean basement = null;

    Agent agent= null;

    Store store= null;

    SunExposure sunExposure = null;
    private List<Photographs> photographs= new ArrayList<>();
    List<AvailableEquipment> availableEquipment = new ArrayList<>();
    PropertyType propertyType= null;



    public void run() {

        area = Utils.readDoubleFromConsole("Insert the area of the property: ");
        distanceFromCityCenter = Utils.readDoubleFromConsole("Insert the distance from the city center: ");
        price = Utils.readDoubleFromConsole("Insert the price of the property: ");
        //ask for a new address
        System.out.println("Insert the address of the property: ");
        String street = Utils.readLineFromConsole("Insert the street: ");
        int doorNumber = Utils.readIntegerFromConsole("Insert the door number: ");
        int floorNumber = Utils.readIntegerFromConsole("Insert the floor number: ");
        String zipCode = Utils.readLineFromConsole("Insert the Zip code: ");
        State state = new State(Utils.readLineFromConsole("Insert the state: "));
        District district = new District(Utils.readLineFromConsole("Insert the district: "));
        City city = new City(Utils.readLineFromConsole("Insert the city: "));
    /*    int count = 0;

        for(Address adr : controller.getAddresses()){
            count++;
            System.out.println(count + ". " + adr.toString());
        }
*/
        address = new PropertyAddress(street, doorNumber, floorNumber, zipCode, state, district, city);

        numberOfPhotos= Utils.readIntegerFromConsole("Insert the number of photos: ");
        while (numberOfPhotos <1 || numberOfPhotos > 30) {
            System.out.println("please insert a number between 1 and 30");
            numberOfPhotos= Utils.readIntegerFromConsole("Insert the number of photos: ");
        }
        for (int i = 0; i < numberOfPhotos; i++) {
            photographs.add(new Photographs(Utils.readLineFromConsole("Insert the photo URI:")));
            System.out.println("photo added");
        }
        System.out.println();
        int count2=0;
        for (PropertyType pt : controller.getPropertiesTypeList()) {
            count2++;
            System.out.println(count2 + ". " + pt.toString());
        }
        int option2 = Utils.readIntegerFromConsole("Insert the number of the property type: ");
        propertyType = controller.getPropertiesTypeList().get(option2-1);
        String inPutType = null;
        if(inPutType.equals("Land")){
            controller.createProperty(area, distanceFromCityCenter, address, price, photographs);
            System.out.println(controller.createRequest());
        }else if (inPutType.equals("House") || inPutType.equals("Apartment")){
            numberOfBathrooms= Utils.readIntegerFromConsole("Insert the number of bathrooms: ");
            numberOfBedrooms= Utils.readIntegerFromConsole("Insert the number of bedrooms: ");
            numberOfParkingSpaces= Utils.readIntegerFromConsole("Insert the number of parking spaces: ");
           // availableEquipment= Utils.listAndSelectMany(controller.getAvailableEquipmentList());
            //controller.createResidence(address,area,distanceFromCityCenter,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,price,availableEquipment,photographs);
            numberOfBathrooms= Utils.readIntegerFromConsole("Insert the number of bathrooms: ");
            numberOfBedrooms= Utils.readIntegerFromConsole("Insert the number of bedrooms: ");
            numberOfParkingSpaces= Utils.readIntegerFromConsole("Insert the number of parking spaces: ");
          //  basement= Utils.readBooleanFromConsole("Does the house have a basement? (y/n)");
          //  inhabitableLoft= Utils.readBooleanFromConsole("Does the house have an inhabitable loft? (y/n)");
          //  sunExposure= Utils.listAndSelectOne(controller.getSunExposuresList());
          //  availableEquipment= Utils.listAndSelectMany(controller.getAvailableEquipmentList());
            //controller.createHouse(address,area,distanceFromCityCenter,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,availableEquipment,basement,sunExposure,inhabitableLoft,price,photographs);
        }else if (inPutType.equals("Apartment")) {
            numberOfBathrooms= Utils.readIntegerFromConsole("Insert the number of bathrooms: ");
            numberOfBedrooms= Utils.readIntegerFromConsole("Insert the number of bedrooms: ");
            numberOfParkingSpaces= Utils.readIntegerFromConsole("Insert the number of parking spaces: ");
          //  availableEquipment= Utils.listAndSelectMany(controller.getAvailableEquipmentList());
            //controller.createResidence(address,area,distanceFromCityCenter,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,price,availableEquipment,photographs);
        }








    }

}



