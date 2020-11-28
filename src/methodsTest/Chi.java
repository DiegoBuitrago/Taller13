package methodsTest;

import data.TableDistribucionChiCuadrado;
import models.Intro;
import models.LineChiTest;
import utilities.Utility;

import java.util.ArrayList;

public class Chi {
    private ArrayList<Intro> intros;
    private int min;
    private int max;
    private int numIntervalos;

    private double minNi;
    private double maxNi;

    private double totalChi2;
    private int libertyGrade;
    private double prueba;
    private boolean result;

    private ArrayList<LineChiTest> lines;
    private Utility ut;
    private TableDistribucionChiCuadrado tableDistribucionChiCuadrado;

    public Chi(ArrayList<Intro> intros, int min, int max, int numIntervalos) {
        this.lines = new ArrayList<LineChiTest>();
        this.ut = new Utility();
        this.tableDistribucionChiCuadrado = new TableDistribucionChiCuadrado();
        
        this.intros = intros;
        this.min = min;
        this.max = max;
        this.numIntervalos = numIntervalos;
        
        this.minNi = 10000.0;
        this.maxNi = 0;

        this.totalChi2 = 0.0;
        this.libertyGrade = 0;
        this.prueba = 0.0;
        this.result = false;

        init();
    }

    private void init(){
        calculateNi();

        minNi();
        maxNi();
        interval();
        frecobt();
        frecEsp();

        chi();

        libertyGrade();
        prueba();
        result();

    }

    private void calculateNi() {
        for (int i=0;i<this.intros.size();i++) {
            this.intros.get(i).calculateNi(min,max);
        }
    }

    private void minNi(){
        for (int i=0;i<this.intros.size();i++){
                if (this.minNi > this.intros.get(i).getNi()) {
                    this.minNi = this.intros.get(i).getNi();
                }
        }
    }

    private void maxNi(){
        for (int i=0;i<this.intros.size();i++){
            if (this.maxNi < this.intros.get(i).getNi()) {
                this.maxNi = this.intros.get(i).getNi();
            }
        }
    }

    private void interval(){
        int id = 0;
        double newInterval = 0.0;
        double myMinNi = this.minNi;
        for (int i=0;i<this.numIntervalos;i++){
            id++;
            newInterval = newInterval(myMinNi);
            lines.add(new LineChiTest(id, myMinNi, newInterval));
            myMinNi = newInterval;
        }
    }

    private double newInterval(double li){
        return ut.formatDouble(li+(this.maxNi-this.minNi)/numIntervalos);
    }

    private void frecobt(){
        double ini = 0.0;
        double fin = 0.0;
        int count = 0;
        double numNi = 0.0;
        for (int i=0;i<this.lines.size();i++) {
            LineChiTest line = this.lines.get(i);
            ini = line.getInitial();
            fin = line.getFinall();
            for (int j = 0; j < this.intros.size(); j++) {
                Intro intro = this.intros.get(j);
                numNi = intro.getNi();
                if (numNi >= ini && numNi <= fin) {
                    count++;
                }
            }
            this.lines.get(i).setFrecObt(count);
            count = 0;
        }
    }

    private void frecEsp() {
        for (int i=0;i<this.lines.size();i++){
            this.lines.get(i).setFrecEsp(ut.formatDouble((double) (this.intros.size())/(this.lines.size())));
        }
    }

    private void chi(){
        double sum = 0.0;
        for (int i=0;i<this.lines.size();i++){
            this.lines.get(i).chi();
            sum = sum + this.lines.get(i).getChi();
        }
        this.totalChi2 = ut.formatDouble(sum);
    }

    private void libertyGrade() {
        int numColumns = 2;
        this.libertyGrade = (numColumns-1)*(this.lines.size()-1);
    }

    private void prueba(){
        this.prueba = this.tableDistribucionChiCuadrado.getdata(this.libertyGrade);
    }

    private void result() {
        if (this.prueba > this.totalChi2) {
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

    public double getPrueba() {
        return prueba;
    }

    public boolean isResult() {
        return result;
    }
}