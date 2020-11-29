package models;

import utilities.Utility;

import java.util.ArrayList;

public class Intro {
    private double ri;
    private double ni;
    private char catPoker;
    private Utility ut;

    public Intro(double ri) {
        this.ut = new Utility();
        this.ri = ut.formatDoubleFive(ri);
        this.ni = 0.0;
        this.catPoker = ' ';
    }

    public double getRi(){
        return ri;
    }

    public void calculateNi(int min, int max) {
        this.ni = ut.formatDoubleFour(min+(max-min)*this.ri);
    }

    public double getNi() {
        return ni;
    }

    public void calculateCatPoker() {
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0, count0 = 0;
        int dou = (int) (this.ri*100000);
        String st = String.valueOf(dou);
        char ch = ' ';
        for (int i=0;i<st.length();i++) {
            ch = st.charAt(i);
            switch (ch) {
                case '1':
                    count1++;
                    break;
                case '2':
                    count2++;
                    break;
                case '3':
                    count3++;
                    break;
                case '4':
                    count4++;
                    break;
                case '5':
                    count5++;
                    break;
                case '6':
                    count6++;
                    break;
                case '7':
                    count7++;
                    break;
                case '8':
                    count8++;
                    break;
                case '9':
                    count9++;
                    break;
                case '0':
                    count0++;
                    break;
                default:
                    break;
            }
        }

        ArrayList<Integer> numbers = new ArrayList();
        int[] counts = {count0, count1, count2, count3, count4, count5, count6, count7, count8, count9};
        for (int i=0;i<counts.length;i++) {
            if (counts[i] != 0) {
                numbers.add(counts[i]);
            }
        }

        if (numbers.size() == 5) {
            this.catPoker = 'D';
        } else if (numbers.size() == 4) {
            this.catPoker = 'O';
        } else if (numbers.size() == 3) {
            this.catPoker = 'T';
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) == 3) {
                    this.catPoker = 'K';
                }
            }
        } else if (numbers.size() == 2) {
            this.catPoker = 'F';
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) == 4) {
                    this.catPoker = 'P';
                }
            }
        } else if (numbers.size() == 1) {
            this.catPoker = 'Q';
        }
    }

    public char getCatPoker() {
        return catPoker;
    }

    public void setCatPoker(char catPoker) {
        this.catPoker = catPoker;
    }

    @Override
    public String toString() {
        return "Intro{" +
                "ri=" + ri +
                ", ni=" + ni +
                ", catPoker=" + catPoker +
                ", ut=" + ut +
                '}';
    }
}