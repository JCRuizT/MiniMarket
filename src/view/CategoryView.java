/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author pc-standard
 */
public class CategoryView extends JPanel {
    
    JTextField fieldName = new JTextField();
    JComboBox fieldIva = new JComboBox();
    private JTableComponent tableList; 
    
    JButton buttonCreateCategory = new JButton();
    JButton buttonDeleteCategory = new JButton();
    JButton buttonUpdateCategory = new JButton();
    JButton buttonCancelCategory = new JButton();
    
    JLabel labelName = new JLabel();
    JLabel title = new JLabel();
    JLabel shearch = new JLabel();
    private JTableSearch fieldSearch;
    
    private final int x = 1500 ;
    private final int y = 1500;
    
    public CategoryView(ResultSet result) {
        
        setSize(x, y);
        setLayout(null);
        
        title.setText("Gestionar Categorias");
        title.setLocation(0, 0);
        title.setSize(850,45);
        title.setForeground(Color.orange);
        title.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 35));
       
        labelName.setText("Nombre de la categoria");
        labelName.setLocation(90, 190);
        labelName.setSize(250,30);
        labelName.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        fieldName.setLocation(90, 240);
        fieldName.setSize(230,30);
        fieldName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        fieldIva = new JComboBox();
        fieldIva.setLocation(90, 290);
        fieldIva.setSize(230,30);
        fieldIva.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
	fieldIva.addItem("     Seleccionar IVA");
        
        buttonCreateCategory = new JButton("Crear Categoria");
        buttonCreateCategory.setLocation(90, 340);
        buttonCreateCategory.setSize(230,30);
        buttonCreateCategory.setBackground(Color.orange);
        buttonCreateCategory.setForeground(Color.white);
        buttonCreateCategory.setFocusable(false);
        buttonCreateCategory.setBorder(null);
        buttonCreateCategory.setFont(new Font("Arial", Font.BOLD, 15));
        
        buttonDeleteCategory.setText("Eliminar Categoria");
        buttonDeleteCategory.setLocation(90, 490);
        buttonDeleteCategory.setSize(230,30);
        buttonDeleteCategory.setBackground(Color.orange);
        buttonDeleteCategory.setForeground(Color.white);
        buttonDeleteCategory.setFocusable(false);
        buttonDeleteCategory.setBorder(null);
        buttonDeleteCategory.setFont(new Font("Arial", Font.BOLD, 15));
        
        buttonUpdateCategory.setText("Actualizar Categoria");
        buttonUpdateCategory.setLocation(90, 540);
        buttonUpdateCategory.setSize(230,30);
        buttonUpdateCategory.setBackground(Color.orange);
        buttonUpdateCategory.setForeground(Color.white);
        buttonUpdateCategory.setFocusable(false);
        buttonUpdateCategory.setBorder(null);
        buttonUpdateCategory.setFont(new Font("Arial", Font.BOLD, 15));
        
        buttonCancelCategory.setText("Cancelar");
        buttonCancelCategory.setLocation(90, 590);
        buttonCancelCategory.setSize(230,30);
        buttonCancelCategory.setBackground(Color.orange);
        buttonCancelCategory.setForeground(Color.white);
        buttonCancelCategory.setFocusable(false);
        buttonCancelCategory.setBorder(null);
        buttonCancelCategory.setFont(new Font("Arial", Font.BOLD, 15));
        buttonCancelCategory.setEnabled(false);
        buttonCancelCategory.setVisible(false);
        
       
       
        
        for(int i=0; i<=100; i++){
            fieldIva.addItem(i);
        }
              
        
            
        String columns[] = {"id","Nombre","Iva"};
        tableList = new JTableComponent(columns);
       
        
        try {
            while (result.next()) {
                Object rs[] = {result.getString("TipProId"),result.getString("TipProNombre"),result.getString("TipProIva")}; 
                tableList.getModel().addRow(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        fieldSearch = new JTableSearch(tableList.getTable());
        fieldSearch.setLocation(750, 110);
        fieldSearch.setSize(200,30);
        fieldSearch.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        shearch.setText("Buscar : ");
        shearch.setLocation(650, 100);
        shearch.setSize(100,40);
        shearch.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        tableList.getScrollTable().setLocation(450, 150);
        tableList.getScrollTable().setSize(500, 500);
       
        
        
        add(shearch);
        add(title);
        add(labelName);
        add(fieldName);
        add(fieldIva);
        add(buttonCreateCategory);
        add(fieldSearch);
        add(tableList.getScrollTable());
        add(buttonDeleteCategory);
        add(buttonUpdateCategory);
        add(buttonCancelCategory);
        

    }
    
    public void setSelectedCombobox(JComboBox select, String txt) {

        for (int i = 0; i < select.getModel().getSize(); i++) {
            if (select.getItemAt(i).toString().equals(txt)) {
                select.setSelectedIndex(i);
                break;
            }
        }

    }

    public CategoryView() {
       
    }
    
    public JTableComponent getTableList() {
        return tableList;
    }
    
    public JButton getButtonDeleteCategory() {
        return buttonDeleteCategory;
    }

    public JButton getButtonUpdateCategory() {
        return buttonUpdateCategory;
    }

    public JButton getButtonCreateCategory() {
        return buttonCreateCategory;
    }

    public JButton getButtonCancelCategory() {
        return buttonCancelCategory;
    }
    

    public JTextField getFieldName() {
        return fieldName;
    }

    public JComboBox getFieldIva() {
        return fieldIva;
    }


}
