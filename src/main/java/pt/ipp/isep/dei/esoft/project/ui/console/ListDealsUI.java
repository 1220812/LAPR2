package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListDealsController;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class ListDealsUI implements Runnable{
    ListDealsController controller = new ListDealsController();
    public void run(){
        int sortingMethod = sortingMethodSelection();
        int sortingOrder = sortingOrderSelection();
        List<Order> dealsMade;
        List<Order> dealsMadeSorted;
        dealsMade = controller.dealsList();
        if(dealsMade.isEmpty()){
            System.out.println("There are no deals made yet!");
        }else{
            dealsMadeSorted = controller.sortDeals(dealsMade,sortingMethod, sortingOrder);
            System.out.println("<<<<<<Operation completed successfully>>>>>>");
            System.out.println("Do you want to see the list of deals made? (Yes/No)");
            String answer = Utils.readLineFromConsole("Answer: ");
            while (!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No")) {
                System.out.println("Invalid option!");
                answer = Utils.readLineFromConsole("Answer: ");
            }
            if(answer.equalsIgnoreCase("Yes")){
                showDeals(dealsMadeSorted);
            }
        }
    }
    public int sortingMethodSelection(){
        return Utils.showAndSelectIndex(controller.showSortingMethods(), "Please select a sorting method: ");
    }
    public int sortingOrderSelection(){
        return Utils.showAndSelectIndex(controller.showSortingOrder(), "Please select a sorting order: ");
    }
    public void showDeals(List<Order> dealsMade) {
        System.out.println("List of deals:");
        System.out.println();
        for (int i = dealsMade.size() - 1; i >= 0; i--) {
            Order order = dealsMade.get(i);
            System.out.println((dealsMade.size() - i) + " - " + order.toStringDeals());
        }
    }
}
