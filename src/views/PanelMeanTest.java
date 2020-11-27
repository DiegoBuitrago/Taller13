package views;

import javax.swing.*;
import java.awt.*;

public class PanelMeanTest extends JPanel {

    public PanelMeanTest(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel cpBtnCalculate = new JPanel();
        add(cpBtnCalculate);

        JButton btnCalculate = new JButton("Calcular");
        cpBtnCalculate.add(btnCalculate);
    }
}
