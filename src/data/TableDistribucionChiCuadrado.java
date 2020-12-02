package data;

public class TableDistribucionChiCuadrado {
    private double[] table;

    public TableDistribucionChiCuadrado(){
        this.table = new double[]
                {0.0, 3.8415, 5.9915, 7.8147, 9.4877, 11.0705, 12.5916, 14.0671, 15.5073, 16.9190, 18.3070, 19.6752, 21.0261, 22.3620, 23.6848, 24.9958, 26.2962, 27.5871, 28.8693, 30.1435, 31.4104, 32.6706, 33.9245, 35.1725, 36.4150, 37.6525, 38.8851, 40.1133, 41.3372, 42.5569, 43.7730};
    }
    
    public double getdata(int index) {
        return this.table[index];
    }
}