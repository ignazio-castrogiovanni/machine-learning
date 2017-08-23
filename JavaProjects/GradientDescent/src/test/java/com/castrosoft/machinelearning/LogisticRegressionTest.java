package com.castrosoft.machinelearning;

import com.castrosoft.machinelearning.utils.FileToMatrix;
import org.jblas.DoubleMatrix;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static junit.framework.Assert.assertEquals;

public class LogisticRegressionTest {
    @Test
    public void sigmoidOnZero() {
        DoubleMatrix vector = new DoubleMatrix(new double[] {0});
        DoubleMatrix result = LogisticRegression.sigmoid(vector);

        assertEquals(0.5, result.data[0]);
    }

    @Test
    public void sigmoidFromNGAssignmentWeek2() {
        DoubleMatrix vector = new DoubleMatrix(new double[] {1, 45, 85}).transpose();
        DoubleMatrix theta = new DoubleMatrix(new double[] {-25.161272, 0.206233, 0.201470});
        DoubleMatrix vectorProduct = vector.mmul(theta);
        DoubleMatrix result = LogisticRegression.sigmoid(vectorProduct);

        assertEquals(0.775, result.data[0], 0.002);
    }

    @Test
    public void logisticRegression( )
        throws IOException {
        InputStream featuresMatrixInputStream = ClassLoader.class.getResourceAsStream("/features.csv");
        DoubleMatrix X = FileToMatrix.readDoubleMatrixFromCSV(featuresMatrixInputStream);

        InputStream yInputStream = ClassLoader.class.getResourceAsStream("/y.csv");
        DoubleMatrix yMatrix = FileToMatrix.readDoubleMatrixFromCSV(yInputStream);

        DoubleMatrix initial_theta = new DoubleMatrix(X.columns);

        DoubleMatrix hypothesis = LogisticRegression.computeHypothesisFunction(X, initial_theta);

        double costFunction = LogisticRegression.costFunction(yMatrix, hypothesis);

        assertEquals(0.693147, costFunction, 0.000001);
    }
}