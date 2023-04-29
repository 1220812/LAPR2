package pt.ipp.isep.dei.esoft.project.domain;

public class Address {
    private String street;

    private String zipCode;

    private static final String DEFAULT_STREET="unregistered";

    private static final String DEFAULT_ZIPCODE="none";

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    public Address() {
        street=DEFAULT_STREET;
        zipCode=DEFAULT_ZIPCODE;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
