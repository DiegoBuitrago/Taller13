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

    public void read(String path){
        listRi = new ArrayList<>();
        Path filePath = Paths.get(path);
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

    public ArrayList<Intro> getList(){
        return listRi;
    }
}
