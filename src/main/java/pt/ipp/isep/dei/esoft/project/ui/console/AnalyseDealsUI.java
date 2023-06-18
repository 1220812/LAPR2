package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AnalyseDealsController;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.IOException;
import java.util.List;

public class AnalyseDealsUI implements Runnable {

    private final AnalyseDealsController controller = new AnalyseDealsController();

    private int regressionModel;

    private double confidenceLevel;

    private int independentVariable;
    private List<Order> deals = controller.getDeals();

    public void run() {
        try {
            requestData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void requestData() throws IOException {
        regressionModel = displayRegressionModelOptions();
        confidenceLevel = displayConfidenceLevelOptions();
        if (regressionModel == 1) {
            independentVariable = displayIndependentVariableOptions();
            if (independentVariable == 1 || independentVariable == 2 || independentVariable == 3 || independentVariable == 4 || independentVariable == 5) {
                controller.calcSimpleRegression(deals, confidenceLevel,independentVariable);
            } else {
                System.out.println("Invalid option. Please try again.");
                requestData();
            }
        } else if (regressionModel == 2) {
            controller.calcMultipleRegression(deals, confidenceLevel);
        } else {
            System.out.println("Invalid option. Please try again.");
            requestData();
        }
    }

    private int displayRegressionModelOptions() {
        return Utils.readIntegerFromConsole("Do you wish to use a Simple Linear Regression or a Multiple Linear Regression?\n" + "1 - Simple Linear Regression\n" + "2 - Multiple Linear Regression\n");
    }

    private int displayIndependentVariableOptions() {
        return Utils.readIntegerFromConsole("Please choose a variable to be used as the independent variable.\n" + "1 - Area (in square feet)\n" + "2 - Distance from city center (in miles)\n" +
                "3 - Number of bedrooms\n" + "4 - Number of bathrooms\n" + "5 - Number of parking\n");
    }

    private double displayConfidenceLevelOptions() {
        return Utils.readDoubleFromConsole("Confidence level (must be 90, 95 or 99): ");
    }
}

