package pt.ipp.isep.dei.esoft.project.domain;

public class InformationFile {
    // private String ownerName;
    //    private final String OWNER_NAME = "owner_name";
    //    private String ownerPassportNumber;
    //    private final String OWNER_PASSPORT_NUMBER = "owner_passportNum";
    //    private String ownerTaxNumber;
    //    private final String OWNER_TAX_NUMBER = "owner_TIN(SSN)";
    //    private String ownerEmail;
    //    private final String OWNER_EMAIL = "owner_email";
    //    private String ownerPhone;
    //    private final String OWNER_PHONE = "owner_phone";
    //    private String propertyType;
    //    private final String PROPERTY_TYPE = "property_type";
    //    private double propertyArea;
    //    private final String PROPERTY_AREA = "property_area(square feet)";
    //    private String propertyStreet;
    //    private String propertyDistrict;
    //    private String propertyCity;
    //    private String propertyState;
    //    private String propertyPostalCode;
    //    private final String PROPERTY_LOCATION = "property_location";
    //    private double propertyDistanceFormCity;
    //    private final String PROPERTY_DISTANCE_FROM_CENTER = "property_distanceFromCenter (miles)";
    //    private int propertyNumberOfBedrooms;
    //    private final String PROPERTY_NUMBER_OF_BEDROOMS = "property_numberBedrooms";
    //    private int propertyNumberOfBathrooms;
    //    private final String PROPERTY_NUMBER_OF_BATHROOMS = "property_numberBathrooms";
    //    private int propertyNumberParkingSpaces;
    //    private final String PROPERTY_NUMBER_PARKING_SPACES = "property_pnumParking";
    //    private String centralHeating;
    //    private final String CENTRAL_HEATING = "property_centralHeating";
    //    private String airConditioning;
    //    private final String AIR_CONDITIONING = "property_airconditioned";
    //    private String basement;
    //    private final String BASEMENT = "property_basement";
    //    private String loft;
    //    private final String LOFT = "property_loft";
    //    private String sunExposure;
    //    private final String SUN_EXPOSURE = "property_sunExposure";
    //    private String propertyRequestedPrice;
    //    private final String PROPERTY_REQUESTED_PRICE = "property_requested_sale_rent_price";
    //    private double propertyPrice;
    //    private final String PROPERTY_PRICE = "property_sale_rent_price (USD)";
    //    private String commission;
    //    private final String COMMISSION = "commission(%)";
    //    private String contractDuration;
    //    private final String CONTRACT_DURATION = "contract_duration(months)";
    //    private String announceRequestDate;
    //    private final String ANNOUNCE_REQUEST_DATE = "property_dateAnnounceRequest";
    //    private String dateSale;
    //    private final String DATE_SALE = "property_dateofSale";
    //    private String typeOfBusiness;
    //    private final String TYPE_OF_BUSINESS = "type_business";
    //    private int storeID;
    //    private final String STORE_ID = "store_ID";
    //    private String storeName;
    //    private final String STORE_NAME = "store_name";
    //    private String storeStreet;
    //    private String storeState;
    //    private String storeDistrict;
    //    private String storeCity;
    //    private String storePostalCode;
    //    private final String STORE_LOCATION = "store_location";
    //    private String storePhoneNumber;
    //    private final String STORE_PHONE_NUMBER = "store_phonenumber";
    //    private String storeEmail;
    //    private final String STORE_EMAIL = "store_emailAddress";
    //    private Person ownerInstance;
    //    private Store storeInstance;
    //    private Advertisement advertisementInstance;
    //
    //    /**
    //     * This method sets the owner's name.
    //     *
    //     * @param ownerName owner's name
    //     */
    //    public void setOwnerName(String ownerName) {
    //        this.ownerName = ownerName;
    //    }
    //
    //    /**
    //     * This method sets the owner's passport number.
    //     *
    //     * @param ownerPassportNumber owner's passport number
    //     */
    //    public void setOwnerPassportNumber(String ownerPassportNumber) {
    //        this.ownerPassportNumber = ownerPassportNumber;
    //    }
    //
    //    /**
    //     * This method sets the owner's tax number.
    //     *
    //     * @param ownerTaxNumber owner's tax number
    //     */
    //    public void setOwnerTaxNumber(String ownerTaxNumber) {
    //        this.ownerTaxNumber = ownerTaxNumber;
    //    }
    //
    //    /**
    //     * This method sets the owner's email.
    //     *
    //     * @param ownerEmail owner's email
    //     */
    //    public void setOwnerEmail(String ownerEmail) {
    //        this.ownerEmail = ownerEmail;
    //    }
    //
    //    /**
    //     * This method sets the owner's phone number.
    //     *
    //     * @param ownerPhone owner's phone number
    //     */
    //    public void setOwnerPhone(String ownerPhone) {
    //        this.ownerPhone = ownerPhone;
    //    }
    //
    //    /**
    //     * This method sets the property's type.
    //     *
    //     * @param propertyType property's type
    //     */
    //    public void setPropertyType(String propertyType) {
    //        this.propertyType = propertyType;
    //    }
    //
    //    /**
    //     * This method sets the property's area.
    //     *
    //     * @param propertyArea property's area
    //     */
    //    public void setPropertyArea(double propertyArea) {
    //        this.propertyArea = propertyArea;
    //    }
    //
    //    /**
    //     * This method sets the property's street.
    //     *
    //     * @param propertyStreet property's street
    //     */
    //    public void setPropertyStreet(String propertyStreet) {
    //        this.propertyStreet = propertyStreet;
    //    }
    //
    //    /**
    //     * This method sets the property's district.
    //     *
    //     * @param propertyDistrict property's district
    //     */
    //    public void setPropertyDistrict(String propertyDistrict) {
    //        this.propertyDistrict = propertyDistrict;
    //    }
    //
    //    /**
    //     * This method sets the property's state.
    //     *
    //     * @param propertyState property's state
    //     */
    //    public void setPropertyState(String propertyState) {
    //        this.propertyState = propertyState;
    //    }
    //
    //    /**
    //     * This method sets the property's postal code.
    //     *
    //     * @param propertyPostalCode property's postal code
    //     */
    //    public void setPropertyPostalCode(String propertyPostalCode) {
    //        this.propertyPostalCode = propertyPostalCode;
    //    }
    //
    //    /**
    //     * This method sets the property's distance from city.
    //     *
    //     * @param propertyDistanceFormCity property's distance from city
    //     */
    //    public void setPropertyDistanceFormCity(double propertyDistanceFormCity) {
    //        this.propertyDistanceFormCity = propertyDistanceFormCity;
    //    }
    //
    //    /**
    //     * This method sets the property's number of bedrooms.
    //     *
    //     * @param propertyNumberOfBedrooms property's number of bedrooms
    //     */
    //    public void setPropertyNumberOfBedrooms(int propertyNumberOfBedrooms) {
    //        this.propertyNumberOfBedrooms = propertyNumberOfBedrooms;
    //    }
    //
    //    /**
    //     * This method sets the property's number of bathrooms.
    //     *
    //     * @param propertyNumberOfBathrooms property's number of bathrooms
    //     */
    //    public void setPropertyNumberOfBathrooms(int propertyNumberOfBathrooms) {
    //        this.propertyNumberOfBathrooms = propertyNumberOfBathrooms;
    //    }
    //
    //    /**
    //     * This method sets the property's number of parking spaces.
    //     *
    //     * @param propertyNumberParkingSpaces property's number of parking spaces
    //     */
    //    public void setPropertyNumberParkingSpaces(int propertyNumberParkingSpaces) {
    //        this.propertyNumberParkingSpaces = propertyNumberParkingSpaces;
    //    }
    //
    //    /**
    //     * This method sets the property's central heating.
    //     *
    //     * @param centralHeating property's central heating
    //     */
    //
    //    public void setCentralHeating(String centralHeating) {
    //        this.centralHeating = centralHeating;
    //    }
    //
    //    /**
    //     * This method sets the property's air conditioning.
    //     *
    //     * @param airConditioning property's air conditioning
    //     */
    //    public void setAirConditioning(String airConditioning) {
    //        this.airConditioning = airConditioning;
    //    }
    //
    //    /**
    //     * This method sets the property's basement.
    //     *
    //     * @param basement property's basement
    //     */
    //
    //    public void setBasement(String basement) {
    //        this.basement = basement;
    //    }
    //
    //    /**
    //     * This method sets the property's loft.
    //     */
    //    public void setLoft(String loft) {
    //        this.loft = loft;
    //    }
    //
    //    /**
    //     * This method sets the property's sun expousure.
    //     *
    //     * @param sunExposure property's sun expousure
    //     */
    //    public void setSunExposure(String sunExposure) {
    //        this.sunExposure = sunExposure;
    //    }
    //
    //    /**
    //     * This method sets the property's requested price.
    //     *
    //     * @param propertyRequestedPrice property's requested price
    //     */
    //    public void setPropertyRequestedPrice(String propertyRequestedPrice) {
    //        this.propertyRequestedPrice = propertyRequestedPrice;
    //    }
    //
    //    /**
    //     * This method sets the store street.
    //     *
    //     * @param storeStreet store street
    //     */
    //    public void setStoreStreet(String storeStreet) {
    //        this.storeStreet = storeStreet;
    //    }
    //
    //    /**
    //     * This method sets the store state.
    //     *
    //     * @param storeState store state
    //     */
    //    public void setStoreState(String storeState) {
    //        this.storeState = storeState;
    //    }
    //
    //    /**
    //     * This method sets the store district.

