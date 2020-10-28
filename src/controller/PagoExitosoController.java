/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DashboardView;
import view.LoginView;
import view.PagoExitosoView;


/**
 *
 * @author quihu
 */
public class PagoExitosoController implements ActionListener {
    
    private PagoExitosoView vista;
    private DashboardController vistaD;
    
    
    public PagoExitosoController(){
        
        vista = new PagoExitosoView();      
        
        vista.getOk().addActionListener(this);
        
    }
       
    @Override
    public void actionPerformed(ActionEvent ae) {
        
         if (ae.getSource() == vista.getOk()) {
             
             vista.dispose();
             DashboardController gui = new DashboardController(null);
             
        }
        
    }
    
}
