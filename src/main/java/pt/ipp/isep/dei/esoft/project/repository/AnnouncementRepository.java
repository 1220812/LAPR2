package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Residence;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository {

    List<Announcement> announcements = new ArrayList<>();

    public void addAnnouncement(Announcement announcement){
        if(validateAnnouncement(announcement))
            announcements.add(announcement);
    }

    public boolean validateAnnouncement(Announcement announcement) {
        return !this.announcements.contains(announcement);
    }

    public List<Announcement> getAnnouncements(){
        return List.copyOf(this.announcements);
    }

    public List<Announcement> getSpecificAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfRooms) {
        List<Announcement> announcementsSpecific = announcements;
        return announcements;
    }
}
