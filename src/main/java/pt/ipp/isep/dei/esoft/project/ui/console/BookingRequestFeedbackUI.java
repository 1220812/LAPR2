package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.BookingRequestFeedbackController;
import pt.ipp.isep.dei.esoft.project.domain.BookingRequestFeedback;
//import pt.ipp.isep.dei.esoft.project.domain.Booking request agent's response;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.CurrentSession;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;
import java.util.Objects;

/**
 * The type Booking request feedback ui.
 */
public class BookingRequestFeedbackUI implements Runnable{

    private BookingRequestFeedbackController controller;

    /**
     * Instantiates a new Booking request feedback ui.
     *
     * @param controller the controller
     */
    public BookingRequestFeedbackUI(BookingRequestFeedbackController controller) {
        this.controller = controller;
    }

    public void run(){

        Client client = controller.getCurrentClient();
        String finalFeedback = null;
        String justification = null;
        BookingRequestFeedback bookingRequestFeedback = new BookingRequestFeedback(finalFeedback, justification);

        List<Message> listMessages = controller.getRequestCompletedList(client);

        List<String> listReplies = controller.getRepliesByClient(listMessages);

        System.out.println(listReplies.toString());

        int selectedReplyNumber = Utils.readIntegerFromConsole("Choose an agent reply from the above to answer:");
        while (selectedReplyNumber < 1 || selectedReplyNumber > listReplies.size()){
            selectedReplyNumber = Utils.readIntegerFromConsole("Select a valid agent reply:");
        }
        String chosenReply = listReplies.get(selectedReplyNumber - 1);
        Message chosenMessage = listMessages.get(selectedReplyNumber - 1);

        System.out.println(chosenMessage.toString());

        do {
            finalFeedback = Utils.readLineFromConsole("Do you intend to accept the appointment? (please answer with 'Yes' or 'No'): ");
        } while ( !finalFeedback.equals("Yes") && !finalFeedback.equals("No"));

        if(finalFeedback.equals("No")) {
            do {
                bookingRequestFeedback.setJustification(Utils.readLineFromConsole("Type the justification for rejecting the appointment: "));
            } while (Objects.isNull(bookingRequestFeedback.getJustification()));
        } else {
            bookingRequestFeedback.setJustification("The appointment has been accepted.");
        }

        controller.getBookingRequestsFeedbackRepository().addFeedbackResponse(bookingRequestFeedback);
        System.out.println();
        System.out.println("Your answer to the agent reply was submitted successfully!");


    }
}
