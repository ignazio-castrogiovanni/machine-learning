package com.castrosoft;

import org.junit.Test;

import static com.castrosoft.GradientDescent.X;
import static com.castrosoft.GradientDescent.Y;

public class GradientDescentTest {
    @Test
    public void twoVariablesDescentTestOne() {
        double[][] trainingSet = new double[2][4];
        trainingSet[X][0] = 3;
        trainingSet[X][1] = 1;
        trainingSet[X][2] = 0;
        trainingSet[X][3] = 4;

        trainingSet[Y][0] = 2;
        trainingSet[Y][1] = 2;
        trainingSet[Y][2] = 1;
        trainingSet[Y][3] = 3;

        double tetha1 = 0;
        double tetha2 = 0;
        double alpha = 0.001;

        int maximumNumberOfIterations = 20000;
        GradientDescent.findOptimalTethas(trainingSet, tetha1, tetha2, alpha, maximumNumberOfIterations);
    }

    @Test
    public void twoVariablesDescentTestTwo() {
        double[][] trainingSet = new double[2][8];
        trainingSet[X][0] = 1;
        trainingSet[X][1] = 1;
        trainingSet[X][2] = 2;
        trainingSet[X][3] = 2;
        trainingSet[X][4] = 3;
        trainingSet[X][5] = 3;
        trainingSet[X][6] = 4;
        trainingSet[X][7] = 4;

        trainingSet[Y][0] = 1.2;
        trainingSet[Y][1] = 0.8;
        trainingSet[Y][2] = 2.3;
        trainingSet[Y][3] = 1.7;
        trainingSet[Y][4] = 3.1;
        trainingSet[Y][5] = 2.9;
        trainingSet[Y][6] = 5;
        trainingSet[Y][7] = 3;

        double tetha1 = 10;
        double tetha2 = 10;
        double alpha = 0.001;

        int maximumNumberOfIterations = 200000;
        GradientDescent.findOptimalTethas(trainingSet, tetha1, tetha2, alpha, maximumNumberOfIterations);
    }
}