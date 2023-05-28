package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.OrderDecisionController;
import pt.ipp.isep.dei.esoft.project.domain.EmailService;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import java.util.ArrayList;
public class OrderDecisionUI implements Runnable{
    OrderDecisionController controller = new OrderDecisionController();
    @Override
    public void run() {
        int numberOfOrders, aux, selectedOption1, selectedOption2, selectedOption3;
        ArrayList<Order> ordersList = controller.getProperties();
        ordersList = controller.sortOrdersByAge(ordersList);
        do{
            numberOfOrders = 0; aux = 0;
            for(Order order : ordersList){
                ArrayList<Double> offers = controller.getOrders(order);
                aux++;
                if(offers.size() != 0){
                    numberOfOrders++;
                    System.out.println(aux + ". " + order.getPropertyCode());
                }
            }
            if(numberOfOrders == 0){
                ArrayList<Order> emptyOrderList = new ArrayList<>();
                System.out.print(emptyOrderList);
                selectedOption1 = 0;
            }
            else{
                System.out.println("0. Cancel");
                selectedOption1 = Utils.readIntegerFromConsole("Select one property from the list:");
                if(selectedOption1 != 0){
                    ArrayList<Double> orders = controller.getOrders(ordersList.get(selectedOption1 - 1));
                    orders = controller.sortOrdersByAmount(orders);
                    numberOfOrders = 0;
                    System.out.println();
                    for(Double amount : orders){
                        numberOfOrders++;
                        System.out.printf(numberOfOrders + ". %.3f\n", amount);
                    }
                    System.out.println();
                    selectedOption2 = Utils.readIntegerFromConsole("Select an offer: ");
                    System.out.println("Offer " + selectedOption2 + ". " + orders.get(selectedOption2 - 1) + " selected:");
                    System.out.println("1 - Accept");
                    System.out.println("2 - Decline");
                    selectedOption3 = Utils.readIntegerFromConsole("Choose an selectedOption1: ");
                    switch (selectedOption3) {
                        case 1:
                            controller.removeOffers(selectedOption2-1, selectedOption1-1);
                            System.out.println("Purchase order accepted with success");
                            System.out.println();
                            EmailService.generateNotification("accepted");
                            System.out.println();
                            break;
                        case 2:
                            controller.removeOffer(selectedOption2-1, selectedOption1-1);
                            System.out.println("Purchase order declined with success");
                            EmailService.generateNotification("declined");
                            break;
                        default:
                            System.out.println("choose a valid selectedOption1");
                    }
                }
            }
        }while (selectedOption1 != 0);
    }
}