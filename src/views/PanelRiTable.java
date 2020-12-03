package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelRiTable extends JPanel {

    private DefaultTableModel tableAdd;
    private JTable table;

    public PanelRiTable(){
        tableAdd = new DefaultTableModel();
        tableAdd.setColumnIdentifiers(new String [] {"Ri"});
        table = new JTable(tableAdd);
        JScrollPane scrollUserTable = new JScrollPane(table);
        add(scrollUserTable);
    }

    public void addRis(double ri) {
        tableAdd.addRow(new Object[]{ri});
    }
}
