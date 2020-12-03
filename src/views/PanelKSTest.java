package views;

import controller.Controller;
import controller.Events;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelKSTest extends JPanel {

    private DefaultTableModel tableResultAdd;
    private JTable tableResult;

    private JSpinner spMin;
    private JSpinner spMax;
    private JSpinner spIteration;

    private JLabel lbValueDmax;
    private JLabel lbValuedmaxp;
    private JLabel lbValueTest;
    private JLabel lbValuefulfill;

    private JButton btnCalculateKS;

    public PanelKSTest(Controller controller){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(getContentData());

        JPanel cpBtnCalculate = new JPanel();
        add(cpBtnCalculate);

        btnCalculateKS = new JButton("Calcular");
        btnCalculateKS.setFont(new Font("Arial", Font.ITALIC, 15));
        btnCalculateKS.setEnabled(false);
        btnCalculateKS.setActionCommand(Events.CALCULATE_KS_TEST.toString());
        btnCalculateKS.addActionListener(controller);
        cpBtnCalculate.add(btnCalculateKS);

        add(getContResults());
    }

    public JPanel getContentData(){
        JPanel cpContData = new JPanel();
        cpContData.setLayout(new GridLayout(1,2));

        JPanel cpFirst = new JPanel();
        cpFirst.setBorder(BorderFactory.createTitledBorder("Datos"));
        cpFirst.setLayout(new GridLayout(1,2));
        cpContData.add(cpFirst);

        JLabel lbIteration = new JLabel("Iteraciones: ");
        lbIteration.setFont(new Font("Arial", Font.ITALIC, 15));
        cpFirst.add(lbIteration);

        spIteration = new JSpinner();
        cpFirst.add(spIteration);

        JPanel cpSecond = new JPanel();
        cpSecond.setBorder(BorderFactory.createTitledBorder("Resultados"));
        cpSecond.setLayout(new GridLayout(3,2));
        cpContData.add(cpSecond);

        JLabel lbDMax = new JLabel("  DMax ");
        lbDMax.setFont(new Font("Arial", Font.ITALIC, 15));
        cpSecond.add(lbDMax);

        lbValueDmax = new JLabel();
        cpSecond.add(lbValueDmax);

        JLabel lbMaxP = new JLabel("  DMaxP: ");
        lbMaxP.setFont(new Font("Arial", Font.ITALIC, 15));
        cpSecond.add(lbMaxP);

        lbValuedmaxp = new JLabel();
        cpSecond.add(lbValuedmaxp);

        JLabel lbfulfill = new JLabel("  Cumple: ");
        lbfulfill.setFont(new Font("Arial", Font.ITALIC, 15));
        cpSecond.add(lbfulfill);

        lbValuefulfill = new JLabel();
        cpSecond.add(lbValuefulfill);

        return cpContData;
    }

    public JPanel getContResults(){
        JPanel cpContResult = new JPanel();
        cpContResult.setBorder(BorderFactory.createTitledBorder("Tabla de resultados"));

        tableResultAdd = new DefaultTableModel();
        tableResultAdd.setColumnIdentifiers(new String [] {"No", "Inicial", "Final", "Frec Obt", "Frec Esp", "Corr", "FrecAcu", "ProbFrecObt", "FrecAcuEsp",
                                                            "ProbAcuEsp", "Diferencia"});
        tableResult = new JTable(tableResultAdd);
        JScrollPane scrollUserTable = new JScrollPane(tableResult);
        cpContResult.add(scrollUserTable);

        return cpContResult;
    }

    public int getIterations(){
        return (Integer) spIteration.getValue();
    }
    
    public void setResults(String dmax, String dmaxp, boolean valueFulFill){
        lbValueDmax.setText(dmax);
        lbValuedmaxp.setText(dmaxp);
        if(valueFulFill){
            lbValuefulfill.setText("Sí");
        }else{
            lbValuefulfill.setText("No");
        }
    }

    public void activateButton(){
        btnCalculateKS.setEnabled(true);
        btnCalculateKS.setBackground(Color.ORANGE);
    }

    public void addResults(int n, double initialN, double finalN, int frecObt, int corr, double frecAcu, double probFrecObt, double frecAcuEsp, double probAcuEsp, double diference) {
        tableResultAdd.addRow(new Object[]{n, initialN, finalN, frecObt, corr, frecAcu, probFrecObt, frecAcuEsp, probFrecObt, probAcuEsp, diference});
    }
}
