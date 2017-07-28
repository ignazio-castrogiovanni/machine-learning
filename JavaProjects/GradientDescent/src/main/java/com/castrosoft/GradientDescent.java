package com.castrosoft;

public class GradientDescent {
    public static final int X = 0;
    public static final int Y = 1;

    private static double[] twoVariableSingleStep(double currentTheta1,
                                                  double currentTheta2,
                                                  double[][] trainingSet,
                                                  double alpha) {

        int trainingSetLength = trainingSet[0].length;
        double tempTetha1 = 0.0;
        double tempTetha2 = 0.0;
        for (int i = 0; i < trainingSetLength; i++) {
            tempTetha1 += -(2.0/trainingSetLength) * trainingSet[X][i] * (trainingSet[Y][i] - (currentTheta1 * trainingSet[X][i] + currentTheta2));
            tempTetha2 += -(2.0/trainingSetLength) * (trainingSet[Y][i] - (currentTheta1 * trainingSet[X][i] + currentTheta2));
        }

        double newTetha1 = currentTheta1 - (alpha * tempTetha1);
        double newTetha2 = currentTheta2 - (alpha * tempTetha2);

        return new double[] {newTetha1, newTetha2};
    }

    private static double computeError(double tetha1, double tetha2, double[][] trainingSet) {
        double totalError = 0.0;
        int trainingSetLength = trainingSet[0].length;

        for (int i = 0; i < trainingSetLength; i++) {
            totalError += Math.pow((trainingSet[Y][i] - ((tetha1 * trainingSet[X][i])+ tetha2)), 2);
        }

        return totalError / trainingSetLength;
    }

    public static double[] findOptimalTethas(double[][] trainingSet,
                                      double tetha1,
                                      double tetha2,
                                      double alpha,
                                      int maximumNumberOfIteration) {
        double lastError = Double.MAX_VALUE;
        double[] lastThetas = new double[]{tetha1, tetha2};

        for (int i = 0; i < maximumNumberOfIteration; i++) {
            double[] currentStep = GradientDescent.twoVariableSingleStep(tetha1, tetha2, trainingSet, alpha);
            tetha1 = currentStep[0];
            tetha2 = currentStep[1];
            lastThetas = new double[]{tetha1, tetha2};

            double currentError = GradientDescent.computeError(tetha1, tetha2, trainingSet);

            if (currentError >= lastError) {
                System.out.println("Alright, we stop here.");
                return lastThetas;
            }

            lastError = currentError;
            printTethaValues(currentStep, currentError);
        }

        return lastThetas;
    }

    private static void printTethaValues(double[] currentStep, double currentError) {
        double tetha1 = currentStep[0];
        double tetha2 = currentStep[1];

        System.out.println("Tetha 1: " + tetha1 + " - Tetha 2: " + tetha2 + " - Error: " + currentError);
    }
}
