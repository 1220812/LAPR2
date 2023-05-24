package pt.ipp.isep.dei.esoft.project.domain;

public class PropertyType {

    private String propertyType;


    public PropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return propertyType;
    }
}