package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.City;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    private List<City> cityList = new ArrayList<>();

    public void addCity(City city){
        if(validateCity(city)){
            cityList.add(city);
        }
    }
    public boolean validateCity(City city){
        return !this.cityList.contains(city);
    }
    public List<City> getCityList(){
        return List.copyOf(this.cityList);
    }
    public static City CreateCity(String name){
        return new City(name);
    }
}