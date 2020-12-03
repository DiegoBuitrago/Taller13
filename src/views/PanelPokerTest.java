package views;

import controller.Controller;
import controller.Events;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelPokerTest extends JPanel {

    private DefaultTableModel tableResultAdd;
    private JTable tableResult;

    private JLabel lbValueTotalChi;
    private JLabel lbValueFreedom;
    private JLabel lbValueTest;
    private JLabel lbValuefulfill;

    private JButton btnCalculatePoker;

    public PanelPokerTest(Controller controller){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(getContentData());

        JPanel cpBtnCalculate = new JPanel();
        add(cpBtnCalculate);

        btnCalculatePoker = new JButton("Calcular");
        btnCalculatePoker.setFont(new Font("Arial", Font.ITALIC, 15));
        btnCalculatePoker.setEnabled(false);
        btnCalculatePoker.setActionCommand(Events.CALCULATE_POKER_TEST.toString());
        btnCalculatePoker.addActionListener(controller);
        cpBtnCalculate.add(btnCalculatePoker);

        add(getContResults());
    }

    public JPanel getContentData(){
        JPanel cpContData = new JPanel();
        cpContData.setLayout(new GridLayout(4,1));
        cpContData.setBorder(BorderFactory.createTitledBorder("Resultados"));

        JLabel lbTotalChi = new JLabel("  Total Chi^2: ");
        lbTotalChi.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbTotalChi);

        lbValueTotalChi = new JLabel();
        cpContData.add(lbValueTotalChi);

        JLabel lbFreedom = new JLabel("  Grado Libertad: ");
        lbFreedom.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbFreedom);

        lbValueFreedom = new JLabel();
        cpContData.add(lbValueFreedom);

        JLabel lbTest = new JLabel("  Prueba: ");
        lbTest.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbTest);

        lbValueTest = new JLabel();
        cpContData.add(lbValueTest);

        JLabel lbfulfill = new JLabel("  Cumple: ");
        lbfulfill.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbfulfill);

        lbValuefulfill = new JLabel();
        cpContData.add(lbValuefulfill);

        return cpContData;
    }

    public JPanel getContResults(){
        JPanel cpContResult = new JPanel();
        cpContResult.setBorder(BorderFactory.createTitledBorder("Tabla de resultados"));

        tableResultAdd = new DefaultTableModel();
        tableResultAdd.setColumnIdentifiers(new String [] {"Cat", "Frec Obt", "Prob", "Frec Esp", "Chi^2", "Desc"});
        tableResult = new JTable(tableResultAdd);
        JScrollPane scrollUserTable = new JScrollPane(tableResult);
        cpContResult.add(scrollUserTable);

        return cpContResult;
    }

    public void addResults(char cat, int frecObt, double prob, double frecEsp, double chi2, String description) {
        tableResultAdd.addRow(new Object[]{cat, frecObt, prob, frecEsp, chi2, description});
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
        btnCalculatePoker.setEnabled(true);
        btnCalculatePoker.setBackground(Color.ORANGE);
    }
}
