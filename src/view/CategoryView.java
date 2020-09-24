/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author pc-standard
 */
public class CategoryView extends JFrame {

    private JTextField fieldName;
    private JComboBox fieldIva;
    private JLabel labelName;
    private JLabel labelIva;
    private Container content;
    private JPanel mainPanel;
    private JButton buttonCreateCategory;
    private JLabel labelError;
    private JTableComponent tableList; 
    private JButton buttonDeleteCategory;
    private JButton buttonUpdateCategory;
    public CategoryView(ResultSet result) {

        content = getContentPane();
        mainPanel = new JPanel();

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
        
        mainPanel.add(labelName);
        mainPanel.add(fieldName);
        mainPanel.add(labelIva);
        mainPanel.add(fieldIva);
        mainPanel.add(buttonCreateCategory);
        mainPanel.add(labelError);
        mainPanel.add(tableList.getScrollTable());
        mainPanel.add(buttonDeleteCategory);
        mainPanel.add(buttonUpdateCategory);
        content.add(mainPanel);
        setLocationRelativeTo(null);
        setTitle("Mini Market - Categoria de Producto");
        setVisible(true);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
