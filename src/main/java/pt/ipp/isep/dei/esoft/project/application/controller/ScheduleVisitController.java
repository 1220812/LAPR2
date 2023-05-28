package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Schedule visit controller.
 */
public class ScheduleVisitController {


    Repositories repositories = Repositories.getInstance();


    public List<Announcement> getAnnouncement() {
        return Repositories.getInstance().getAnnouncementRepository.getAnnuncementsList();
    }

    public LocalDate createDate(int day, int month, int year) {
        return Message.createDate(day, month, year);
    }

    public boolean checkDay(int day) {
        return Message.checkDay(day);
    }

    public boolean checkMonth(int month) {
        return Message.checkMonth(month);
    }

    public boolean checkYear(int year) {
        return Message.checkYear(year);
    }

    public boolean checkHour(int startHour) {
        return Message.checkHour(startHour);
    }

    public boolean checkMinutes(int startMinute) {
        return Message.checkMinute(startMinute);
    }

    public void getUser() {
        UserSession.

    }


//    public List<Announcement> getSortedProperties(announcement){
//        return Announcement.getSortedProperties();
//    }
}

