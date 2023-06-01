package pt.ipp.isep.dei.esoft.project.domain;

public class Offer {

    // ATTRIBUTES
    private Announcement announcement;
    private double offerPrice;

    /**
     * Creates a new request with all the attributes
     * @param announcement announcement
     * @param offerPrice ammount offered for the property
     */
    public Offer(Announcement announcement, double offerPrice) {
        this.announcement = announcement;
        this.offerPrice = offerPrice;
    }

    /**
     * Getters
     */
    public Announcement getAnnouncement() {
        return announcement;
    }

    public double getOfferPrice() {
        return offerPrice;
    }


    public Offer clone() {
        return new Offer(this.announcement, this.offerPrice);
    }

    @Override
    public String toString() {
        return "Offer:" +
                "Property =" + announcement +
                ", Offer Price =" + offerPrice;
    }
    
}
