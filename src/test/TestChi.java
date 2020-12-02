package test;

import methodsTest.Chi;
import models.Intro;
import models.LineChiTest;

import java.util.ArrayList;

public class TestChi {

    public static void main(String[] args) {
//        for (int i=0;i<list.size();i++) {
//            System.out.println(list.get(i));
//        }
//        Double dou = new Double("0.151");
//        double hola = dou.doubleValue();
//        System.out.println(""+hola);
//        double a = 9.5529999999;
//        System.out.println(new Utility().formatDouble(a));
//        TableDistribucionChiCuadrado tb = new TableDistribucionChiCuadrado();

          p1();
    }

    private static void p1(){
        ArrayList<Intro> list = new ArrayList<Intro>();

        list.add(new Intro(0.1214));
        list.add(new Intro(0.4267));
        list.add(new Intro(0.1379));
        list.add(new Intro(0.7385));
        list.add(new Intro(0.8432));
        list.add(new Intro(0.5801));
        list.add(new Intro(0.0100));
        list.add(new Intro(0.3703));
        list.add(new Intro(0.7205));
        list.add(new Intro(0.5427));
        list.add(new Intro(0.3795));
        list.add(new Intro(0.7389));
        list.add(new Intro(0.1266));
        list.add(new Intro(0.6429));
        list.add(new Intro(0.8298));

        int numIntervalos = 8;

        Chi chi = new Chi(list, numIntervalos);
        ArrayList<LineChiTest> lines = chi.getLines();

        for (int i=0;i<lines.size();i++) {
            System.out.println(lines.get(i).toString());
        }

        System.out.println(chi.getTotalChi2());
        System.out.println(chi.getLibertyGrade());
        System.out.println(chi.getDistributionChi());
        System.out.println(chi.isResult());
    }
}