package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import java.util.List;

public class DisplayPropertiesController {

    private AnnouncementRepository announcementRepository = null;

    public AnnouncementRepository getAnnouncementRepository() {
        return announcementRepository;
    }

    public DisplayPropertiesController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    private AnnouncementRepository getAnnouncementsRepository() {
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();

            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    public List<Announcement> getSpecificAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfRooms) {
        AnnouncementRepository announcementRepository = getAnnouncementRepository();
        return announcementRepository.getSpecificAnnouncements(typeOfBusiness, typeOfProperty, numberOfRooms);
    }
}
