package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.DisplayPropertiesController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DisplayPropertiesUI implements Runnable{

    private final DisplayPropertiesController dpController = new DisplayPropertiesController();
    private final AnnouncementRepository aRepository = new AnnouncementRepository();


    @Override
    public void run() {

        System.out.println("List of Properties:");
        dpController.DisplayAnnouncements(aRepository);
        System.out.println();
        System.out.println("X - Cancel");

    }

}
