package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.City;

import java.util.ArrayList;

public class CityRepository {

    private static ArrayList<City> cityList = new ArrayList<>();

    public static void addCity(City city){
        cityList.add(city);
    }
    public static ArrayList<City> getCityList(){
        return cityList;
    }
    public static City CreateCity(String name){
        return new City(name);
    }
}