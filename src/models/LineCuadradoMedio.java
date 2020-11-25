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

    private Utility ut;

    public LineCuadradoMedio(int interaction, int xi, int min, int max) {
        this.ut = new Utility();
        this.interaction = interaction;
        this.xi = xi;
        this.min = min;
        this.max = max;
        calculateXi2();
        calculateExtension();
        calculateExtraction();
        calculateRi();
        calculateNi();
    }

    private void calculateXi2() {
        this.xi2 = (long) Math.pow(this.xi,2);
    }

    private void calculateExtension() {
        this.extension = ut.sizeNumber(xi2);
    }

    private void calculateExtraction() {
        this.extraction = Integer.parseInt(ut.billingNumber(xi2).substring(2,6));
    }

    private void calculateRi() {
        this.ri = (double) this.extraction/10000;
    }

    private void calculateNi() {
        this.ni = min+(max-min)*this.ri;
    }

    public int getInteraction() {
        return interaction;
    }

    public int getXi() {
        return xi;
    }

    public long getXi2() {
        return xi2;
    }

    public int getExtension() {
        return extension;
    }

    public int getExtraction() {
        return extraction;
    }

    public double getRi() {
        return ri;
    }

    public double getNi() {
        return ni;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "LineCuadradoMedio{" +
                "interaction=" + interaction +
                ", xi=" + xi +
                ", xi2=" + xi2 +
                ", extension=" + extension +
                ", extraction=" + extraction +
                ", ri=" + ri +
                ", ni=" + ni +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}