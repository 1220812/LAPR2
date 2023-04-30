package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.domain.City;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CityRepository {

    private List<State> stateList;

    public List<State> getStateList() {
        return stateList;
    }

    public void registerState(State state) {
        stateList.add(state);
    }

    private static final Map<String, City> cities= new HashMap<>();

    public City getCityByName(String cityName){
        return cities.get(cityName);
    }

    public void addCity(City city){
        cities.put(city.getName(), city);
    }
    public boolean checkDesignation(String designation) {
        for (State state : stateList) {
            if (state.getName().equals(designation)) {
                return true;
            }
        }
        return false;
    }

}