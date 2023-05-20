package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

public class RegisterStoreController {
    private Repositories repositories;
    private Store storeInstance;
    private State stateInstance;
    private Localization localizationInstance;
    private District districtInstance;
    private City cityInstance;

    public RegisterStoreController() {
        repositories=Repositories.getInstance();
    }

    public Store getStoreInstance(int ID, String designation, int phoneNumber, String emailAddress, String location, Localization localization) {
        if (storeInstance ==null){
            storeInstance=new Store(designation, location, phoneNumber, emailAddress, ID, localization);
        }
        return storeInstance;
    }

    public State getStateInstance(String name) {
        if (stateInstance == null) {
            stateInstance = new State(name);
        }
        return stateInstance;
    }

    public void setStateInstance(State state) {
        this.stateInstance = state;
    }

    public Localization getLocationInstance(String street, String doorNumber, String floorNumber, String postalCode, String city, String district, String state) {
        if (localizationInstance == null) {
            localizationInstance = new Localization(street,doorNumber, floorNumber, postalCode, city, district, state);
        }
        return localizationInstance;

    }

    public District getDistrictInstance(String name) {
        if (districtInstance == null) {
            districtInstance = new District(name);
        }
        return districtInstance;
    }

    public void setDistrictInstance(District district) {
        this.districtInstance = district;
    }

    public City getCityInstance(String name) {
        if (cityInstance == null) {
            cityInstance = new City(name);
        }
        return cityInstance;
    }

    public void setCityInstance(City city) {
        this.cityInstance = city;
    }
    public boolean getCheckIfStateListIsEmpty(){
        return repositories.getStateRepository().getStateList().isEmpty();
    }
    public List<State> getStateList(){
        return repositories.getStateRepository().getStateList();
    }
    public Store getCreateStore(int ID, String designation, int phoneNumber, String emailAddress, String location, Localization localization){
        if (storeInstance == null) {
            storeInstance = new Store(designation,location,phoneNumber,emailAddress,ID,localization);
        }
        storeInstance.setID(ID);
        storeInstance.setDesignation(designation);
        storeInstance.setPhoneNumber(phoneNumber);
        storeInstance.setEmailAddress(emailAddress);
        storeInstance.setLocation(location);
        storeInstance.setLocalization(localization);
        return storeInstance;

    }
    public Localization getCreateLocation(String street, String doorNumber, String floorNumber, String postalCode, String city, String district , String state){
        if(localizationInstance ==null){
            localizationInstance = LocalizationRepository.createLocation(street,floorNumber,doorNumber,postalCode,city, district,state);
        }
        localizationInstance.setStreet(street);
        localizationInstance.setFloorNumber(floorNumber);
        localizationInstance.setDoorNumber(doorNumber);
        localizationInstance.setPostalCode(postalCode);
        localizationInstance.setCity(city);
        localizationInstance.setDistrict(district);
        localizationInstance.setState(state);
        return localizationInstance;

    }
    public void getRegisterStore(){
        repositories.getStoreRepository().registerStore(storeInstance);
    }
    public void getRegisterLocation(){
        repositories.getLocationRepository().registerLocation(this.localizationInstance);
    }
}