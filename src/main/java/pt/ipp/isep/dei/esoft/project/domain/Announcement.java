package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
public class Announcement {
    /**
     * announcement publish date
     */
    private String date;
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
    private PropertyType propertyType;


    public Announcement(Property property, String date, String comissionType, double comission, RequestType requestType, PropertyType propertyType) {
        this.property = property;
        this.date = date;
        this.comissionType = comissionType;
        this.comission = comission;
        this.requestType = requestType;
        this.propertyType=propertyType;
    }
    public Announcement(Property property, String date){
        this.property = property;
        this.date = date;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "date='" + date + '\'' +
                ", property=" + property +
                ", comissionType='" + comissionType + '\'' +
                ", comission=" + comission +
                ", requestType=" + requestType +
                ", propertyType=" + propertyType +
                '}';
    }

    public Announcement clone(){
        return  new Announcement(this.property,this.date,this.comissionType,this.comission,this.requestType,this.propertyType);
    }

    public static boolean existsPrice(double price){
        if (price < 1) { return false; }
        else return true;
    }
}
