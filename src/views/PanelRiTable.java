package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelRiTable extends JPanel {

    private DefaultTableModel tableAdd;
    private JTable table;

    public PanelRiTable(){
        tableAdd = new DefaultTableModel();
        tableAdd.setColumnIdentifiers(new String [] {"Ri", "Ni"});
        table = new JTable(tableAdd);
        JScrollPane scrollUserTable = new JScrollPane(table);
        add(scrollUserTable);
    }

    public void addMeanSquares(double ri, double ni) {
        tableAdd.addRow(new Object[]{ri, ni});
    }
}
