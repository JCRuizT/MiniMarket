/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.HistorialPedidoView;


/**
 *
 * @author quihu
 */
public class HistorialPedidoController {
    
    
    private HistorialPedidoView vista;
    
    public HistorialPedidoController(){
        
        vista = new HistorialPedidoView();
        
    }
    
    public HistorialPedidoView getVista(){
        return vista;
    }
    
}
