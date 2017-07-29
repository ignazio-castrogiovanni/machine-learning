package com.castrosoft.machinelearning.mapper;

/**
 * Created by Ignazio Castrogiovanni on 29/7/17.
 */
public class TrainingSetMapper {
    public double[][] convertTrainingSetXYToSeparatedXAndY(double[][] xyTrainingSet) {
        double[][] resultingTrainingSet = new double[xyTrainingSet[0].length][xyTrainingSet.length];
        for (int i = 0; i < xyTrainingSet[0].length; i++) {
            for (int j = 0; j < xyTrainingSet.length ; j++) {
                resultingTrainingSet[i][j] = xyTrainingSet[j][i];
            }
        }
        return resultingTrainingSet;
    }
}
