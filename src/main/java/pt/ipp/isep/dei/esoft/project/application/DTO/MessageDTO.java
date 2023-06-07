package pt.ipp.isep.dei.esoft.project.application.DTO;

import pt.ipp.isep.dei.esoft.project.domain.Agent;

import java.time.LocalDate;

public class MessageDTO {

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
    private Agent agent;

    /**
     * Instantiates a new Message.
     *
     * @param date     the date
     * @param schedule the schedule
     */
    public MessageDTO(LocalDate date, String schedule) {
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
    public MessageDTO(LocalDate date, String schedule, String name, int phone, int inputAnnou, Agent agent) {
        this.date = date;
        this.schedule = schedule;
        this.name = name;
        this.phone = phone;
        this.inputAnnou = inputAnnou;
        this.agent = agent;
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

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "date=" + date +
                ", schedule='" + schedule + '\'' +
                '}';
    }


    public String toString2() {
        return "Message{" +
                "date=" + date +
                ", schedule='" + schedule + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", Announcement=" + inputAnnou;
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
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataInput =LocalDate.of(year, month, day);
        if (dataAtual.isAfter(dataInput)) {
            System.out.println("Data inválida. A data fornecida está no passado.");
            return null;
        }
        return dataInput;
    }
    public static boolean checkDate(int day, int month, int year) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (Exception e) {
            return false;
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
