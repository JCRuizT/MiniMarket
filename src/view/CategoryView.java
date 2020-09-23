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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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

    public CategoryView(ResultSet result) {

        content = getContentPane();
        mainPanel = new JPanel();

        buttonCreateCategory = new JButton("Crear Categoria");
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

        Object column[] = {"Nombre","Apellido","Cedula"};
        Object a[][] = {{"sss","sss","ssss"}};
        
        DefaultTableModel dtm= new DefaultTableModel(a, column); 
        JTable tabla = new JTable(dtm);
        /*mainPanel.add(labelName);
        mainPanel.add(fieldName);
        mainPanel.add(labelIva);
        mainPanel.add(fieldIva);
        mainPanel.add(buttonCreateCategory);
        mainPanel.add(labelError);*/
        mainPanel.add(tabla);
        content.add(mainPanel);
        
        



        try {
            while (result.next()) {
                System.out.println(result.getString("TipProNombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        setLocationRelativeTo(null);
        setTitle("Mini Market - Categoria de Producto");
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
