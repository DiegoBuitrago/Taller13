package utilities;

public class Utility {
    public int sizeNumber(long number){
        return String.valueOf(number).length();
    }

    public int sizeNumber(int number){
        return String.valueOf(number).length();
    }

    public String billingNumber(long number){
        String numberSt = String.valueOf(number);
        int i = numberSt.length();
        switch(i)
        {
            case 8:
                return numberSt;
            case 7:
                return "0"+numberSt;
            case 6:
                return "00"+numberSt;
            case 5:
                return "000"+numberSt;
            case 4:
                return "0000"+numberSt;
            case 3:
                return "00000"+numberSt;
            case 2:
                return "000000"+numberSt;
            case 1:
                return "0000000"+numberSt;
            default:
                return "00000000";
            }
        }
    }