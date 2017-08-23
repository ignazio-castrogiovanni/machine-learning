package com.castrosoft.machinelearning;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

public class LogisticRegression {
    public static DoubleMatrix sigmoid(DoubleMatrix matrix) {
        DoubleMatrix intermediateMatrix = matrix.copy(matrix);
        intermediateMatrix.muli(-1);
        MatrixFunctions.expi(intermediateMatrix);

        intermediateMatrix.addi(1.0);

        DoubleMatrix ones = DoubleMatrix.ones(matrix.rows, matrix.columns);
        return ones.divi(intermediateMatrix);
    }

    public static DoubleMatrix computeHypothesisFunction(DoubleMatrix X, DoubleMatrix theta) {
        DoubleMatrix matrix = X.mmul(theta);
        return sigmoid(matrix);
    }

    public static double costFunction(DoubleMatrix y, DoubleMatrix hypothesis) {
        DoubleMatrix tempMatrix = new DoubleMatrix();
        tempMatrix.copy(hypothesis);
        DoubleMatrix logHypothesis = MatrixFunctions.logi(tempMatrix);

        DoubleMatrix ones = new DoubleMatrix(hypothesis.length);
        ones.fill(1.0);

        tempMatrix = new DoubleMatrix();
        tempMatrix.copy(hypothesis);
        DoubleMatrix logOneMinusHypothesis = MatrixFunctions.logi(ones.sub(tempMatrix));

        ones.fill(1.0);

        DoubleMatrix result1 = y.neg().muli(logHypothesis);
        DoubleMatrix result2 = (ones.sub(y)).muli(logOneMinusHypothesis);

        DoubleMatrix temporaryResult = result1.sub(result2);

        return temporaryResult.sum() * (1.0 / y.length);
    }
}
