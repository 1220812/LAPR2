package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

public class CreateRequestController {
    private State state;
    private double area;
    private double distanceFromCityCentre;
    private double price;
    private String doorNumber;
    private String floorNumber;
    private String street;
    private String postalCode;
    private Address address;
    private Property property;
    private Residence residence;
    private House house;

    public CreateRequestController (){
        this.state = null;
    }
    public void createState(String state){
        this.state = new State(state);
    }
    public void createAddress( String floorNumber,String street, String postalCode){
        this.address = new Address(floorNumber, "2", street,postalCode, this.state);
    }
    public void createProperty(double area, double distanceFromCityCentre, double price, List<String> photographs){
        this.property = new Property(area,distanceFromCityCentre,this.address, photographs, price);
    }
    public void createResidence (int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces, String availableEquipment, double distanceFromCityCentre, double area, List<String> photograph, double price){
        this.residence = new Residence(this.address,area,distanceFromCityCentre,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,price,photograph,availableEquipment);
    }
    public void createHouse (int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces, String availableEquipment, double distanceFromCityCentre, double area, List<String> photograph, double price, String inhabitableLoft, String existenceOfAbasement, String sunExposure  ){
        this.house = new House(this.address, area,distanceFromCityCentre,numberOfBathrooms,numberOfBedrooms,numberOfParkingSpaces,price,photograph,availableEquipment,existenceOfAbasement,sunExposure,inhabitableLoft);
    }
    public List<String> getAgencyList(){
        return AgencyRepository.getAgency();
    }
}