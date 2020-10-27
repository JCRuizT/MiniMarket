/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DashboardView;
import view.PagoTarjetaView;

/**
 *
 * @author quihu
 */
public class PagoTarjetaController implements ActionListener{
    
    private PagoTarjetaView vista;
    private TipoPagoController vistaT;
    private DashboardView vistaD;
    
    public PagoTarjetaController(DashboardView vistaD){
        
        vista = new PagoTarjetaView();
        
        this.vistaD=vistaD;
        
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
           vistaT = new TipoPagoController(vistaD);
           vistaT.getVista();
           
           
          
       }
    }
    
}
