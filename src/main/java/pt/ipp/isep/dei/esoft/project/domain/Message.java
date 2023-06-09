package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static pt.ipp.isep.dei.esoft.project.repository.MessageRepository.getMessageList;

public class Message {
    /**
     * Date of the sending message
     */
    private LocalDate date;
    /**
     * Schedule
     */
    private String schedule;
    /**
     *
     */
    private String name;
    private int phone;

    private int inputAnnou;

    private LocalDateTime newVisitStartTime;

    private LocalDateTime newVisitEndTime;


    /**
     * Instantiates a new Message.
     *
     * @param date     the date
     * @param schedule the schedule
     */
    public Message(LocalDate date, String schedule) {
        this.date = date;
        this.schedule = schedule;
    }

    public Message(LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        this.newVisitStartTime = newVisitStartTime;
        this.newVisitEndTime = newVisitEndTime;
    }

    public static boolean checkVisitTime(LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        LocalDateTime now = LocalDateTime.now();
        return newVisitStartTime.isAfter(now) && newVisitEndTime.isAfter(now);
    }


    public LocalDateTime getNewVisitStartTime() {
        return newVisitStartTime;
    }

    public void setNewVisitStartTime(LocalDateTime newVisitStartTime) {
        this.newVisitStartTime = newVisitStartTime;
    }

    public LocalDateTime getNewVisitEndTime() {
        return newVisitEndTime;
    }

    public void setNewVisitEndTime(LocalDateTime newVisitEndTime) {
        this.newVisitEndTime = newVisitEndTime;
    }


    public Message(String name, int phone, int inputAnnou, LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {

        this.name = name;
        this.phone = phone;
        this.inputAnnou = inputAnnou;
        this.newVisitStartTime = newVisitStartTime;
        this.newVisitEndTime = newVisitEndTime;
    }


    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets schedule.
     *
     * @return the schedule
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * Sets schedule.
     *
     * @param schedule the schedule
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getInputAnnou() {
        return inputAnnou;
    }

    public void setInputAnnou(int inputAnnou) {
        this.inputAnnou = inputAnnou;
    }

    @Override
    public String toString() {
        return "MessageINCOMPLETE{" +
                "newVisitStartTime=" + newVisitStartTime +
                ", newVisitEndTime=" + newVisitEndTime +
                '}';
    }

    public String toString2() {
        return "Message:"
                + "\nname: " + name
                + "\nphone: " + phone
                + "\nListing number of announcement: " + inputAnnou
                + "\nstart date of the visit: " + newVisitStartTime
                + "\nend date of the visit: " + newVisitEndTime;
    }


    /**
     * To string 2 string.
     *
     * @return the string
     */


    /**
     * Create date local date.
     *
     * @param day   the day
     * @param month the month
     * @param year  the year
     * @return the local date
     */
    public static LocalDate createDate(int day, int month, int year) {
        try {
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return null;
        }
    }


    /**
     * Check day boolean.
     *
     * @param day the day
     * @return the boolean
     */
    public static boolean checkDay(int day) {
        if (day < 1 || day > 31) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check month boolean.
     *
     * @param month the month
     * @return the boolean
     */
    public static boolean checkMonth(int month) {
        if (month < 1 || month > 12) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check year boolean.
     *
     * @param year the year
     * @return the boolean
     */
    public static boolean checkYear(int year) {
        if (year < 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check hour boolean.
     *
     * @param startHour the start hour
     * @return the boolean
     */
    public static boolean checkHour(int startHour) {
        if (startHour < 0 || startHour > 24) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check minute boolean.
     *
     * @param startMinute the start minute
     * @return the boolean
     */
    public static boolean checkMinute(int startMinute) {
        if (startMinute < 0 || startMinute > 60) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkIfValidVisit(List<Message> MessageList, LocalDateTime newVisitStartTime, LocalDateTime newVisitEndTime) {
        for (Message messageList : MessageList) {
            LocalDateTime existingStartDate = messageList.getNewVisitStartTime();
            LocalDateTime existingEndDate = messageList.getNewVisitEndTime();

            if (newVisitStartTime.isBefore(existingEndDate) && newVisitEndTime.isAfter(existingStartDate)) {
                return true; // A nova visita se sobrepõe a uma visita existente
            }
        }

        MessageList.add(new Message(newVisitStartTime, newVisitEndTime)); // Adiciona a nova visita à lista
        return false; // A nova visita não se sobrepõe a nenhuma visita existente
    }
}



