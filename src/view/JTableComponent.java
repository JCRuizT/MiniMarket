/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc-standard
 */
public class JTableComponent {
    
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollTable;

    public JTableComponent(String columns[]){
        
        Object data [][] = null;
        model = new DefaultTableModel(data, columns){
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
        
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(true); ;
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.getTableHeader().setResizingAllowed(false);
        scrollTable = new JScrollPane(table);
    }
   
    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JScrollPane getScrollTable() {
        return scrollTable;
    }
    
}
