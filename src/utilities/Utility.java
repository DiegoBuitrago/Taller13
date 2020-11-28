package utilities;

import java.text.DecimalFormat;

public class Utility {
    public double formatDouble(double db){
        String b = new DecimalFormat("#.0000").format(db);
        char n;
        String newSt = "";
        for (int i=0;i<b.length();i++) {
            newSt=(b.charAt(i)!=',')?newSt+b.charAt(i):newSt+'.';
        }
        return Double.parseDouble(newSt);
    }
}
