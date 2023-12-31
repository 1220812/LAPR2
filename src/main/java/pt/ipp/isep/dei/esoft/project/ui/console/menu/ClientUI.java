package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.BookingRequestFeedbackUI;
import pt.ipp.isep.dei.esoft.project.ui.console.PublishOrderUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterEmployeeUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ScheduleVisitUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClientUI implements Runnable {
    public ClientUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("US009-Schedule a visit", new ScheduleVisitUI()));
        options.add(new MenuItem("US010-Place an order to purchase a property", new PublishOrderUI()));
        options.add(new MenuItem("US020-Accept or decline the reply for a appointment request", new BookingRequestFeedbackUI()));



        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nClient Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
