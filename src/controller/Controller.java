package controller;

import methodsTest.Chi;
import models.LineChiTest;
import persistence.IOReader;
import views.IOManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private IOManager ioManager;
    private IOReader ioReader;

    private Chi chi;

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
        }
    }

    private void importFile(){
        ioReader.read(ioManager.chooseFile());
        for(int i = 0; i < ioReader.getList().size(); i++){
            ioReader.getList().get(i).calculateNi(8, 10);
            ioManager.fillRiList(ioReader.getList().get(i).getRi(), ioReader.getList().get(i).getNi());
        }
    }

    private void calculateChi2(){
        int min = ioManager.getData()[0];
        int max = ioManager.getData()[1];
        int iterations = ioManager.getData()[2];
        //chi = new Chi(ioReader.getList(), min, max, iterations);
        ioManager.panelChiSetResults(""+ chi.getTotalChi2(), "" + chi.getLibertyGrade(), "" + chi.getPrueba(), chi.isResult());
        System.out.println("Min: " + min + "** Max: " + max + "**It: " + iterations);
        for (int i = 0; i < chi.getLines().size(); i++){
            LineChiTest currentLine = chi.getLines().get(i);
            ioManager.fillResultsChi2(currentLine.getId(), currentLine.getInitial(), currentLine.getFinall(),
                    currentLine.getFrecObt(), currentLine.getFrecEsp(), currentLine.getChi());
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
