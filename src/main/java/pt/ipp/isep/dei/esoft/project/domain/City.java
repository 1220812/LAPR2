package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

/**
 The City class represents a city with a name.
 */
public class City {
    /**
     The name of the City.
     */
    private String name;

    /**
     * Creates a City object with the given name.
     * @param name the name of the city.
     */
    public City(String name) {
        this.name = name;
    }
    /**
     * Returns the name of the City.
     * @return the name of the City.
     */
    public String getName() {
        return name;
    }

    /**
     Sets the name of the City.
     * @param name of the City.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compares two City objects for equality based on their name fields.
     * @param o the object to compare to this City object.
     * @return true if the objects are equal, false otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof City)){
            return false;
        }
        City city = (City) o;
        return Objects.equals(name, city.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Textual representation of an instance of Address
     */
    @Override
    public String toString() {
        return "City{" + name + "}";
    }
}