package com.castrosoft.machinelearning.utils;

import org.jblas.DoubleMatrix;
import org.junit.Test;

import java.io.InputStream;

public class FileToMatrixTest {
    @Test
    public void testMatrixReadingSimpleCSV() {
        InputStream feat2 = ClassLoader.class.getResourceAsStream("/feat2.csv");
        DoubleMatrix test = FileToMatrix.readDoubleMatrixFromCSV(feat2);
        System.out.println(test.toString());
    }

    @Test
    public void testMatrixReadingComplexCSV() {
        InputStream features = ClassLoader.class.getResourceAsStream("/features.csv");
        DoubleMatrix test = FileToMatrix.readDoubleMatrixFromCSV(features);
        System.out.println(test.toString());
    }
}