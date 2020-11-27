package models;

public class LineChiTest {
    private int id;
    private double initial;
    private double finall;
    private int frecObt;
    private double frecEsp;
    private int chi;

    public LineChiTest(int id, double initial, double finall, int frecObt, double frecEsp, int chi) {
        this.id = id;
        this.initial = initial;
        this.finall = finall;
        this.frecObt = frecObt;
        this.frecEsp = frecEsp;
        this.chi = chi;
    }
}