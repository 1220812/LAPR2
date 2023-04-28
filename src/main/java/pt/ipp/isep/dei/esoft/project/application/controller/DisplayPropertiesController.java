package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.AnnouncementsRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.PublishedAnnouncement;

import java.util.List;

public class DisplayPropertiesController {

    private AnnouncementsRepository announcementsRepository = null;

    public DisplayPropertiesController() {
        getAnnouncementsRepository();
    }

    public DisplayPropertiesController(AnnouncementsRepository announcementsRepository) {
        this.announcementsRepository = announcementsRepository;
    }

    private AnnouncementsRepository getAnnouncementsRepository() {
        if (announcementsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AnnouncementsRepository
            announcementsRepository = repositories.getAnnouncementsRepository();
        }
        return announcementsRepository;
    }

    public List<PublishedAnnouncement> getAnnouncements() {
        AnnouncementsRepository announcementsRepository = getAnnouncementsRepository();
        return announcementsRepository.getAnnouncements();
    }

    public List<PublishedAnnouncement> getSpecificAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfRooms) {
        AnnouncementsRepository announcementsRepository = getAnnouncementsRepository();
        return announcementsRepository.getSpecificAnnouncements(typeOfBusiness, typeOfProperty, numberOfRooms);
    }


}
