package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class RequestRepository {

    List<Request> announcements = new ArrayList<>();

    public Request getAnnouncementByDescription(String description) {
        Request newAnnouncement = new Request(description);
        Request announcement = null;
        if (announcements.contains(newAnnouncement)) {
            announcement = announcements.get(announcements.indexOf(newAnnouncement));
        }

        if (announcement == null) {
            throw new IllegalArgumentException(
                    "Announcement requested for [" + description + "] does not exist.");
        }
        return newAnnouncement;
    }

    public Optional<Request> add(Request announcement) {

        Optional<Request> newAnnouncement = Optional.empty();
        boolean operationSuccess = false;

        if (validateRequest(announcement)) {
            newAnnouncement = Optional.of(announcement.clone());
            operationSuccess = announcements.add(newAnnouncement.get());
        }

        if (!operationSuccess) {
            newAnnouncement = Optional.empty();
        }

        return newAnnouncement;

    }

    private boolean validateRequest(Request announcement) {
        boolean isValid = !announcements.contains(announcement);
        return isValid;
    }

    public List<Request> getAnnouncements() {
        return List.copyOf(announcements);
    }
}
