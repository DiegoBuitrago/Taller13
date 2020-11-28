package models;

import utilities.Utility;

public class Intro {
    private double ri;
    private double ni;
    private Utility ut;

    public Intro(double ri) {
        this.ri = ri;
        this.ni = 0.0;
        this.ut = new Utility();
    }

    public double getRi(){
        return ri;
    }

    public void calculateNi(int min, int max) {
        this.ni = ut.formatDouble(min+(max-min)*this.ri);
    }

    public double getNi() {
        return ni;
    }

    @Override
    public String toString() {
        return "Intro{" +
                "ri=" + ri +
                ", ni=" + ni +
                '}';
    }
}