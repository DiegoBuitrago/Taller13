package persistence;

import models.Intro;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class IOReader {

    private ArrayList<Intro> listRi;

    public void read(){
        listRi = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Path filePath = Paths.get("src/files/archivoCsv.csv");
        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String line;
            System.out.println(br.readLine());
            while((line = br.readLine()) != null){
                double val = Double.parseDouble(changeComaPerPoint(line));
                listRi.add(new Intro(val));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String changeComaPerPoint(String line){
        String newLine = "";
        for (int i = 0; i < line.length(); i++){
            if(line.charAt(i) == ','){
                newLine += '.';
            }else{
                newLine += line.charAt(i);
            }
        }
        return newLine;
    }

    public void printList(){
        for (int i=0; i < listRi.size(); i++){
            System.out.println(listRi.get(i).getRi());
        }
    }

    public void chooseFile(JFrame frame){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(frame);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            // Ir a método read y enviarle file como parametro.
        }
    }

    public static void main(String[] args) {
        IOReader ioReader = new IOReader();
        ioReader.read();
        ioReader.printList();
    }
}
