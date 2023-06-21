package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.domain.Residence;
import pt.ipp.isep.dei.esoft.project.domain.Statistics;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;


import java.text.DecimalFormat;
import java.util.List;

public class AnalyseDealsController {
    private OrderRepository orderRepository;

    public AnalyseDealsController() {
        getOrderRepository();
    }

    public OrderRepository getOrderRepository() {
        if (orderRepository == null) {
            Repositories repositories = Repositories.getInstance();
            orderRepository = repositories.getOrderRepository();
        }
        return orderRepository;
    }

    public List<Order> getDeals() {
        return orderRepository.getOrderAcceptedListHousesAndApparts();
    }


    public String calcSimpleRegression(List<Order> deals, double confidenceLevel, int option) {
        double[][] data = new double[2][deals.size()];
        data = getOrderAmount(data);
        switch (option) {
            case 1:
                data = getAreas(data, 1);
                break;
            case 2:
                data = getDistanceFromCityCenter(data, 1);
                break;
            case 3:
                data = getBedrooms(data, 1);
                break;
            case 4:
                data = getBathrooms(data, 1);
                break;
            case 5:
                data = getNumberOfParkingSpaces(data, 1);
                break;
            default:
        }
        List<String> output = (Statistics.calcSimpleRegression(data, confidenceLevel));
        return simpleRegressionToString(output, option);
    }

    public String calcMultipleRegression(List<Order> deals, double confidenceLevel) {
        double[][] data = new double[7][deals.size()];
        data = getOrderAmount(data);
        data = getAreas(data, 1);
        data = getDistanceFromCityCenter(data, 2);
        data = getBedrooms(data, 3);
        data = getBathrooms(data, 4);
        data = getNumberOfParkingSpaces(data, 5);
        List<String> output = Statistics.calcMultipleRegression(data, confidenceLevel);
        return multiRegressionToString(output);
    }

    public double[][] getOrderAmount(double[][] data) {
        List<Order> orders = orderRepository.getOrderAcceptedListHousesAndApparts();
        for (int i = 0; i < orders.size(); i++) {
            data[0][i] = orders.get(i).getOrderPrice();
        }
        return data;
    }

    public double[][] getAreas(double[][] data, int index) {
        List<Order> orders = orderRepository.getOrderAcceptedListHousesAndApparts();
        for (int i = 0; i < orders.size(); i++) {
            data[index][i] = orders.get(i).getAnnouncement().getProperty().getArea();
        }
        return data;
    }

    private double[][] getDistanceFromCityCenter(double[][] data, int index) {
        List<Order> orders = orderRepository.getOrderAcceptedListHousesAndApparts();
        for (int i = 0; i < orders.size(); i++) {
            data[index][i] = orders.get(i).getAnnouncement().getProperty().getDistanceFromTheCityCenter();
        }
        return data;
    }

