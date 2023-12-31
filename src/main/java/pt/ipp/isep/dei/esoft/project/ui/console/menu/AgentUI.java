package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.ui.gui.ListRequestsGUI;

import java.util.ArrayList;
import java.util.List;

public class AgentUI implements Runnable {
    public AgentUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("US 002 - Register announcement", new RegisterAnnouncementUI()));
        options.add(new MenuItem("US 008 - Post announcement request", new PostAnnouncementRequestUI()));
        options.add(new MenuItem("US 011 - list real estate purchase orders", new OrderDecisionUI()));
        options.add(new MenuItem("US 015 - List all booking requests", new ListRequestsGUI()));
        options.add(new MenuItem("US 016 - Respond to booking requests", new RespondBookingRequestUI()));



        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAgent Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
