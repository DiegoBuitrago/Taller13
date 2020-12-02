package methodsTest;

import data.TableDistribucionChiCuadrado;
import models.Intro;
import models.LineChiTest;
import utilities.Utility;

import java.util.ArrayList;

public class Chi {
    private ArrayList<Intro> intros;
    private int numIntervalos;

    private double minRi;
    private double maxRi;

    private double totalChi2;
    private int libertyGrade;
    private double distributionChi;
    private boolean result;

    private ArrayList<LineChiTest> lines;
    private Utility ut;
    private TableDistribucionChiCuadrado tableDistribucionChiCuadrado;

    public Chi(ArrayList<Intro> intros, int numIntervalos) {
        this.lines = new ArrayList<LineChiTest>();
        this.ut = new Utility();
        this.tableDistribucionChiCuadrado = new TableDistribucionChiCuadrado();
        
        this.intros = intros;
        this.numIntervalos = numIntervalos;
        
        this.minRi = 10000.0;
        this.maxRi = 0;

        this.totalChi2 = 0.0;
        this.libertyGrade = 0;
        this.distributionChi = 0.0;
        this.result = false;

        init();
    }

    private void init(){

        minRi();
        maxRi();
        interval();
        frecobt();
        frecEsp();

        chi();

        libertyGrade();
        prueba();
        result();

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
                lines.add(new LineChiTest(id, myMinRi, newInterval));
            } else {
                lines.add(new LineChiTest(id, myMinRi, newInterval+0.01));
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
            LineChiTest line = this.lines.get(i);
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

    private void frecEsp() {
        for (int i=0;i<this.lines.size();i++){
            this.lines.get(i).setFrecEsp(ut.formatDoubleFive((double) (this.intros.size())/(this.lines.size())));
        }
    }

    private void chi(){
        double sum = 0.0;
        for (int i=0;i<this.lines.size();i++){
            this.lines.get(i).chi();
            sum = sum + this.lines.get(i).getChi();
        }
        this.totalChi2 = ut.formatDoubleFive(sum);
    }

    private void libertyGrade() {
        int numColumns = 2;
        this.libertyGrade = (numColumns-1)*(this.lines.size()-1);
    }

    private void prueba(){
        this.distributionChi = this.tableDistribucionChiCuadrado.getdata(this.libertyGrade);
    }

    private void result() {
        if (this.distributionChi > this.totalChi2) {
            this.result = true;
        } else {
            this.result = false;
        }
    }

    public ArrayList<LineChiTest> getLines() {
        return lines;
    }

    public ArrayList<Intro> getIntros() {
        return intros;
    }

    public double getTotalChi2() {
        return totalChi2;
    }

    public int getLibertyGrade() {
        return libertyGrade;
    }

    public double getDistributionChi() {
        return distributionChi;
    }

    public boolean isResult() {
        return result;
    }
}