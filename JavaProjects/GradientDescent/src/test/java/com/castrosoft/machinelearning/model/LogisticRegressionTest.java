package com.castrosoft.machinelearning.model;

import cc.mallet.optimize.GradientAscent;
import cc.mallet.optimize.InvalidOptimizableException;
import cc.mallet.optimize.LimitedMemoryBFGS;
import cc.mallet.optimize.Optimizer;
import com.castrosoft.machinelearning.utils.FileToMatrix;
import org.jblas.DoubleMatrix;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by Ignazio Castrogiovanni on 26/8/17.
 */
public class LogisticRegressionTest {
    @Test
    public void optimiseLinearRegression() {
        InputStream featuresMatrixInputStream = ClassLoader.class.getResourceAsStream("/ex2_linReg_X.csv");
        DoubleMatrix X = FileToMatrix.readDoubleMatrixFromCSV(featuresMatrixInputStream);

        InputStream yInputStream = ClassLoader.class.getResourceAsStream("/ex2_linReg_y.csv");
        DoubleMatrix Y = FileToMatrix.readDoubleMatrixFromCSV(yInputStream);

        DoubleMatrix initial_theta = new DoubleMatrix(X.columns);

        LogisticRegression logisticRegression = new LogisticRegression(X, Y, initial_theta);
        Optimizer optimizer = new GradientAscent(logisticRegression);

        try {
                optimizer.optimize();
        } catch (InvalidOptimizableException e) {
            throw e;
        } finally {
            double[] results = new double[initial_theta.length];

            logisticRegression.getParameters(results);
            System.out.println(results);
        }
    }
}