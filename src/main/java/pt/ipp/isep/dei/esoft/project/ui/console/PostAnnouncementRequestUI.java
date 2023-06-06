package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PostAnnouncementRequestController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Date;
import java.util.List;

public class PostAnnouncementRequestUI implements Runnable{

    Request request;
    private final PostAnnouncementRequestController controller = new PostAnnouncementRequestController();

    public void run() {
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
                System.out.println("Property Type = " + request.getPropertyType());
            }
            int assignedRequest = Utils.readIntegerFromConsole("Select one of the requests:");
            while (assignedRequest < 1 || assignedRequest > assignedRequestList.size()){
                assignedRequest = Utils.readIntegerFromConsole("Select a valid request:");
            }
            for (Request request: assignedRequestList) {
                i += 1;
                if (i == assignedRequest) {
                    System.out.println(request.toString());
                }
            }
            String publishOption = Utils.readLineFromConsole("Do you want to accept or decline the request?");
            while(!publishOption.equals("accept")&&!publishOption.equals("decline")){
                publishOption = Utils.readLineFromConsole("Write a valid answer (accept / decline)");
            }

            Request requestChosen;

            if(publishOption.equals("accept")) {
                for (Request request: assignedRequestList) {
                    i += 1;
                    if (i == assignedRequest) {
                        requestChosen = request;
                    }
                }

                Property property = new Property();
                Date date = new Date();
                String comissionType;
                double comission;
                RequestType requestType = new RequestType();
                PropertyType propertyType = new PropertyType();
                Announcement newAnnouncement = new Announcement(property, date, comissionType, comission, requestType, propertyType);
            }
            else if (publishOption.equals("decline")) {

            }
        }
    }
}
