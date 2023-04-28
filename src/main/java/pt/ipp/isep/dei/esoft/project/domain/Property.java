package pt.ipp.isep.dei.esoft.project.domain;

public class Property {

    /**
     * Area of property.
     */
    private Double area;

    /**
     * Distance from the center of property.
     */
    private Double distanceFromCityCenter;

    /**
     * Price of property.
     */
    private Double price;

    /**
     * Photographs of property.
     */
    private String photograph;


    /**
     * Constructs a property instance receiving the area, the distance from the city center, the price and photographs.
     *
     * @param area               area of property
     * @param distanceFromCityCenter distance from the center of property
     * @param price     price of the property
     * @param photographs        photographs of property
     */
    public Property(double area, double distanceFromCityCenter, double price, String photographs) {
        this.area = area;
        this.distanceFromCityCenter = distanceFromCityCenter;
        this.price = price;
        this.photograph = photographs;
    }

    public Property() {

    }

    /**
     * Returns the area of property.
     *
     * @return area of property
     */
    public Double getArea() {
        return area;
    }

    /**
     * Returns the distance from city center of property.
     *
     * @return distance from the city center
     */
    public Double getDistanceFromCityCenter() {
        return distanceFromCityCenter;
    }

    /**
     * Returns the price of property.
     *
     * @return price of property
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Returns the photographs of property.
     *
     * @return photographs of property
     */
    public String getPhotographs() {
        return photograph;
    }

    /**
     * Modifies the area of property.
     *
     * @param area area of property
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * Modifies the distance from the city center.
     *
     * @param distanceFromCityCenter distance from the city center
     */
    public void setDistanceFromCityCenter(Double distanceFromCityCenter) {
        this.distanceFromCityCenter = distanceFromCityCenter;
    }

    /**
     * Modifies the price of the property.
     *
     * @param price price of the property
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Modifies the photographs of the property.
     *
     * @param photographs photographs of the property
     */
    public void setPhotographs(String photographs) {
        this.photograph = photographs;
    }


    @Override
    public String toString() {
        return String.format("Area: " + area + "%nCity Center Distance: " + distanceFromCityCenter + "%nRequested Price: " + price + "%nPhotographs" + photograph);
    }
}