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
            Message message = (Message) Utils.showAndSelectOne(list, "Select the booking request to reply to:");
            System.out.println(message.toString());
            String reply = Utils.readLineFromConsole("Write reply message to booking request:");
            LocalDate replyDate = LocalDate.now();

            String path = "src\\main\\java\\pt\\ipp\\isep\\dei\\esoft\\project\\application\\notification\\email";
            Announcement announcement = controller.getAnnouncement(message);
            String replyMessage =
                    "Subject: Response to booking request"
                    + "\nFrom: " + controller.getAgentEmail(agent)
                    + "\nTo: " + controller.getClientEmail(message)
                    + "\nBody:"
                    + "\nProperty info:"
                    + "\nProperty type: " + controller.getPropertyType(announcement)
                    + "\nAddress: " + controller.getAddress(announcement)
                    + "\nAgent info:"
                    + "\nName: " + controller.getAgentName(agent)
                    + "\nPhone number: " + controller.getAgentPhone(agent)
                    + "\nMessage from agent: " + reply
                    + "\nReply date: " + replyDate;

            File newFile = new File(path);
            PrintWriter printWriter;
            try {
                printWriter = new PrintWriter(newFile);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            printWriter.write(replyMessage);
            printWriter.close();
            newFile.deleteOnExit();

            controller.replyMessage(message, replyMessage);
        }
    }
}
