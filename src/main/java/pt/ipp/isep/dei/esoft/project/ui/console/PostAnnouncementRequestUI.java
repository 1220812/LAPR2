package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PostAnnouncementRequestController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PostAnnouncementRequestUI implements Runnable{

    Request request;
    private final PostAnnouncementRequestController controller = new PostAnnouncementRequestController();

    public void run() {
        Scanner ler = new Scanner(System.in);

        Agent agent = controller.getCurrentAgent();

        List<Request> assignedRequestList = controller.getRequestAssignedList(agent);

        if(assignedRequestList.isEmpty()) {
            System.out.println("There are no requests");
        } else {
            System.out.println("Requests:");
            int i = 0;
            for (Request request: assignedRequestList) {
                i += 1;
                System.out.println(i);
                System.out.println("Date = " + request.getRequestDate());
                System.out.println("Property Type = " + request.getProperty().getPropertyType());
            }
            int assignedRequest = Utils.readIntegerFromConsole("Select one of the requests:");
            while (assignedRequest < 1 || assignedRequest > assignedRequestList.size()){
                assignedRequest = Utils.readIntegerFromConsole("Select a valid request:");
            }
            Request requestChosen = assignedRequestList.get(assignedRequest - 1);
            System.out.println(requestChosen.toString());

            String publishOption = Utils.readLineFromConsole("Do you want to accept or decline the request?");
            while(!publishOption.equalsIgnoreCase("accept")&&!publishOption.equalsIgnoreCase("decline")){
                publishOption = Utils.readLineFromConsole("Write a valid answer (accept / decline)");
            }

            if(publishOption.equalsIgnoreCase("accept")) {

                System.out.println("Commission type:");
                String commissionType = ler.next();
                while (!commissionType.equalsIgnoreCase("Percentage") && !commissionType.equalsIgnoreCase("Value")) {
                    System.out.println("Please write a valid option.");
                    commissionType = ler.next();
                }

                System.out.println("Commission:");
                double commission = ler.nextDouble();
                while (commission < 0) {
                    System.out.println("Please write a valid commission.");
                    commission = ler.nextInt();
                }
                Property property = requestChosen.getProperty();
                LocalDate date = LocalDate.now();
                RequestType requestType = requestChosen.getRequestType();
                double price = requestChosen.getPrice();
                Owner owner = requestChosen.getOwner();
                Store store = requestChosen.getStore();
                Announcement announcement = new Announcement(property, date, commissionType, commission, requestType, agent, price, owner, store);
                controller.acceptRequest(requestChosen);
                controller.registerAnnouncement(announcement);
                System.out.println("Announcement posted successfully!");
            }
            else if (publishOption.equalsIgnoreCase("decline")) {
                String justification = Utils.readLineFromConsole("Please write a justification for the declinement?");
                controller.declineRequest(requestChosen);
                System.out.println("Announcement declined successfully!");

            }
        }
    }
}
