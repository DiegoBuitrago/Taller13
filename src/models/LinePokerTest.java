package models;

public class LinePokerTest {
    private char cat;
    private int frecObs;
    private double prob;
    private double frecEsp;
    private double chi2;
    private String desc;

    public LinePokerTest(char cat, double prob, String desc){
        this.cat = cat;
        this.prob = prob;
        this.desc = desc;
    }

    public void setFrecObs(int frecObs) {
        this.frecObs = frecObs;
    }

    public void setFrecEsp(double frecEsp) {
        this.frecEsp = frecEsp;
    }

    public char getCat() {
        return cat;
    }

    public int getFrecObs() {
        return frecObs;
    }

    public double getProb() {
        return prob;
    }

    public double getFrecEsp() {
        return frecEsp;
    }

    public double getChi2() {
        return chi2;
    }

    public String getDesc() {
        return desc;
    }

    public void setChi2(double chi2) {
        this.chi2 = chi2;
    }

    @Override
    public String toString() {
        return "LinePokerTest{" +
                "cat=" + cat +
                ", frecObs=" + frecObs +
                ", prob=" + prob +
                ", frecEsp=" + frecEsp +
                ", chi2=" + chi2 +
                ", desc='" + desc + '\'' +
                '}';
    }
}
