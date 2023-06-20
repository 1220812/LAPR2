package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The ScheduleVisitController class represents a controller for scheduling visits.
 */
public class ScheduleVisitController {

    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();

    /**
     * Retrieves a list of announcements.
     *
     * @return List of Announcement objects.
     */
    public List<Announcement> getAnnouncement() {
        return Repositories.getInstance().getAnnouncementRepository.getAnnouncementsList();
    }

    /**
     * Checks if the given day is valid.
     *
     * @param day the day to check.
     * @return true if the day is valid, false otherwise.
     */
    public boolean checkDay(int day) {
        return Message.checkDay(day);
    }

    /**
     * Checks if the given month is valid.
     *
     * @param month the month to check.
     * @return true if the month is valid, false otherwise.
     */
    public boolean checkMonth(int month) {
        return Message.checkMonth(month);
    }

    /**
     * Checks if the given year is valid.
     *
     * @param year the year to check.
     * @return true if the year is valid, false otherwise.
     */
    public boolean checkYear(int year) {
        return Message.checkYear(year);
    }

    /**
     * Checks if the given hour is valid.
     *
     * @param startHour the hour to check.
     * @return true if the hour is valid, false otherwise.
     */
    public boolean checkHour(int startHour) {
        return Message.checkHour(startHour);
    }

    /**
     * Checks if the given minutes are valid.
     *
     * @param startMinute the minutes to check.
     * @return true if the minutes are valid, false otherwise.
     */
    public boolean checkMinutes(int startMinute) {
        return Message.checkMinute(startMinute);
    }


    /**
     * Adds a new message for scheduling a visit.
     *
     * @param client            the client
     * @param announcement      the announcement
     * @param newVisitStartTime the start time of the visit.
     * @param newVisitEndTime   the end time of the visit.
     * @return the created Message object.
     */
    public Message addMessage( Client client,Announcement announcement, LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        return MessageRepository.addMessage(client,announcement, newVisitStartTime, newVisitEndTime);
    }

    /**
     * Checks if the visit specified by the start and end times is valid.
     *
     * @param MessageList       the list of messages to check against.
     * @param newVisitStartTime the start time of the visit.
     * @param newVisitEndTime   the end time of the visit.
     * @return true if the visit is valid, false otherwise.
     */
    public boolean checkIfValidVisit(List<Message> MessageList, LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        return Message.checkIfValidVisit(MessageList, newVisitStartTime, newVisitEndTime);
    }

    /**
     * Checks if the visit time is valid, i.e., the end time occurs after the start time.
     *
     * @param newVisitStartTime the start time of the visit.
     * @param newVisitEndTime   the end time of the visit.
     * @return true if the visit time is valid, false otherwise.
     */
    public boolean checkVisitTime(LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        return Message.checkVisitTime(newVisitStartTime, newVisitEndTime);
    }

    /**
     * Check email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean checkEmail(String email) {
        return (Employee.existsEmail(email));
    }

    /**
     * Gets current client.
     *
     * @return the current client
     */
    public Client getCurrentClient() {
        AuthenticationRepository rep = Repositories.getInstance().getAuthenticationRepository();
        UserSession us = rep.getCurrentUserSession();
        String email = us.getUserId().getEmail();
        return Repositories.getInstance().getClientRepository().getClientByEmail(email);
    }

    public List<Announcement> getAnnouncementList() {
        return repositories.getAnnouncementRepository.getAnnouncementsList();
    }
}



