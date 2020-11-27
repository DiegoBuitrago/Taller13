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

    public PanelChiSquareTest(Controller controller){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(getContentData());

        JPanel cpBtnCalculate = new JPanel();
        add(cpBtnCalculate);

        JButton btnCalculateChi = new JButton("Calcular");
        btnCalculateChi.setActionCommand(Events.CALCULATE_CHI2.toString());
        btnCalculateChi.addActionListener(controller);
        cpBtnCalculate.add(btnCalculateChi);

        add(getContResults());
    }

    public JPanel getContentData(){
        JPanel cpContData = new JPanel();
        cpContData.setBorder(BorderFactory.createTitledBorder("Datos"));
        cpContData.setLayout(new GridLayout(3,4));

        JLabel lbMin = new JLabel("Mínimo: ");
        lbMin.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbMin);

        spMin = new JSpinner();
        cpContData.add(spMin);

        JLabel lbResult = new JLabel("  Prueba: ");
        lbResult.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbResult);

        JLabel lbValueResult = new JLabel();
        cpContData.add(lbValueResult);

        JLabel lbMax = new JLabel("Máximo: ");
        lbMax.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbMax);

        spMax = new JSpinner();
        cpContData.add(spMax);

        JLabel lbValTable = new JLabel("  Valor Tabla: ");
        lbValTable.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbValTable);

        JLabel lbValueTable = new JLabel();
        cpContData.add(lbValueTable);

        JLabel lbIteration = new JLabel("Iteraciones: ");
        lbIteration.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbIteration);

        spIteration = new JSpinner();
        cpContData.add(spIteration);

        JLabel lbSumChi = new JLabel("  Suma Chi: ");
        lbSumChi.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbSumChi);

        JLabel lbValueSumChi = new JLabel();
        cpContData.add(lbValueSumChi);

        return cpContData;
    }

    public JPanel getContResults(){
        JPanel cpContResult = new JPanel();
        cpContResult.setBorder(BorderFactory.createTitledBorder("Resultados"));

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

    public void addResults(int n, double initialN, double finalN, int frecObt, double frecEsp, double chi2) {
        tableResultAdd.addRow(new Object[]{n, initialN, finalN, frecObt, frecEsp, chi2});
    }
}
