package test;

import methodsTest.Chi;
import models.Intro;
import models.LineChiTest;

import java.util.ArrayList;

public class TestChi {

    public static void main(String[] args) {
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