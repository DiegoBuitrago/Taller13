package methodsTest;

import models.Intro;
import utilities.Utility;

import java.util.ArrayList;

public class Varianza {
    private ArrayList<Intro> intros;

    private double alfa;
    private int numIntros;
    private double riProm;
    private double varianza;
    private double marginToleranceLi;
    private double marginToleranceLs;

    private double chi2Li;
    private double chi2Ls;
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
        this.varianza = 0.0;

        this.chi2Li = 27.4884;
        this.chi2Ls = 6.2621;
        this.li = 0.0;
        this.ls = 0.0;

        init();
    }

    public void init(){
        calculateProm();
        calulateVarianza();

        calculateMarginToleranceLi();
        calculateMarginToleranceLs();

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
    }

    private void calulateVarianza() {
        double sum = 0.0;
        for (int i=0;i<numIntros;i++){
            double diference = this.intros.get(i).getRi()-riProm;
            sum = sum + Math.pow(diference, 2);
        }
        this.varianza = (double)sum/(numIntros-1);
    }

    private void calculateMarginToleranceLi() {
        this.marginToleranceLi = ut.formatDoubleFive((alfa/2));
    }

    private void calculateMarginToleranceLs() {
        this.marginToleranceLs = ut.formatDoubleFive(1-(alfa/2));
    }

    private void calculateLi(){
        this.li = ut.formatDoubleFive(this.chi2Li/((12*numIntros)-(12*1)));
    }

    private void calculateLs(){
        this.ls = ut.formatDoubleFive(this.chi2Ls/((12*numIntros)-(12*1)));
    }

    private void result() {
        if (this.ls <= this.varianza && this.varianza <= this.li) {
            this.result = true;
        } else {
            this.result = false;
        }
    }

    public double getRiProm() {
        return riProm;
    }

    public double getVarianza() {
        return varianza;
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