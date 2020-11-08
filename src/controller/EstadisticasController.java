/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.EstadisticasView;

/**
 *
 * @author quihu
 */
public class EstadisticasController {
    
    private EstadisticasView vista;
    
    
    public EstadisticasController(){
       vista = new EstadisticasView();

        
    }
    
    public EstadisticasView getVista(){
        return vista;
    }
    
    
}
