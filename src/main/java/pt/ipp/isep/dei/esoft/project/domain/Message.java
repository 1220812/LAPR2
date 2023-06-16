package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The Message class represents a message.
 */
public class Message implements Serializable {
    private String name;
    private Client client;
    private int phone;
    private Announcement announcement;
    private LocalDateTime newVisitStartTime;
    private LocalDateTime newVisitEndTime;


    /**
     * Constructs a new instance of Message with visit start and end times.
     *
     * @param newVisitStartTime  the start time of the visit.
     * @param newVisitEndTime    the end time of the visit.
     */
    public Message(LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        this.newVisitStartTime = newVisitStartTime;
        this.newVisitEndTime = newVisitEndTime;
    }

    /**
     * Constructs a new instance of Message with visit details.
     *
     * @param announcement         the input announcement for the visit.
     * @param newVisitStartTime  the start time of the visit.
     * @param newVisitEndTime    the end time of the visit.
     */
    public Message(Client client, Announcement announcement, LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        this.client=client;
        this.announcement = announcement;
        this.newVisitStartTime = newVisitStartTime;
        this.newVisitEndTime = newVisitEndTime;
    }




    /**
     * Retrieves the start time of the visit.
     *
     * @return the start time of the visit.
     */
    public LocalDateTime getNewVisitStartTime() {
        return newVisitStartTime;
    }

    /**
     * Sets the start time of the visit.
     *
     * @param newVisitStartTime  the start time of the visit.
     */
    public void setNewVisitStartTime(LocalDateTime newVisitStartTime) {
        this.newVisitStartTime = newVisitStartTime;
    }

    /**
     * Retrieves the end time of the visit.
     *
     * @return the end time of the visit.
     */
    public LocalDateTime getNewVisitEndTime() {
        return newVisitEndTime;
    }

    /**
     * Sets the end time of the visit.
     *
     * @param newVisitEndTime  the end time of the visit.
     */
    public void setNewVisitEndTime(LocalDateTime newVisitEndTime) {
        this.newVisitEndTime = newVisitEndTime;
    }

    /**
     * Retrieves the name of the message sender.
     *
     * @return the name of the message sender.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the message sender.
     *
     * @param name  the name of the message sender.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the phone number of the message sender.
     *
     * @return the phone number of the message sender.
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the message sender.
     *
     * @param phone  the phone number of the message sender.
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }





    /**
     * Returns a string representation of the Message object.
     *
     * @return a string representation of the Message object.
     */
    public String toString() {
        return "Message:"
                + "\nname: " + client.getName()
                + "\nphone: " + client.getPhoneNumber()
                + "\nAnnouncement: " + announcement
                + "\nstart date of the visit: " + newVisitStartTime
                + "\nend date of the visit: " + newVisitEndTime;
    }

    /**
     * Checks if the visit time is valid.
     *
     * @param newVisitStartTime  the start time of the visit.
     * @param newVisitEndTime    the end time of the visit.
     * @return true if the visit time is valid, false otherwise.
     */
    public static boolean checkVisitTime(LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        LocalDateTime now = LocalDateTime.now();
        return newVisitStartTime.isAfter(now) && newVisitEndTime.isAfter(now) && newVisitEndTime.isAfter(newVisitStartTime);
    }

    /**
     * Checks if the specified day is valid.
     *
     * @param day  the day to be checked.
     * @return true if the day is valid, false otherwise.
     */
    public static boolean checkDay(int day) {
        return day >= 1 && day <= 31;
    }

    /**
     * Checks if the specified month is valid.
     *
     * @param month  the month to be checked.
     * @return true if the month is valid, false otherwise.
     */
    public static boolean checkMonth(int month) {
        return month >= 1 && month <= 12;
    }

    /**
     * Checks if the specified year is valid.
     *
     * @param year  the year to be checked.
     * @return true if the year is valid, false otherwise.
     */
    public static boolean checkYear(int year) {
        return year >= 0;
    }

    /**
     * Checks if the specified hour is valid.
     *
     * @param startHour  the hour to be checked.
     * @return true if the hour is valid, false otherwise.
     */
    public static boolean checkHour(int startHour) {
        return startHour >= 0 && startHour <= 24;
    }

    /**
     * Checks if the specified minute is valid.
     *
     * @param startMinute  the minute to be checked.
     * @return true if the minute is valid, false otherwise.
     */
    public static boolean checkMinute(int startMinute) {
        return startMinute >= 0 && startMinute <= 60;
    }

    /**
     * Checks if the visit time overlaps with any existing visits.
     *
     * @param MessageList          the list of existing messages.
     * @param newVisitStartTime    the start time of the new visit.
     * @param newVisitEndTime      the end time of the new visit.
     * @return true if there is an overlap, false otherwise.
     */
    public static boolean checkIfValidVisit(List<Message> MessageList, LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        for (Message messageList : MessageList) {
            LocalDateTime existingStartDate = messageList.getNewVisitStartTime();
            LocalDateTime existingEndDate = messageList.getNewVisitEndTime();

            if (newVisitStartTime.isBefore(existingEndDate) && newVisitEndTime.isAfter(existingStartDate)) {
                return true;
            }
        }
        MessageList.add(new Message(newVisitStartTime, newVisitEndTime));
        return false;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public Agent getAgent() {
        return announcement.getAgent();
    }

    public Client getClient() {
        return client;
    }
}