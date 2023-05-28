package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.time.LocalDate;

public class Message {

    private LocalDate date;
    private String schedule;

    private String name;
    private int phone;

    public Message(LocalDate date, String schedule) {
        this.date = date;
        this.schedule = schedule;
    }

    public Message(LocalDate date, String schedule, String name, int phone) {
        this.date = date;
        this.schedule = schedule;
        this.name=name;
        this.phone=phone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSchedule() {
        return schedule;
    }

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

    public String toString2() {
        return "Message{" +
                "date=" + date +
                ", schedule='" + schedule + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

    public static LocalDate createDate(int day, int month, int year) {
        try {
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return null;
        }
    }


    public static boolean checkDay(int day) {
        if (day < 1 || day > 31) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkMonth(int month) {
        if (month < 1 || month > 12) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkYear(int year) {
        if (year < 2023) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkHour(int startHour) {
        if (startHour < 0 || startHour > 24) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkMinute(int startMinute) {
        if (startMinute < 0 || startMinute > 60) {
            return false;
        } else {
            return true;
        }
    }
//
//    public static boolean createMessage(LocalDate date, String schedule) {
//        return MessageRepository.add(date, schedule);
//    }
}

