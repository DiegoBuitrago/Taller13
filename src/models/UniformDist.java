package models;

public class UniformDist {

    private double initial;
    private double finish;
    private int frecuencyObtained;
    private double frecuencyExpected;
    private double chi2;

    public UniformDist(double initial, double finish, int frecuencyObtained, double frecuencyExpected, double chi2) {
        this.initial = initial;
        this.finish = finish;
        this.frecuencyObtained = frecuencyObtained;
        this.frecuencyExpected = frecuencyExpected;
        this.chi2 = chi2;
    }

    public double getInitial() {
        return initial;
    }

    public void setInitial(double initial) {
        this.initial = initial;
    }

    public double getFinish() {
        return finish;
    }

    public void setFinish(double finish) {
        this.finish = finish;
    }

    public int getFrecuencyObtained() {
        return frecuencyObtained;
    }

    public void setFrecuencyObtained(int frecuencyObtained) {
        this.frecuencyObtained = frecuencyObtained;
    }

    public double getFrecuencyExpected() {
        return frecuencyExpected;
    }

    public void setFrecuencyExpected(double frecuencyExpected) {
        this.frecuencyExpected = frecuencyExpected;
    }

    public double getChi2() {
        return chi2;
    }

    public void setChi2(double chi2) {
        this.chi2 = chi2;
    }
}