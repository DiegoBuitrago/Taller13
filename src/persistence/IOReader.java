package persistence;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class IOReader {

    private ArrayList<Double> listRi;

    public void read(){
        StringBuilder sb = new StringBuilder();
        Path filePath = Paths.get("src/files/archivoCsv.csv");

        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String line;
            line = br.readLine();
            while((line = br.readLine()) != null){
                //System.out.println("... " + line);
                changeComaPerPoint(line);
                //listRi.add(Double.parseDouble(changeComaPerPoint(line)));
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
                //System.out.println("hola");
            }else{
                newLine += line.charAt(i);
            }
        }
        System.out.println(newLine);
        return newLine;
    }

    public void printList(){
        for (int i=0; i < listRi.size(); i++){
            System.out.println(listRi.get(i));
        }
    }

    public void chooseFile(JFrame frame){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(frame);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }
    }

    public static void main(String[] args) {
        IOReader ioReader = new IOReader();
        ioReader.read();
        //ioReader.printList();
    }
}
