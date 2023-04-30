package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class CreateRequestController {
    private State state;
    private String doorNumber;
    private String floorNumber;
    private String street;
    private String postalCode;
    private Address address;

    public CreateRequestController (){
        this.state = null;
    }
    public void createState(String state){
        this.state = new State(state);
    }
    public void createAddress(String doorNumber, String floorNumber, String street, State state, String postalCode){
        this.address = new Address(doorNumber, floorNumber,postalCode,street,state);
    }
}