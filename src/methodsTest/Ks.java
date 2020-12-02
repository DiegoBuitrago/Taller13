package methodsTest;

import data.TableDistribucionKS;
import models.Intro;
import models.LineKsTest;
import utilities.Utility;

import java.util.ArrayList;

public class Ks {
    private ArrayList<Intro> intros;
    private int numIntervalos;

    private double minRi;
    private double maxRi;
    private double prom;

    private double diferenceMax;
    private double distributionKS;
    private boolean result;

    private ArrayList<LineKsTest> lines;
    private Utility ut;
    private TableDistribucionKS tableDistribucionKS;

    public Ks(ArrayList<Intro> intros, int numIntervalos){
        this.lines = new ArrayList<LineKsTest>();
        this.ut = new Utility();
        this.tableDistribucionKS = new TableDistribucionKS();

        this.intros = intros;
        this.numIntervalos = numIntervalos;

        this.prom = 0.0;
        this.minRi = 10000.0;
        this.maxRi = 0;

        this.diferenceMax = 0;
        this.distributionKS = 0.0;
        this.result = false;

        init();
    }

    private void init() {
        calculateProm();
        minRi();
        maxRi();

        interval();
        frecobt();
        corr();
        frecAcum();
        probFrecObtAcum();
        frecAcumEsp();
        probFrecAcumEsp();
        diference();

        diferenceMax();
        distributionKS();
        result();
    }

    private void calculateProm(){
        double sum = 0.0;
        for (int i=0;i<this.intros.size();i++) {
            sum = sum + this.intros.get(i).getRi();
        }
        this.prom = sum/intros.size();
    }

    private void minRi(){
        for (int i=0;i<this.intros.size();i++){
            if (this.minRi > this.intros.get(i).getRi()) {
                this.minRi = this.intros.get(i).getRi();
            }
        }
    }

    private void maxRi(){
        for (int i=0;i<this.intros.size();i++){
            if (this.maxRi < this.intros.get(i).getRi()) {
                this.maxRi = this.intros.get(i).getRi();
            }
        }
    }

    private void interval(){
        int id = 0;
        double newInterval = 0.0;
        double myMinRi = this.minRi;
        for (int i=0;i<this.numIntervalos;i++){
            id++;
            newInterval = newInterval(myMinRi);
            if(i!=this.numIntervalos-1){
                lines.add(new LineKsTest(id, myMinRi, newInterval));
            } else {
                lines.add(new LineKsTest(id, myMinRi, newInterval+0.01));
            }
            myMinRi = newInterval;
        }
    }

    private double newInterval(double li){
        return ut.formatDoubleFive(li+(this.maxRi-this.minRi)/numIntervalos);
    }

    private void frecobt(){
        double ini = 0.0;
        double fin = 0.0;
        int count = 0;
        double numRi = 0.0;
        for (int i=0;i<this.lines.size();i++) {
            LineKsTest line = this.lines.get(i);
            ini = line.getInitial();
            fin = line.getFinall();
            for (int j = 0; j < this.intros.size(); j++) {
                Intro intro = this.intros.get(j);
                numRi = intro.getRi();
                if (numRi >= ini && numRi <= fin) {
                    count++;
                }
            }
            this.lines.get(i).setFrecObt(count);
            count = 0;
        }
    }

    private void corr() {
        int sum = 0;
        for (int i=0;i<this.lines.size();i++) {
            sum = sum + this.lines.get(i).getFrecObt();
        }
        if(sum == this.intros.size()){
            addCorr();
        } else if(sum == this.intros.size()-1){
            addCorr();
            this.lines.get(this.lines.size()-1).setCorr(this.lines.get(this.lines.size()-1).getFrecObt()+1);
        } else if(sum == this.intros.size()+1) {
            addCorr();
            this.lines.get(this.lines.size()-1).setCorr(this.lines.get(this.lines.size()-1).getFrecObt()-1);
        }
    }

    private void addCorr(){
        for (int i = 0; i < this.lines.size(); i++) {
            this.lines.get(i).setCorr(this.lines.get(i).getFrecObt());
        }
    }

    private void frecAcum(){
        int sum = 0;
        for (int i=0;i<this.lines.size();i++) {
            sum = sum + this.lines.get(i).getCorr();
            this.lines.get(i).setFrecAcu(sum);
        }
    }

    private void probFrecObtAcum(){
        for (int i=0;i<this.lines.size();i++) {
            this.lines.get(i).setProbFrecObt(ut.formatDoubleFive((double)this.lines.get(i).getFrecAcu()/this.intros.size()));
        }
    }

    private void frecAcumEsp(){
        double sum = (double)this.intros.size()/this.lines.size();
        for (int i=0;i<lines.size();i++) {
            if(i == 0){
                this.lines.get(i).setFrecAcuEsp(ut.formatDoubleFive(sum));
            }else{
                this.lines.get(i).setFrecAcuEsp(ut.formatDoubleFive(this.lines.get(i-1).getFrecAcuEsp()+sum));
            }
        }
    }

    private void probFrecAcumEsp() {
        for (int i=0;i<lines.size();i++) {
            this.lines.get(i).setProbFrecAcuEsp(ut.formatDoubleFive((double)this.lines.get(i).getFrecAcuEsp()/this.intros.size()));
        }
    }

    private void diference() {
        for (int i=0;i<lines.size();i++) {
            lines.get(i).setDiference(ut.formatDoubleFive(Math.abs(this.lines.get(i).getProbFrecAcuEsp()-this.lines.get(i).getProbFrecObt())));
        }
    }

    private void diferenceMax(){
        for (int i=0;i<this.lines.size();i++){
            if (this.diferenceMax < this.lines.get(i).getDiference()) {
                this.diferenceMax = this.lines.get(i).getDiference();
            }
        }
    }

    private void distributionKS(){
        int size = this.intros.size();
        if(size<=50){
            this.distributionKS = tableDistribucionKS.getdata(size);
        }else{
            this.distributionKS = ut.formatDoubleFive((double) 1.36/Math.sqrt(size));
        }
    }

    private void result(){
        if(this.diferenceMax < this.distributionKS){
            this.result = true;
        } else {
            this.result = false;
        }
    }

    public ArrayList<Intro> getIntros() {
        return intros;
    }

    public double getDiferenceMax() {
        return diferenceMax;
    }

    public double getDistributionKS() {
        return distributionKS;
    }

    public boolean isResult() {
        return result;
    }

    public ArrayList<LineKsTest> getLines() {
        return lines;
    }
}