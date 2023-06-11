package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListRequestsController;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.repository.RequestRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ListRequestsUI implements Runnable {

    ListRequestsController controller = new ListRequestsController();


    public void run() {

//        System.out.println(controller.getRequests());

        System.out.println(controller.getRequestsSorted());


        int startDay = Utils.readIntegerFromConsole("Start day:");
        int endtDay = Utils.readIntegerFromConsole("End day:");
        int startMonth = Utils.readIntegerFromConsole(" Start Month:");
        int endMonth = Utils.readIntegerFromConsole("End Month:");
        int startYear = Utils.readIntegerFromConsole("Start Year");
        int endYear = Utils.readIntegerFromConsole("End Year:");

        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endtDay);

        List<Request> RequestList = RequestRepository.getRequests();

        System.out.println(controller.getRequestDated(RequestList,startDate, endDate));

    }
}
