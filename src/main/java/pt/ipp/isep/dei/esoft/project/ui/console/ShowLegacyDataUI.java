package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ShowLegacyDataController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for interacting betten the user and the controller.
 */
public class ShowLegacyDataUI implements Runnable {
    /**
     * Controller attribute.
     */
    ShowLegacyDataController controller = new ShowLegacyDataController();
    /**
     * List of options.
     */
    private final List<String> YES_OR_NO = new ArrayList<>() {{
        add("Yes");
        add("No");
    }};

    /**
     * This method runs the UI.
     */
    public void run() {
        String path = "";
        boolean flag;
        do {
            do {
                flag = false;
                try {
                    path = Utils.readLineFromConsole("Insert the path of the file you want to import: ");
                    if(!path.substring(path.length()-4).equals(".csv")) {
                        System.out.println("This file is not valid, please insert a .csv file");
                        flag = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid path");
                    flag = true;
                }
            } while (flag);
            String answer = "";
            do {
                try {
                    answer = (String) Utils.showAndSelectOne(YES_OR_NO, "Do you want to import the information from the file?");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid option");
                    flag = true;
                }
            } while (flag);
            if (answer.equals("Yes")) {
                try {
                   // controller.importInformationFromFile(path);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Trouble with the file");
                    flag = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid path or file is empty");
                    flag = true;
                }
            } else {
                System.out.println("Information not imported");
                return;
            }
        } while (flag);
        System.out.println("Information imported successfully");
    }
}


