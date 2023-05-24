package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.User;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class RegisterAnnouncementController {

    Repositories repositories = Repositories.getInstance();

    public boolean checkEmail(String email) {
        return (User.existsEmail(email));
    }

    public boolean checkArea(double area) {return (Property.existsArea(area));}

    public boolean checkDoorNumber(int doorNumber) {return (Address.existsDoorNumber(doorNumber));}

    public boolean checkZipCode(String zipCode) {return (Address.existsZipCode(zipCode));}

    public boolean checkDistanceFromCityCenter(double distanceFromCityCenter) {return (Property.existsDistanceFromCityCenter(distanceFromCityCenter));}

    public boolean checkPrice(double price) {return (Property.existsPrice(price));}

}
