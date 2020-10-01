/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
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

    private JTextField fieldName;
    private JComboBox fieldIva;
    private JLabel labelName;
    private JLabel labelIva;
    private JButton buttonCreateCategory;
    private JLabel labelError;
    private JTableComponent tableList; 
    private JButton buttonDeleteCategory;
    private JButton buttonUpdateCategory;
    public CategoryView(ResultSet result) {

    
        buttonCreateCategory = new JButton("Crear Categoria");
        buttonDeleteCategory = new JButton("Eliminar Categoria");
        buttonUpdateCategory = new JButton("Actualizar Categoria");

        labelName = new JLabel("Nombre de la categoria");
        labelIva = new JLabel("Iva");
        fieldName = new JTextField(10);
        
        fieldIva = new JComboBox();
	fieldIva.addItem("Seleccionar iva");
        
        for(int i=0; i<=100; i++){
            fieldIva.addItem(i);
        }
              
        labelError = new JLabel("");
        labelError.setForeground(Color.red);

            
        String columns[] = {"Nombre","Iva"};
        tableList = new JTableComponent(columns);
        
        try {
            while (result.next()) {
                Object rs[] = {result.getString("TipProNombre"),result.getString("TipProIva")}; 
                tableList.getModel().addRow(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        setSize(400, 500);
        setVisible(true);
       
        add(labelName);
        add(fieldName);
        add(labelIva);
        add(fieldIva);
        add(buttonCreateCategory);
        add(labelError);
        add(tableList.getScrollTable());
        add(buttonDeleteCategory);
        add(buttonUpdateCategory);
        

    }

    public CategoryView() {
        
        buttonCreateCategory = new JButton("Crear Categoria");
        buttonDeleteCategory = new JButton("Eliminar Categoria");
        buttonUpdateCategory = new JButton("Actualizar Categoria");

        labelName = new JLabel("Nombre de la categoria");
        labelIva = new JLabel("Iva");
        fieldName = new JTextField(10);
        
        fieldIva = new JComboBox();
	fieldIva.addItem("Seleccionar iva");
        
        for(int i=0; i<=100; i++){
            fieldIva.addItem(i);
        }
              
        labelError = new JLabel("");
        labelError.setForeground(Color.red);

           
        
        
        setVisible(true);
       
        add(labelName);
        add(fieldName);
        add(labelIva);
        add(fieldIva);
        add(buttonCreateCategory);
        add(labelError);
        add(buttonDeleteCategory);
        add(buttonUpdateCategory);
        

       
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

    public JTextField getFieldName() {
        return fieldName;
    }

    public JComboBox getFieldIva() {
        return fieldIva;
    }

    public JLabel getLabelError() {
        return labelError;
    }

}
