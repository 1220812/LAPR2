package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationRepository {
    private static List<Location> locationList;
    public LocationRepository(){
        locationList = new ArrayList<>();
    }
    public List<Location> getLocationList(){
        return locationList;
    }
    public static void registerLocation(Location location){
        locationList.add(location);
    }
    public static Location createLocation(String street, String doorNumber, String floorNumber, String postalCode, String city, String district, String state){
        Location location = new Location (street, doorNumber,floorNumber, postalCode,city, district,state);
        registerLocation(location);
        return location;
    }

}