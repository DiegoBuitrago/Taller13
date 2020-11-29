package methodsTest;

import models.Intro;
import models.LinePokerTest;

import java.util.ArrayList;

public class Poker {

    private ArrayList<Intro> intros;

    private ArrayList<LinePokerTest> lines;

    public Poker(ArrayList<Intro> intros) {
        this.lines = new ArrayList<LinePokerTest>();
        this.intros = intros;
        init();
    }

    private void init() {
        addLines();
        calculateFrecObs();
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

    }

    private void calculateCat(){
//        char cat = calculateCat();
        for (int i=0;i<intros.size();i++) {
            this.intros.get(i).calculateCatPoker();
        }
        for (int i=0;i<intros.size();i++) {
            System.out.println(this.intros.get(i).toString());
        }
    }
}