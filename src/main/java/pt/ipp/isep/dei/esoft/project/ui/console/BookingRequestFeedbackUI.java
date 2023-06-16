package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.BookingRequestFeedbackController;
import pt.ipp.isep.dei.esoft.project.domain.BookingRequestFeedback;
//import pt.ipp.isep.dei.esoft.project.domain.Booking request agent's response;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;
import java.util.Objects;
public class BookingRequestFeedbackUI implements Runnable{

    private BookingRequestFeedbackController controller;

    public BookingRequestFeedbackUI(BookingRequestFeedbackController controller) {
        this.controller = controller;
    }

    public void run(){

        String finalFeedback = null;
        String justification = null;
        BookingRequestFeedback bookingRequestFeedback = new BookingRequestFeedback(finalFeedback, justification);

        System.out.println();
        System.out.println("Choose an appointment request to answer:");
        System.out.println();


    }
}
