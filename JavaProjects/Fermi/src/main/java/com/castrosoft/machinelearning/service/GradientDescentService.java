package com.castrosoft.machinelearning.service;

import com.castrosoft.machinelearning.GradientDescent;
import com.castrosoft.machinelearning.mapper.TrainingSetMapper;
import com.castrosoft.machinelearning.vo.GradientDescentOutputVO;
import com.castrosoft.machinelearning.vo.GradientDescentTwoVariablesInputVO;
import org.springframework.stereotype.Service;

/**
 * Created by Ignazio Castrogiovanni on 29/7/17.
 */
@Service
public class GradientDescentService {
    private GradientDescent gradientDescent = new GradientDescent();
    private TrainingSetMapper trainingSetMapper = new TrainingSetMapper();

    public GradientDescentOutputVO computeGradientDescentTwoVariables(GradientDescentTwoVariablesInputVO gradientDescentParameters) {
        double startingTheta1 = gradientDescentParameters.getStartingTheta1();
        double startingTheta2 = gradientDescentParameters.getStartingTheta2();
        double[][] trainingSet = gradientDescentParameters.getTrainingSet();
        double alpha = gradientDescentParameters.getAlpha();
        int maximumNumbersOfIterations = gradientDescentParameters.getMaximumNumberOfIteration();


        double[][] normalisedTrainigSet = trainingSetMapper.convertTrainingSetXYToSeparatedXAndY(trainingSet);
        double[] thetas = gradientDescent.findOptimalThetas(normalisedTrainigSet,
                                                            startingTheta1,
                                                            startingTheta2,
                                                            alpha,
                                                            maximumNumbersOfIterations);

        if (thetas != null) {
            return new GradientDescentOutputVO(thetas[0], thetas[1]);
        }
        return null;
    }

}
