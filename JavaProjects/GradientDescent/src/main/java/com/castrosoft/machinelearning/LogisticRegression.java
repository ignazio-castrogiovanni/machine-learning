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
}
