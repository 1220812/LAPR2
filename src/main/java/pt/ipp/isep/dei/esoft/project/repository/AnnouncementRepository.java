package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Residence;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository {

    List<Announcement> announcements = new ArrayList<>();

    public List<Announcement> getSpecificAnnouncements(String typeOfBusiness, String typeOfProperty, int numberOfRooms) {
        List<Announcement> announcementsSpecific = announcements;
        for (int j = 0; j < announcementsSpecific.size(); j++) {
            if (typeOfBusiness.equals(announcementsSpecific.get(j).getProperty().getTypeOfBusiness()) && typeOfProperty.equals(announcementsSpecific.get(j).getProperty().getTypeOfProperty()) && numberOfRooms == ((Residence) announcementsSpecific.get(j).getProperty()).getNumberOfBedrooms()) {
                j++;
            } else if (typeOfBusiness.equals(announcementsSpecific.get(j).getProperty().getTypeOfBusiness()) && typeOfProperty.equals(announcementsSpecific.get(j).getProperty().getTypeOfProperty()) && announcementsSpecific.get(j).getProperty().getTypeOfBusiness().equals("Land")) {
                j++;
            } else {
                announcementsSpecific.remove(j);
                j--;
            }
        }
        return announcementsSpecific;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

}
