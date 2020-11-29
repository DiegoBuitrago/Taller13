package methodsTest;

import data.TableDistribucionChiCuadrado;
import models.Intro;
import models.LinePokerTest;
import utilities.Utility;

import java.util.ArrayList;

public class Poker {

    private ArrayList<Intro> intros;


    private double sumChi2;
    private int libertyGrade;
    private double prueba;
    private boolean result;

    private ArrayList<LinePokerTest> lines;
    private Utility ut;
    private TableDistribucionChiCuadrado tableDistribucionChiCuadrado;

    public Poker(ArrayList<Intro> intros) {
        this.lines = new ArrayList<LinePokerTest>();
        this.ut = new Utility();
        this.tableDistribucionChiCuadrado = new TableDistribucionChiCuadrado();

        this.intros = intros;

        this.sumChi2 = 0;
        this.libertyGrade = 0;
        this.prueba = 0.0;
        this.result = false;

        init();
    }

    private void init() {
        addLines();

        calculateFrecObs();
        calculateFrecEsp();
        calculateChi2();

        calculateSumChi();
        libertyGrade();
        prueba();
        result();
    }

    private void addLines() {
        lines.add(new LinePokerTest('D', 0.3024, "Diferentes"));
        lines.add(new LinePokerTest('O', 0.5040, "Un par"));
        lines.add(new LinePokerTest('T', 0.1080, "Dos pares"));
        lines.add(new LinePokerTest('K', 0.0720, "Tercia"));
        lines.add(new LinePokerTest('F', 0.0090, "Tercia y par"));
        lines.add(new LinePokerTest('P', 0.0045, "Poker"));
        lines.add(new LinePokerTest('Q', 0.0001, "Iguales"));
    }

    private void calculateFrecObs(){
        calculateCat();
        for (int i=0;i<lines.size();i++) {
            int countChar = 0;
            for (int j=0;j<intros.size();j++) {
                if (lines.get(i).getCat() == intros.get(j).getCatPoker()){
                    countChar++;
                }
            }
            this.lines.get(i).setFrecObs(countChar);
        }
    }

    private void calculateCat(){
        for (int i=0;i<intros.size();i++) {
            this.intros.get(i).calculateCatPoker();
        }
    }

    private void calculateFrecEsp() {
        for (int j=0;j<lines.size();j++) {
            this.lines.get(j).setFrecEsp(ut.formatDoubleFive(this.lines.get(j).getProb()*this.intros.size()));
        }
    }

    private void calculateChi2() {
        for (int i=0;i<lines.size();i++) {
            this.lines.get(i).setChi2(ut.formatDoubleFive(Math.pow((this.lines.get(i).getFrecEsp()-this.lines.get(i).getFrecObs()),2)/this.lines.get(i).getFrecEsp()));
        }
    }

    private void calculateSumChi() {
        for (int i=0;i<lines.size();i++) {
            this.sumChi2 = this.sumChi2 + this.lines.get(i).getChi2();
        }
    }

    private void libertyGrade() {
        int numColumns = 2;
        this.libertyGrade = (numColumns-1)*(this.lines.size()-1);
    }

    private void prueba() {
        this.prueba = this.tableDistribucionChiCuadrado.getdata(this.libertyGrade);
    }

    private void result() {
        if (this.prueba > this.sumChi2) {
            this.result = true;
        } else {
            this.result = false;
        }
    }

    public ArrayList<Intro> getIntros() {
        return intros;
    }

    public ArrayList<LinePokerTest> getLines() {
        return lines;
    }

    public double getSumChi2() {
        return sumChi2;
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