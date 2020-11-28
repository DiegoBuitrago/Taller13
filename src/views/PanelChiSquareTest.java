package views;

import controller.Controller;
import controller.Events;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelChiSquareTest extends JPanel {

    private DefaultTableModel tableResultAdd;
    private JTable tableResult;

    private JSpinner spMin;
    private JSpinner spMax;
    private JSpinner spIteration;
    
    private JLabel lbValueTotalChi;
    private JLabel lbValueFreedom;
    private JLabel lbValueTest;
    private JLabel lbValuefulfill;

    private JButton btnCalculateChi;

    public PanelChiSquareTest(Controller controller){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(getContentData());

        JPanel cpBtnCalculate = new JPanel();
        add(cpBtnCalculate);

        btnCalculateChi = new JButton("Calcular");
        btnCalculateChi.setFont(new Font("Arial", Font.ITALIC, 15));
        btnCalculateChi.setEnabled(false);
        btnCalculateChi.setActionCommand(Events.CALCULATE_CHI2.toString());
        btnCalculateChi.addActionListener(controller);
        cpBtnCalculate.add(btnCalculateChi);

        add(getContResults());
    }

    public JPanel getContentData(){
        JPanel cpContData = new JPanel();
        cpContData.setLayout(new GridLayout(1,2));

        JPanel cpFirst = new JPanel();
        cpFirst.setBorder(BorderFactory.createTitledBorder("Datos"));
        cpFirst.setLayout(new GridLayout(3,1));
        cpContData.add(cpFirst);

        JLabel lbMin = new JLabel("Mínimo: ");
        lbMin.setFont(new Font("Arial", Font.ITALIC, 15));
        cpFirst.add(lbMin);

        spMin = new JSpinner();
        cpFirst.add(spMin);

        JLabel lbMax = new JLabel("Máximo: ");
        lbMax.setFont(new Font("Arial", Font.ITALIC, 15));
        cpFirst.add(lbMax);

        spMax = new JSpinner();
        cpFirst.add(spMax);

        JLabel lbIteration = new JLabel("Iteraciones: ");
        lbIteration.setFont(new Font("Arial", Font.ITALIC, 15));
        cpFirst.add(lbIteration);

        spIteration = new JSpinner();
        cpFirst.add(spIteration);

        JPanel cpSecond = new JPanel();
        cpSecond.setBorder(BorderFactory.createTitledBorder("Resultados"));
        cpSecond.setLayout(new GridLayout(4,1));
        cpContData.add(cpSecond);

        JLabel lbTotalChi = new JLabel("  Total Chi^2: ");
        lbTotalChi.setFont(new Font("Arial", Font.ITALIC, 15));
        cpSecond.add(lbTotalChi);

        lbValueTotalChi = new JLabel();
        cpSecond.add(lbValueTotalChi);

        JLabel lbFreedom = new JLabel("  Grado Libertad: ");
        lbFreedom.setFont(new Font("Arial", Font.ITALIC, 15));
        cpSecond.add(lbFreedom);

        lbValueFreedom = new JLabel();
        cpSecond.add(lbValueFreedom);

        JLabel lbTest = new JLabel("  Prueba: ");
        lbTest.setFont(new Font("Arial", Font.ITALIC, 15));
        cpSecond.add(lbTest);

        lbValueTest = new JLabel();
        cpSecond.add(lbValueTest);

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
        tableResultAdd.setColumnIdentifiers(new String [] {"No", "Inicial", "Final", "Frec Obt", "Frec Esp", "Chi^2"});
        tableResult = new JTable(tableResultAdd);
        JScrollPane scrollUserTable = new JScrollPane(tableResult);
        cpContResult.add(scrollUserTable);

        return cpContResult;
    }

    public int [] getData(){
        int[] dataList = new int[3];
        dataList[0] = (Integer) spMin.getValue();
        dataList[1] = (Integer) spMax.getValue();
        dataList[2] = (Integer) spIteration.getValue();
        return dataList;
    }
    
    public void setResults(String valueTotalChi, String valueFreedomGrade, String valueTest, boolean valueFulFill){
        lbValueTotalChi.setText(valueTotalChi);
        lbValueFreedom.setText(valueFreedomGrade);
        lbValueTest.setText(valueTest);
        if(valueFulFill){
            lbValuefulfill.setText("Sí");
        }else{
            lbValuefulfill.setText("No");
        }
    }

    public void activateButton(){
        btnCalculateChi.setEnabled(true);
        btnCalculateChi.setBackground(Color.ORANGE);
    }

    public void addResults(int n, double initialN, double finalN, int frecObt, double frecEsp, double chi2) {
        tableResultAdd.addRow(new Object[]{n, initialN, finalN, frecObt, frecEsp, chi2});
    }
}
