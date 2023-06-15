package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

public class PropertyType implements Serializable {
    /**
     * Property type
     */
    private String propertyType;

    /**
     * Method that creates a new instance of property type
     * @param propertyType property type
     */
    public PropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * Method that returns the property type characteristics
     * @return property type
     */
    @Override
    public String toString() {
        return propertyType;
    }
}