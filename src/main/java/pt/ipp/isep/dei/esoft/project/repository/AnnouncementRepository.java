package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnnouncementRepository implements Serializable {
    private static final long serialVersionUID = 1513917858611164050L;
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

    public List<Announcement> getAnnouncements() {
        return announcementsList;
    }
    public void removeAnnouncement(Announcement announcement){
        announcementsList.remove(announcement);
    }
}