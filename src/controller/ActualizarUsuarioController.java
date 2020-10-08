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
import view.LoginView;

/**
 *
 * @author quihu
 */
public class ActualizarUsuarioController implements MouseListener{
    
    private ActualizarUsuarioView vista;
    private DashboardView vistaD;
    
    public ActualizarUsuarioController(DashboardView vistaD){
        
      vista = new ActualizarUsuarioView();
      
      this.vistaD = vistaD;
        
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