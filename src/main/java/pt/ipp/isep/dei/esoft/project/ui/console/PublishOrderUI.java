package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishOrderController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class PublishOrderUI implements Runnable {
    public void run(){
        PublishOrderController controller = new PublishOrderController();
        System.out.println(controller.getAnnouncements());
        int selection = Utils.showAndSelectIndex(controller.getAnnouncements(), "Please select an announcement: ");

    }

}
