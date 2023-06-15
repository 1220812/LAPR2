package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.City;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepository implements Serializable {

    private final List<City> cityList = new ArrayList<>();

    public Optional<City> addCity(City city){
        Optional<City> newCity = Optional.empty();
        boolean operationSuccess = false;
        if (validateCity(city)) {
            newCity = Optional.of(city.clone());
            operationSuccess = cityList.add(newCity.get());
        }

        if (!operationSuccess) {
            newCity = Optional.empty();
        }

        return newCity;
    }

    public boolean validateCity(City city){
        boolean isValid = !cityList.contains(city);
        return isValid;
    }
    public boolean add(City city){
        boolean addCity = false;
        if(validateCity(city)){
            addCity = cityList.add(city);
        }
        return addCity;
    }
    public List<City> getCityList(){
        return List.copyOf(this.cityList);
    }
    public static City CreateCity(String name){
        return new City(name);
    }
}