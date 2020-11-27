package controller;

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
        }
    }

    private void importFile(){
        ioReader.read(ioManager.chooseFile());
        for(int i = 0; i < ioReader.getList().size(); i++){
            ioReader.getList().get(i).calculateNi(8, 10);
            ioManager.fillRiList(ioReader.getList().get(i).getRi(), ioReader.getList().get(i).getNi());
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
