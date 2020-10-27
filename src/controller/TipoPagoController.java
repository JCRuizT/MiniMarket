/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.DashboardView;
import view.LoginView;
import view.TipoPagoView;

/**
 *
 * @author quihu
 */

public class TipoPagoController implements MouseListener {
    
    private TipoPagoView vista;
    private DashboardView vistaD;

    public TipoPagoController(DashboardView vistaD) {
        
         vista = new TipoPagoView();
         this.vistaD=vistaD;
         
         vista.getMinimize().addMouseListener(this);
         vista.getClose().addMouseListener(this);
         vista.getTextCancelar().addMouseListener(this);
         vista.getPicCancel().addMouseListener(this);
         vista.getTextTarjeta().addMouseListener(this);
         vista.getPicTarjeta().addMouseListener(this);

         
    }

    public TipoPagoView getVista(){
        return vista;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == vista.getMinimize()) {
            vista.setState(LoginView.ICONIFIED);
            System.out.println("prueba");
        }
        if (me.getSource() == vista.getClose()) {
            vista.dispose();
            vistaD.setVisible(true);
        }
         if (me.getSource() == vista.getTextCancelar()) {
            vista.dispose();
            vistaD.setVisible(true);
        }
          if (me.getSource() == vista.getPicCancel()) {
            vista.dispose();
            vistaD.setVisible(true);
        }
           if (me.getSource() == vista.getPicTarjeta()) {
            
               vista.setVisible(false);
               PagoTarjetaController payTarjet = new PagoTarjetaController(vistaD);
            
        }
            if (me.getSource() == vista.getTextTarjeta()) {
                vista.setVisible(false);
                PagoTarjetaController payTarjet = new PagoTarjetaController(vistaD);
               
            
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
    
    public static void main(String[] args) {
    }

}
