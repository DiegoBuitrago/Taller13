package views;

import controller.Controller;
import controller.Events;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class IOManager extends JFrame {
    
    private PanelRiTable panelRiList;
    private PanelNiTable panelNiList;

    private PanelChiSquareTest panelChiSquareTest;
    private PanelPokerTest panelPokerTest;
    private PanelKSTest panelKSTest;

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
        lbIdentify.setFont(new Font("Arial", Font.ITALIC, 25));
        cpTitle.add(lbIdentify);

        JPanel cpBtnImport = new JPanel();
        cpHeader.add(cpBtnImport);

        JButton btnImport = new JButton("Importar");
        btnImport.setFocusable(false);
        btnImport.setBackground(Color.ORANGE);
        btnImport.setFont(new Font("Arial", Font.ITALIC, 15));
        btnImport.setActionCommand(Events.IMPORT.toString());
        btnImport.addActionListener(controller);
        cpBtnImport.add(btnImport);

        JPanel cpCenter = new JPanel();
        cpCenter.setLayout(new GridLayout(1, 2));
        add(cpCenter, BorderLayout.CENTER);

        cpCenter.add(panelRiList);

        JTabbedPane pestañas=new JTabbedPane();
        cpCenter.add(pestañas);


        pestañas.addTab("Prueba Chi^2", panelChiSquareTest);
        pestañas.addTab("Prueba de medias", new PanelMeanTest());
        pestañas.addTab("Prueba de varianza", new PanelVarianceTest());
        pestañas.addTab("Prueba KS", panelKSTest);
        pestañas.addTab("Prueba de Póker", panelPokerTest);
        pestañas.addTab("Ni", panelNiList);
        
        setVisible(true);
    }
    
    private void initPanels(Controller controller){
        panelRiList = new PanelRiTable();
        panelNiList = new PanelNiTable();
        panelChiSquareTest = new PanelChiSquareTest(controller);
        panelPokerTest = new PanelPokerTest(controller);
        panelKSTest = new PanelKSTest(controller);
    }

    public void fillRiList(double ri){
        panelRiList.addRis(ri);
    }

    public void fillNiList(double ni){
        panelNiList.addNis(ni);
    }

    //Panel Chi^2
    public void fillResultsChi2(int n, double initialN, double finalN, int frecObt, double frecEsp, double chi2){
        panelChiSquareTest.addResults(n, initialN, finalN, frecObt, frecEsp, chi2);
    }

    public int getDataChi(){
        return panelChiSquareTest.getData();
    }

    public void setPanelChiSetResults(String valueTotalChi, String valueFreedomGrade, String valueTest, boolean valueFulFill){
        panelChiSquareTest.setResults(valueTotalChi, valueFreedomGrade, valueTest, valueFulFill);
    }

    //Panel Poker
    public void fillResultPoker(char cat, int frecObt, double prob, double frecEsp, double chi2, String description){
        panelPokerTest.addResults(cat, frecObt, prob, frecEsp, chi2, description);
    }

    public void setPanelPokerSetResults(String valueTotalChi, String valueFreedomGrade, String valueTest, boolean valueFulFill){
        panelPokerTest.setResults(valueTotalChi, valueFreedomGrade, valueTest, valueFulFill);
    }

    //Panel KS
    public void fillResultKS(int n, double initialN, double finalN, int frecObt, int corr, double frecAcu, double probFrecObt, double frecAcuEsp, double probAcuEsp, double diference){
        panelKSTest.addResults(n, initialN, finalN, frecObt, corr, frecAcu, probFrecObt, frecAcuEsp, probAcuEsp, diference);
    }

    public void setPanelKSSetResults(String dmax, String dmaxp, boolean valueFulFill){
        panelKSTest.setResults(dmax, dmaxp, valueFulFill);
    }

    public int getIterationKS(){
        return panelKSTest.getIterations();
    }

    public void setPanelKSResults(){

    }



    public String chooseFile(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            panelChiSquareTest.activateButton();
            panelPokerTest.activateButton();
            panelKSTest.activateButton();
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getPath());
            return chooser.getSelectedFile().getPath();
        }
        return null;
    }
}