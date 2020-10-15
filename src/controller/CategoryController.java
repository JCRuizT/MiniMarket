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
    private boolean stateButtonUpdate;

    public CategoryController() {

        model = new CategoryModel();
        vista = new CategoryView(model.listCategory());
        vista.getButtonCreateCategory().addActionListener(this);
        vista.getButtonDeleteCategory().addActionListener(this);
        vista.getButtonUpdateCategory().addActionListener(this);
        vista.getButtonCancelCategory().addActionListener(this);
        stateButtonUpdate = false;

    }

    public CategoryView getVista() {
        return vista;
    }

  

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getButtonCreateCategory())) {

            if (vista.getFieldName().getText().equals("") || vista.getFieldIva().getSelectedItem().equals("     Seleccionar IVA")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
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
                    Object x[] = {field[0],field[1],field[2]};
                    vista.getTableList().getModel().addRow(x);
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
                }else{
                    vista.getTableList().getTable().clearSelection();
                }
            }
        }else if(e.getSource().equals(vista.getButtonUpdateCategory())){
            if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {

                if (stateButtonUpdate == false) {
                    vista.getButtonCreateCategory().setEnabled(false);
                    vista.getButtonDeleteCategory().setEnabled(false);
                    vista.getButtonCancelCategory().setVisible(true);
                    vista.getButtonCancelCategory().setEnabled(true);
                    vista.getTableList().getTable().setEnabled(false);
                    stateButtonUpdate = true;

                    String id = (String) vista.getTableList().getModel().getValueAt(vista.getTableList().getTable().getSelectedRow(), 0);
                    String name = (String) vista.getTableList().getModel().getValueAt(vista.getTableList().getTable().getSelectedRow(), 1);
                    String iva = (String) vista.getTableList().getModel().getValueAt(vista.getTableList().getTable().getSelectedRow(), 2);
                    vista.getFieldName().setText(name);

                    System.out.println(iva);
                    vista.setSelectedCombobox(vista.getFieldIva(), iva);

                } else {
                    System.out.println("lkdldkldkldkldklddkldkl");
                }

            }

        }else if(e.getSource().equals(vista.getButtonCancelCategory())){
            vista.getButtonCancelCategory().setVisible(false);
            vista.getButtonCancelCategory().setEnabled(false);
            vista.getButtonCreateCategory().setEnabled(true);
            vista.getButtonDeleteCategory().setEnabled(true);
            vista.getTableList().getTable().setEnabled(true);
            vista.getTableList().getTable().clearSelection();
            stateButtonUpdate = false;
            vista.setSelectedCombobox(vista.getFieldIva(), "     Seleccionar IVA");
            vista.getFieldName().setText("");
        }
    }


}
