package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListEmployeesController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterStoreController;

public class ListEmployeesUI implements Runnable{



    ListEmployeesController controller = new ListEmployeesController();
    @Override
    public void run() {
        System.out.println("gelado");
    }
}
