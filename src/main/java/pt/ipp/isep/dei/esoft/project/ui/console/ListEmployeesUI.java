package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListEmployeesController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterStoreController;
import pt.ipp.isep.dei.esoft.project.domain.Employee;

/**
 * The type List employees ui.
 */
public class ListEmployeesUI implements Runnable {


    /**
     * The Controller.
     */
    ListEmployeesController controller = new ListEmployeesController();

    @Override
    public void run() {
        System.out.println(controller.getEmployeeRepositorySortedAndGrouped());

    }
}
