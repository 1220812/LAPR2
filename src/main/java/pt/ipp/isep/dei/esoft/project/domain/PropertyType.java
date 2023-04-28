package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class PropertyType {
    private final String designation;

    public PropertyType(String designation) {
        this.designation = designation;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PropertyType)) {
            return false;
        }
        PropertyType that = (PropertyType) o;
        return designation.equals(that.designation);
    }

    public int hashCode(){
        return Objects.hash(designation);
    }

    /**
     * This method returns the description of the property type.
     *
     * @return The description of the property type.
     */
    public String getDesignation() {
        return designation;
    }
}