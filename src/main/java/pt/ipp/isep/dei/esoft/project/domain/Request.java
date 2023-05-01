package pt.ipp.isep.dei.esoft.project.domain;
import java.util.Objects;

public class Request {
    // ATTRIBUTES
    private Property property;
    private double price;
    private String type;
    // CONSTRUCTORS

    public Request(Property property, double price, String type) {
        if (property == null){
            throw new IllegalArgumentException("Property must not be null");
        }
        if (price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (type == null ){
            throw new IllegalArgumentException("Invalid property type");
        }
        this.property = property;
        this.price = price;
        this.type = type;
    }

    /**
     * Method to show the property
     * @return property
     */

    public Property getProperty() {
        return property;
    }

    /**
     * Method to change the property
     * @param property property
     */

    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Method to show the price
     * @return price
     */

    public double getPrice() {
        return price;
    }

    /**
     * Method to change the price
     * @param price
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method to show the type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Method to change the type
     * @param type type
     */

    public void setType(String type) {
        this.type = type;
    }

    public Request clone(){
        return new Request(this.property, this.price, this.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request that = (Request) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(property, that.property) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, price, type);
    }

    @Override
    public String toString() {
        return "AnnouncementRequest{" +
                "property=" + property +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}