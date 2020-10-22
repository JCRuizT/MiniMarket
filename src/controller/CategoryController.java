/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Table.TipoProducto;
import model.TipoProductoModel;

/**
 *
 * @author pc-standard
 */
public class CategoryController implements ActionListener {

    private view.CategoryView vista;
    private TipoProductoModel model;
    private boolean stateButtonUpdate;
    private ArrayList<TipoProducto> categ;

    public CategoryController() {

        model = new TipoProductoModel();
        categ = model.getAll();
        vista = new view.CategoryView(categ);
        vista.getButtonCreateCategory().addActionListener(this);
        vista.getButtonDeleteCategory().addActionListener(this);
        vista.getButtonUpdateCategory().addActionListener(this);
        vista.getButtonCancelCategory().addActionListener(this);
        stateButtonUpdate = false;

    }

    public view.CategoryView getVista() {
        return vista;
    }

  

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getButtonCreateCategory())) {

            if (vista.getFieldName().getText().equals("") || vista.getFieldIva().getSelectedItem().equals("     Seleccionar IVA")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                
                TipoProducto p = new TipoProducto();
                
                p.setTipProIva(vista.getFieldIva().getSelectedItem().toString());
                p.setTipProNombre(vista.getFieldName().getText());
                
                p = model.create(p);
                if (p != null) {
                    vista.getFieldName().setText("");
                    vista.getFieldIva().setSelectedIndex(0);
                    categ.add(p);
                    vista.getTableList().getModel().fireTableDataChanged();
                    System.out.println(p.getTipProId());
                    JOptionPane.showMessageDialog(null, "Se ha creado la categoria de manera correcta");
                } else {
                    JOptionPane.showMessageDialog(null, " Ha ocurrido un error en la insercion");
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
