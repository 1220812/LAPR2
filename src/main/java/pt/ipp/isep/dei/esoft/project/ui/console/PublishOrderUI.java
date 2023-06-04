package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishOrderController;

public class PublishOrderUI implements Runnable {

    private final PublishOrderController controller = new PublishOrderController();

    private PublishOrderController getController() {
        return controller;
    }

    public void run(){


    }
}
