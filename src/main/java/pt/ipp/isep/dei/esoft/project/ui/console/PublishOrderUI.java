package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishOrderController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class PublishOrderUI implements Runnable {

    PublishOrderController controller = new PublishOrderController();
    private Announcement chosenAnnouncement;
    private double orderPrice;
    private boolean validOrder = false;

    public void run() {
        int selection = Utils.showAndSelectIndex(controller.getAnnouncements(), "Please select an announcement: ");
        while (!controller.checkIfOrderIsPending(controller.getAnnouncements().get(selection))) {
            System.out.println("You already have a pending order for this announcement, please choose another one!");
            System.out.println(controller.getAnnouncements());
            selection = Utils.showAndSelectIndex(controller.getAnnouncements(), "Please select an announcement: ");
        }
        do {
            chosenAnnouncement = controller.getAnnouncements().get(selection);
            orderPrice = Utils.readDoubleFromConsole("Insert the price that you want to offer:");
            while (!controller.orderPriceLimits(chosenAnnouncement, orderPrice)) {
                System.out.println("The price that you entered is invalid, please insert a price equal or lower to the price defined in the announcement!");
                System.out.println();
                orderPrice = Utils.readDoubleFromConsole("Insert a valid offer price!");
            }
            if (controller.validateOrder(chosenAnnouncement, orderPrice)) {
                controller.registerOrder(chosenAnnouncement, orderPrice);
                System.out.println("Your order was successfully registered!");
                validOrder = true;
            } else {
                System.out.println("There is other orders registered in the system with the same amount offered for this announcement!");
                selection = Utils.showAndSelectIndex(List.of("Yes", "No"), "Do tou want to keep your order?");
                if (selection == 1) {
                    validOrder = true;
                }
            }
        } while (!validOrder);
    }
}

