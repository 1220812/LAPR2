package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.BookingRequestFeedbackController;
import pt.ipp.isep.dei.esoft.project.application.controller.RespondBookingRequestController;
import pt.ipp.isep.dei.esoft.project.domain.*;
//import pt.ipp.isep.dei.esoft.project.domain.Booking request agent's response;

import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BookingRequestFeedbackUI implements Runnable{

    private BookingRequestFeedbackController controller= new BookingRequestFeedbackController();


    public void run(){

        Client client = controller.getCurrentClient();
        String finalFeedback = null;
        String justification = null;

        List<Message> listMessages = controller.getRequestCompletedList(client);

        List<String> listReplies = controller.getRepliesByClient(listMessages);

        if(listMessages.isEmpty())
            System.out.println("No new messages");
        else {

            System.out.println(listReplies.toString());


            int selectedReplyNumber = Utils.readIntegerFromConsole("Choose an agent reply from the above to answer:");
            while (selectedReplyNumber < 1 || selectedReplyNumber > listReplies.size()) {
                selectedReplyNumber = Utils.readIntegerFromConsole("Select a valid agent reply:");
            }
            String chosenReply = listReplies.get(selectedReplyNumber - 1);
            Message chosenMessage = listMessages.get(selectedReplyNumber - 1);

            System.out.println(chosenMessage.toString());

            do {
                finalFeedback = Utils.readLineFromConsole("Do you intend to accept the appointment? (please answer with 'Yes' or 'No'): ");
            } while (!finalFeedback.equals("Yes") && !finalFeedback.equals("No"));

            if (finalFeedback.equalsIgnoreCase("No")) {

                do {
                    justification = (Utils.readLineFromConsole("Type the justification for rejecting the appointment: "));
                } while (Objects.isNull(justification));

                String path = "src\\main\\java\\pt\\ipp\\isep\\dei\\esoft\\project\\application\\notification\\emails";
                LocalDate date = LocalDate.now();

                String replyMessage =
                        "Subject: Declinement to response to booking request"
                                + "\nFrom: " + client.getEmailAddress()
                                + "\nTo: " + chosenMessage.getAgent().getEmailAddress()
                                + "\nBody:"
                                + "\nProperty info:"
                                + "\nProperty type: " + chosenMessage.getAnnouncement().getProperty().getPropertyType()
                                + "\nAddress: \n" + chosenMessage.getAnnouncement().getProperty().getAddress()
                                + "\nAgent info:"
                                + "\nName: " + chosenMessage.getAgent().getName()
                                + "\nPhone number: " + chosenMessage.getAgent().getPhoneNumber()
                                + "\nClient info:"
                                + "\nName: " + client.getName()
                                + "\nPhone number: " + client.getPhoneNumber()
                                + "\nJustification from client: " + justification
                                + "\nReply date: " + date + "\n\n\n";
                File newFile = new File(path);
                PrintWriter printWriter;
                try {
                    printWriter = new PrintWriter(newFile);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                printWriter.write(replyMessage);
                printWriter.close();


            } else if (finalFeedback.equalsIgnoreCase("Yes")) {
                String path = "src\\main\\java\\pt\\ipp\\isep\\dei\\esoft\\project\\application\\notification\\emails";
                LocalDate date = LocalDate.now();

                String replyMessage =
                        "Subject: Acceptance to response to booking request"
                                + "\nFrom: " + client.getEmailAddress()
                                + "\nTo: " + chosenMessage.getAgent().getEmailAddress()
                                + "\nBody:"
                                + "\nProperty info:"
                                + "\nProperty type: " + chosenMessage.getAnnouncement().getProperty().getPropertyType()
                                + "\nAddress: \n" + chosenMessage.getAnnouncement().getProperty().getAddress()
                                + "\nAgent info:"
                                + "\nName: " + chosenMessage.getAgent().getName()
                                + "\nPhone number: " + chosenMessage.getAgent().getPhoneNumber()
                                + "\nClient info:"
                                + "\nName: " + client.getName()
                                + "\nPhone number: " + client.getPhoneNumber()
                                + "\nVisit start time: " + chosenMessage.getNewVisitStartTime()
                                + "\nVisit end time: " + chosenMessage.getNewVisitEndTime()
                                + "\nReply date: " + date + "\n\n\n";
                File newFile = new File(path);
                PrintWriter printWriter;
                try {
                    printWriter = new PrintWriter(newFile);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                printWriter.write(replyMessage);
                printWriter.close();
            }
            controller.finishReply(chosenReply, chosenMessage);


            System.out.println();
            System.out.println("Your answer to the agent reply was submitted successfully!");

        }
    }
}
