package pt.ipp.isep.dei.esoft.project.ui.console;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.ListRequestsController;
import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RequestRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ListRequestsUI implements Runnable {

    ListRequestsController controller = new ListRequestsController();

    private int startDay = 0;
    private int startMonth = 0;
    private int startYear = 0;
    private int endDay = 0;
    private int endMonth = 0;
    private int endYear = 0;
    private LocalDate newStartTime;
    private LocalDate newEndTime;

    public void run() {

        List<Request> RequestList = Repositories.getInstance().getRequestRepository().getRequests();


        System.out.println(controller.getRequests());
        controller.showBookingRequests();
        try {
            System.out.println(controller.getRequestsSorted(RequestList));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        startDay = Utils.readIntegerFromConsole("Start Day: ");
        while (!controller.checkDay(startDay)) {
            startDay = Utils.readIntegerFromConsole("Invalid day (format: 1-31)\n Insert new day");
        }

        startMonth = Utils.readIntegerFromConsole("Start Month:");
        while (!controller.checkMonth(startMonth)) {
            startMonth = Utils.readIntegerFromConsole("Invalid month (format: 1-12)\nInsert new month");
        }

        startYear = Utils.readIntegerFromConsole("Start Year");
        while (!controller.checkYear(startYear)) {
            startYear = Utils.readIntegerFromConsole(")\nInsert new year");
        }

        endDay = Utils.readIntegerFromConsole("End day:");
        while (!controller.checkDay(endDay)) {
            endDay = Utils.readIntegerFromConsole("Invalid day (format: 1-31)\n Insert new day");
        }

        endMonth = Utils.readIntegerFromConsole("End Month:");
        while (!controller.checkMonth(endMonth)) {
            endMonth = Utils.readIntegerFromConsole("Invalid month (format: 1-12)\nInsert new month");
        }

        endYear = Utils.readIntegerFromConsole("End Year:");
        while (!controller.checkYear(endYear)) {
            endYear = Utils.readIntegerFromConsole(")\nInsert new year");
        }

        System.out.println(newStartTime = LocalDate.of(startYear, startMonth, startDay));
        System.out.println(newEndTime = LocalDate.of(endYear, endMonth, endDay));


        while (!controller.checkVisitTime(newStartTime, newEndTime)) {

            System.out.println("Date Entered is invalid");

            startDay = Utils.readIntegerFromConsole("Start Day: ");
            while (!controller.checkDay(startDay)) {
                startDay = Utils.readIntegerFromConsole("Invalid day (format: 1-31)\n Insert new day");
            }

            startMonth = Utils.readIntegerFromConsole(" Start Month:");
            while (!controller.checkMonth(startMonth)) {
                startMonth = Utils.readIntegerFromConsole("Invalid month (format: 1-12)\nInsert new month");
            }

            startYear = Utils.readIntegerFromConsole("Start Year");
            while (!controller.checkYear(startYear)) {
                startYear = Utils.readIntegerFromConsole(")\nInsert new year");
            }

            endDay = Utils.readIntegerFromConsole("End day:");
            while (!controller.checkDay(endDay)) {
                endDay = Utils.readIntegerFromConsole("Invalid day (format: 1-31)\n Insert new day");
            }

            endMonth = Utils.readIntegerFromConsole("End Month:");
            while (!controller.checkMonth(endMonth)) {
                endMonth = Utils.readIntegerFromConsole("Invalid month (format: 1-12)\nInsert new month");
            }

            endYear = Utils.readIntegerFromConsole("End Year:");
            while (!controller.checkYear(endYear)) {
                endYear = Utils.readIntegerFromConsole(")\nInsert new year");
            }

            System.out.println(newStartTime = LocalDate.of(startYear, startMonth, startDay));
            System.out.println(newEndTime = LocalDate.of(endYear, endMonth, endDay));
        }


        System.out.println(controller.getRequestDated(RequestList, newStartTime, newEndTime));

    }


}
