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
}
