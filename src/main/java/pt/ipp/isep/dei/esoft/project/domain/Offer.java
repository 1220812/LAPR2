package pt.ipp.isep.dei.esoft.project.domain;

public class Offer {

    // ATTRIBUTES
    private Property property;
    private double offerPrice;

    /**
     * Creates a new request with all the attributes
     * @param property property
     * @param offerPrice ammount offered for the property
     */
    public Offer(Property property, double offerPrice) {
        this.property = property;
        this.offerPrice = offerPrice;
    }

    /**
     * Getters
     */
    public Property getProperty() {
        return property;
    }

    public double getOfferPrice() {
        return offerPrice;
    }


    public Offer clone() {
        return new Offer(this.property, this.offerPrice);
    }

    @Override
    public String toString() {
        return "Offer:" +
                "Property =" + property +
                ", Offer Price =" + offerPrice;
    }
    
}
