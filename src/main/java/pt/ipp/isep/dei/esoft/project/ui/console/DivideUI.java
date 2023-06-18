package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.DivideController;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class DivideUI implements Runnable{
    private final DivideController controller = new DivideController();

    public void run(){
        int numberOfStores;
        numberOfStores = Utils.readIntegerFromConsole("Please insert the number of stores you want to consider for the study: ");
        while (numberOfStores <= 0 || numberOfStores > controller.getStores().size()) {
            System.out.println("Invalid number of stores!");
            numberOfStores = Utils.readIntegerFromConsole("Please insert the number of stores you want to consider for the study: ");
        }
        showsNumberOfPropertiesByStore();
        controller.divideStores(numberOfStores);
    }
    public void showsNumberOfPropertiesByStore() {
        List<Store> storesList = controller.getStores();
        for (Store store : storesList) {
            int numberOfProperties = controller.getNumberOfProperties(store.getID());
            System.out.println("The Store: " + store.getID() + ". " + store.getDesignation() + " has " + numberOfProperties + " properties.");
        }
    }
}
