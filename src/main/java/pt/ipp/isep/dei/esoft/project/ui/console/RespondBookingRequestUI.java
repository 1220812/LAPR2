package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.RespondBookingRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Respond booking request ui.
 */
public class RespondBookingRequestUI implements Runnable {

    private RespondBookingRequestController controller= new RespondBookingRequestController();

    private List<String> options= new ArrayList<>() {{
        add("Accept");
        add("Decline");
    }};

    @Override
    public void run () {
        System.out.println("Respond Booking Request");

        Agent agent = controller.getCurrentAgent();
        List<Message> list = controller.getListOfBookingRequestByAgent(agent);

        if(list.isEmpty()){
            System.out.println("At the moment there are no pending booking requests.");
        }else{
            System.out.println("Select the booking request to reply to:");
            Message message = (Message) Utils.listAndSelectOne(list);
            System.out.println(message.toString());
            String reply = Utils.readLineFromConsole("Write reply message to booking request:");
            LocalDate replyDate = LocalDate.now();

            String path = "src\\main\\java\\pt\\ipp\\isep\\dei\\esoft\\project\\application\\notification\\emails";
            Announcement announcement = controller.getAnnouncement(message);

            Agent loggedInAgent = controller.getCurrentAgent();

            String replyMessage =
                    "Subject: Response to booking request"
                    + "\nFrom: " + loggedInAgent.getEmailAddress()
                    + "\nTo: " + controller.getClientEmail(message)
                    + "\nBody:"
                    + "\nProperty info:"
                    + "\nProperty type: " + controller.getPropertyType(announcement)
                    + "\nAddress: \n" + controller.getAddress(announcement)
                    + "\nAgent info:"
                    + "\nName: " + loggedInAgent.getName()
                    + "\nPhone number: " + loggedInAgent.getPhoneNumber()
                    + "\nMessage from agent: " + reply
                    + "\nReply date: " + replyDate + "\n\n\n";
            File newFile = new File(path);
            PrintWriter printWriter;
            try {
                printWriter = new PrintWriter(newFile);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            printWriter.write(replyMessage);
            printWriter.close();


            controller.replyMessage(message, replyMessage);
        }
    }
}
