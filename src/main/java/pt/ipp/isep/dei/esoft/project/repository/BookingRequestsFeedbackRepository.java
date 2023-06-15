package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.BookingRequestFeedback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookingRequestsFeedbackRepository implements Serializable {

    private List<BookingRequestFeedback> BookingRequestFeedbackList = new ArrayList<>();

    public BookingRequestsFeedbackRepository() {
        BookingRequestFeedbackList = new ArrayList<>();
    }

    public void addFeedbackResponse(BookingRequestFeedback requestFeedback) {
        BookingRequestFeedbackList.add(requestFeedback);
    }

    public List<BookingRequestFeedback> getBookingRequestFeedbackList(){
        return BookingRequestFeedbackList;
    }

}
