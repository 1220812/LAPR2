package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishOrderController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.CurrentSession;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PublishOrderUI implements Runnable {

    PublishOrderController controller = new PublishOrderController();
    private Announcement chosenAnnouncement;
    private double orderPrice;
    private boolean validOrder = false;
    private List<Order> orderList = new ArrayList<>();

    public void run() {
        int selection = showAndSelectAnnouncement(controller.getAnnouncements());
        chosenAnnouncement = controller.getAnnouncements().get(selection);
        if (controller.verifyIfEmailHasOrder(CurrentSession.getEmail(), orderList)) {
            System.out.println("You already have an order pending for this announcement, you cannot publish another one!");
        }
        orderPrice = requestOrderPrice();
        while (controller.verifyIfAmountIsOnLimits(chosenAnnouncement, orderPrice) || orderPrice <= 0) {
            System.out.println("The order price inserted must be equal or lower than the owner set price and higher than 0!");
            orderPrice = requestOrderPrice();
        }
        if (controller.verifyIfThePriceIsUnique(orderPrice, orderList)) {
            System.out.println("There's already an order with this price, and will be considered first!");
            controller.createOrder(orderPrice, CurrentSession.getEmail(), chosenAnnouncement);
            System.out.println("Order published successfully!");
        } else {
            controller.createOrder(orderPrice, CurrentSession.getEmail(), chosenAnnouncement);
            System.out.println("Order published successfully!");
        }

    }

    private int showAndSelectAnnouncement(List<Announcement> announcements) {
        int selection = Utils.showAndSelectIndex(announcements, "Choose the announcement you want to publish an order for: ");
        return selection;
    }

    private double requestOrderPrice() {
        orderPrice = Utils.readDoubleFromConsole("Insert the price you want to offer for this property: ");
        return orderPrice;
    }
}
