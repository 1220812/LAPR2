package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.Request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Announcement repository.
 */
public class AnnouncementRepository implements Serializable {
    private static final long serialVersionUID = 1513917858611164050L;
    /**
     * The Announcements list.
     */
    List<Announcement> announcementsList = new ArrayList<>();
    /**
     * The Finished announcements list.
     */
    List<Announcement> finishedAnnouncementsList = new ArrayList<>();

    /**
     * Add list.
     *
     * @param announcement the announcement
     * @return the list
     * @throws CloneNotSupportedException the clone not supported exception
     */
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

    /**
     * Validate announcement boolean.
     *
     * @param announcement the announcement
     * @return the boolean
     */
    public boolean validateAnnouncement(Announcement announcement) {
        boolean isValid = !announcementsList.contains(announcement);
        return isValid;
    }


    /**
     * Gets announcements list.
     *
     * @return the announcements list
     */
    public List<Announcement> getAnnouncementsList() {
        return announcementsList;
    }

    /**
     * Add announcement announcement.
     *
     * @param announcement the announcement
     * @return the announcement
     */
    public Announcement addAnnouncement(Announcement announcement){
        if(validateAnnouncement(announcement))
            announcementsList.add(announcement);
        return announcement;
    }

    /**
     * Get announcements by store id int.
     *
     * @param storeID the store id
     * @return the int
     */
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

    /**
     * Gets announcements.
     *
     * @return the announcements
     */
    public List<Announcement> getAnnouncements() {
        return announcementsList;
    }

    /**
     * Remove announcement.
     *
     * @param announcement the announcement
     */
    public void removeAnnouncement(Announcement announcement){
        announcementsList.remove(announcement);
    }

    /**
     * Add finished announcement announcement.
     *
     * @param announcement the announcement
     * @return the announcement
     */
    public Announcement addFinishedAnnouncement(Announcement announcement){
        if(validateAnnouncement(announcement))
            finishedAnnouncementsList.add(announcement);
        return announcement;
    }

    /**
     * Gets announcement assigned list.
     *
     * @param agent the agent
     * @return the announcement assigned list
     */
    public List<Announcement> getAnnouncementAssignedList(Agent agent) {
        List<Announcement> assignedList = new ArrayList<>();
        for (Announcement announcement : this.announcementsList) {
            if (announcement.getAgent().getEmailAddress().equalsIgnoreCase(agent.getEmailAddress())) {
                assignedList.add(announcement);
            }
        }
        return assignedList;
    }

    /**
     * Gets finished announcements list.
     *
     * @return the finished announcements list
     */
    public List<Announcement> getFinishedAnnouncementsList() {
        return finishedAnnouncementsList;
    }


}