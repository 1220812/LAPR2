package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PostAnnouncementRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

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
            int i = 1;
            for (Request request: assignedRequestList) {
                System.out.println(i);
                System.out.println("Date = " + request.getRequestDate());
                System.out.println("Property Type = " + request.getRequestType());
            }
        }
    }
}
