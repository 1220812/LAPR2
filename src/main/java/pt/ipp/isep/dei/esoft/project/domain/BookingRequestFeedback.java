package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class BookingRequestFeedback {

    private String finalFeedback;
    private String justification;

    public BookingRequestFeedback(String finalFeedback, String justification) {
        this.finalFeedback = finalFeedback;
        this.justification = justification;
    }

    public String getFinalFeedback() {
        return finalFeedback;
    }

    public void setFinalFeedback(String finalFeedback) {
        this.finalFeedback = finalFeedback;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingRequestFeedback)) return false;
        BookingRequestFeedback that = (BookingRequestFeedback) o;
        return Objects.equals(finalFeedback, that.finalFeedback) && Objects.equals(justification, that.justification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalFeedback, justification);
    }

    @Override
    public String toString() {
        return "Booking Request Feedback" +
                "Final Response:'" + finalFeedback + '\'' +
                ", Justification:'" + justification;
    }
}
