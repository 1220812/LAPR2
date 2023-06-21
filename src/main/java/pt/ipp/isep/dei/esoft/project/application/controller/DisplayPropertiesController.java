package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

/**
 * The type Display properties controller.
 */
public class DisplayPropertiesController {


    /**
     * Get announcement repository announcement repository.
     *
     * @return the announcement repository
     */
    public AnnouncementRepository getAnnouncementRepository(){
        return Repositories.getInstance().getAnnouncementRepository();
    }


    /**
     * Display announcements.
     *
     * @param announcementRepository the announcement repository
     */
    public void DisplayAnnouncements (AnnouncementRepository announcementRepository) {
        Utils.showList(announcementRepository.getAnnouncementsList(), "Announcements");
    }

}
