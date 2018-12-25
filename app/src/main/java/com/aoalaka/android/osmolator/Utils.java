package com.aoalaka.android.osmolator;

public class Utils {
    final static int CONVERSION_FACTOR = 100;

    public static double calculateVolumeOfWaterRequired(OsmoticDehydration od, double weightOfSugar) {
        double volumeOfWater = od.calculateWeightOfSugarSolution() - weightOfSugar;
        return volumeOfWater;
    }

    public static double calculateWeightOfSugarRequired(OsmoticDehydration od) {
        double weightOfSugarSoln = od.calculateWeightOfSugarSolution();
        double degreeBrixConverted = convertDegreeBrix(od.getDegreeBrix());
        double weightOfSugar = Math.round(weightOfSugarSoln * degreeBrixConverted);
        return weightOfSugar;
    }

    private static double convertDegreeBrix(double degreeBrix) {
        return degreeBrix / CONVERSION_FACTOR;
    }
}
