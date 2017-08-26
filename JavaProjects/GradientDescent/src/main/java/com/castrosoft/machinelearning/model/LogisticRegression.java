package com.castrosoft.machinelearning.model;

import cc.mallet.optimize.Optimizable;
import com.castrosoft.machinelearning.calculator.LogisticRegressionCalculator;
import org.jblas.DoubleMatrix;

/**
 * Created by Ignazio Castrogiovanni on 26/8/17.
 */
public class LogisticRegression implements Optimizable.ByGradientValue {
    private DoubleMatrix X;
    private DoubleMatrix Y;
    private DoubleMatrix theta;

    public LogisticRegression(DoubleMatrix X,
                              DoubleMatrix Y,
                              DoubleMatrix theta) {
        this.X = X;
        this.Y = Y;
        this.theta = theta;
    }

    @Override
    public void getValueGradient(double[] doubles) {
        DoubleMatrix hypothesis = LogisticRegressionCalculator.computeHypothesisFunction(X, theta);
        DoubleMatrix gradient = LogisticRegressionCalculator.computeGradient(X, Y, hypothesis);

        double[] gradients = gradient.toArray();

        for (int i = 0; i < gradients.length; i++) {
            doubles[i] = gradients[i];
        }
    }

    @Override
    public double getValue() {
        DoubleMatrix hypothesis = LogisticRegressionCalculator.computeHypothesisFunction(X, theta);
        double debugVar = LogisticRegressionCalculator.computeCost(this.Y, hypothesis);

        System.out.println(debugVar);
        return debugVar;
    }

    @Override
    public int getNumParameters() {
        return theta.length;
    }

    @Override
    public void getParameters(double[] doubles) {
        double[] thetas = this.theta.toArray();

        for (int i = 0; i < thetas.length; i++) {
            doubles[i] = thetas[i];
        }
    }

    @Override
    public double getParameter(int i) {
        return theta.toArray()[i];
    }

    @Override
    public void setParameters(double[] doubles) {
        for (int i = 0; i < theta.length; i++) {
            theta.put(i, doubles[i]);
        }
    }

    @Override
    public void setParameter(int i, double v) {
        theta.put(i, v);
    }
}
