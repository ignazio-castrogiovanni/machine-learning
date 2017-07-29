package com.castrosoft.machinelearning.vo;

/**
 * Created by Ignazio Castrogiovanni on 29/7/17.
 */
public class GradientDescentOutputVO {
    public GradientDescentOutputVO(double theta1, double theta2) {
        this.theta1 = theta1;
        this.theta2 = theta2;
    }

    private double theta1;
    private double theta2;

    public double getTheta1() {
        return theta1;
    }

    public void setTheta1(double theta1) {
        this.theta1 = theta1;
    }

    public double getTheta2() {
        return theta2;
    }

    public void setTheta2(double theta2) {
        this.theta2 = theta2;
    }
}
