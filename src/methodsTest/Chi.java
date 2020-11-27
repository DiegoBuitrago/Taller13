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
        double myMinNi = this.minNi;
        for (int i=0;i<this.numIntervalos;i++){
            id++;
            lines.add(new LineChiTest(id, myMinNi, 8));
        }
    }

    private double newInterval(double li){
        return 0.0;
    }
}