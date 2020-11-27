package methodsTest;

import models.Intro;
import models.LineChiTest;

import java.util.ArrayList;

public class Chi {
    private ArrayList<Intro> intros;
    private int min;
    private int max;
    private int numIntervalos;
    private double minNi;
    private double maxNi;

    private ArrayList<LineChiTest> lines;

    public Chi(ArrayList<Intro> intros, int min, int max, int numIntervalos) {
        this.lines = new ArrayList<LineChiTest>();
        this.intros = intros;
        this.min = min;
        this.max = max;
        this.numIntervalos = numIntervalos;
        this.minNi = 10000.0;
        this.maxNi = 0;
        init();
    }

    private void init(){
        calculateNi();
        minNi();
        maxNi();
        interval();
        frecobt();
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
        return li+(this.maxNi-this.minNi)/numIntervalos;
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
            System.out.println(this.lines.get(i).toString());
        }
    }

    public ArrayList<LineChiTest> getLines() {
        return lines;
    }
}