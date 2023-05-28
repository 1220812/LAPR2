package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;

public class Message {



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
}

