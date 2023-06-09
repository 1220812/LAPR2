package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ScheduleVisitController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;


import java.time.LocalDateTime;

import java.util.List;


public class ScheduleVisitUI implements Runnable {
    Announcement announcement = null;
    int day = 0;
    int month = 0;
    int year = 0;
    int startHour = 0;
    int startMinute = 0;

    int endHour = 0;
    int endMinute = 0;
    String name = null;
    int phone = 0;


    LocalDateTime newVisitEndTime;
    LocalDateTime newVisitStartTime;


    ScheduleVisitController controller = new ScheduleVisitController();


    public void run() {
        System.out.println("Schedule a visit:");


        name = Utils.readLineFromConsole("Employee name:");
        while (name.trim().isEmpty()) {
            name = Utils.readLineFromConsole("Invalid Name \nInsert employee name:");
        }

        phone = Utils.readIntegerFromConsole("Phone number:");
        while (!controller.checkPhone(String.valueOf(phone))) {
            phone = Utils.readIntegerFromConsole("Invalid Phone number (format: xxxxxxxxxx) \nInsert new phone number: ");
        }
        boolean continueScheduling = true;
        while (continueScheduling) {

            System.out.println("####### List of Annoucements #######");
            int inputAnnou;


            inputAnnou = Utils.showAndSelectIndex2(controller.getAnnouncement()) + 1;
            if (inputAnnou == 0) return;


            System.out.println(inputAnnou);

            System.out.println("#######Sugest a date to visit the property#######");
            day = Utils.readIntegerFromConsole("Day: ");
            while (!controller.checkDay(day)) {
                day = Utils.readIntegerFromConsole("Invalid day (format: 1-31)\n Insert new day");
            }

            month = Utils.readIntegerFromConsole("Month:");
            while (!controller.checkMonth(month)) {
                month = Utils.readIntegerFromConsole("Invalid month (format: 1-12)\nInsert new month");
            }

            year = Utils.readIntegerFromConsole("Year:");
            while (!controller.checkYear(year)) {
                year = Utils.readIntegerFromConsole(")\nInsert new year");
            }

            startHour = Utils.readIntegerFromConsole("Starting hour:");
            while (!controller.checkHour(startHour)) {
                startHour = Utils.readIntegerFromConsole("Invalid hour (format: 0-23)\nInsert new hour");
            }

            startMinute = Utils.readIntegerFromConsole("Starting minute:");
            while (!controller.checkMinutes(startMinute)) {
                startMinute = Utils.readIntegerFromConsole("Invalid minute (format: 0-59)\nInsert new minute");
            }
            endHour = Utils.readIntegerFromConsole("Ending hour:");
            while (!controller.checkHour(endHour)) {
                endHour = Utils.readIntegerFromConsole("Invalid hour (format: 0-23)\nInsert new hour");
            }

            endMinute = Utils.readIntegerFromConsole("Ending minute:");
            while (!controller.checkMinutes(endMinute)) {
                endMinute = Utils.readIntegerFromConsole("Invalid minute (format: 0-59)\nInsert new minute");
            }

            newVisitStartTime = LocalDateTime.of(year, month, day, startHour, startMinute);
            newVisitEndTime = LocalDateTime.of(year, month, day, endHour, endMinute);

            while (!controller.checkVisitTime(newVisitStartTime, newVisitEndTime)) {
                System.out.println("Date Entered is invalid");

                day = Utils.readIntegerFromConsole("Day: ");
                while (!controller.checkDay(day)) {
                    day = Utils.readIntegerFromConsole("Invalid day (format: 1-31)\n Insert new day");
                }

                month = Utils.readIntegerFromConsole("Month:");
                while (!controller.checkMonth(month)) {
                    month = Utils.readIntegerFromConsole("Invalid month (format: 1-12)\nInsert new month");
                }

                year = Utils.readIntegerFromConsole("Year:");
                while (!controller.checkYear(year)) {
                    year = Utils.readIntegerFromConsole("Invalid year (format: 0-...))\nInsert new year");
                }

                startHour = Utils.readIntegerFromConsole("Starting hour:");
                while (!controller.checkHour(startHour)) {
                    startHour = Utils.readIntegerFromConsole("Invalid hour (format: 0-23)\nInsert new hour");
                }

                startMinute = Utils.readIntegerFromConsole("Starting minute:");
                while (!controller.checkMinutes(startMinute)) {
                    startMinute = Utils.readIntegerFromConsole("Invalid minute (format: 0-59)\nInsert new minute");
                }
                endHour = Utils.readIntegerFromConsole("Ending hour:");
                while (!controller.checkHour(endHour)) {
                    endHour = Utils.readIntegerFromConsole("Invalid hour (format: 0-23)\nInsert new hour");
                }

                endMinute = Utils.readIntegerFromConsole("Ending minute:");
                while (!controller.checkMinutes(endMinute)) {
                    endMinute = Utils.readIntegerFromConsole("Invalid minute (format: 0-59)\nInsert new minute");
                }
                newVisitStartTime = LocalDateTime.of(year, month, day, startHour, startMinute);
                newVisitEndTime = LocalDateTime.of(year, month, day, endHour, endMinute);
            }





            List<Message> MessageList = MessageRepository.getMessageList();
            boolean hasOverlap = controller.checkIfValidVisit(MessageList, newVisitStartTime, newVisitEndTime);

            if (hasOverlap) {
                System.out.println("There is overlapping schedule.");
            } else {
                System.out.println("There is no overlapping of visits. The new message has been sent to an agent.");
                System.out.println(controller.addMessage(name, phone, inputAnnou, newVisitStartTime, newVisitEndTime).toString());
                System.out.println("                  ");
                System.out.println("#######successful operation#######");
                System.out.println("                  ");
                System.out.println("List of scheduled visits:");
                boolean isFirstMessage = true;
                for (Message messageList : MessageList) {
                    if (isFirstMessage) {
                        isFirstMessage = false;
                        continue;
                    }
                    System.out.println("Start of visit: " + messageList.getNewVisitStartTime() + " - End of Visit: " + messageList.getNewVisitEndTime());
                }
            }
            String flag = Utils.readLineFromConsole("\"Do you want to schedule another visit? (yes/no): ");
            if (!flag.equalsIgnoreCase("yes")) {
                continueScheduling = false;
            }
        }
    }
}


