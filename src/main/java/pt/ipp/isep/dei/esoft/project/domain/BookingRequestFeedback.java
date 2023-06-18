package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Booking request feedback.
 */
public class BookingRequestFeedback implements Serializable {

    private String finalFeedback;
    private String justification;

    /**
     * Instantiates a new Booking request feedback.
     *
     * @param finalFeedback the final feedback
     * @param justification the justification
     */
    public BookingRequestFeedback(String finalFeedback, String justification) {
        this.finalFeedback = finalFeedback;
        this.justification = justification;
    }

    /**
     * Gets final feedback.
     *
     * @return the final feedback
     */
    public String getFinalFeedback() {
        return finalFeedback;
    }

    /**
     * Sets final feedback.
     *
     * @param finalFeedback the final feedback
     */
    public void setFinalFeedback(String finalFeedback) {
        this.finalFeedback = finalFeedback;
    }

    /**
     * Gets justification.
     *
     * @return the justification
     */
    public String getJustification() {
        return justification;
    }

    /**
     * Sets justification.
     *
     * @param justification the justification
     */
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
