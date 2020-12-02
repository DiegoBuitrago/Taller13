package test;

import methodsTest.Poker;
import models.Intro;

import java.util.ArrayList;

public class TestPoker {
    public static void main(String[] args) {
        p1();
    }

    private static void p1(){
        ArrayList<Intro> list = new ArrayList<Intro>();
        //25 numeros.
        //Todos diferentes
        list.add(new Intro(0.12345));
        list.add(new Intro(0.78945));
        list.add(new Intro(0.45698));
        list.add(new Intro(0.12345));
        list.add(new Intro(0.78945));
        list.add(new Intro(0.45698));
        list.add(new Intro(0.12345));
        //Un par
        list.add(new Intro(0.11467));
        list.add(new Intro(0.77894));
        list.add(new Intro(0.99451));
        //Dos pares
        list.add(new Intro(0.11887));
        list.add(new Intro(0.99664));
        list.add(new Intro(0.45533));
        //Tercia
        list.add(new Intro(0.42844));
        list.add(new Intro(0.77756));
        list.add(new Intro(0.99974));
        //Tercia y par
        list.add(new Intro(0.77788));
        list.add(new Intro(0.99922));
        list.add(new Intro(0.66655));
        //4 cartas Poker
        list.add(new Intro(0.77778));
        list.add(new Intro(0.99992));
        list.add(new Intro(0.65555));
        //5 cartas del mismo valor
        list.add(new Intro(0.77777));
        list.add(new Intro(0.99999));
        list.add(new Intro(0.55555));

        Poker poker = new Poker(list);

        for (int i=0;i<poker.getLines().size();i++) {
            System.out.println(poker.getLines().get(i).toString());
        }

        System.out.println(poker.getSumChi2());
        System.out.println(poker.getLibertyGrade());
        System.out.println(poker.getDistributionChi());
        System.out.println(poker.isResult());
    }
}