package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
public class PublishedAnnouncement {

    private Property property;

    private String date;
    private static final String DATE_POR_OMISSAO = "without date";

    public PublishedAnnouncement(Property property, String date) {
        this.property=property;
        this.date = date;
    }

    public PublishedAnnouncement() {
        date = DATE_POR_OMISSAO;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PublishedAnnouncement)) {
            return false;
        }
        PublishedAnnouncement that = (PublishedAnnouncement) o;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return (super.toString() +
                "\nAnnouncement:\n" +
                "date - " + date + "\n");
    }

    public Property getProperty() {
        return property;
    }

}
