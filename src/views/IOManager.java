package views;

import controller.Controller;
import controller.Events;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class IOManager extends JFrame {
    
    private PanelRiTable panelRiList;
    private PanelChiSquareTest panelChiSquareTest;

    public IOManager(Controller controller){
        initPanels(controller);
        
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
        btnImport.setActionCommand(Events.IMPORT.toString());
        btnImport.addActionListener(controller);
        cpBtnImport.add(btnImport);

        JPanel cpCenter = new JPanel();
        cpCenter.setLayout(new GridLayout(1, 2));
        add(cpCenter, BorderLayout.CENTER);

        cpCenter.add(panelRiList);

        JTabbedPane pestañas=new JTabbedPane();
        cpCenter.add(pestañas);

        pestañas.addTab("Prueba de medias", new PanelMeanTest());
        pestañas.addTab("Prueba de varianza", new PanelVarianceTest());
        pestañas.addTab("Prueba KS", new PanelKSTest());
        pestañas.addTab("Prueba Chi^2", panelChiSquareTest);
        pestañas.addTab("Prueba de Póker", new PanelPokerTest());
        
        setVisible(true);
    }
    
    private void initPanels(Controller controller){
        panelRiList = new PanelRiTable();
        panelChiSquareTest = new PanelChiSquareTest(controller);
    }

    public void fillRiList(double ri, double ni){
        panelRiList.addValues(ri, ni);
    }

    public void fillResultsChi2(int n, double initialN, double finalN, int frecObt, double frecEsp, double chi2){
        panelChiSquareTest.addResults(n, initialN, finalN, frecObt, frecEsp, chi2);
    }

    public String chooseFile(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getPath());
            return chooser.getSelectedFile().getPath();
        }
        return null;
    }

    public int[] getData(){
        return panelChiSquareTest.getData();
    }
}
