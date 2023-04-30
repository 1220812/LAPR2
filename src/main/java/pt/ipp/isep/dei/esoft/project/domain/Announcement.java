package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
public class Announcement {

    private Property property = new Property();

    private String date;
    private static final String DATE_POR_OMISSAO = "no date";

    public Announcement(Property property, String date) {
        this.property = property;
        this.date = date;
    }

    public Announcement() {
        date = DATE_POR_OMISSAO;
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

    @Override
    public String toString() {
        return (property.toString() +
                "date - " + date + "\n");
    }



}
