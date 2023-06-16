package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.DisplayPropertiesController;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DisplayPropertiesUI implements Runnable{

    private final DisplayPropertiesController dpController = new DisplayPropertiesController();
//    private final AnnouncementRepository aRepository = new AnnouncementRepository();

    AnnouncementRepository announcementRepository = dpController.getAnnouncementRepository();
    @Override
    public void run() {
        int count = 1;
        System.out.println("List of Properties:");
        for (Announcement announcement : announcementRepository.getAnnouncementsList()) {
            System.out.println(count+". "+announcement);
            count++;
        }
        System.out.println();
        System.out.println("X - Cancel");


    }

}
