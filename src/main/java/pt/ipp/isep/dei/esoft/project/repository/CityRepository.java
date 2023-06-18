package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.City;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type City repository.
 */
public class CityRepository implements Serializable {

    private final List<City> cityList = new ArrayList<>();

    /**
     * Add city optional.
     *
     * @param city the city
     * @return the optional
     */
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

    /**
     * Validate city boolean.
     *
     * @param city the city
     * @return the boolean
     */
    public boolean validateCity(City city){
        boolean isValid = !cityList.contains(city);
        return isValid;
    }

    /**
     * Add boolean.
     *
     * @param city the city
     * @return the boolean
     */
    public boolean add(City city){
        boolean addCity = false;
        if(validateCity(city)){
            addCity = cityList.add(city);
        }
        return addCity;
    }

    /**
     * Get city list list.
     *
     * @return the list
     */
    public List<City> getCityList(){
        return List.copyOf(this.cityList);
    }

    /**
     * Create city city.
     *
     * @param name the name
     * @return the city
     */
    public static City CreateCity(String name){
        return new City(name);
    }
}