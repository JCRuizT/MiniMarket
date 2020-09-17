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
        vista = new CategoryView(model.listCategory("TblTipoProducto"));
        vista.getButtonCreateCategory().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getButtonCreateCategory())) {

            if (vista.getFieldName().getText().equals("") || vista.getFieldIva().getText().equals("")) {
                vista.getLabelError().setText("Todos los campos son obligatorios");
            } else {
                String field[] = new String[4];
                field[0] = null;
                field[1] = vista.getFieldName().getText();
                field[2] = vista.getFieldIva().getText();
                field[3] = "1";
                boolean val = model.createCategory(field);
                if (val) {
                    vista.getFieldName().setText("");
                    vista.getFieldIva().setText("");
                    JOptionPane.showMessageDialog(null, "Se ha creado la categoria de manera correcta");
                    vista.getLabelError().setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error en la insercion");
                }
            }
        }
    }

    public static void main(String[] args) {
        CategoryController app = new CategoryController();
    }

}
