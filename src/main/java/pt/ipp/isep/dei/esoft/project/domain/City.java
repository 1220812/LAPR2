package pt.ipp.isep.dei.esoft.project.domain;

public class City{
    /**
     * City name
     */
    private String name;

    /**
     * Creates a new instance of City with name
     * @param name city name
     */
    public City (String name){
        this.name = name;
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
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}