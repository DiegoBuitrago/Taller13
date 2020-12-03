package data;

public class TableDistribucionKS {
    private double[] table;

    public TableDistribucionKS(){
        this.table = new double[]
                {0.0, 0.97500,0.84189,0.70760,0.62394,0.56328,0.51926,0.48342,0.45427,0.43001,0.40925,0.39122,0.37543,0.36143,0.34890,0.33750,0.32733,0.31796,0.30936,0.30143,0.29408,0.28724,0.28087,0.27490,0.26931,0.26404,0.25908,0.25438,0.24993,0.24571,0.24170,0.23788,0.23424,0.23076,0.22743,0.22425,0.22119,0.21826,0.21544,0.21273,0.21012,0.20760,0.20517,0.20283,0.20056,0.19837,0.19625,0.19420,0.19221,0.19028,0.18841};
    }
    
    public double getdata(int index) {
        return this.table[index];
    }
}