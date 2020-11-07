/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.RowFilter.regexFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author pc-standard
 */
public class JTableSearch extends JTextField implements DocumentListener {

    private JTable tableList;
    private TableRowSorter sorter;

    public JTableSearch(JTable tableList) {
        super();
        this.tableList = tableList;
        sorter = new TableRowSorter<>(tableList.getModel());

        tableList.setRowSorter(sorter);
        super.getDocument().addDocumentListener((DocumentListener) this);
        
    }

    public void insertUpdate(DocumentEvent e) {
        search(this.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        search(this.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        search(this.getText());
    }

    public void search(String str) {
        
        
        if (str.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            
           
           sorter.setRowFilter(regexFilter("(?i)"+str));
           
           //sorter.setRowFilter(regexFilter(str));
        }
        
        
    }

}