    //     *
    //     * @param storeDistrict store district
    //     */
    //    public void setStoreDistrict(String storeDistrict) {
    //        this.storeDistrict = storeDistrict;
    //    }
    //
    //    /**
    //     * This method sets the store city.
    //     *
    //     * @param storeCity store city
    //     */
    //    public void setStoreCity(String storeCity) {
    //        this.storeCity = storeCity;
    //    }
    //
    //    /**
    //     * This method sets the store postal code.
    //     *
    //     * @param storePostalCode store postal code
    //     */
    //    public void setStorePostalCode(String storePostalCode) {
    //        this.storePostalCode = storePostalCode;
    //    }
    //
    //    /**
    //     * This method sets the property's price.
    //     *
    //     * @param propertyPrice property's price
    //     */
    //    public void setPropertyPrice(double propertyPrice) {
    //        this.propertyPrice = propertyPrice;
    //    }
    //
    //    /**
    //     * This method sets the commission.
    //     *
    //     * @param commission commission
    //     */
    //    public void setCommission(String commission) {
    //        this.commission = commission;
    //    }
    //
    //    /**
    //     * This method sets the contract duration.
    //     *
    //     * @param contractDuration contract duration
    //     */
    //    public void setContractDuration(String contractDuration) {
    //        this.contractDuration = contractDuration;
    //    }
    //
    //    /**
    //     * This method sets the announce request date.
    //     *
    //     * @param announceRequestDate announce request date
    //     */
    //    public void setAnnounceRequestDate(String announceRequestDate) {
    //        this.announceRequestDate = announceRequestDate;
    //    }
    //
    //    /**
    //     * This method sets the sale date.
    //     *
    //     * @param dateSale sale date
    //     */
    //    public void setDateSale(String dateSale) {
    //        this.dateSale = dateSale;
    //    }
    //
    //    /**
    //     * This method sets the type of business.
    //     *
    //     * @param typeOfBusiness type of business
    //     */
    //    public void setTypeOfBusiness(String typeOfBusiness) {
    //        this.typeOfBusiness = typeOfBusiness;
    //    }
    //
    //    /**
    //     * This method sets the store's ID.
    //     *
    //     * @param storeID store's ID
    //     */
    //    public void setStoreID(int storeID) {
    //        this.storeID = storeID;
    //    }
    //
    //    /**
    //     * This method sets the store's name.
    //     *
    //     * @param storeName store's name
    //     */
    //    public void setStoreName(String storeName) {
    //        this.storeName = storeName;
    //    }
    //
    //    /**
    //     * This method sets the property's City.
    //     *
    //     * @param propertyCity property's City
    //     */
    //    public void setPropertyCity(String propertyCity) {
    //        this.propertyCity = propertyCity;
    //    }
    //
    //    /**
    //     * This method sets the store's phone number.
    //     *
    //     * @param storePhoneNumber store's phone number
    //     */
    //    public void setStorePhoneNumber(String storePhoneNumber) {
    //        this.storePhoneNumber = storePhoneNumber;
    //    }
    //
    //    /**
    //     * This method sets the store's email.
    //     *
    //     * @param storeEmail store's email
    //     */
    //    public void setStoreEmail(String storeEmail) {
    //        this.storeEmail = storeEmail;
    //    }
    //
    //    /**
    //     * This method loads the information from a file.
    //     * @param path path to the file
    //     * @param advertisementRepository advertisement repository
    //     * @param storeRepository store repository
    //     * @param stateRepository state repository
    //     * @param districtRepository district repository
    //     * @param cityRepository city repository
    //     * @param personRepository person repository
    //     */
    //    public void loadInformationFromFile(String path, AdvertisementRepository advertisementRepository,
    //                                        StoreRepository storeRepository, StateRepository stateRepository,
    //                                        DistrictRepository districtRepository, CityRepository cityRepository,
    //                                        PersonRepository personRepository) {
    //        List<List<String>> data = Utils.readLinesFromFile(path);
    //        if (data == null) {
    //            throw new IllegalArgumentException("Invalid file path");
    //        }
    //        List<String> header = data.get(0);
    //        for (int i = 1; i < data.size(); i++) {
    //            List<String> line = data.get(i);
    //            for (int j = 1; j < header.size(); j++) {
    //                saveInformationFromLine(header.get(j), line.get(j).trim());
    //            }
    //            try {
    //                saveOwnerInformation(new Email(ownerEmail), ownerName, ownerPassportNumber, ownerTaxNumber,
    //                        ownerPhone, personRepository);
    //
    //                saveStoreInformation(storeID, storeName, storePhoneNumber, storeEmail, storeStreet, storeCity,
    //                        storeDistrict, storeState, storePostalCode, cityRepository, districtRepository, stateRepository,
    //                        storeRepository);
    //
    //                if (propertyType.equalsIgnoreCase("Land")) {
    //                    saveLandInformation(propertyArea, propertyDistanceFormCity, propertyStreet, propertyCity,
    //                            propertyDistrict, propertyState, propertyPostalCode, propertyPrice, typeOfBusiness,
    //                            cityRepository, districtRepository, stateRepository, advertisementRepository);
    //
    //                } else if (propertyType.equalsIgnoreCase("Apartment")) {
    //                    saveApartmentInformation(propertyArea, propertyDistanceFormCity, propertyStreet, propertyCity,
    //                            propertyDistrict, propertyState, propertyPostalCode, propertyPrice, typeOfBusiness,
    //                            propertyNumberOfBedrooms, propertyNumberOfBathrooms, propertyNumberParkingSpaces, centralHeating,
    //                            airConditioning, cityRepository, districtRepository, stateRepository, advertisementRepository);
    //
    //                } else if (propertyType.equalsIgnoreCase("House")) {
    //                    saveHouseInformation(propertyArea, propertyDistanceFormCity, propertyStreet, propertyCity,
    //                            propertyDistrict, propertyState, propertyPostalCode, propertyPrice, typeOfBusiness,
    //                            propertyNumberOfBedrooms, propertyNumberOfBathrooms, propertyNumberParkingSpaces, centralHeating,
    //                            airConditioning, basement, loft, sunExposure, cityRepository, districtRepository, stateRepository,
    //                            advertisementRepository);
    //                }
    //            } catch (IllegalArgumentException e) {
    //                int lineOfTrouble = i + 1;
    //                System.out.println("Trouble saving " + ownerName + "'s property at line (" + lineOfTrouble + ")");
    //            }
    //        }
    //    }
    //
    //    /**
    //     * This method creates and saves the House information.
    //     * @param propertyArea property area
    //     * @param propertyDistanceFormCity property distance from city
    //     * @param propertyStreet property street
    //     * @param propertyCity property city
    //     * @param propertyDistrict property district
    //     * @param propertyState property state
    //     * @param propertyPostalCode property postal code
    //     * @param propertyPrice property price
    //     * @param typeOfBusiness type of business
    //     * @param propertyNumberOfBedrooms number of bedrooms
    //     * @param propertyNumberOfBathrooms number of bathrooms
    //     * @param propertyNumberParkingSpaces number of parking spaces
    //     * @param centralHeating central heating
    //     * @param airConditioning air conditioning
    //     * @param basement basement
    //     * @param loft loft
    //     * @param sunExposure sun exposure
    //     * @param cityRepository city repository
    //     * @param districtRepository district repository
    //     * @param stateRepository state repository
    //     * @param advertisementRepository advertisement repository
    //     */
    //    private void saveHouseInformation(double propertyArea, double propertyDistanceFormCity, String propertyStreet,
    //                                      String propertyCity, String propertyDistrict, String propertyState,
    //                                      String propertyPostalCode, double propertyPrice, String typeOfBusiness,
    //                                      int propertyNumberOfBedrooms, int propertyNumberOfBathrooms,
    //                                      int propertyNumberParkingSpaces, String centralHeating, String airConditioning,
    //                                      String basement, String loft, String sunExposure, CityRepository cityRepository,
    //                                      DistrictRepository districtRepository, StateRepository stateRepository,
    //                                      AdvertisementRepository advertisementRepository) {
    //        advertisementInstance = advertisementRepository.createHouseAdvertisement(ownerInstance, propertyArea, propertyDistanceFormCity,
    //                createCity(propertyCity, propertyDistrict, propertyState, cityRepository, districtRepository, stateRepository),
    //                propertyStreet, propertyPostalCode, propertyNumberOfBedrooms, propertyNumberOfBathrooms, propertyNumberParkingSpaces,
    //                centralHeating, airConditioning, sunExposure, basement, loft, propertyPrice, typeOfBusiness);
    //        advertisementRepository.addAdvertisement(advertisementInstance);
    //    }
    //
    //    /**
    //     * This method creates and saves the Apartment information.
    //     * @param propertyArea property area
    //     * @param propertyDistanceFormCity property distance from city
    //     * @param propertyStreet property street
    //     * @param propertyCity property city
    //     * @param propertyDistrict property district
    //     * @param propertyState property state
    //     * @param propertyPostalCode property postal code
    //     * @param propertyPrice property price
    //     * @param typeOfBusiness type of business
    //     * @param propertyNumberOfBedrooms number of bedrooms
    //     * @param propertyNumberOfBathrooms number of bathrooms
    //     * @param propertyNumberParkingSpaces number of parking spaces
    //     * @param centralHeating central heating
    //     * @param airConditioning air conditioning
    //     * @param cityRepository city repository
    //     * @param districtRepository district repository
    //     * @param stateRepository state repository
    //     * @param advertisementRepository advertisement repository
    //     */
    //    private void saveApartmentInformation(double propertyArea, double propertyDistanceFormCity, String propertyStreet,
    //                                          String propertyCity, String propertyDistrict, String propertyState,
    //                                          String propertyPostalCode, double propertyPrice, String typeOfBusiness,
    //                                          int propertyNumberOfBedrooms, int propertyNumberOfBathrooms,
    //                                          int propertyNumberParkingSpaces, String centralHeating, String airConditioning,
    //                                          CityRepository cityRepository, DistrictRepository districtRepository,
    //                                          StateRepository stateRepository, AdvertisementRepository advertisementRepository) {
    //        advertisementInstance = advertisementRepository.createApartmentAdvertisement(ownerInstance,
    //                createCity(propertyCity, propertyDistrict, propertyState, cityRepository, districtRepository, stateRepository),
    //                propertyStreet, propertyPostalCode, propertyArea, propertyDistanceFormCity, propertyNumberOfBedrooms,
    //                propertyNumberOfBathrooms, propertyNumberParkingSpaces, centralHeating, airConditioning, propertyPrice,
    //                typeOfBusiness);
    //        advertisementRepository.addAdvertisement(advertisementInstance);
    //        storeInstance.addAdvertisement(advertisementInstance);
    //    }
    //
    //    /**
    //     * This method creates and saves the Land information.
    //     * @param propertyArea property area
    //     * @param propertyDistanceFormCity property distance from city
    //     * @param propertyStreet property street
    //     * @param propertyCity property city
    //     * @param propertyDistrict property district
    //     * @param propertyState property state
    //     * @param propertyPostalCode property postal code
    //     * @param propertyPrice property price
    //     * @param typeOfBusiness type of business
    //     * @param cityRepository city repository
    //     * @param districtRepository district repository
    //     * @param stateRepository state repository
    //     * @param advertisementRepository advertisement repository
    //     */
    //    private void saveLandInformation(double propertyArea, double propertyDistanceFormCity, String propertyStreet,
    //                                     String propertyCity, String propertyDistrict, String propertyState,
    //                                     String propertyPostalCode, double propertyPrice, String typeOfBusiness,
    //                                     CityRepository cityRepository, DistrictRepository districtRepository,
    //                                     StateRepository stateRepository, AdvertisementRepository advertisementRepository) {
    //        advertisementInstance = advertisementRepository.createLandAdvertisement(propertyArea, propertyDistanceFormCity,
    //                createCity(propertyCity, propertyDistrict, propertyState, cityRepository, districtRepository,
    //                        stateRepository), propertyStreet, propertyPostalCode, ownerInstance,
    //                propertyPrice, typeOfBusiness);
    //        advertisementRepository.addAdvertisement(advertisementInstance);
    //        storeInstance.addAdvertisement(advertisementInstance);
    //    }
    //
    //    /**
    //     * This method creates and saves the Store information.
    //     * @param storeID store id
    //     * @param storeName store name
    //     * @param storePhoneNumber store phone number
    //     * @param storeEmail store email
    //     * @param storeStreet store street
    //     * @param storeCity store city
    //     * @param storeDistrict store district
    //     * @param storeState store state
    //     * @param storePostalCode store postal code
    //     * @param cityRepository city repository
    //     * @param districtRepository district repository
    //     * @param stateRepository state repository
    //     * @param storeRepository store repository
    //     */
    //    private void saveStoreInformation(int storeID, String storeName, String storePhoneNumber, String storeEmail,
    //                                      String storeStreet, String storeCity, String storeDistrict, String storeState,
    //                                      String storePostalCode, CityRepository cityRepository,
    //                                      DistrictRepository districtRepository, StateRepository stateRepository,
    //                                      StoreRepository storeRepository) {
    //        storeInstance = storeRepository.createStore(storeID, storeName, storePhoneNumber, storeEmail, storeStreet,
    //                createCity(storeCity, storeDistrict, storeState, cityRepository, districtRepository, stateRepository),
    //                storePostalCode);
    //        storeRepository.registerStore(storeInstance);
    //        storeInstance.addAdvertisement(advertisementInstance);
    //    }
    //
    //    /**
    //     * This method creates and saves the City information.
    //     * @param city city
    //     * @param district district
    //     * @param state state
    //     * @param cityRepository city repository
    //     * @param districtRepository district repository
    //     * @param stateRepository state repository
    //     * @return city
    //     */
    //    private City createCity(String city, String district, String state, CityRepository cityRepository,
    //                            DistrictRepository districtRepository, StateRepository stateRepository) {
    //        return cityRepository.createCity(city, createDistrict(district, state, districtRepository, stateRepository));
    //    }
    //
    //    /**
    //     * This method creates and saves the District information.
    //     * @param district district
    //     * @param state state
    //     * @param districtRepository district repository
    //     * @param stateRepository state repository
    //     * @return district
    //     */
    //    private District createDistrict(String district, String state, DistrictRepository districtRepository,
    //                                    StateRepository stateRepository) {
    //        return districtRepository.createDistrict(district, createState(state, stateRepository));
    //    }
    //
    //    /**
    //     * This method creates and saves the State information.
    //     * @param state state
    //     * @param stateRepository state repository
    //     * @return state
    //     */
    //    private State createState(String state, StateRepository stateRepository) {
    //        return stateRepository.createState(state);
    //    }
    //
    //    /**
    //     * This method saves the owner information.
    //     * @param email owner email
    //     * @param ownerName owner name
    //     * @param ownerPassportNumber owner passport number
    //     * @param ownerTaxNumber owner tax number
    //     * @param ownerPhone owner phone
    //     * @param personRepository person repository
    //     */
    //    private void saveOwnerInformation(Email email, String ownerName, String ownerPassportNumber, String ownerTaxNumber,
    //                                      String ownerPhone, PersonRepository personRepository) {
    //        ownerInstance = personRepository.createPerson(email, ownerName, ownerPassportNumber, ownerTaxNumber, ownerPhone);
    //        personRepository.registerClient(ownerInstance);
    //    }
    //
    //    /**
    //     * This method saves the information from a line.
    //     *
    //     * @param header header
    //     * @param info   information from the line for each column
    //     */
    //    public void saveInformationFromLine(String header, String info) {
    //        switch (header) {
    //            case STORE_EMAIL:
    //                setStoreEmail(info);
    //                break;
    //            case STORE_PHONE_NUMBER:
    //                setStorePhoneNumber(info);
    //                break;
    //            case STORE_LOCATION:
    //                String storeLocation[] = info.split(",");
    //                if (storeLocation.length == 5) {
    //                    setStoreStreet(storeLocation[0].trim());
    //                    setStoreCity(storeLocation[1].trim());
    //                    setStoreDistrict(storeLocation[2].trim());
    //                    setStoreState(storeLocation[3].substring(storeLocation[3].length() - 2));
    //                    setStorePostalCode(storeLocation[4].trim());
    //                } else if (storeLocation.length == 4) {
    //                    setStoreStreet(storeLocation[0].trim());
    //                    setStoreCity(storeLocation[1].trim());
    //                    setStoreState(storeLocation[2].substring(storeLocation[2].length() - 2));
    //                    setStorePostalCode(storeLocation[3].trim());
    //                }
    //                break;
    //            case STORE_NAME:
    //                setStoreName(info);
    //                break;
    //            case STORE_ID:
    //                setStoreID(Integer.parseInt(info));
    //                break;
    //            case TYPE_OF_BUSINESS:
    //                setTypeOfBusiness(info);
    //                break;
    //            case DATE_SALE:
    //                setDateSale(info);
    //                break;
    //            case ANNOUNCE_REQUEST_DATE:
    //                setAnnounceRequestDate(info);
    //                break;
    //            case CONTRACT_DURATION:
    //                setContractDuration(info);
    //                break;
    //            case COMMISSION:
    //                setCommission(info);
    //                break;
    //            case PROPERTY_PRICE:
    //                setPropertyPrice(Double.parseDouble(info));
    //                break;
    //            case PROPERTY_REQUESTED_PRICE:
    //                setPropertyRequestedPrice(info);
    //                break;
    //            case SUN_EXPOSURE:
    //                switch (info) {
    //                    case "N":
    //                        setSunExposure("North");
    //                        break;
    //                    case "S":
    //                        setSunExposure("South");
    //                        break;
    //                    case "E":
    //                        setSunExposure("East");
    //                        break;
    //                    case "W":
    //                        setSunExposure("West");
    //                        break;
    //                }
    //                break;
    //            case LOFT:
    //                switch (info) {
    //                    case "Y":
    //                        setLoft("Yes");
    //                        break;
    //                    case "N":
    //                        setLoft("No");
    //                        break;
    //                }
    //                break;
    //            case BASEMENT:
    //                switch (info) {
    //                    case "Y":
    //                        setBasement("Yes");
    //                        break;
    //                    case "N":
    //                        setBasement("No");
    //                        break;
    //                }
    //                break;
    //            case AIR_CONDITIONING:
    //                switch (info) {
    //                    case "Y":
    //                        setAirConditioning("Yes");
    //                        break;
    //                    case "N":
    //                        setAirConditioning("No");
    //                        break;
    //                }
    //                break;
    //            case CENTRAL_HEATING:
    //                switch (info) {
    //                    case "Y":
    //                        setCentralHeating("Yes");
    //                        break;
    //                    case "N":
    //                        setCentralHeating("No");
    //                        break;
    //                }
    //                break;
    //            case PROPERTY_NUMBER_PARKING_SPACES:
    //                if (!info.equals("NA"))
    //                    setPropertyNumberParkingSpaces(Integer.parseInt(info));
    //                break;
    //            case PROPERTY_NUMBER_OF_BATHROOMS:
    //                if (!info.equals("NA"))
    //                    setPropertyNumberOfBathrooms(Integer.parseInt(info));
    //                break;
    //            case PROPERTY_NUMBER_OF_BEDROOMS:
    //                if (!info.equals("NA"))
    //                    setPropertyNumberOfBedrooms(Integer.parseInt(info));
    //                break;
    //            case PROPERTY_DISTANCE_FROM_CENTER:
    //                setPropertyDistanceFormCity(Double.parseDouble(info));
    //                break;
    //            case PROPERTY_LOCATION:
    //                String[] propertyLocation = info.split(",");
    //                if (propertyLocation.length == 4) {
    //                    setPropertyStreet(propertyLocation[0].trim());
    //                    setPropertyCity(propertyLocation[1].trim());
    //                    setPropertyState(propertyLocation[2].trim());
    //                    setPropertyPostalCode(propertyLocation[3].trim());
    //                } else if (propertyLocation.length == 8) {
    //                    setPropertyStreet(propertyLocation[0] + "," + propertyLocation[1] + "," + propertyLocation[2] + ","
    //                            + propertyLocation[3]);
    //                    setPropertyCity(propertyLocation[4].trim());
    //                    setPropertyDistrict(propertyLocation[5].trim());
    //                    setPropertyState(propertyLocation[6].substring(propertyLocation[6].length() - 2));
    //                    setPropertyPostalCode(propertyLocation[7].trim());
    //                } else if (propertyLocation.length == 7) {
    //                    setPropertyStreet(propertyLocation[0] + "," + propertyLocation[1] + "," + propertyLocation[2] + ","
    //                            + propertyLocation[3]);
    //                    setPropertyCity(propertyLocation[4].trim());
    //                    setPropertyState(propertyLocation[5].trim());
    //                    setPropertyPostalCode(propertyLocation[6].trim());
    //                }
    //                break;
    //            case PROPERTY_AREA:
    //                setPropertyArea(Double.parseDouble(info));
    //                break;
    //            case PROPERTY_TYPE:
    //                setPropertyType(info);
    //                break;
    //            case OWNER_PHONE:
    //                setOwnerPhone(info);
    //                break;
    //            case OWNER_EMAIL:
    //                setOwnerEmail(info);
    //                break;
    //            case OWNER_TAX_NUMBER:
    //                setOwnerTaxNumber(info);
    //                break;
    //            case OWNER_PASSPORT_NUMBER:
    //                setOwnerPassportNumber(info);
    //                break;
    //            case OWNER_NAME:
    //                setOwnerName(info);
    //                break;
    //        }
    //
    //    }
    //}
}
