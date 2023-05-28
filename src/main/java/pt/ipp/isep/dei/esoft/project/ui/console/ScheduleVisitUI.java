package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.application.controller.ScheduleVisitController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;


public class ScheduleVisitUI implements Runnable {
    Announcement announcement = null;
    int day=0;
    int month=0;
    int year=0;
    LocalDate date = null;

    int startHour=0;
    int startMinute=0;

    int endHour=0;
    int endMinute=0;

    String name=null;

    int phone=0;

    String schedule=null;


    ScheduleVisitController controller = new ScheduleVisitController();


    public void run() {
        System.out.println("Schedule a visit:");

        System.out.println("####### List of Annoucements #######");
        int inputAnnou;


        inputAnnou = Utils.showAndSelectIndex2(controller.getAnnouncement())+1;
        if (inputAnnou == 0) return;


        System.out.println(inputAnnou);


        if (inputAnnou==1){
            System.out.println("#######Sugest a date to visit the property#######");
            day=Utils.readIntegerFromConsole("Day: ");
            while (!controller.checkDay(day)){
                day =Utils.readIntegerFromConsole("Invalide day (format: 1-31)\n Insert new day");
            }

            month=Utils.readIntegerFromConsole("Month:");
            while (!controller.checkMonth(month)){
                month =Utils.readIntegerFromConsole("Invalide month (format: 1-12)\nInsert new month");
            }

            year=Utils.readIntegerFromConsole("Year:");
            while (!controller.checkYear(year)){
                year =Utils.readIntegerFromConsole("Invalide month (value of year has to be more than 2022)\nInsert new month");
            }

            System.out.println(date=(controller.createDate(day, month, year)));

            startHour=Utils.readIntegerFromConsole("Hour for the beginning of the visit: ");
            while (!controller.checkHour(startHour)){
                startHour =Utils.readIntegerFromConsole("Invalide hour (format: 0-24)\nInsert new hour");
            }

            startMinute=Utils.readIntegerFromConsole("Minutes for the beginning of the visit: ");
            while (!controller.checkMinutes(startMinute)){
                startHour =Utils.readIntegerFromConsole("Invalide minute (format: 0-60)\nInsert new minute");
            }

            endHour=Utils.readIntegerFromConsole("Hour for the ending of the visit: ");
            while (!controller.checkHour(endHour)){
                endHour =Utils.readIntegerFromConsole("Invalide hour (format: 0-24)\nInsert new hour");
            }

            endMinute=Utils.readIntegerFromConsole("Minutes for the ending of the visit: ");
            while (!controller.checkMinutes(endMinute)){
                endMinute =Utils.readIntegerFromConsole("Invalide hour (format: 0-60)\nInsert new hour");
            }
            System.out.println(schedule="Visit hour: "+startHour+":"+startMinute+" until "+endHour+":"+endMinute);



            System.out.println(schedule="Visit hour: "+startHour+":"+startMinute+" until "+endHour+":"+endMinute);


            System.out.println(controller.checkIfValid(date, schedule));




           System.out.println(MessageRepository.getMessageList());


        } else if (inputAnnou==2) {
            System.out.println("#######Sugest a date to visit the property#######");
            day=Utils.readIntegerFromConsole("Day: ");
            while (!controller.checkDay(day)){
                day =Utils.readIntegerFromConsole("Invalide day (format: 1-31)\n Insert new day");
            }

            month=Utils.readIntegerFromConsole("Month:");
            while (!controller.checkMonth(month)){
                month =Utils.readIntegerFromConsole("Invalide month (format: 1-12)\nInsert new month");
            }

            year=Utils.readIntegerFromConsole("Year:");
            while (!controller.checkYear(year)){
                year =Utils.readIntegerFromConsole("Invalide month (value of year has to be more than 2022)\nInsert new month");
            }

            System.out.println(date=(controller.createDate(day, month, year)));

            startHour=Utils.readIntegerFromConsole("Hour for the beginning of the visit: ");
            while (!controller.checkHour(startHour)){
                startHour =Utils.readIntegerFromConsole("Invalide hour (format: 0-24)\nInsert new hour");
            }

            startMinute=Utils.readIntegerFromConsole("Minutes for the beginning of the visit: ");
            while (!controller.checkMinutes(startMinute)){
                startHour =Utils.readIntegerFromConsole("Invalide minute (format: 0-60)\nInsert new minute");
            }

            endHour=Utils.readIntegerFromConsole("Hour for the ending of the visit: ");
            while (!controller.checkHour(endHour)){
                endHour =Utils.readIntegerFromConsole("Invalide hour (format: 0-24)\nInsert new hour");
            }

            endMinute=Utils.readIntegerFromConsole("Minutes for the ending of the visit: ");
            while (!controller.checkMinutes(endMinute)){
                endMinute =Utils.readIntegerFromConsole("Invalide hour (format: 0-60)\nInsert new hour");
            }
            System.out.println(schedule="Visit hour: "+startHour+":"+startMinute+" until "+endHour+":"+endMinute);
            System.out.println(MessageRepository.getMessageList());
        }



        name = Utils.readLineFromConsole("Employee name:");
        while (name.trim().isEmpty()) {
            name = Utils.readLineFromConsole("Invalid Name \nInsert employee name:");
        }

        phone = Utils.readIntegerFromConsole("Phone number:");
        while (!controller.checkPhone(phone)) {
            phone = Utils.readIntegerFromConsole("Invalid Phone number (format: xxxxxxxxxx) \nInsert new phone number: ");
        }



        System.out.println(controller.addMessage(date, schedule, name, phone).toString2());

        System.out.println("Operation sucess");




    }
}
