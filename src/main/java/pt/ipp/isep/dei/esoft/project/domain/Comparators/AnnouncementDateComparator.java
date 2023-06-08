package pt.ipp.isep.dei.esoft.project.domain.Comparators;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;

import java.util.Comparator;

public class AnnouncementDateComparator implements Comparator<Announcement> {
    /**
     * This method compares the date of the creation of two announcements.
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return the value 0 if the date of the first announcement is equal to the date of the second announcement; a value less than 0 if the date of the first announcement is before the date of the second announcement; and a value greater than 0 if the date of the first announcement is after the date of the second announcement.
     */
    @Override
    public int compare(Announcement o1, Announcement o2) {
        if (o1.getDate().isAfter(o2.getDate()))
            return -1;
        else if (o1.getDate().isBefore(o2.getDate()))
            return 1;
        else
            return 0;
    }
}
