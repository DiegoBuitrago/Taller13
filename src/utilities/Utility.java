package utilities;

import java.text.DecimalFormat;

public class Utility {
    public double formatDoubleFour(double db){
        String b = new DecimalFormat("#.0000").format(db);
        char n;
        String newSt = "";
        for (int i=0;i<b.length();i++) {
            newSt=(b.charAt(i)!=',')?newSt+b.charAt(i):newSt+'.';
        }
        return Double.parseDouble(newSt);
    }

    public double formatDoubleFive(double db){
        String b = new DecimalFormat("#.00000").format(db);
        char n;
        String newSt = "";
        for (int i=0;i<b.length();i++) {
            newSt=(b.charAt(i)!=',')?newSt+b.charAt(i):newSt+'.';
        }
        return Double.parseDouble(newSt);
    }
}
