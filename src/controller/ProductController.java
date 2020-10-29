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
import model.ProductoModel;
import model.Table.Producto;
import view.ProductoView;
import view.Resource;

/**
 *
 * @author pc-standard
 */
public class ProductController implements ActionListener {

    private ProductoView vista;
    private ProductoModel model;
    private ArrayList<Producto> pro;

    public ProductController() {

        model = new ProductoModel();
        pro = model.getAll();
        vista = new ProductoView(pro);
        vista.getButtonCreateProduct().addActionListener(this);
        vista.getButtonDeleteProduct().addActionListener(this);
        vista.getButtonUpdateProduct().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getButtonCreateProduct())) {
            if (vista.getFieldName().getText().equals("") || vista.getFieldPrecio().getText().equals("")
                    || vista.getFieldStock().getSelectedItem().equals("Seleccionar Stock")
                    || vista.getFieldCategoria().getSelectedItem().equals("Seleccionar Categoria")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                Producto p = new Producto();

                p.setProNombre(vista.getFieldName().getText());
                p.setProPrecio(vista.getFieldPrecio().getText());
                p.setProFechaVencimiento(vista.getFieldFechaVencimiento().getDate());
                p.setTblTipoProducto_TipId(String.valueOf(vista.getFieldCategoria().getSelectedItem().hashCode()));
                p.setProStock(vista.getFieldStock().getSelectedItem().toString());

                p = model.create(p);
                if (p != null) {
                    Object rs[] = {p, p.getProNombre(), p.getProStock(), p.getProPrecio(), Resource.transformFecha(p.getProFechaVencimiento()), p.getTipProNombre()};
                    vista.getTableList().getModel().addRow(rs);
                    vista.getFieldName().setText("");
                    vista.getFieldPrecio().setText("");
                    vista.getFieldFechaVencimiento().setDefaultText();
                    vista.getFieldCategoria().setSelectedIndex(0);
                    vista.getFieldStock().setSelectedIndex(0);
                    pro.add(p);

                    JOptionPane.showMessageDialog(null, "Se ha creado el producto de manera correcta");
                } else {
                    JOptionPane.showMessageDialog(null, " Ha ocurrido un error en la insercion");
                }
            }
        } else if (e.getSource().equals(vista.getButtonDeleteProduct())) {
            if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {
                Producto p = (Producto) vista.getTableList().getObject();

                p.setTblEstado_EstId("2");
                int valDelete = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if (valDelete == JOptionPane.YES_NO_OPTION) {
                    if (model.update(p)) {

                        vista.getTableList().getModel().removeRow(vista.getTableList().getTable().getSelectedRow());
                        JOptionPane.showMessageDialog(null, "Se ha Eliminado el producto correctamente");

                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la Eliminacion", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        }else if(e.getSource().equals(vista.getButtonUpdateProduct())){
             if (vista.getTableList().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {
                 
             }

        }
    }

    public ProductoView getVista() {
        return vista;
    }

}
