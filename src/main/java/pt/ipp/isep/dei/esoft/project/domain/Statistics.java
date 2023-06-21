
package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import org.apache.commons.math3.distribution.TDistribution;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Statistics implements Serializable {
    private static ArrayList<Double> forecastedPrices = new ArrayList<>();

    private static double determinationCoefficient;
    private static double adjustedDeterminationCoefficient;
    private static double alfa;
    private static int n;
    private static double[][] confidenceIntervals = new double[3][2];
    private static boolean[] rejects = new boolean[2];
    private static double totalSumOfSquares;
    private static double residualSumOfSquares;
    private static double fValue;
    private static double pValue;
    private static double criticalValue;

    private static double[] coefficientLowerBounds = new double[6];
    private static double[] coefficientUpperBounds = new double[6];


    public static List<String> calcSimpleRegression(double[][] deals, double confidenceLevel) {
        try {
            List<String> output = new ArrayList<>();

            SimpleRegression regression = new SimpleRegression();
            int size = deals[0].length;
            //Forecast Prices
            for (int i = 0; i < size; i++) {
                regression.addData(deals[1][i], deals[0][i]);
            }

            if (!forecastedPrices.isEmpty()) {
                forecastedPrices.clear();
            }

            for (int i = 0; i < size; i++) {
                forecastedPrices.add(regression.predict(deals[1][i]));
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.####");
            StringBuilder formattedNumbers = new StringBuilder();

            for (double forecastPrice : forecastedPrices) {
                String formattedNumber = decimalFormat.format(forecastPrice);
                formattedNumbers.append(formattedNumber).append("; ");
                output.add(formattedNumber);
            }

            if (formattedNumbers.length() > 0) {
                formattedNumbers.setLength(formattedNumbers.length() - 2);
            }

            output.add("Next");

            //R, R^2 and adjusted R^2
            double correlationCoefficient = regression.getR();
            determinationCoefficient = regression.getRSquare();
            adjustedDeterminationCoefficient = 1 - (1 - determinationCoefficient) * (size - 1) / (size - 2 - 1);

            //Confidence Interval
            double slopeStandardError = regression.getSlopeStdErr();
            double slope = regression.getSlope();
            confidenceLevel = confidenceLevel / 100;
            alfa = 1 - confidenceLevel;
            n = size;
            int residualDegreesOfFreedom = n - 2;
            double intercept = regression.getIntercept();
            TDistribution tDistribution = new TDistribution(residualDegreesOfFreedom);

            output.add(String.valueOf(intercept));
            output.add(String.valueOf(slope));

            output.add(String.valueOf(correlationCoefficient));
            output.add(String.valueOf(determinationCoefficient));

            double interceptStandardError = regression.getInterceptStdErr();
            double interceptLowerBound = intercept - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;
            double interceptUpperBound = intercept + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * interceptStandardError;

            confidenceIntervals[0][0] = interceptLowerBound;
            confidenceIntervals[1][1] = interceptUpperBound;

            output.add(String.valueOf(interceptLowerBound));
            output.add(String.valueOf(interceptUpperBound));


            double slopeLowerBound = regression.getSlope() - tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
            double slopeUpperBound = regression.getSlope() + tDistribution.inverseCumulativeProbability(1 - alfa / 2) * slopeStandardError;
            confidenceIntervals[2][0] = slopeLowerBound;
            confidenceIntervals[2][1] = slopeUpperBound;

            output.add(String.valueOf(slopeLowerBound));
            output.add(String.valueOf(slopeUpperBound));

            //Hyphotesis Test
            double a0 = 0;
            double b0 = 0;
            boolean interceptReject;
            boolean slopeReject;
            intercept = regression.getIntercept();
            double interceptTValue = (intercept - a0) / interceptStandardError;
            double interceptCriticalValue = tDistribution.inverseCumulativeProbability(1 - alfa / 2);

            if (Math.abs(interceptTValue) > interceptCriticalValue) {
                interceptReject = true;
            } else {
                interceptReject = false;
            }

            output.add(String.valueOf(interceptTValue));
            output.add(String.valueOf(interceptCriticalValue));
            output.add(String.valueOf(interceptReject));

            slope = regression.getSlope();
            double slopeTValue = (slope - b0) / slopeStandardError;
            double slopeCriticalValue = tDistribution.inverseCumulativeProbability(1 - (alfa / 2));

            if (Math.abs(slopeTValue) > slopeCriticalValue) {
                slopeReject = true;
            } else {
                slopeReject = false;
            }

            output.add(String.valueOf(slopeTValue));
            output.add(String.valueOf(slopeCriticalValue));
            output.add(String.valueOf(slopeReject));

            rejects[0] = interceptReject;
            rejects[1] = slopeReject;

            //Anova
            totalSumOfSquares = regression.getTotalSumSquares();
            double regressionSumOfSquares = regression.getRegressionSumSquares();
            residualSumOfSquares = regression.getSumSquaredErrors();

            int totalDegreesOfFreedom = n - 1;
            int regressionDegreesOfFreedom = 1;
            residualDegreesOfFreedom = n - 2;

            double regressionMeanSquare = regressionSumOfSquares / regressionDegreesOfFreedom;
            double residualMeanSquare = residualSumOfSquares / residualDegreesOfFreedom;

            fValue = regressionMeanSquare / residualMeanSquare;
            FDistribution fDistribution = new FDistribution(regressionDegreesOfFreedom, residualDegreesOfFreedom);
            //pValue = 1 - fDistribution.cumulativeProbability(fValue);
            criticalValue = fDistribution.inverseCumulativeProbability(1 - alfa);

            //DecimalFormat decimalFormat2 = new DecimalFormat("0.00E0");
            //String formattedNumber2 = decimalFormat2.format(pValue);

            output.add(String.valueOf(regressionDegreesOfFreedom));
            output.add(String.valueOf(regressionSumOfSquares));
            output.add(String.valueOf(regressionMeanSquare));
            output.add(String.valueOf(fValue));
            output.add(String.valueOf(residualDegreesOfFreedom));
            output.add(String.valueOf(residualSumOfSquares));
            output.add(String.valueOf(residualMeanSquare));
            output.add(String.valueOf(totalDegreesOfFreedom));
            output.add(String.valueOf(totalSumOfSquares));

            return output;
        }catch (NotStrictlyPositiveException e){
            throw e;
        }

    }


    public static List<String> calcMultipleRegression(double[][] deals, double confidenceLevel) {
        try {
            OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();

            List<String> output = new ArrayList<>();

            confidenceLevel = confidenceLevel / 100;

            n = deals[0].length;
            double[][] independentVariables = new double[n][5];
            double[] dependentVariable = new double[n];

            for (int i = 0; i < n; i++) {
                independentVariables[i][0] = deals[1][i]; //area
                independentVariables[i][1] = deals[2][i]; //distanceFromCenter
                independentVariables[i][2] = deals[3][i]; //bedroom
                independentVariables[i][3] = deals[4][i]; //bathroom
                independentVariables[i][4] = deals[5][i]; //parkingSpace

                dependentVariable[i] = deals[0][i]; //price
            }

            regression.newSampleData(dependentVariable, independentVariables);

            // General Data
            double[] coefficients = regression.estimateRegressionParameters();
            determinationCoefficient = regression.calculateRSquared();
            adjustedDeterminationCoefficient = regression.calculateAdjustedRSquared();
            double[] standardErrors = regression.estimateRegressionParametersStandardErrors();
            double[] estimatedCoefficient = regression.estimateRegressionParameters();
            alfa = 1 - confidenceLevel;
            int numIndependentVariables = 5;

            //Forecasted Prices
            if (!forecastedPrices.isEmpty()) {
                forecastedPrices.clear();
            }

            for (int i = 0; i < n; i++) {

                double predictedSaleValue = coefficients[0] + coefficients[1] * deals[1][i] + coefficients[2] * deals[2][i] +
                        coefficients[3] * deals[3][i] + coefficients[4] * deals[4][i] + coefficients[5] * deals[5][i];

                forecastedPrices.add(predictedSaleValue);
                output.add(String.valueOf(predictedSaleValue));
            }

            output.add("Next");
            output.add(String.valueOf(determinationCoefficient));
            output.add(String.valueOf(adjustedDeterminationCoefficient));

            // Coefficient Intervals
            int numPredictors = 5; // Number of independent variables
            int degreesOfFreedom = n - numPredictors - 1;
            TDistribution tDistribution = new TDistribution(degreesOfFreedom);
            criticalValue = tDistribution.inverseCumulativeProbability(1 - (1 - confidenceLevel) / 2);

            for (int i = 0; i < coefficients.length; i++) {
                double coefficient = coefficients[i];
                double standardError = standardErrors[i];
                coefficientLowerBounds[i] = coefficient - criticalValue * standardError;
                coefficientUpperBounds[i] = coefficient + criticalValue * standardError;
            }

            DecimalFormat decimalFormat = new DecimalFormat("#.####");
            StringBuilder formattedNumbers = new StringBuilder();
            StringBuilder formattedNumbers2 = new StringBuilder();


            for (double coefficientLowerBounds : coefficientLowerBounds) {
                String formattedNumber = decimalFormat.format(coefficientLowerBounds);
                formattedNumbers.append(formattedNumber).append("; ");
                output.add(formattedNumber);
            }

            if (formattedNumbers.length() > 0) {
                formattedNumbers.setLength(formattedNumbers.length() - 2);
            }

            for (double coefficientUpperBounds : coefficientUpperBounds) {
                String formattedNumber2 = decimalFormat.format(coefficientUpperBounds);
                formattedNumbers2.append(formattedNumber2).append("; ");
                output.add(formattedNumber2);
            }

            if (formattedNumbers2.length() > 0) {
                formattedNumbers2.setLength(formattedNumbers2.length() - 2);
            }

            //ANOVA
            residualSumOfSquares = regression.calculateResidualSumOfSquares();
            double explainedSumOfSquares = regression.calculateTotalSumOfSquares() - residualSumOfSquares;
            totalSumOfSquares = regression.calculateTotalSumOfSquares();
            double degreesOfFreedomR = 5;
            double degreesOfFreedomRSS = n - numIndependentVariables - 1;
            double degreesOfFreedomTSS = n - 1;
            double meanSquareRegression = explainedSumOfSquares / numIndependentVariables;
            double meanSquaredError = residualSumOfSquares / degreesOfFreedomRSS;
            fValue = meanSquareRegression / meanSquaredError;

            FDistribution fDistribution = new FDistribution(numIndependentVariables, n - numIndependentVariables - 1);
            double multipleCriticalValue = fDistribution.inverseCumulativeProbability(1 - alfa);

            //Hyphotesis Testing

            for (int i = 0; i < estimatedCoefficient.length; i++) {
                double tStat = coefficients[i] / standardErrors[i]; //t0
                output.add(String.valueOf(tStat));
                output.add(String.valueOf(multipleCriticalValue));
            }

            output.add(String.valueOf(explainedSumOfSquares));
            output.add(String.valueOf(degreesOfFreedomR));
            output.add(String.valueOf(meanSquareRegression));
            output.add(String.valueOf(fValue));
            output.add(String.valueOf(residualSumOfSquares));
            output.add(String.valueOf(degreesOfFreedomRSS));
            output.add(String.valueOf(meanSquaredError));
            output.add(String.valueOf(totalSumOfSquares));
            output.add(String.valueOf(degreesOfFreedomTSS));

            return output;
        }catch (NotStrictlyPositiveException e) {
            throw e;
        }

    }


}
