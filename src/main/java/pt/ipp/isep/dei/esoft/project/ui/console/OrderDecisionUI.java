package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.OrderDecisionController;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class OrderDecisionUI implements Runnable {
    public void run() {
        List<Order> emptyList = new ArrayList<>();
        OrderDecisionController controller = new OrderDecisionController();
        System.out.println(controller.getOrderList());
        if (controller.getOrderList().size() == 0) {
            System.out.println();
            System.out.println(emptyList);
            System.out.println();
        } else {
            int order = Utils.showAndSelectIndex(controller.getOrderList(), "List of orders");
            String answer = Utils.readLineFromConsole("Do you accept? (yes/no)");
            boolean decision;
            if (answer.equalsIgnoreCase("yes")) {
                decision = true;
            } else decision = false;
            String propertyCode = controller.getOrderList().get(order).getProperty().getCode();
            int orderNumber = controller.getOrderList().get(order).getOrderNumber();
            controller.makeDecision(propertyCode, orderNumber, decision);
            System.out.println("««« Operation success »»»");
        }
    }
}
