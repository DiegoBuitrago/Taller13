package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelNiTable extends JPanel {

    private DefaultTableModel tableAdd;
    private JTable table;

    public PanelNiTable(){
        setLayout(new BorderLayout());

        JPanel cpTitle = new JPanel();
        add(cpTitle, BorderLayout.PAGE_START);

        JLabel lbIdentify = new JLabel("Cómo generar Ni");
        lbIdentify.setFont(new Font("Arial", Font.ITALIC, 25));
        cpTitle.add(lbIdentify);

        tableAdd = new DefaultTableModel();
        tableAdd.setColumnIdentifiers(new String [] {"Ni"});
        table = new JTable(tableAdd);
        JScrollPane scrollUserTable = new JScrollPane(table);
        add(scrollUserTable, BorderLayout.CENTER);
    }

    public void addNis(double ni) {
        tableAdd.addRow(new Object[]{ni});
    }
}
