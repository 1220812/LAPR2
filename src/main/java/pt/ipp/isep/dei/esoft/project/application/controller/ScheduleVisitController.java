package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.time.LocalDate;
import java.util.List;


/**
 * The type Schedule visit controller.
 */
public class ScheduleVisitController {


    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();


    /**
     * Gets announcement.
     *
     * @return the announcement
     */
    public List<Announcement> getAnnouncement() {
        return Repositories.getInstance().getAnnouncementRepository.getAnnuncementsList();
    }

    /**
     * Create date local date.
     *
     * @param day   the day
     * @param month the month
     * @param year  the year
     * @return the local date
     */
    public LocalDate createDate(int day, int month, int year) {
        return Message.createDate(day, month, year);
    }

    /**
     * Check day boolean.
     *
     * @param day the day
     * @return the boolean
     */
    public boolean checkDay(int day) {
        return Message.checkDay(day);
    }

    /**
     * Check month boolean.
     *
     * @param month the month
     * @return the boolean
     */
    public boolean checkMonth(int month) {
        return Message.checkMonth(month);
    }

    /**
     * Check year boolean.
     *
     * @param year the year
     * @return the boolean
     */
    public boolean checkYear(int year) {
        return Message.checkYear(year);
    }

    /**
     * Check hour boolean.
     *
     * @param startHour the start hour
     * @return the boolean
     */
    public boolean checkHour(int startHour) {
        return Message.checkHour(startHour);
    }

    /**
     * Check minutes boolean.
     *
     * @param startMinute the start minute
     * @return the boolean
     */
    public boolean checkMinutes(int startMinute) {
        return Message.checkMinute(startMinute);
    }


    /**
     * Check phone boolean.
     *
     * @param phone the phone
     * @return the boolean
     */
    public boolean checkPhone(int phone) {
        return Employee.existsPhone(phone);
    }

    /**
     * Check if valid message.
     *
     * @param date     the date
     * @param schedule the schedule
     * @return the message
     */
    public Message checkIfValid(LocalDate date, String schedule) {
        return  MessageRepository.checkIfValid(date, schedule);
    }

    /**
     * Add message message.
     *
     * @param date     the date
     * @param schedule the schedule
     * @param name     the name
     * @param phone    the phone
     * @return the message
     */
    public Message addMessage(LocalDate date, String schedule, String name, int phone) {
        return MessageRepository.addMessage(date, schedule, name, phone);
    }

}

