package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class FileInformation {
    Repositories repositories = Repositories.getInstance();
    AnnouncementRepository announcementRepository = repositories.getAnnouncementRepository();
    UserRepository userRepository = repositories.getUserRepository();
    PropertyRepository propertyRepository = repositories.getPropertyRepository();
    StoreRepository storeRepository = repositories.getStoreRepository();

    public static final int SID_INDEX = 0;
    public static final int OWNER_NAME_INDEX = 1;
    public static final int PASSPORT_NUMBER_INDEX = 2;
    public static final int TIN_INDEX = 3;
    public static final int OWNER_EMAIL_INDEX = 4;
    public static final int OWNER_PHONE_INDEX = 5;
    public static final int PROPERTY_TYPE_INDEX = 6;
    public static final int PROPERTY_AREA_INDEX = 7;
    public static final int PROPERTY_LOCATION_INDEX = 8;
    public static final int PROPERTY_DISTANCE_FROM_CENTER_INDEX = 9;
    public static final int PROPERTY_NUMBER_BEDROOMS_INDEX = 10;
    public static final int PROPERTY_NUMBER_BATHROOMS_INDEX = 11;
    public static final int PROPERTY_NPARK_INDEX = 12;
    public static final int PROPERTY_CENTRALHEATING_INDEX = 13;
    public static final int PROPERTY_AIRCONDITIONED_INDEX = 14;
    public static final int PROPERTY_BASEMENT_INDEX = 15;
    public static final int PROPERTY_LOFT_INDEX = 16;
    public static final int PROPERTY_SUN_EXPOSURE_INDEX = 17;
    public static final int PROPERTY_REQUESTED_PRICE_INDEX = 18;
    public static final int PROPERTY_REQUESTED_PRICE_USD_INDEX = 19;
    public static final int COMMISSION_INDEX = 20;
    public static final int CONTRACT_DURATION_INDEX = 21;
    public static final int PROPERTY_DATE_ANNOUNCE_REQUEST_INDEX = 22;
    public static final int PROPERTY_DATE_OF_SALE_INDEX = 23;
    public static final int BUSINESS_TYPE_INDEX = 24;
    public static final int STORE_ID_INDEX = 25;
    public static final int STORE_NAME_INDEX = 26;
    public static final int STORE_LOCATION_INDEX = 27;
    public static final int STORE_PHONENUMBER_INDEX = 28;
    public static final int STORE_EMAIL_INDEX = 29;

    public void importFile(String filePath) throws IOException {
        File f = new File(filePath);
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
        if (!extension.equals("csv")) {
            throw new IOException("Not a valid file format!");
        }
        Scanner sc = new Scanner(f);
        String header = sc.nextLine();
        if (!headerVerification(header)){
            throw new IOException("Not in the requested format!");
        }
        while (sc.hasNextLine()) {
            String streetP = "";State stateP = null; District districtP = null;City cityP = null; int zipcodeP = 0;
            String streetS = "";State stateS = null; District districtS = null;City cityS = null; int zipcodeS = 0;
            Address propertyAddress; Address storeAddress;
            String line = sc.nextLine();
            String[] contents = line.split(";");
            if(!contents[0].equals("")) {
                int sid = parseInt(contents[SID_INDEX].replace("NA","-1"));
                String ownerName = contents[OWNER_NAME_INDEX];
                String ownerPassportNum = contents[PASSPORT_NUMBER_INDEX];
                String ownerTIN = contents[TIN_INDEX];
                String ownerEmail = contents[OWNER_EMAIL_INDEX];
                String ownerPhoneNumber = contents[OWNER_PHONE_INDEX];
                String propertyType = contents[PROPERTY_TYPE_INDEX];
                double propertyArea = Double.parseDouble(contents[PROPERTY_AREA_INDEX]);
                String propertyLocation = contents[PROPERTY_LOCATION_INDEX];
                int propertyDistanceFromCenter = parseInt(contents[PROPERTY_DISTANCE_FROM_CENTER_INDEX].replace("NA","0"));
                int propertyNumberBedrooms = parseInt(contents[PROPERTY_NUMBER_BEDROOMS_INDEX].replace("NA","-1"));
                int propertyNumberOfBathrooms = parseInt(contents[PROPERTY_NUMBER_BATHROOMS_INDEX].replace("NA","-1"));
                int propertyNumberParking = parseInt(contents[PROPERTY_NPARK_INDEX].replace("NA","-1"));
                String propertyCentralHeating = contents[PROPERTY_CENTRALHEATING_INDEX];
                String propertyAirConditioned = contents[PROPERTY_AIRCONDITIONED_INDEX];
                String propertyBasement = contents[PROPERTY_BASEMENT_INDEX];
                String propertyLoft = contents[PROPERTY_LOFT_INDEX];
                String propertySunExposure = contents[PROPERTY_SUN_EXPOSURE_INDEX];
                int propertySaleRentPrice = parseInt(contents[PROPERTY_REQUESTED_PRICE_INDEX].replace("NA","-1"));
                int propertySaleRentPriceUSD = parseInt(contents[PROPERTY_REQUESTED_PRICE_USD_INDEX].replace("NA","-1"));
                int comission = parseInt(contents[COMMISSION_INDEX].replace("NA","-1"));
                int contractDurationInMonths = parseInt(contents[CONTRACT_DURATION_INDEX].replace("NA","0"));
                String propertyAnnouncementDate = contents[PROPERTY_DATE_ANNOUNCE_REQUEST_INDEX];
                String propertyDateSale = contents[PROPERTY_DATE_OF_SALE_INDEX];
                String propertyTypeBusiness = contents[BUSINESS_TYPE_INDEX];
                String storeId = contents[STORE_ID_INDEX];
                String storeName = contents[STORE_NAME_INDEX];
                String storeLocation = contents[STORE_LOCATION_INDEX];
                String storePhoneNumber = contents[STORE_PHONENUMBER_INDEX];
                String storeEmail = contents[STORE_EMAIL_INDEX];

            }
        }

    }
    private boolean headerVerification (String header) {
        return header.equals ("sid, owner name, passport number, tin, owner email, owner phone, property type, property area, location,");

    }
}