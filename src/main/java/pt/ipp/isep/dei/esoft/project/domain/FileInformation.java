package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class FileInformation {
    Repositories repositories = Repositories.getInstance();
    AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
    StoreRepository storeRepository = repositories.getStoreRepository();
    PropertyRepository propertyRepository = repositories.getPropertyRepository();
    UserRepository userRepository = repositories.getUserRepository();
    public static final int sidPosition = 0;
    public static final int ownerNamePosition = 1;
    public static final int ownerPassportCardNumberPosition = 2;
    public static final int ownerTaxNumberPosition = 3;
    public static final int ownerEmailPosition = 4;
    public static final int ownerPhoneNumberPosition = 5;
    public static final int propertyTypePosition = 6;
    public static final int areaPosition = 7;
    public static final int propertyAddressPosition = 8;
    public static final int distanceFromCityCenterPosition = 9;
    public static final int numberOfBedroomsPosition = 10;
    public static final int numberOfBathroomsPosition = 11;
    public static final int numberOfParkingSpacesPosition = 12;
    public static final int propertyCentralHeatingPosition = 13;
    public static final int propertyAirConditioningPosition = 14;
    public static final int propertyBasementPosition = 15;
    public static final int propertyLoftPosition = 16;
    public static final int propertySunExposurePosition = 17;
    public static final int requestedPricePosition = 18;
    public static final int finalPricePosition = 19;
    public static final int commissionPosition = 20;
    public static final int contractDurationPosition = 21;
    public static final int announcementDatePosition = 22;
    public static final int businessDatePosition = 23;
    public static final int requestTypePosition = 24;
    public static final int storeIDPosition = 25;
    public static final int storeNamePosition = 26;
    public static final int storeAddressPosition = 27;
    public static final int storePhoneNumberPosition = 28;
    public static final int storeEmailPosition = 29;

    public void importFile(String filePath)throws IOException, CloneNotSupportedException {
        File file = new File(filePath);
        String extension = filePath.substring(filePath.lastIndexOf(".")+1);
        if (!extension.equals("csv")) {
            throw new IOException("File extension is not csv");
        }
        Scanner reader = new Scanner(file);
        if(!readerVerification(reader)) {
            throw new IOException("Not in the requested format");
        }
        while (reader.hasNextLine()) {
            String streetAddress = "";
            State state = null;
            District district = null;
            City city = null;
            String zipCode = "";
            Address propertyAddress = null;
            Address storeAddress = null;
            String line = reader.nextLine();
            String[] data = line.split(";");
            if (!data[0].equals("")) {
                int sid = Integer.parseInt(data[sidPosition].replace("NA", "-1"));
                String ownerName = data[ownerNamePosition];
                String ownerPassportCardNumber = data[ownerPassportCardNumberPosition];
                String ownerTaxNumber = data[ownerTaxNumberPosition];
                String ownerEmail = data[ownerEmailPosition];
                String ownerPhoneNumber = data[ownerPhoneNumberPosition];
                String propertyType = data[propertyTypePosition];
                double area = Double.parseDouble(data[areaPosition]);
                String propertyAddressString = data[propertyAddressPosition];
                int distanceFromCityCenter = Integer.parseInt(data[distanceFromCityCenterPosition].replace("NA", "-1"));
                int numberOfBedrooms = Integer.parseInt(data[numberOfBedroomsPosition].replace("NA", "-1"));
                int numberOfBathrooms = Integer.parseInt(data[numberOfBathroomsPosition].replace("NA", "-1"));
                int numberOfParkingSpaces = Integer.parseInt(data[numberOfParkingSpacesPosition].replace("NA", "-1"));
                String propertyCentralHeating = data[propertyCentralHeatingPosition];
                String propertyAirConditioning = data[propertyAirConditioningPosition];
                String propertyBasement = data[propertyBasementPosition];
                String propertyLoft = data[propertyLoftPosition];
                String propertySunExposure = data[propertySunExposurePosition];
                double requestedPrice = Double.parseDouble(data[requestedPricePosition].replace("NA", "-1"));
                double finalPrice = Double.parseDouble(data[finalPricePosition].replace("NA", "-1"));
                int commission = Integer.parseInt(data[commissionPosition].replace("NA", "-1"));
                int contractDuration = Integer.parseInt(data[contractDurationPosition].replace("NA", "-1"));
                String storePhoneNumber = data[storePhoneNumberPosition];
                String storeEmail = data[storeEmailPosition];
                String storeName = data[storeNamePosition];
                String storeAddressString = data[storeAddressPosition];
                String requestType = data[requestTypePosition];
                String announcementDateString = data[announcementDatePosition];
                String businessDateString = data[businessDatePosition];
                int storeID = Integer.parseInt(data[storeIDPosition].replace("NA", "-1"));
                String[] propertyAddress1 = propertyAddressString.split(",");
                String[] storeAddress1 = storeAddressString.split(",");
                if(propertyAddress1.length == 4) {
                    streetAddress = propertyAddress1[0];
                    state = new State(propertyAddress1[2]);
                    city = new City(propertyAddress1[1]);
                    zipCode = propertyAddress1[3].trim();
                    propertyAddress = new Address(streetAddress, city, state, zipCode);
                }
                else if(propertyAddress1.length == 5) {
                    streetAddress = propertyAddress1[0];
                    state = new State(propertyAddress1[3]);
                    city = new City(propertyAddress1[1]);
                    district = new District(propertyAddress1[2]);
                    zipCode = propertyAddress1[4].trim();
                    propertyAddress = new Address(streetAddress, city, district, state , zipCode);
                }
                if(storeAddress1.length == 4){
                    streetAddress = storeAddress1[0];
                    state = new State(storeAddress1[2]);
                    city = new City(storeAddress1[1]);
                    zipCode = storeAddress1[3].trim();
                    storeAddress = new Address(streetAddress, city, state, zipCode);
                } else if(storeAddress1.length == 5){
                    streetAddress = storeAddress1[0];
                    state = new State(storeAddress1[3]);
                    city = new City(storeAddress1[1]);
                    district = new District(storeAddress1[2]);
                    zipCode = storeAddress1[4].trim();
                    storeAddress = new Address(streetAddress, city, district, state , zipCode);
                }
                Store newStore = new Store(storeName, storeAddress, storePhoneNumber, storeEmail, storeID);
                String[] data1 = announcementDateString.split("-");
                String[] data2 = businessDateString.split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(data1[2].trim()), Integer.parseInt(data1[1].trim()), Integer.parseInt(data1[0].trim()));
                LocalDate date1 = LocalDate.of(Integer.parseInt(data2[2].trim()), Integer.parseInt(data2[1].trim()), Integer.parseInt(data2[0].trim()));
                String ownerTaxNumber1 = ownerTaxNumber.replaceAll("-", "");
                userRepository.add(new User(ownerName, ownerEmail,new PassportCardNumber(ownerPassportCardNumber), new TaxNumber(ownerTaxNumber1), ownerPhoneNumber));
                storeRepository.add(newStore);
                if(!propertySunExposure.equals("NA")){
                    boolean basement = Boolean.getBoolean(propertyBasement);
                    boolean loft = Boolean.getBoolean(propertyLoft);
                    boolean centralHeating = Boolean.getBoolean(propertyCentralHeating);
                    boolean airConditioning = Boolean.getBoolean(propertyAirConditioning);
                    if(propertyType.equalsIgnoreCase("Apartment")){
                        Residence residence = new Residence(propertyAddress, area, distanceFromCityCenter, new PropertyType(propertyType), numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, centralHeating, airConditioning, finalPrice, date1);
                        propertyRepository.addProperty(residence);
                        announcementRepository.add(new Announcement(residence, date, commission,new RequestType(requestType, contractDuration), requestedPrice, new Owner(ownerName, ownerPhoneNumber, ownerEmail, new TaxNumber(ownerTaxNumber), new PassportCardNumber(ownerPassportCardNumber)), newStore));
                    } else if (propertyType.equalsIgnoreCase("House")) {
                        House house = new House(propertyAddress, area, distanceFromCityCenter, new PropertyType(propertyType), numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, centralHeating, airConditioning, basement, new SunExposure(propertySunExposure), loft, finalPrice, date1);
                        propertyRepository.addProperty(house);
                        announcementRepository.add(new Announcement(house, date, commission, new RequestType(requestType, contractDuration), requestedPrice, new Owner(ownerName, ownerPhoneNumber, ownerEmail, new TaxNumber(ownerTaxNumber), new PassportCardNumber(ownerPassportCardNumber)), newStore));
                        System.out.println();
                        }
                }
                if(propertyType.equalsIgnoreCase("Land")){
                    Property land = new Property(area, distanceFromCityCenter, propertyAddress ,new PropertyType(propertyType), finalPrice, date1);
                    propertyRepository.addProperty(land);
                    announcementRepository.add(new Announcement(land, date, commission, new RequestType(requestType, contractDuration), requestedPrice, new Owner(ownerName, ownerPhoneNumber, ownerEmail, new TaxNumber(ownerTaxNumber), new PassportCardNumber(ownerPassportCardNumber)), newStore));
                }
            }
        }
    }

    private boolean readerVerification(Scanner reader) {
        String expectedHeader = "sid;owner_name;owner_passportNum;owner_TIN(SSN);owner_email;owner_phone;property_type;property_area(square feet);property_location;property_distanceFromCenter (miles);property_numberBedrooms;property_numberBathrooms;property_pnumParking;property_centralHeating;property_airconditioned;property_basement;property_loft;property_sunExposure;property_requested_sale_rent_price;property_sale_rent_price (USD);commission(%);contract_duration(months);property_dateAnnounceRequest;property_dateofSale;type_business;store_ID;store_name;store_location;store_phonenumber;store_emailAddress";
        String header = reader.nextLine().trim();
        return header.equals(expectedHeader);
    }
}