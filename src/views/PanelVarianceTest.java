package views;

import controller.Controller;
import controller.Events;

import javax.swing.*;
import java.awt.*;

public class PanelVarianceTest extends JPanel {

    private JLabel lbValueRiProm;
    private JLabel lbValueli;
    private JLabel lbValuels;
    private JLabel lbValueVariance;
    private JLabel lbValuefulfill;

    private JButton btnCalculatePoker;

    public PanelVarianceTest(Controller controller){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(getContentData());

        JPanel cpBtnCalculate = new JPanel();
        add(cpBtnCalculate);

        btnCalculatePoker = new JButton("Calcular");
        btnCalculatePoker.setFont(new Font("Arial", Font.ITALIC, 15));
        btnCalculatePoker.setEnabled(false);
        btnCalculatePoker.setActionCommand(Events.CALCULATE_VARIANCE_TEST.toString());
        btnCalculatePoker.addActionListener(controller);
        cpBtnCalculate.add(btnCalculatePoker);

    }

    public JPanel getContentData(){
        JPanel cpContData = new JPanel();
        cpContData.setLayout(new GridLayout(5,1));
        cpContData.setBorder(BorderFactory.createTitledBorder("Resultados"));

        JLabel lbRiProm = new JLabel("  Ri Promedio ");
        lbRiProm.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbRiProm);

        lbValueRiProm = new JLabel();
        cpContData.add(lbValueRiProm);

        JLabel lbLi = new JLabel("  Li: ");
        lbLi.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbLi);

        lbValueli = new JLabel();
        cpContData.add(lbValueli);

        JLabel lbLs = new JLabel("  Ls: ");
        lbLs.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbLs);

        lbValuels = new JLabel();
        cpContData.add(lbValuels);

        JLabel lbVariance = new JLabel("  Varianza: ");
        lbVariance.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbVariance);

        lbValueVariance = new JLabel();
        cpContData.add(lbValueVariance);

        JLabel lbfulfill = new JLabel("  Cumple: ");
        lbfulfill.setFont(new Font("Arial", Font.ITALIC, 15));
        cpContData.add(lbfulfill);

        lbValuefulfill = new JLabel();
        cpContData.add(lbValuefulfill);

        return cpContData;
    }

    public void setResults(String riProm, String li, String ls, String valueVariance, boolean valueFulFill){
        lbValueRiProm.setText(riProm);
        lbValueli.setText(li);
        lbValuels.setText(ls);
        lbValueVariance.setText(valueVariance);
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
