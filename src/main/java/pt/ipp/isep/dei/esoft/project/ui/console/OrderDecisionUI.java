package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.OrderDecisionController;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Order decision ui.
 */
public class OrderDecisionUI implements Runnable {
    private final OrderDecisionController controller = new OrderDecisionController();

    public void run() {
        Agent agent = controller.getCurrentAgent();
        List<Announcement> assignedAnnouncementList = controller.getAnnouncements();
        if (assignedAnnouncementList.isEmpty()) {
            System.out.println("There are no announcements!");
        } else {
            int i = 0;
            for (Announcement announcement : assignedAnnouncementList) {
                i += 1;
                System.out.println(i);
                System.out.println("Date = " + announcement.getDate());
                System.out.println("Property = " + announcement.getProperty());
            }
            int assignedAnnouncement = Utils.readIntegerFromConsole("Select one of the announcements:");
            while (assignedAnnouncement < 1 || assignedAnnouncement > assignedAnnouncementList.size()) {
                assignedAnnouncement = Utils.readIntegerFromConsole("Select a valid announcement:");
            }
            Announcement announcementChosen = assignedAnnouncementList.get(assignedAnnouncement - 1);
            listOrders(announcementChosen);
        }
    }

    private void listOrders(Announcement announcement) {
        List<Order> emptyOrderList = new ArrayList<>();
        List<Order> allOrders = controller.getAllOrders();
        List<Order> ordersByAnnouncement = controller.getOrdersByAnnouncement(announcement, allOrders);
        if (ordersByAnnouncement.isEmpty()) {
            System.out.println(emptyOrderList);
        } else {
            int selection = Utils.showAndSelectIndex(controller.getOrderListSortedByPrice(ordersByAnnouncement), "Please select one order!");
            Order order = ordersByAnnouncement.get(selection);
            System.out.println("1 - Accept order");
            System.out.println("2 - Decline order");
            System.out.println("0 - Exit");
            int option = Utils.readIntegerFromConsole("Please choose an option!");
            switch (option) {
                case 1:
                    acceptOrder(order, announcement);
                    break;
                case 2:
                    declineOrder(order, announcement);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void declineOrder(Order order, Announcement announcement) {
        if (order == null) {
            System.out.println("Invalid order ID!");
        } else if (order.getStatus() == Status.DECLINED) {
            System.out.println("This order has already been declined");
        } else {
            controller.removeOrder(order);
            System.out.println("Order declined!");
        }

        Agent agent = controller.getCurrentAgent();
        controller.acceptOrder(order, announcement);
        System.out.println(controller.getAnnouncementListSortedByDate(agent));
        LocalDate date = LocalDate.now();
        String path = "src\\main\\java\\pt\\ipp\\isep\\dei\\esoft\\project\\application\\notification\\emails";
        String replyMessage =
                "Subject: Order update - declined"
                        + "\nFrom: " + agent.getEmailAddress()
                        + "\nTo: " + order.getEmail()
                        + "\nBody:"
                        + "\nProperty info:"
                        + "\nProperty type: " + announcement.getProperty().getPropertyType()
                        + "\nAddress: \n" + announcement.getProperty().getAddress()
                        + "\nAgent info:"
                        + "\nName: " + agent.getName()
                        + "\nPhone number: " + agent.getPhoneNumber()
                        + "\nReply date: " + date;
        File newFile = new File(path);
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(newFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        printWriter.write(replyMessage);
        printWriter.close();
    }

    private void acceptOrder(Order order, Announcement announcement) {
        Agent agent = controller.getCurrentAgent();
        if (order == null) {
            System.out.println("Invalid order ID!");
        } else if (order.getStatus() == Status.ACCEPTED) {
            System.out.println("This order has already been accepted");
        } else {
            controller.acceptOrder(order, announcement);
            System.out.println(controller.getAnnouncementListSortedByDate(agent));
            LocalDate date = LocalDate.now();
            String path = "src\\main\\java\\pt\\ipp\\isep\\dei\\esoft\\project\\application\\notification\\emails";
             String replyMessage =
             "Subject: Order update - Accepted"
             + "\nFrom: " + agent.getEmailAddress()
             + "\nTo: " + order.getEmail()
             + "\nBody:"
             + "\nProperty info:"
             + "\nProperty type: " + announcement.getProperty().getPropertyType()
             + "\nAddress: \n" + announcement.getProperty().getAddress()
             + "\nAgent info:"
             + "\nName: " + agent.getName()
             + "\nPhone number: " + agent.getPhoneNumber()
             + "\nReply date: " + date;
             File newFile = new File(path);
             PrintWriter printWriter;
             try {
             printWriter = new PrintWriter(newFile);
             } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
             }
             printWriter.write(replyMessage);
             printWriter.close();
        }
    }

}