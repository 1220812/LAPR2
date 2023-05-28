package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.time.LocalDate;

/**
 * The type Message.
 */
public class Message {

    private LocalDate date;
    private String schedule;

    private String name;
    private int phone;

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

    /**
     * Instantiates a new Message.
     *
     * @param date     the date
     * @param schedule the schedule
     * @param name     the name
     * @param phone    the phone
     */
    public Message(LocalDate date, String schedule, String name, int phone) {
        this.date = date;
        this.schedule = schedule;
        this.name=name;
        this.phone=phone;
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

    @Override
    public String toString() {
        return "Message{" +
                "date=" + date +
                ", schedule='" + schedule + '\'' +
                '}';
    }

    /**
     * To string 2 string.
     *
     * @return the string
     */
    public String toString2() {
        return "Message{" +
                "date=" + date +
                ", schedule='" + schedule + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

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
        if (year < 2023) {
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

}

