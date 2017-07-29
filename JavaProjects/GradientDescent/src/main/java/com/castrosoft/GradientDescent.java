package com.castrosoft;

public class GradientDescent {
    public static final int X = 0;
    public static final int Y = 1;

    private static double[] twoVariableSingleStep(double currentTheta1,
                                                  double currentTheta2,
                                                  double[][] trainingSet,
                                                  double alpha) {

        int trainingSetLength = trainingSet[0].length;
        double tempTheta1 = 0.0;
        double tempTheta2 = 0.0;
        for (int i = 0; i < trainingSetLength; i++) {
            tempTheta1 += -(2.0/trainingSetLength) * trainingSet[X][i] * (trainingSet[Y][i] - (currentTheta1 * trainingSet[X][i] + currentTheta2));
            tempTheta2 += -(2.0/trainingSetLength) * (trainingSet[Y][i] - (currentTheta1 * trainingSet[X][i] + currentTheta2));
        }

        double newTheta1 = currentTheta1 - (alpha * tempTheta1);
        double newTheta2 = currentTheta2 - (alpha * tempTheta2);

        return new double[] {newTheta1, newTheta2};
    }

    private static double computeError(double theta1, double theta2, double[][] trainingSet) {
        double totalError = 0.0;
        int trainingSetLength = trainingSet[0].length;

        for (int i = 0; i < trainingSetLength; i++) {
            totalError += Math.pow((trainingSet[Y][i] - ((theta1 * trainingSet[X][i])+ theta2)), 2);
        }

        return totalError / trainingSetLength;
    }

    public static double[] findOptimalThetas(double[][] trainingSet,
                                      double theta1,
                                      double theta2,
                                      double alpha,
                                      int maximumNumberOfIteration) {
        double lastError = Double.MAX_VALUE;
        double[] lastThetas = new double[]{theta1, theta2};

        for (int i = 0; i < maximumNumberOfIteration; i++) {
            double[] currentStep = GradientDescent.twoVariableSingleStep(theta1, theta2, trainingSet, alpha);
            theta1 = currentStep[0];
            theta2 = currentStep[1];
            lastThetas = new double[]{theta1, theta2};

            double currentError = GradientDescent.computeError(theta1, theta2, trainingSet);

            if (currentError >= lastError) {
                System.out.println("Alright, we stop here.");
                return lastThetas;
            }

            lastError = currentError;
            printThetaValues(currentStep, currentError);
        }

        return lastThetas;
    }

    private static void printThetaValues(double[] currentStep, double currentError) {
        double theta1 = currentStep[0];
        double theta2 = currentStep[1];

        System.out.println("Theta 1: " + theta1 + " - Theta 2: " + theta2 + " - Error: " + currentError);
    }
}
