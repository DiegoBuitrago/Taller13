package models;

public class LineKsTest {
    private int id;
    private double initial;
    private double finall;
    private int frecObt;
    private int corr;
    private int frecAcu;
    private double probFrecObt;

    public LineKsTest(int id, double initial, double finall){
        this.id = id;
        this.initial = initial;
        this.finall = finall;
        this.frecObt = 0;
        this.corr = 0;
        this.frecAcu= 0 ;
        this.probFrecObt = 0.0;
    }

    public int getId() {
        return id;
    }

    public double getInitial() {
        return initial;
    }

    public double getFinall() {
        return finall;
    }

    public int getFrecObt() {
        return frecObt;
    }

    public int getCorr() {
        return corr;
    }

    public int getFrecAcu() {
        return frecAcu;
    }

    public double getProbFrecObt() {
        return probFrecObt;
    }

    public void setFrecAcu(int frecAcu) {
        this.frecAcu = frecAcu;
    }

    public void setFrecObt(int frecObt) {
        this.frecObt = frecObt;
    }

    public void setCorr(int corr) {
        this.corr = corr;
    }

    public void setProbFrecObt(double probFrecObt) {
        this.probFrecObt = probFrecObt;
    }

    @Override
    public String toString() {
        return "LineKsTest{" +
                "id=" + id +
                ", initial=" + initial +
                ", finall=" + finall +
                ", frecObt=" + frecObt +
                ", corr=" + corr +
                ", frecAcu=" + frecAcu +
                ", probFrecObt=" + probFrecObt +
                '}';
    }
}
