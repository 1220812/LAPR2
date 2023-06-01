package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListRequestsController;

public class ListRequestsUI implements Runnable{

    ListRequestsController controller = new ListRequestsController();



    public void run() {

        System.out.println(controller.getRequests());

        System.out.println(controller.getRequestsSorted());

        
    }
}
