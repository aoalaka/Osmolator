package com.aoalaka.android.osmolator;

public class OsmoticDehydration {
    /*
    * Sugar is assumed as the solute here because it is most commonly used for osmotic dehydration. Meanwhile, salt can also be used.
    * But, generally the concept is the same.
    * */
    /*Unit weight of food sample to be immersed in osmotic solution*/
    double weightPerUnitSample;
    /*Total number of samples of the food going into the solution that is to be prepared. This factor is used in evaluating friut/osmotic solution ratio*/
    int numberOfSamplesToBeImmersed;
    /*This factor is important to ensure that the solution doesn't lose it brix level throughout the experimental period*/
    double fruitToSugarRatio;
    /*percentage of solute in solution. Otherwise known as solid level*/
    double degreeBrix;

    public OsmoticDehydration() {
    }

    public OsmoticDehydration(double weightPerUnitSample, int numberOfSamplesToBeImmersed,
                              double fruitToSugarRatio, double degreeBrix) {
        this.weightPerUnitSample = weightPerUnitSample;
        this.numberOfSamplesToBeImmersed = numberOfSamplesToBeImmersed;
        this.fruitToSugarRatio = fruitToSugarRatio;
        this.degreeBrix = degreeBrix;
    }

    public double getWeightPerUnitSample() {
        return weightPerUnitSample;
    }

    public int getNumberOfSamplesToBeImmersed() {
        return numberOfSamplesToBeImmersed;
    }

    public double getfruitToSugarRatio() {
        return fruitToSugarRatio;
    }

    public double getDegreeBrix() {
        return degreeBrix;
    }

    public double calculateWeightOfSugarSolution() {
        double weightOfSugarSoln = weightPerUnitSample * fruitToSugarRatio * numberOfSamplesToBeImmersed;
        return weightOfSugarSoln;
    }
}
