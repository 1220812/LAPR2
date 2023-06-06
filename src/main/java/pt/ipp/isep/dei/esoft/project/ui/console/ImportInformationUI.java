package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ImportInformationController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for interacting between the user and the controller.
 */
public class ImportInformationUI implements Runnable {
    /**
     * Controller attribute.
     */
   public ImportInformationUI () {}

    public  void run () {
        String filePath = Utils.readLineFromConsole("Insert lien path:");

        ImportInformationController ctrl = new ImportInformationController();

        try {
            ctrl.ImportFile(filePath);
            System.out.println("File successfully imported");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
   }





