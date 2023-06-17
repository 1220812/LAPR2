package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class NetworkUI implements Runnable {


    public NetworkUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("US013 - list all employees", new ListEmployeesUI()));
        options.add(new MenuItem("US017 - List all deals made", new ListDealsUI()));
        options.add(new MenuItem("US019 - to divide the set of all stores into two subsets ", new DivideUI()));


        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nNetwork Manager Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}
