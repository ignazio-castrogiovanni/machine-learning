package com.castrosoft.machinelearning;

import com.castrosoft.machinelearning.calculator.LogisticRegressionCalculator;
import com.castrosoft.machinelearning.utils.FileToMatrix;
import org.jblas.DoubleMatrix;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static junit.framework.Assert.assertEquals;

public class LogisticRegressionCalculatorTest {
    @Test
    public void sigmoidOnZero() {
        DoubleMatrix vector = new DoubleMatrix(new double[] {0});
        DoubleMatrix result = LogisticRegressionCalculator.sigmoid(vector);

        assertEquals(0.5, result.data[0]);
    }

    @Test
    public void sigmoidFromNGAssignmentWeek2() {
        DoubleMatrix vector = new DoubleMatrix(new double[] {1, 45, 85}).transpose();
        DoubleMatrix theta = new DoubleMatrix(new double[] {-25.161272, 0.206233, 0.201470});
        DoubleMatrix vectorProduct = vector.mmul(theta);
        DoubleMatrix result = LogisticRegressionCalculator.sigmoid(vectorProduct);

        assertEquals(0.775, result.data[0], 0.002);
    }

    @Test
    public void logisticRegressionCostFunction( )
        throws IOException {
        InputStream featuresMatrixInputStream = ClassLoader.class.getResourceAsStream("/features.csv");
        DoubleMatrix X = FileToMatrix.readDoubleMatrixFromCSV(featuresMatrixInputStream);

        InputStream yInputStream = ClassLoader.class.getResourceAsStream("/y.csv");
        DoubleMatrix yMatrix = FileToMatrix.readDoubleMatrixFromCSV(yInputStream);

        DoubleMatrix initial_theta = new DoubleMatrix(X.columns);

        DoubleMatrix hypothesis = LogisticRegressionCalculator.computeHypothesisFunction(X, initial_theta);

        double costFunction = LogisticRegressionCalculator.computeCost(yMatrix, hypothesis);

        assertEquals(0.693147, costFunction, 0.000001);
    }

    @Test
    public void logisticRegressionGradient( )
        throws IOException {
        InputStream featuresMatrixInputStream = ClassLoader.class.getResourceAsStream("/features2.csv");
        DoubleMatrix X = FileToMatrix.readDoubleMatrixFromCSV(featuresMatrixInputStream);

        InputStream yInputStream = ClassLoader.class.getResourceAsStream("/y.csv");
        DoubleMatrix yMatrix = FileToMatrix.readDoubleMatrixFromCSV(yInputStream);

        DoubleMatrix initial_theta = new DoubleMatrix(X.columns);

        DoubleMatrix hypothesis = LogisticRegressionCalculator.computeHypothesisFunction(X, initial_theta);

        DoubleMatrix gradient = LogisticRegressionCalculator.computeGradient(X, yMatrix, hypothesis);

        // Testing first 5 values
        assertEquals(0.0084745, gradient.get(0),  0.000001);
        assertEquals(0.0187880, gradient.get(1), 0.000001);
        assertEquals(0.000077771186, gradient.get(2),  0.000001);
        assertEquals(0.0503446,gradient.get(3),  0.000001);
        assertEquals(0.0115013, gradient.get(4),  0.000001);
    }
}