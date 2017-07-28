package com.castrosoft;

public class GreadientDescent {
    private static final int X = 0;
    private static final int Y = 1;

    public static double[] twoVariableSingleStep(double currentTheta1,
                                              double currentTheta2,
                                              double [][] trainingSet,
                                              double alpha) {

        int numberOfExperiences = trainingSet.length;
        double tempTeta1 = 0.0;
        double tempTeta2 = 0.0;
        for (int i = 0; i < numberOfExperiences; i++) {
            tempTeta1 += -(2/numberOfExperiences) * trainingSet[X][i] * (trainingSet[Y][i] - (currentTheta1 * trainingSet[X][i] + currentTheta2));
            tempTeta2 += -2/numberOfExperiences * (trainingSet[Y][i] - (trainingSet[Y][i] - (currentTheta1 * trainingSet[X][i] + currentTheta2)));
        }

        double newTeta1 = currentTheta1 - (alpha * tempTeta1);
        double newTeta2 = currentTheta2 - (alpha * tempTeta2);

        double[] newTeta = new double[] {newTeta1, newTeta2};

        return newTeta;
    }

    public static double computeError(double tetha1, double tetha2, double[][] trainingSet) {
        double totalError = 0.0;
        int numberOfExperiences = trainingSet.length;

        for (int i = 0; i < numberOfExperiences; i++) {
            totalError += Math.pow((trainingSet[Y][i] - ((tetha2 * trainingSet[X][i])+ tetha2)), 2);
        }

        return totalError / numberOfExperiences;
    }
}
