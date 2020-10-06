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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import model.CategoryModel;

/**
 *
 * @author pc-standard
 */
public class ProductView extends JPanel {

    
    JTextField fieldPrecio = new JTextField();
    JTextField fieldName = new JTextField();
    JTextField fieldFechaVencimiento = new JTextField();
  
    JComboBox fieldStock = new JComboBox();
    JComboBox fieldCategoria = new JComboBox();

    JLabel labelName = new JLabel();
    JLabel title = new JLabel();
    JLabel labelPrecio = new JLabel();
    JLabel labelFechaVencimiento = new JLabel();

    JButton buttonCreateProduct = new JButton();
    JButton buttonDeleteProduct = new JButton();
    JButton buttonUpdateProduct = new JButton();
    JTableComponent tableList; 
   
    private final int x = 1500 ;
    private final int y = 1500;
    

    public ProductView(ResultSet result) {
        
        setSize(x, y);
        setLayout(null);
        
        title.setText("                 Gestionar producto");
        title.setLocation(0, 0);
        title.setSize(850,40);
        title.setForeground(Color.orange);
        title.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 35));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        labelName.setText("  Nombre del Producto");
        labelName.setLocation(0, 100);
        labelName.setSize(250,30);
        labelName.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        fieldName.setLocation(0, 150);
        fieldName.setSize(230,30);
        fieldName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        labelPrecio.setText("    Precio del producto");
        labelPrecio.setLocation(0, 200);
        labelPrecio.setSize(250,30);
        labelPrecio.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        fieldPrecio.setLocation(0, 250);
        fieldPrecio.setSize(230,30);
        fieldPrecio.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        labelFechaVencimiento.setText("  Fecha de Vencimiento");
        labelFechaVencimiento.setLocation(0, 300);
        labelFechaVencimiento.setSize(250,30);
        labelFechaVencimiento.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        fieldFechaVencimiento.setLocation(0, 350);
        fieldFechaVencimiento.setSize(230,30);
        fieldFechaVencimiento.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 18));
        
        fieldCategoria.setLocation(0, 400);
        fieldCategoria.setSize(230,30);
        fieldCategoria.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 18));
	fieldCategoria.addItem("Seleccionar Categoria");
        ResultSet categoria = new CategoryModel().listCategory();
        
        fieldStock.setLocation(0, 450);
        fieldStock.setSize(230,30);
        fieldStock.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 18));
        fieldStock.addItem("Seleccionar Stock");

        for (int i = 0; i <= 50; i++) {
            fieldStock.addItem(i);
        }
        
        buttonCreateProduct = new JButton("Crear Producto");
        buttonCreateProduct.setLocation(0, 550);
        buttonCreateProduct.setSize(230,30);
        buttonCreateProduct.setBackground(Color.orange);
        buttonCreateProduct.setForeground(Color.white);
        buttonCreateProduct.setFocusable(false);
        buttonCreateProduct.setBorder(null);
        buttonCreateProduct.setFont(new Font("Arial", Font.BOLD, 15));

        try {
            while (categoria.next()) {
                fieldCategoria.addItem(categoria.getString("TipProNombre"));   
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
        String columns[] = {"id","Nombre","Stock","Precio","Fecha de Vencimiento","Categoria"};
        tableList = new JTableComponent(columns);
        
        try {
            while (result.next()) {
                Object rs[] = {result.getString("ProRef"),result.getString("ProNombre"),result.getString("ProStock"),
                    result.getString("ProPrecio"),
                    transformFecha(result.getString("ProFechaVencimiento")),
                    result.getString("TipProNombre")}; 
                tableList.getModel().addRow(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        tableList.getScrollTable().setLocation(300, 100);
        tableList.getScrollTable().setSize(500, 500);
        
          
        tableList.getTable().getColumnModel().getColumn(0).setMaxWidth(0);
        tableList.getTable().getColumnModel().getColumn(0).setMinWidth(0);
        tableList.getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
        tableList.getTable().getTableHeader().setResizingAllowed(false);
        
        
        
                
        buttonDeleteProduct = new JButton("Eliminar Producto");
        buttonDeleteProduct.setLocation(310, 650);
        buttonDeleteProduct.setSize(230,30);
        buttonDeleteProduct.setBackground(Color.orange);
        buttonDeleteProduct.setForeground(Color.white);
        buttonDeleteProduct.setFocusable(false);
        buttonDeleteProduct.setBorder(null);
        buttonDeleteProduct.setFont(new Font("Arial", Font.BOLD, 15));
        
        buttonUpdateProduct = new JButton("Actualizar Producto");
        buttonUpdateProduct.setLocation(560, 650);
        buttonUpdateProduct.setSize(230,30);
        buttonUpdateProduct.setBackground(Color.orange);
        buttonUpdateProduct.setForeground(Color.white);
        buttonUpdateProduct.setFocusable(false);
        buttonUpdateProduct.setBorder(null);
        buttonUpdateProduct.setFont(new Font("Arial", Font.BOLD, 15));
       
        add(title);
        
        add(buttonDeleteProduct);
        add(buttonUpdateProduct);
        
        add(labelName);
        add(fieldName);
        
        add(fieldCategoria);
        add(labelPrecio);
        add(fieldPrecio);
        
        add(fieldStock);

        add(labelFechaVencimiento);
        add(fieldFechaVencimiento);

        add(buttonCreateProduct);
        add(tableList.getScrollTable());
       
       
        setVisible(true);
      
    }
    
     public String transformFecha(String fecha){
        
        String mes[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre"
                ,"Diciembre"};
        String arr[] = fecha.split("-");
        int mesSelected = Integer.parseInt(arr[1])-1;
        String response  = arr[2]+" de "+mes[mesSelected]+" del "+arr[0];
        return response;
        
        
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
