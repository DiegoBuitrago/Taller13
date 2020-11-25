package models;

import utilities.Utility;

public class LineCuadradoMedio {

    private int interaction;
    private int xi;
    private long xi2;
    private int extension;
    private int extraction;
    private double ri;
    private double ni;
    private int min;
    private int max;

    public LineCuadradoMedio(int interaction, int xi, int min, int max) {
        this.interaction = interaction;
        this.xi = xi;
        this.xi2 = calculateXi2();
        this.extension = calculateExtension();
        this.extraction = calculateExtraction();
        this.ri = calculateRi();
        this.ni = calculateNi();
        this.min = min;
        this.max = max;
    }

    private long calculateXi2() {
        return (long) Math.pow(this.xi,2);
    }

    private int calculateExtension() {
        return new Utility().sizeNumber(xi2);
    }

    private int calculateExtraction() {

        if(extension == 8) {
            return Integer.parseInt(String.valueOf(xi2).substring(2,6));
        } else if (extension == 7){

        } else if (extension == 6){

        }
        return 0;
    }

    private double calculateRi() {
        return 0;
    }

    private double calculateNi() {
        return 0;
    }
}