    private double[][] getBedrooms(double[][] data, int index) {
        List<Order> orders = orderRepository.getOrderAcceptedListHousesAndApparts();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getAnnouncement().getProperty() instanceof Residence)
                data[index][i] = ((Residence) orders.get(i).getAnnouncement().getProperty()).getNumberOfBedrooms();;
        }
        return data;
    }

    private double[][] getBathrooms(double[][] data, int index) {
        List<Order> orders = orderRepository.getOrderAcceptedListHousesAndApparts();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getAnnouncement().getProperty() instanceof Residence)
                data[index][i] = ((Residence) orders.get(i).getAnnouncement().getProperty()).getNumberOfBathrooms();
        }
        return data;
    }

    private double[][] getNumberOfParkingSpaces(double[][] data, int index) {
        List<Order> orders = orderRepository.getOrderAcceptedListHousesAndApparts();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getAnnouncement().getProperty() instanceof Residence)
                data[index][i] = ((Residence) orders.get(i).getAnnouncement().getProperty()).getNumberOfParkingSpaces();
        }
        return data;
    }

    private String simpleRegressionToString(List<String> output, int option) {
        List<Order> deals = getDeals();
        String independentVariable = independentVariableToString(option);


        StringBuilder result = new StringBuilder();
        int i = 0;
        result.append("Forecasted value for ").append(independentVariable).append(":\n");

        while (!output.get(i).equals("Next")) {
            result.append("Property sold for: ").append(deals.get(i).getOrderPrice()).append("$").append(" - Forecasted value: ");
            result.append(output.get(i)).append("$").append("\n");
            i++;
        }
        double slope = Double.parseDouble(output.get(i + 1));
        System.out.println(slope);
        double intercept = Double.parseDouble(output.get(i + 2));
        System.out.println(intercept);

        if (slope < 0) {
            result.append("\nFor ").append(independentVariable).append(":\ny^ = ").append(intercept).append("x - ").append(Math.abs(slope)).append("\n");
        } else {
            result.append("\nFor ").append(independentVariable).append(":\ny^ = ").append(intercept).append("x + ").append(slope).append("\n");
        }

        double correlationCoefficient = Double.parseDouble(output.get(i + 3));
        System.out.println(correlationCoefficient);
        double determinationCoefficient = Double.parseDouble(output.get(i + 4));
        System.out.println(determinationCoefficient);

        result.append("\nR = ").append(toDecimalFormat(correlationCoefficient)).append("\n");
        result.append("R^2 = ").append(toDecimalFormat(determinationCoefficient)).append("\n");

        double interceptLowerBound = Double.parseDouble(output.get(i + 5));
        System.out.println("algo" + interceptLowerBound);
        double interceptUpperBound = Double.parseDouble(output.get(i + 6));
        System.out.println(interceptUpperBound);

        result.append("\nThe confidence interval for a^ is ]").append(toDecimalFormat(interceptLowerBound)).append(" ; ").append(toDecimalFormat(interceptUpperBound)).append("[\n");

        double slopeLowerBound = Double.parseDouble(output.get(i + 7));
        System.out.println(slopeLowerBound);
        double slopeUpperBound = Double.parseDouble(output.get(i + 8));
        System.out.println(slopeUpperBound);

        result.append("The confidence interval for b^ is ]").append(toDecimalFormat(slopeLowerBound)).append(" ; ").append(toDecimalFormat(slopeUpperBound)).append("[\n");


        double interceptValue = Double.parseDouble(output.get(i + 9));
        System.out.println(interceptValue);
        double interceptCriticalValue = Double.parseDouble(output.get(i + 10));
        System.out.println(interceptCriticalValue);
        String interceptReject = output.get(i + 11);
        System.out.println(interceptReject);

        result.append("\nHypothesis test for a^:\n");
        result.append("H0: a = 0\n");
        result.append("H1: a ≠ 0\n");
        result.append("The Ta: ").append(toDecimalFormat(interceptValue)).append("\n");
        result.append("The critical value: ").append(toDecimalFormat(interceptCriticalValue)).append("\n");
        if (interceptReject.equals("true")) {
            result.append("The hypothesis H0 was accepted because Ta > Critical value\n");
        } else {
            result.append("The hypothesis H0 was rejected because Ta < Critical value\n");
        }

        double slopeValue = Double.parseDouble(output.get(i + 12));
        System.out.println(slopeValue);
        double slopeCriticalValue = Double.parseDouble(output.get(i + 13));
        System.out.println(slopeCriticalValue);
        String slopeReject = output.get(i + 14);
        System.out.println(slopeReject);

        result.append("\nHypothesis test for b^:\n");
        result.append("H0: b = 0\n");
        result.append("H1: b ≠ 0\n");
        result.append("The Tb: ").append(toDecimalFormat(slopeValue)).append("\n");
        result.append("The critical value: ").append(toDecimalFormat(slopeCriticalValue)).append("\n");
        if (slopeReject.equals("true")) {
            result.append("The hypothesis H0 was accepted because Tb > Critical value\n");
        } else {
            result.append("The hypothesis H0 was rejected because Tb < Critical value\n");
        }

        double regressionDegreesOfFreedom = Double.parseDouble(output.get(i + 15));
        double regressionSumOfSquares = Double.parseDouble(output.get(i + 16));
        double regressionMeanSquare = Double.parseDouble(output.get(i + 17));
        double regressionFValue = Double.parseDouble(output.get(i + 18));
        double residualDegreesOfFreedom = Double.parseDouble(output.get(i + 19));
        double residualSumOfSquares = Double.parseDouble(output.get(i + 20));
        double residualMeanSquare = Double.parseDouble(output.get(i + 21));
        double totalDegreesOfFreedom = Double.parseDouble(output.get(i + 22));
        double totalSumOfSquares = Double.parseDouble(output.get(i + 23));

        result.append("Anova Table:\n");
        result.append("----------------------------------------------------------------\n");
        result.append("Source of Variation     Degrees of Freedom          Sum of Squares             Mean Square            F Value   \n");
        result.append("Regression                   ").append(toDecimalFormat(regressionDegreesOfFreedom)).append("                   ");
        result.append(toDecimalFormat(regressionSumOfSquares)).append("         ").append(toDecimalFormat(regressionMeanSquare));
        result.append("        ").append(toDecimalFormat(regressionFValue)).append("\n");
        result.append("Residual                    ").append(toDecimalFormat(residualDegreesOfFreedom)).append("                  ");
        result.append(toDecimalFormat(residualSumOfSquares)).append("          ").append(toDecimalFormat(residualMeanSquare)).append("\n");
        result.append("Total                       ").append(toDecimalFormat(totalDegreesOfFreedom)).append("                  ");
        result.append(toDecimalFormat(totalSumOfSquares)).append("\n");
        result.append("----------------------------------------------------------------\n");

        return result.toString();
    }

    private String multiRegressionToString(List<String> output) {
        List<Order> deals = getDeals();

        StringBuilder result = new StringBuilder();

        result.append("Multiple Linear Regression\n");

        result.append("Forecasted value for : \n");

        int i = 0;
        while (!output.get(i).equals("Next")) {
            result.append("Property sold for: ").append(deals.get(i).getOrderPrice()).append("$").append(" - Forecasted value: ");
            result.append(output.get(i)).append("$").append("\n");
            i++;
        }

        double correlationCoefficient = Double.parseDouble(output.get(i + 1));
        double determinationCoefficient = Double.parseDouble(output.get(i + 2));

        result.append("\nR^2= ").append(toDecimalFormat(correlationCoefficient)).append("\n");
        result.append("R^2  adjusted = ").append(toDecimalFormat(determinationCoefficient)).append("\n");


        for (int j = 0; j < 6; j++) {
            double coefficientLowerBound = Double.parseDouble(output.get(i + 3 + j).replace(",", "."));

            double coefficientUpperBound = Double.parseDouble(output.get(i + 9 + j).replace(",", "."));

            double tStatistic = Double.parseDouble(output.get(i + 15 + 2 * j).replace(",", "."));

            double criticalValue = Double.parseDouble(output.get(i + 16 + 2 * j).replace(",", "."));

            String independentVariableString = independentVariableToString(j);

            result.append("\nHypothesis test for ").append(independentVariableString).append(":\n");
            result.append("H0: b = 0\n");
            result.append("H1: b ≠ 0\n");
            result.append("T value: ").append(toDecimalFormat(tStatistic)).append("\n");
            result.append("The critical value: ").append(toDecimalFormat(criticalValue)).append("\n");
            if (tStatistic <= criticalValue) {
                result.append("The hypothesis H0 was accepted because Tb > Critical value\n");
            } else {
                result.append("The hypothesis H0 was rejected because Tb < Critical value\n");
            }
            result.append("\nThe confidence interval for ").append(independentVariableString).append("  is ]").append(toDecimalFormat(coefficientLowerBound));
            result.append(" ; ").append(toDecimalFormat(coefficientUpperBound)).append("[\n");



        }
        double explainedSumOfSquares = Double.parseDouble(output.get(i + 27).replace(",", "."));
        double degreesOfFreedomR = Double.parseDouble(output.get(i + 28).replace(",", "."));
        double meanSquareRegression = Double.parseDouble(output.get(i + 29).replace(",", "."));
        double fValue = Double.parseDouble(output.get(i + 30).replace(",", "."));
        double residualSumOfSquares = Double.parseDouble(output.get(i + 31).replace(",", "."));
        double degreesOfFreedomRSS = Double.parseDouble(output.get(i + 32).replace(",", "."));
        double meanSquaredError = Double.parseDouble(output.get(i + 33).replace(",", "."));
        double totalSumOfSquares = Double.parseDouble(output.get(i + 34).replace(",", "."));
        double degreesOfFreedomTSS = Double.parseDouble(output.get(i + 35).replace(",", "."));

        result.append("Anova Table\n");
        result.append("----------------------------------------------------------------------------------------------------------------------------------\n");
        // Table headers
        result.append("Source of Variation     Sum of Squares       Degrees of Freedom         Mean Square            F   \n");
        result.append("----------------------------------------------------------------------------------------------------------------------------------\n");
        // Table data
        result.append("Regression             ").append(toDecimalFormat(explainedSumOfSquares)).append("                 ").append(toDecimalFormat(degreesOfFreedomR));
        result.append("                ").append(toDecimalFormat(meanSquareRegression)).append("        ").append(toDecimalFormat(fValue));
        result.append("\nError                  ").append(toDecimalFormat(residualSumOfSquares)).append("            ").append(toDecimalFormat(degreesOfFreedomRSS)).append("               ")
                .append(toDecimalFormat(meanSquaredError));
        result.append("\nTotal                  ").append(toDecimalFormat(totalSumOfSquares)).append("           ")
                .append(toDecimalFormat(degreesOfFreedomTSS));


        return result.toString();
    }

    private String toDecimalFormat(double number) {
        DecimalFormat df = new DecimalFormat("#.####");
        return df.format(number);
    }

    private String independentVariableToString(int option) {
        String independentVariable = "";

        switch (option) {
            case 0:
                independentVariable = "Intercept";
                break;
            case 1:
                independentVariable = "Area (square feet)";
                break;
            case 2:
                independentVariable = "Distance from city center (miles)";
                break;
            case 3:
                independentVariable = "Number of bedrooms";
                break;
            case 4:
                independentVariable = "Number of bathrooms";
                break;
            case 5:
                independentVariable = "Number of parking spaces";
                break;
            default:
        }
        return independentVariable;
    }
}


