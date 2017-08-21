package com.castrosoft.machinelearning.utils;

import org.jblas.DoubleMatrix;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileToMatrix {
    public static DoubleMatrix readDoubleMatrixFromCSV(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        List<String> rows = new ArrayList<String>();

        while (scanner.hasNext()) {
            rows.add(scanner.nextLine());
        }

        int numOfRows = rows.size();
        int numOfColumns = rows.get(0).split(",").length;

        DoubleMatrix resultMatrix = new DoubleMatrix(numOfRows, numOfColumns);

        for (int row = 0; row < numOfRows ; row++) {
            String[] currentRow = rows.get(row).split(",");
            for (int column = 0; column < numOfColumns ; column++) {
                resultMatrix.put(row, column, Double.parseDouble(currentRow[column]));
            }
        }
        return resultMatrix;
    }
}
