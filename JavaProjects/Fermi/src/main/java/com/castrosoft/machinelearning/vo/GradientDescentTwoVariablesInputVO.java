package com.castrosoft.machinelearning.vo;

/**
 * Created by Ignazio Castrogiovanni on 29/7/17.
 */
public class GradientDescentTwoVariablesInputVO {
    private double[][] trainingSet;
    private double startingTheta1;
    private double startingTheta2;
    private double alpha;
    private int maximumNumberOfIteration;

    public double[][] getTrainingSet() {
        return trainingSet;
    }

    public void setTrainingSet(double[][] trainingSet) {
        this.trainingSet = trainingSet;
    }

    public double getStartingTheta1() {
        return startingTheta1;
    }

    public void setStartingTheta1(double startingTheta1) {
        this.startingTheta1 = startingTheta1;
    }

    public double getStartingTheta2() {
        return startingTheta2;
    }

    public void setStartingTheta2(double startingTheta2) {
        this.startingTheta2 = startingTheta2;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public int getMaximumNumberOfIteration() {
        return maximumNumberOfIteration;
    }

    public void setMaximumNumberOfIteration(int maximumNumberOfIteration) {
        this.maximumNumberOfIteration = maximumNumberOfIteration;
    }
}