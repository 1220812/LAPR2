package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.AnnouncementsRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class PublishAnnouncementController {

    private AnnouncementsRepository announcementsRepository = null;

    public PublishAnnouncementController(AnnouncementsRepository announcementsRepository) {
        this.announcementsRepository = announcementsRepository;

    }

    private AnnouncementsRepository getAnnouncementsRepository() {
        if (announcementsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            //Get the AnnouncementRepository
            announcementsRepository = repositories.getAnnouncementsRepository();
        }
        return announcementsRepository;
    }
}
