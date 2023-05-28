package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.application.controller.ScheduleVisitController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

//import static pt.ipp.isep.dei.esoft.project.domain.Announcement.getSortedProperties;

public class ScheduleVisitUI implements Runnable {
    Announcement announcement = null;

    ScheduleVisitController controller = new ScheduleVisitController();


    public void run() {
        System.out.println("Schedule a visit:");

        System.out.println("####### List of Annoucements #######");
        int inputAnnou;


        inputAnnou = Utils.showAndSelectIndex2(controller.getAnnouncement())+1;
        if (inputAnnou == 0) return;


        System.out.println(inputAnnou);


        if (inputAnnou==1){
            System.out.println("hello");

        } else if (inputAnnou==2) {
            System.out.println("adeus");
        }


//        System.out.println(controller.getSortedProperties(announcement));




    }
}
