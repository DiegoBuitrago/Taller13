package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelMeanSquares extends JPanel {

    private DefaultTableModel meanSquaresTableAdd;
    private JTable meanSquaresTable;

    public PanelMeanSquares(){
        setLayout(new BorderLayout());

        add(getPanelStart(), BorderLayout.LINE_START);
        add(getPanelCenter(), BorderLayout.CENTER);
        add(getPanelEnd(), BorderLayout.LINE_END);
    }

    public JPanel getPanelStart(){
        JPanel cpStart = new JPanel();
        cpStart.setLayout(new GridLayout(3,1));
        //cpStart.setLayout(new BoxLayout(cpStart, BoxLayout.PAGE_AXIS));

        JPanel cpContData = new JPanel();
        cpContData.setBorder(BorderFactory.createTitledBorder("Datos"));
        cpContData.setLayout(new GridLayout(4,2));
        cpStart.add(cpContData);

        JLabel lbSeed = new JLabel("Semilla");
        cpContData.add(lbSeed);

        JTextField txtSeed = new JTextField(13);
        cpContData.add(txtSeed);

        JLabel lbIteration = new JLabel("Iteraciones");
        cpContData.add(lbIteration);

        JTextField txtIteration = new JTextField();
        cpContData.add(txtIteration);

        JLabel lbMin = new JLabel("Mínimo");
        cpContData.add(lbMin);

        JTextField txtMin = new JTextField();
        cpContData.add(txtMin);

        JLabel lbMax = new JLabel("Máximo");
        cpContData.add(lbMax);

        JTextField txtMax = new JTextField();
        cpContData.add(txtMax);

        JPanel cpExe = new JPanel();
        cpStart.add(cpExe);
        JButton btnExecute = new JButton("Ejecutar");
        cpExe.add(btnExecute);

        JPanel cpClean = new JPanel();
        cpStart.add(cpClean);
        JButton btnClean = new JButton("Limpiar");
        cpClean.add(btnClean);

        return cpStart;
    }

    public JPanel getPanelCenter(){
        JPanel cpCenter = new JPanel();
        meanSquaresTableAdd = new DefaultTableModel();
        meanSquaresTableAdd.setColumnIdentifiers(new String [] {"Xi", "X^2", "Extension", "Extraction", "Ri", "Ni"});
        meanSquaresTable = new JTable(meanSquaresTableAdd);
        JScrollPane scrollUserTable = new JScrollPane(meanSquaresTable);
        cpCenter.add(scrollUserTable);
        return cpCenter;
    }

    public JPanel getPanelEnd(){
        JPanel cpEnd = new JPanel();
        cpEnd.setLayout(new BoxLayout(cpEnd, BoxLayout.Y_AXIS));

        JPanel cpGeneral = new JPanel();
        cpGeneral.setBorder(BorderFactory.createTitledBorder("Prueba uniformidad"));
        cpGeneral.setLayout(new BoxLayout(cpGeneral, BoxLayout.Y_AXIS));
        cpEnd.add(cpGeneral);

        JPanel cpData = new JPanel();
        cpData.setLayout(new GridLayout(5,2));
        cpGeneral.add(cpData);

        JLabel lbMin = new JLabel("Min");
        cpData.add(lbMin);

        JTextField txtMin = new JTextField();
        cpData.add(txtMin);

        JLabel lbMax = new JLabel("Max");
        cpData.add(lbMax);

        JTextField txtMax = new JTextField();
        cpData.add(txtMax);

        JLabel lbResult = new JLabel("Resultado");
        cpData.add(lbResult);

        JLabel lbValueResult = new JLabel();
        cpData.add(lbValueResult);

        JLabel lbValTable = new JLabel("Val Tabla");
        cpData.add(lbValTable);

        JLabel lbValueTable = new JLabel();
        cpData.add(lbValueTable);

        JLabel lbSumChi = new JLabel("Sum Chi");
        cpData.add(lbSumChi);

        JLabel lbValueSumChi = new JLabel();
        cpData.add(lbValueSumChi);

        JButton btnCalc = new JButton("Calcular");
        cpGeneral.add(btnCalc);

        return cpEnd;
    }

    public void addMeanSquares(int x, int squareX, int extension, int extraction, double ri, double ni) {
        meanSquaresTableAdd.addRow(new Object[]{x, squareX, extension, extraction, ri, ni});
    }
}
