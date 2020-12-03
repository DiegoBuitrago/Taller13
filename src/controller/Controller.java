package controller;

import methodsTest.Chi;
import methodsTest.Ks;
import methodsTest.Poker;
import models.LineChiTest;
import models.LineKsTest;
import models.LinePokerTest;
import persistence.IOReader;
import views.IOManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private IOManager ioManager;
    private IOReader ioReader;

    public Controller(){
        ioManager = new IOManager(this);
        ioReader = new IOReader();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Events.valueOf(e.getActionCommand())) {
            case IMPORT:
                importFile();
                break;
            case CALCULATE_CHI2:
                calculateChi2();
                break;
            case CALCULATE_POKER_TEST:
                calculatePokerTest();
                break;
            case CALCULATE_KS_TEST:
                calculateKS();
                break;
        }
    }

    private void calculateChi2(){
        int iterations = ioManager.getDataChi();
        Chi chi = new Chi(ioReader.getList(), iterations);
        ioManager.setPanelChiSetResults(""+ chi.getTotalChi2(), "" + chi.getLibertyGrade(), "" + chi.getDistributionChi(), chi.isResult());
        //System.out.println("Min: " + min + "** Max: " + max + "**It: " + iterations);
        for (int i = 0; i < chi.getLines().size(); i++){
            LineChiTest currentLine = chi.getLines().get(i);
            ioManager.fillResultsChi2(currentLine.getId(), currentLine.getInitial(), currentLine.getFinall(),
                    currentLine.getFrecObt(), currentLine.getFrecEsp(), currentLine.getChi());
        }
    }

    private void calculatePokerTest(){
        Poker poker = new Poker(ioReader.getList());
        ioManager.setPanelPokerSetResults(""+ poker.getSumChi2(), "" + poker.getLibertyGrade(), "" + poker.getDistributionChi(), poker.isResult());
        for (int i = 0; i < poker.getLines().size(); i++){
            LinePokerTest currentLine = poker.getLines().get(i);
            ioManager.fillResultPoker(currentLine.getCat(), currentLine.getFrecObs(), currentLine.getProb(),
                    currentLine.getFrecEsp(), currentLine.getChi2(), currentLine.getDesc());
        }
    }

    private void calculateKS(){
        Ks ks = new Ks(ioReader.getList(), ioManager.getIterationKS());
        ioManager.setPanelKSSetResults(""+ ks.getDiferenceMax(), "" + ks.getDistributionKS(), ks.isResult());
        for (int i = 0; i < ks.getLines().size(); i++){
            LineKsTest currentLine = ks.getLines().get(i);
            ioManager.fillResultKS(currentLine.getId(), currentLine.getInitial(), currentLine.getFinall(),
                    currentLine.getFrecObt(), currentLine.getCorr(), currentLine.getFrecAcu(),
                    currentLine.getProbFrecObt(), currentLine.getFrecAcuEsp(), currentLine.getProbFrecAcuEsp(), currentLine.getDiference());
        }
    }

    private void importFile(){
        ioReader.read(ioManager.chooseFile());
        for(int i = 0; i < ioReader.getList().size(); i++){
            ioReader.getList().get(i).calculateNi(8, 10);
            ioManager.fillRiList(ioReader.getList().get(i).getRi());
            ioManager.fillNiList(ioReader.getList().get(i).getNi());
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
