package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepository {

    private List<City> cityList = new ArrayList<>();

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
    public List<City> getCityList(){
        return List.copyOf(this.cityList);
    }
    public static City CreateCity(String name){
        return new City(name);
    }
}