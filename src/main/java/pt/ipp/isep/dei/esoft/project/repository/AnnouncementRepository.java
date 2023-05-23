package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnnouncementRepository {

    List<Announcement> announcements = new ArrayList<>();


    public List<Announcement> getAnnouncements(){
        return List.copyOf(this.announcements);
    }

//    public List<Announcement> getSpecificAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfRooms) {
//        List<Announcement> announcementsSpecific = announcements;
//        return announcements;
//    }


    private final List<Announcement> annuncementsList = new ArrayList<>();

    public List<Announcement> addAnnouncement(Announcement announcement){
        annuncementsList.add(announcement);
        Optional<Announcement> newAnnoucement = Optional.empty();
        boolean operationSuccess = false;
        if(validateAnnaucement(announcement)){
            newAnnoucement = Optional.of(announcement.clone());
            operationSuccess = annuncementsList.add(newAnnoucement.get());
        }
        if(!operationSuccess){
            newAnnoucement = Optional.empty();
        }
        return annuncementsList;
    }

    public boolean validateAnnaucement(Announcement announcement) {
        boolean isValid = !annuncementsList.contains(announcement);
        return isValid;
    }

    public List<Announcement> getAnnuncementsList(){
        return List.copyOf(this.annuncementsList);
    }
}
