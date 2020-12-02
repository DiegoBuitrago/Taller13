package test;

import methodsTest.Ks;
import models.Intro;

import java.util.ArrayList;

public class TestKS {
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

        int numIntervalos = 10;

        Ks ks = new Ks(list, numIntervalos);

        for (int i=0;i<ks.getLines().size();i++) {
            System.out.println(ks.getLines().get(i).toString());
        }

        System.out.println(ks.getDiferenceMax());
        System.out.println(ks.getDistributionKS());
        System.out.println(ks.isResult());

    }
}
