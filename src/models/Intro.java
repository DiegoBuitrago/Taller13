package models;

public class Intro {
    private double ri;
    private double ni;

    public Intro(double ri) {
        this.ri = ri;
        this.ni = 0.0;
    }

    public void calculateNi(int min, int max) {
        this.ni = min+(max-min)*this.ri;
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