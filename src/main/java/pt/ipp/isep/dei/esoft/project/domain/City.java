package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class City implements Serializable {
    /**
     * City name
     */
    private String name;
    /**
     * City name by default
     */
    private static final String DEFAULT_NAME = "no name";

    /**
     * Creates a new instance of City with name
     * @param name city name
     */
    public City (String name){
        this.name = name;
    }

    /**
     * Creates a new instance of City with name by default
     */
    public City(){
        this.name = DEFAULT_NAME;
    }

    /**
     * Method to show the city name
     * @return name city name
     */
    public String getName() {
        return name;
    }

    /**
     * Method tho change the city name
     * @param name changed city name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that provides the city characteristics
     * @return city characteristics
     */
    @Override
    public String toString() {
        return name;
    }
    /**
     * Method that creates a clone of the city object
     * @return clone of the city object
     */
    public City clone(){
        return new City(this.name);
    }
}