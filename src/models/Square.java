package models;

public class Square {

    private int id;
    private String xi;
    private String xCuadrado;
    private int size;
    private String extraction;
    private double ri;

    public Square(int id, String xi, String xCuadrado, int size, String extraction, double ri) {
        this.id = id;
        this.xi = xi;
        this.xCuadrado = xCuadrado;
        this.size = size;
        this.extraction = extraction;
        this.ri = ri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXi() {
        return xi;
    }

    public void setXi(String xi) {
        this.xi = xi;
    }

    public String getxCuadrado() {
        return xCuadrado;
    }

    public void setxCuadrado(String xCuadrado) {
        this.xCuadrado = xCuadrado;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getExtraction() {
        return extraction;
    }

    public void setExtraction(String extraction) {
        this.extraction = extraction;
    }

    public double getRi() {
        return ri;
    }

    public void setRi(double ri) {
        this.ri = ri;
    }
}
