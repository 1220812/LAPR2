package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Residence;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository {

    List<Announcement> announcements = new ArrayList<>();

    public List<Announcement> getSpecificAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfRooms) {
        List<Announcement> announcementsSpecific = announcements;

    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

}
