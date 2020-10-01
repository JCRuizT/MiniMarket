/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ProductModel;
import view.ProductView;

/**
 *
 * @author pc-standard
 */
public class ProductController implements ActionListener{
    
    private ProductView vista;
    private ProductModel model;
  
    public ProductController(){
        
        
        model = new ProductModel();
        vista = new ProductView(model.listProduct());
        vista.getButtonCreateProduct().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.getButtonCreateProduct())){
            if(vista.getFieldName().getText().equals("") || vista.getFieldPrecio().getText().equals("") 
                    || vista.getFieldStock().getSelectedItem().equals("Seleccionar Stock") || 
                    vista.getFieldCategoria().getSelectedItem().equals("Seleccionar Categoria")){
                vista.setLabelError("Todos los campos son obligatorios");
            }else{
                vista.setLabelError("");
                String field[] = new String[7];
                field[1] = vista.getFieldName().getText();
                field[2] = vista.getFieldPrecio().getText();
                field[3] = vista.getFieldStock().getSelectedItem().toString();
                field[4] = vista.getFieldFechaVencimiento().getText();
                field[5] = vista.getFieldCategoria().getSelectedItem().toString();
                field[6] = "1";
                boolean val = model.createProduct(field);
                if (val) {
                    System.out.println("Se ha creado correctamente");
                }else{
                    System.out.println("pailas");
                }
            }
        }
    }

    public ProductView getVista() {
        return vista;
    }
    
    
}
