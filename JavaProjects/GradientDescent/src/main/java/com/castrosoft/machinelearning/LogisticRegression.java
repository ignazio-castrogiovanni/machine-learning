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
        return sigmoid(X.mul(theta));
    }

    public static DoubleMatrix temporaryArrayToSum(DoubleMatrix y, DoubleMatrix hypothesis) {
        DoubleMatrix logHypothesis = MatrixFunctions.logi(hypothesis);
        DoubleMatrix ones = new DoubleMatrix(hypothesis.length);
        ones.fill(1.0);

        DoubleMatrix logOneMinusHypothesis = MatrixFunctions.logi(ones.sub(hypothesis));

        ones.fill(1.0);

        // TODO: fix this
        DoubleMatrix result1 = y.neg().muli(logHypothesis);
        DoubleMatrix result2 = (ones.sub(y)).muli(logOneMinusHypothesis);

        return result1.sub(result2);
        //arrayToSum = (-y .* log(hypothesis) - (1 - y) .* log(1 - hypothesis));
    }
}
