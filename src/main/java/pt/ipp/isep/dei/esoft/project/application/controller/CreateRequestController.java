package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;

public class CreateRequestController {
    private PropertyType propertyType;
    private City city;
    private District district;
    private State state;

    private RequestType requestType;

    public ArrayList<PropertyType> getPropertiesTypeList(){
        return Repositories.getInstance().getPropertyTypeListRepository().getPropertiesTypeList();
    }
    public PropertyType CreatePropertyType(String name){
        propertyType = Repositories.getInstance().getPropertyTypeListRepository().CreatePropertyType(name);
        return propertyType;
    }
    public ArrayList<City> getCityList(){
        return Repositories.getInstance().getCityRepository().getCityList();
    }
    public City CreateCity(String name){
        city = Repositories.getInstance().getCityRepository().CreateCity(name);
        return city;
    }
    public ArrayList<State> getStateList(){
        return Repositories.getInstance().getStateRepository().getStateList();
    }
    public State CreateState(String name){
        state = Repositories.getInstance().getStateRepository().CreateState(name);
        return state;
    }
    public ArrayList<District> getDistrictList(){
        return Repositories.getInstance().getDistrictRepository().getDistrictList();
    }
    public District CreateDistrict(String name){
        district = Repositories.getInstance().getDistrictRepository().CreateDistrict(name);
        return district;
    }
    public ArrayList<RequestType> getRequestTypeList(){
        return Repositories.getInstance().getRequestTypeRepository().getRequestTypeList();
    }
    public RequestType CreateRequestType(String name){
        requestType = Repositories.getInstance().getRequestTypeRepository().CreateRequestType(name);
        return requestType;
    }
    public Property createProperty(double area, double distanceFromCityCenter, Address address, double price){
        return new Property(area, distanceFromCityCenter, address, price);
    }
    public House createHouse(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, String availableEquipment, String basement, String sunExposure, String inhabitableLoft,double price ){
        return new House(address,area,distanceFromCityCentre,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,availableEquipment,basement,sunExposure,inhabitableLoft,price);
    }
    public Residence createResidence(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, double price, String availableEquipment){
        return new Residence(address, area, distanceFromCityCentre, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, price, availableEquipment);
    }
}
