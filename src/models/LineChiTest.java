package models;

public class LineChiTest {
    private int id;
    private double initial;
    private double finall;
    private int frecObt;
    private double frecEsp;
    private double chi;

    public LineChiTest(int id, double initial, double finall) {
        this.id = id;
        this.initial = initial;
        this.finall = finall;
    }

    public double getInitial() {
        return initial;
    }

    public double getFinall() {
        return finall;
    }

    @Override
    public String toString() {
        return "LineChiTest{" +
                "id=" + id +
                ", initial=" + initial +
                ", finall=" + finall +
                ", frecObt=" + frecObt +
                ", frecEsp=" + frecEsp +
                ", chi=" + chi +
                '}';
    }
}