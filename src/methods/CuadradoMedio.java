package methods;

import models.LineCuadradoMedio;
import utilities.Utility;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public class CuadradoMedio {
    private int seed;
    private int numInteractions;
    private int minNi;
    private int maxNi;

    private ArrayList<LineCuadradoMedio> list;

    public CuadradoMedio(int seed, int numInteractions, int minNi, int maxNi){
        this.seed = seed;
        this.numInteractions = numInteractions;
        this.minNi = minNi;
        this.maxNi = maxNi;
        init();
    }

    private void init() {
        for (int i = 0; i < numInteractions; ++i) {
            //list.add(new LineCuadradoMedio(i,seed,minNi,maxNi));
            LineCuadradoMedio ln = new LineCuadradoMedio(i,seed,minNi,maxNi);
            System.out.println(ln.toString());
            this.seed = ln.getExtraction();
        }
    }
}