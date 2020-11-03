/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.ActualizarUsuarioView;
import view.DashboardView;
import view.JTableComponent;
import view.LoginView;

/**
 *
 * @author quihu
 */
public class ActualizarUsuarioController implements MouseListener{
    
    private ActualizarUsuarioView vista;
    private DashboardView vistaD;
    
    public ActualizarUsuarioController(DashboardView vistaD,JTableComponent Tabla){
        
      vista = new ActualizarUsuarioView();
      
      this.vistaD = vistaD;
      int row = Tabla.getTable().getSelectedRow();
        System.out.println(Tabla.getModel().getValueAt(row, 9));
        
        vista.setFieldnumIdentificacion((String) Tabla.getModel().getValueAt(row, 2));
        vista.setFieldName((String) Tabla.getModel().getValueAt(row, 3));
        vista.setFieldSecondName((String) Tabla.getModel().getValueAt(row, 4));
        vista.setFieldLastName((String) Tabla.getModel().getValueAt(row, 5));
        vista.setFieldSecondLastName((String) Tabla.getModel().getValueAt(row, 6));
        vista.setFieldCel((String) Tabla.getModel().getValueAt(row, 7));
        vista.setFieldEmail((String) Tabla.getModel().getValueAt(row, 8));
        //vista.setSelectedCombobox(vista.getFieldIva(), iva);

        //vista.setTipoRol((JComboBox) Tabla.getModel().getValueAt(row, 9));
        
      vista.getClose().addMouseListener(this);
      vista.getMinimize().addMouseListener(this);
      vista.getCancelar().addMouseListener(this);
      
    }
    
     @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == vista.getMinimize()) {
            vista.setState(LoginView.ICONIFIED);
        }
        if (me.getSource() == vista.getClose()) {
            vista.dispose();
             vistaD.setVisible(true);
        }
        if (me.getSource() == vista.getCancelar()) {
            vista.dispose();
             vistaD.setVisible(true);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}
