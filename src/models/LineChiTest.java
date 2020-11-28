package models;

import utilities.Utility;

import java.text.DecimalFormat;

public class LineChiTest {
    private int id;
    private double initial;
    private double finall;
    private int frecObt;
    private double frecEsp;
    private double chi;

    private Utility ut;

    public LineChiTest(int id, double initial, double finall) {
        this.ut = new Utility();
        this.id = id;
        this.initial = initial;
        this.finall = finall;
    }

    public int getId(){
        return id;
    }

    public void chi(){
        this.chi = ut.formatDouble(Math.pow((this.frecObt-this.frecEsp),2)/this.frecEsp);
    }

    public double getInitial() {
        return initial;
    }

    public double getFinall() {
        return finall;
    }

    public void setFrecObt(int frecObt) {
        this.frecObt = frecObt;
    }

    public void setFrecEsp(double frecEsp){
        this.frecEsp = frecEsp;
    }

    public double getChi() {
        return chi;
    }

    public int getFrecObt(){
        return frecObt;
    }

    public double getFrecEsp(){
        return frecEsp;
    }

    @Override
    public String toString() {
        return "LineChiTest{" +
                "id=" + id +
                ", initial=" + initial +
                ", finall=" + finall +
                ", frecObt=" + frecObt +
                ", frecEsp=" + frecEsp +
                ", chi=" + chi +
                '}';
    }
}