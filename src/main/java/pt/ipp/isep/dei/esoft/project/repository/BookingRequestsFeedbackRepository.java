package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.BookingRequestFeedback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Booking requests feedback repository.
 */
public class BookingRequestsFeedbackRepository implements Serializable {

    private List<BookingRequestFeedback> BookingRequestFeedbackList = new ArrayList<>();

    /**
     * Instantiates a new Booking requests feedback repository.
     */
    public BookingRequestsFeedbackRepository() {
        BookingRequestFeedbackList = new ArrayList<>();
    }

    /**
     * Add feedback response.
     *
     * @param requestFeedback the request feedback
     */
    public void addFeedbackResponse(BookingRequestFeedback requestFeedback) {
        BookingRequestFeedbackList.add(requestFeedback);
    }

    /**
     * Get booking request feedback list list.
     *
     * @return the list
     */
    public List<BookingRequestFeedback> getBookingRequestFeedbackList(){
        return BookingRequestFeedbackList;
    }

}
