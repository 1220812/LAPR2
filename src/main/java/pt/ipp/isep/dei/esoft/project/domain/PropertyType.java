package pt.ipp.isep.dei.esoft.project.domain;

public enum PropertyType {
    HOUSE("House"), LAND("Land"), APARTMENT("Apartment");

    PropertyType(String description) {
        this.description = description;
    }

    private String description;

    @Override
    public String toString() {
        return description;
    }
}