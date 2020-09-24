/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.CategoryModel;
import view.CategoryView;

/**
 *
 * @author pc-standard
 */
public class CategoryController implements ActionListener {

    private CategoryView vista;
    private CategoryModel model;

    public CategoryController() {

        model = new CategoryModel();
        vista = new CategoryView(model.listCategory());
        vista.getButtonCreateCategory().addActionListener(this);
        vista.getButtonDeleteCategory().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getButtonCreateCategory())) {

            if (vista.getFieldName().getText().equals("") || vista.getFieldIva().getSelectedItem().equals("Seleccionar iva")) {
                vista.getLabelError().setText("Todos los campos son obligatorios");
            } else {
                String field[] = new String[4];
                field[1] = vista.getFieldName().getText();
                field[2] = vista.getFieldIva().getSelectedItem().toString();
                field[3] = "1";
                boolean val = model.createCategory(field);
                if (val) {
                    vista.getFieldName().setText("");
                    vista.getFieldIva().setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Se ha creado la categoria de manera correcta");
                    Object x[] = {field[1],field[2]};
                    vista.getTableList().getModel().addRow(x);
                    vista.getLabelError().setText("");
                } else {
                    JOptionPane.showMessageDialog(null, " Ha ocurrido un error en la insercion");
                }
            }
        }else if(e.getSource().equals(vista.getButtonDeleteCategory())){
            if(vista.getTableList().getTable().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            }else{
                
                int confim = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere eliminar este registro?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if(confim == JOptionPane.YES_OPTION){
                    String id = (String) vista.getTableList().getModel().getValueAt(vista.getTableList().getTable().getSelectedRow(), 0);
                    System.out.println(id);
                    if(model.deleteCategory(id)){
                        vista.getTableList().getModel().removeRow(vista.getTableList().getTable().getSelectedRow());
                    }
                }
            }
        }else if(e.getSource().equals(vista.getButtonUpdateCategory())){
            if(vista.getTableList().getTable().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            }else{
                
            }

        }
    }

    public static void main(String[] args) {
        CategoryController app = new CategoryController();
    }

}
