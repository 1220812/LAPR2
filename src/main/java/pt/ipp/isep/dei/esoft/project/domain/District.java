package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * The type District.
 */
public class District implements Serializable {
    /**
     * District name
     */
    private String name;
    /**
     * Default district name
     */
    private static final String DEFAULT_NAME="none";

    /**
     * Creates a new instance of district with name
     *
     * @param name district name
     */
    public District (String name){
        this.name = name;
    }

    /**
     * Creates a new instance of district with name by default
     */
    public District(){
        this.name = DEFAULT_NAME;
    }

    /**
     * Method to show the name of the district
     *
     * @return district name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to change the name of the district
     *
     * @param name changed district name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that provides the district characteristics
     * @return district characteristics
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * This method creates a clone of the district object
     * @return clone of the district object
     */
    public District clone(){
        return new District(this.name);
    }
}