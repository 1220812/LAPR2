package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import java.util.List;

public class DisplayPropertiesController {

    private AnnouncementRepository announcementRepository = null;

    public DisplayPropertiesController() {
        getAnnouncementsRepository();
    }

    public DisplayPropertiesController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    private AnnouncementRepository getAnnouncementsRepository() {
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();

            announcementRepository = getAnnouncementsRepository();
        }
        return announcementRepository;
    }

    public List<Announcement> getSpecificAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfRooms) {
        AnnouncementRepository announcementRepository = getAnnouncementsRepository();
        return announcementRepository.getSpecificAnnouncements(typeOfBusiness, typeOfProperty, numberOfRooms);
    }

}
