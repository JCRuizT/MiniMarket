/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.CategoryModel;


/**
 *
 * @author pc-standard
 */
public class ProductView extends JPanel {

    private JComboBox fieldStock;
    private JTextField fieldPrecio;
    private JTextField fieldName;
    private JTextField fieldFechaVencimiento;
    private JComboBox fieldCategoria;

    private JLabel labelName;
    private JLabel labelStock;
    private JLabel labelPrecio;
   private JLabel labelCategoria;
    private JLabel labelFechaVencimiento;

    private JButton buttonCreateProduct;
    private JTableComponent tableList; 
    JLabel labelError;

    public ProductView(ResultSet result) {

        
      
        setBorder(new EmptyBorder(15, 15, 15, 15));

        buttonCreateProduct = new JButton("Crear Producto");
        labelName = new JLabel("Nombre del Producto");
        fieldName = new JTextField(10);
        labelCategoria = new JLabel("Categoria");

        labelPrecio = new JLabel("Precio");
        fieldPrecio = new JTextField(10);
        labelStock = new JLabel("Stock");
        fieldStock = new JComboBox();
        fieldStock.addItem("Seleccionar Stock");

        for (int i = 0; i <= 50; i++) {
            fieldStock.addItem(i);
        }

        labelError = new JLabel();

        labelFechaVencimiento = new JLabel("Fecha de Vencimiento");
        fieldFechaVencimiento = new JTextField(10);
        

        fieldCategoria = new JComboBox();
        ResultSet categoria = new CategoryModel().listCategory();
        fieldCategoria.addItem("Seleccionar Categoria");

        try {
            while (categoria.next()) {
                fieldCategoria.addItem(categoria.getString("TipProNombre"));   
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
        String columns[] = {"Nombre","Stock","Precio","Categoria","Fecha de Vencimiento"};
        tableList = new JTableComponent(columns);
        
        try {
            while (result.next()) {
                Object rs[] = {result.getString("ProNombre"),result.getString("ProStock"),
                    result.getString("ProPrecio"),
                    result.getString("TipProNombre"),
                    result.getString("ProFechaVencimiento")}; 
                tableList.getModel().addRow(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        fieldCategoria.addItem("Categoria-1");
        fieldCategoria.addItem("Categoria-1");
        fieldCategoria.addItem("Categoria-3");

        add(labelName);
        add(fieldName);
        
        add(labelCategoria);
        add(fieldCategoria);
        add(labelPrecio);
        add(fieldPrecio);

        add(labelStock);
        add(fieldStock);

        add(labelFechaVencimiento);
        add(fieldFechaVencimiento);

        add(labelError);
        add(buttonCreateProduct);
        add(tableList.getScrollTable());
       
       
        setVisible(true);
        setSize(800, 800);
    }

    public void setLabelError(String text) {
        this.labelError.setText(text);
    }

    public JComboBox getFieldStock() {
        return fieldStock;
    }

    public JTextField getFieldPrecio() {
        return fieldPrecio;
    }

    public JTextField getFieldName() {
        return fieldName;
    }

    public JTextField getFieldFechaVencimiento() {
        return fieldFechaVencimiento;
    }

    public JComboBox getFieldCategoria() {
        return fieldCategoria;
    }

    public JButton getButtonCreateProduct() {
        return buttonCreateProduct;
    }

}
