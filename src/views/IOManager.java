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
        add(cpHeader, BorderLayout.PAGE_START);

        JLabel lbIdentify = new JLabel("Programa de números pseudoaleatorios");
        lbIdentify.setFont(new Font("Arial", Font.BOLD, 20));
        cpHeader.add(lbIdentify);

        JTabbedPane pestañas=new JTabbedPane();
        add(pestañas);

        pestañas.addTab("Cuadrados Medios", new PanelMeanSquares());
        pestañas.addTab("Congruencia Lineal", createPanelCongruenceLineal());
        pestañas.addTab("Congruencia Multiplicativa", createPanelCongruenceMult());
        pestañas.addTab("Distribución uniforme", createPanelUniforDist());
        pestañas.addTab("Distribución Normal", createPanelNormalDist());

        setVisible(true);
    }

    public JPanel createPanelCongruenceLineal(){
        JPanel panel=new JPanel();
        JLabel label=new JLabel("Estas en el panel del metodo de congruencia lineal");
        panel.add(label);
        return panel;
    }

    public JPanel createPanelCongruenceMult(){
        JPanel panel=new JPanel();
        JLabel label=new JLabel("Estas en el panel del metodo de congruencia multiplicativa");
        panel.add(label);
        return panel;
    }

    public JPanel createPanelUniforDist(){
        JPanel panel=new JPanel();
        JLabel label=new JLabel("Estas en el panel de distribución uniforme");
        panel.add(label);
        return panel;
    }

    public JPanel createPanelNormalDist(){
        JPanel panel=new JPanel();
        JLabel label=new JLabel("Estas en el panel de distribución normal");
        panel.add(label);
        return panel;
    }

    public static void main(String[] args) {
        new IOManager();
    }
}
