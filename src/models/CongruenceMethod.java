package models;

public class CongruenceMethod {

    public int id;
    public double xi;
    public double ri;
    public double ri2;

    public CongruenceMethod(int id, double xi, double ri, double ri2) {
        this.id = id;
        this.xi = xi;
        this.ri = ri;
        this.ri2 = ri2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getXi() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public double getRi() {
        return ri;
    }

    public void setRi(double ri) {
        this.ri = ri;
    }

    public double getRi2() {
        return ri2;
    }

    public void setRi2(double ri2) {
        this.ri2 = ri2;
    }
}
