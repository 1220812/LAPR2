package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.DivideController;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class DivideUI implements Runnable{
    private final DivideController controller = new DivideController();

    public void run(){
        showsNumberOfPropertiesByStore();
        controller.divideStores();
    }
    public void showsNumberOfPropertiesByStore() {
        List<Store> storesList = controller.getStores();
        for (Store store : storesList) {
            int numberOfProperties = controller.getNumberOfProperties(store.getID());
            System.out.println("The Store: " + store.getID() + ". " + store.getDesignation() + " has " + numberOfProperties + " properties.");
        }
    }
}
