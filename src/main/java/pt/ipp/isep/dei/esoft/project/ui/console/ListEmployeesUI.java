package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListEmployeesController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterStoreController;
import pt.ipp.isep.dei.esoft.project.domain.Employee;

public class ListEmployeesUI implements Runnable {


    ListEmployeesController controller = new ListEmployeesController();

    @Override
    public void run() {
        System.out.println(controller.getEmployeeRepository());
        System.out.println("awsas<dhf<befçefçv<sdfiv<sefçi<vefçiu");

            System.out.println(controller.getEmployeeRepositorySortedAndGrouped());

    }
}
