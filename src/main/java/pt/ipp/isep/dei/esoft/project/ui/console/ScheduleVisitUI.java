package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class ScheduleVisitUI implements Runnable {
    Announcement announcement=null;

    RegisterAnnouncementController controller = new RegisterAnnouncementController();


    public void run() {
        System.out.println("Schedule a visit:");

//        System.out.println("####### List of Agencies #######");
//        announcement = Utils.listAndSelectOne(controller.getAnnouncement());
//        if (announcement == null) return;











    }
}
