/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.HacerPedidoModel;
import view.DashboardView;
import view.HacerPedidoView;
import view.TipoPagoView;

/**
 *
 * @author quihu
 */
public class HacerPedidoController implements ActionListener {
    
    
    private HacerPedidoView vistaH;
    private TipoPagoView pagoVista;
    private HacerPedidoModel modelo;
    private DashboardView vistaD;
    
    
    public HacerPedidoController(DashboardView vistaD){
        
        vistaH = new HacerPedidoView();
        modelo = new HacerPedidoModel();
        this.vistaD=vistaD;
        
        
        vistaH.getButtonBuy().addActionListener(this);
        
    }
    
    public HacerPedidoView getVista(){
        return vistaH;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource() == vistaH.getButtonBuy()){
           
           
            TipoPagoView vista = new TipoPagoView();
           
       }
            
    }
    
}
