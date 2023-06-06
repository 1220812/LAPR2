package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;

public class Announcement {
    /**
     * announcement property
     */
    private Property property;
    /**
     * announcement commision type
     */
    private String comissionType;
    /**
     * announcement comission
     */
    private double comission;

    private RequestType requestType;

    private Agent agent;
    /**
     * announcement publish date
     */
    private LocalDate date;

    private double price;

    private Owner owner;


    public Announcement(Property property, LocalDate date, String comissionType, double comission, RequestType requestType, Agent agent, double price, Owner owner) {
        this.property = property;
        this.date = date;
        this.comissionType = comissionType;
        this.comission = comission;
        this.requestType = requestType;
        this.agent=agent;
        this.price= price;
        this.owner = owner;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    public String getComissionType() {
        return comissionType;
    }

    public void setComissionType(String comissionType) {
        this.comissionType = comissionType;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "property=" + property +
                ", comissionType='" + comissionType + '\'' +
                ", comission=" + comission +
                ", requestType=" + requestType +
                ", agent=" + agent +
                ", date=" + date +
                ", price=" + price +
                ", owner=" + owner +
                '}';
    }

    public Announcement clone(){
        return  new Announcement(this.property,this.date,this.comissionType,this.comission,this.requestType, this.agent,this.price, this.owner);
    }
    public static boolean existsPrice(double price){
        if (price < 1) { return false; }
        else return true;
    }

    public Agent getAgent() {
        return agent;
    }
}
