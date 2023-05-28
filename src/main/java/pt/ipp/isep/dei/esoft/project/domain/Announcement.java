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


    public Announcement(Property property, String date, String comissionType, double comission, RequestType requestType) {
        this.property = property;
        this.date = date;
        this.comissionType = comissionType;
        this.comission = comission;
        this.requestType = requestType;
    }
    public Announcement(Property property, String date){
        this.property = property;
        this.date = date;
    }

//    public static List<Announcement> getSortedProperties() {
//        return annoucement;
//    }

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

    @Override
    public String toString() {
        return "Announcement{" +
                "date=" + date +
                ", property=" + property +
                ", comissionType='" + comissionType + '\'' +
                ", comission=" + comission +
                '}';
    }


    public Announcement clone(){
        return  new Announcement(this.property,this.date,this.comissionType,this.comission,this.requestType);
    }

    public static boolean existsPrice(double price){
        if (price < 1) { return false; }
        else return true;
    }
}
