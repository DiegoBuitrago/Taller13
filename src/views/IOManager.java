package views;

import controller.Controller;
import controller.Events;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class IOManager extends JFrame {

    public IOManager(){
        setTitle("Pantalla de Inicio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        JPanel cpHeader = new JPanel();
        cpHeader.setBorder(new LineBorder(Color.BLACK,1));
        cpHeader.setLayout(new BoxLayout(cpHeader, BoxLayout.Y_AXIS));
        add(cpHeader, BorderLayout.PAGE_START);

        JPanel cpTitle = new JPanel();
        cpHeader.add(cpTitle);

        JLabel lbIdentify = new JLabel("Pruebas de números pseudoaleatorios");
        lbIdentify.setFont(new Font("Arial", Font.BOLD, 20));
        cpTitle.add(lbIdentify);
        
        JPanel cpBtnImport = new JPanel();
        cpHeader.add(cpBtnImport);
        
        JButton btnImport = new JButton("Importar");
        cpBtnImport.add(btnImport);

        JPanel cpCenter = new JPanel();
        cpCenter.setLayout(new GridLayout(1, 2));
        add(cpCenter, BorderLayout.CENTER);

        cpCenter.add(new PanelRiTable());

        JTabbedPane pestañas=new JTabbedPane();
        cpCenter.add(pestañas);

        pestañas.addTab("Prueba de medias", new PanelMeanTest());
        pestañas.addTab("Prueba de varianza", new PanelVarianceTest());
        pestañas.addTab("Prueba KS", new PanelKSTest());
        pestañas.addTab("Prueba Chi^2", new PanelChiSquareTest());
        pestañas.addTab("Prueba de Póker", new PanelPokerTest());

        setVisible(true);
    }

    public static void main(String[] args) {
        new IOManager();
    }
}
