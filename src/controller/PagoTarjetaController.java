/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.PagoTarjetaView;

/**
 *
 * @author quihu
 */
public class PagoTarjetaController implements ActionListener{
    
    private PagoTarjetaView vista;
   
    
    public PagoTarjetaController(){
        
        vista = new PagoTarjetaView();
        
        vista.getCancelar().addActionListener(this);
        vista.getPagar().addActionListener(this);
        
    }
    
    public PagoTarjetaView getVista(){
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent me) {
       if (me.getSource() == vista.getCancelar()){
           vista.setVisible(false);
          
       }
    }
    
}
