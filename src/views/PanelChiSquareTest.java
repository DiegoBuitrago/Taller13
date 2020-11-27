package views;

import javax.swing.*;
import java.awt.*;

public class PanelChiSquareTest extends JPanel {

    public PanelChiSquareTest(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(getContentData());
        add(getContResults());

        JPanel cpBtnCalculate = new JPanel();
        add(cpBtnCalculate);

        JButton btnCalculate = new JButton("Calcular");
        cpBtnCalculate.add(btnCalculate);
    }

    public JPanel getContentData(){
        JPanel cpContData = new JPanel();
        cpContData.setBorder(BorderFactory.createTitledBorder("Datos"));
        cpContData.setLayout(new GridLayout(3,2));

        JLabel lbMin = new JLabel("Mínimo: ");
        lbMin.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbMin);

        JSpinner spMin = new JSpinner();
        cpContData.add(spMin);

        JLabel lbMax = new JLabel("Máximo: ");
        lbMax.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbMax);

        JSpinner spMax = new JSpinner();
        cpContData.add(spMax);

        JLabel lbIteration = new JLabel("Iteraciones: ");
        lbIteration.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbIteration);

        JSpinner spIteration = new JSpinner();
        cpContData.add(spIteration);

        return cpContData;
    }

    public JPanel getContResults(){
        JPanel cpContResult = new JPanel();
        cpContResult.setBorder(BorderFactory.createTitledBorder("Resultados"));
        cpContResult.setLayout(new GridLayout(3,2));

        JLabel lbResult = new JLabel("Prueba: ");
        lbResult.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContResult.add(lbResult);

        JLabel lbValueResult = new JLabel();
        cpContResult.add(lbValueResult);

        JLabel lbValTable = new JLabel("Valor Tabla: ");
        lbValTable.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContResult.add(lbValTable);

        JLabel lbValueTable = new JLabel();
        cpContResult.add(lbValueTable);

        JLabel lbSumChi = new JLabel("Suma Chi: ");
        lbSumChi.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContResult.add(lbSumChi);

        JLabel lbValueSumChi = new JLabel();
        cpContResult.add(lbValueSumChi);

        return cpContResult;
    }
}
