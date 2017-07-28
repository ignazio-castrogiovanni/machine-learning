package com.castrosoft;

import org.junit.Test;

public class GreadientDescentTest {
    @Test
    public void twoVariablesDescent() {
        double[][] trainingSet = new double[2][4];
        trainingSet[0][0] = 3;
        trainingSet[0][1] = 1;
        trainingSet[0][2] = 0;
        trainingSet[0][3] = 4;

        trainingSet[1][0] = 2;
        trainingSet[1][1] = 2;
        trainingSet[1][2] = 1;
        trainingSet[1][3] = 3;

        double teta1 = 0;
        double teta2 = 0;
        double alpha = 0.001;

        int numberOfIteration = 20000;
        findOptimalTetha(trainingSet, teta1, teta2, alpha, numberOfIteration);
    }

    private void findOptimalTetha(double[][] trainingSet,
                                  double tetha1,
                                  double tetha2,
                                  double alpha,
                                  int numberOfIteration) {
        double lastError = Double.MAX_VALUE;
        for (int i = 0; i < numberOfIteration; i++) {
            double[] currentStep = GreadientDescent.twoVariableSingleStep(tetha1, tetha2, trainingSet, alpha);
            tetha1 = currentStep[0];
            tetha2 = currentStep[1];

            double currentError = GreadientDescent.computeError(tetha1, tetha2, trainingSet);

            if (currentError > lastError) {
                System.out.println("Alright, we stop here.");
                break;
            }

            lastError = currentError;
            printTethaValues(currentStep, currentError);
        }
    }

    private void printTethaValues(double[] currentStep, double currentError) {
        double tetha1 = currentStep[0];
        double tetha2 = currentStep[1];

        System.out.println("Tetha 1: " + tetha1 + " - Tetha 2: " + tetha2 + " - Error: " + currentError);
    }
}