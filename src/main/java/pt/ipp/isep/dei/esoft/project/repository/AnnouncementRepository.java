package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnnouncementRepository implements Serializable {

    public List<Announcement> getAnnouncements(){
        return List.copyOf(this.announcementsList);
    }
//
//    public List<Announcement> getSpecificAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfRooms) {
//        List<Announcement> announcementsSpecific = announcements;
//        return announcements;
//    }


    private static List<Announcement> announcementsList = new ArrayList<>();

    public List<Announcement> add(Announcement announcement) throws CloneNotSupportedException {

        announcementsList.add(announcement);

        Optional<Announcement> newAnnouncement = Optional.empty();
        boolean operationSuccess = false;

        if (validateAnnouncement(announcement)) {
            newAnnouncement = Optional.of((Announcement) announcement.clone());
            operationSuccess = announcementsList.add((Announcement) newAnnouncement.get());
        }

        if (!operationSuccess) {
            newAnnouncement = Optional.empty();
        }

        System.out.println(announcementsList);

        return announcementsList;
    }

    public static boolean validateAnnouncement(Announcement announcement) {
        boolean isValid = !announcementsList.contains(announcement);
        return isValid;
    }

    public  List<Announcement> getAnnouncementsList(){
        return List.copyOf(this.announcementsList);
    }

    public static Announcement addAnnouncement(Announcement announcement){
        if(validateAnnouncement(announcement))
            announcementsList.add(announcement);
        return announcement;
    }

    public int getAnnouncementsByStoreID(int storeID){
        List<Announcement> announcementList = getAnnouncementsList();
        int count = 0;
        for (int i = 0; i < announcementList.size(); i++) {
            if(announcementList.get(i).getStore().getID() == storeID){
                count++;
            }
        }
        return count;
    }
}