package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class DisplayPropertiesController {


    public AnnouncementRepository getAnnouncementRepository(){
        return Repositories.getInstance().getAnnouncementRepository();
    }

//    public List<Announcement> getSpecificAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfRooms) {
//         AnnouncementRepository announcementRepository = getAnnouncementsRepository();
//        return announcementRepository.getSpecificAnnouncements(typeOfBusiness, typeOfProperty, numberOfRooms);
//    }

    public void DisplayAnnouncements (AnnouncementRepository announcementRepository) {
        Utils.showList(announcementRepository.getAnnouncementsList(), "Announcements");
    }

}
