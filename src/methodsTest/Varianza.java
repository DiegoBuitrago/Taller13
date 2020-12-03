package methodsTest;

import models.Intro;
import utilities.Utility;

import java.util.ArrayList;

public class Varianza {
    private ArrayList<Intro> intros;

    private double alfa;
    private int numIntros;
    private double riProm;
    private double marginTolerance;
    private double z;
    private double li;
    private double ls;

    private boolean result;

    private Utility ut;

    public Varianza(ArrayList<Intro> intros) {
        this.ut = new Utility();

        this.intros = intros;

        this.alfa = 0.05;
        this.numIntros = this.intros.size();
        this.riProm = 0.0;
        this.z = 1.9600;
        this.result = false;

        init();
    }

    public void init(){
        calculateProm();
        calculateMarginTolerance();
        calculateLi();
        calculateLs();
        result();
    }

    private void calculateProm() {
        double sumRi = 0;
        for (int i=0;i<numIntros;i++){
            sumRi = sumRi + this.intros.get(i).getRi();
        }
        this.riProm =ut.formatDoubleFive(sumRi/numIntros);
        System.out.println(riProm);
    }


    private void calculateMarginTolerance() {
        this.marginTolerance = ut.formatDoubleFive(1-(alfa/2));
        System.out.println(marginTolerance);
    }

    private void calculateLi(){
        this.li = ut.formatDoubleFive((0.5)-(this.z*(1/Math.sqrt(12*this.numIntros))));
        System.out.println(this.li);
    }

    private void calculateLs(){
        this.ls = ut.formatDoubleFive((0.5)+(this.z*(1/Math.sqrt(12*this.numIntros))));
        System.out.println(this.ls);
    }

    private void result() {
        if (this.li <= this.riProm && this.riProm <= this.ls) {
            this.result = true;
        } else {
            this.result = false;
        }
    }

    public double getRiProm() {
        return riProm;
    }

    public double getLi() {
        return li;
    }

    public double getLs() {
        return ls;
    }

    public boolean isResult() {
        return result;
    }
}