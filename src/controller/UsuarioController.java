/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.UsuarioView;

/**
 *
 * @author quihu
 */
public class UsuarioController {
    
    private UsuarioView vista;
    
    public UsuarioController(){
        
         vista = new UsuarioView();
        
    }

    public UsuarioView getVista() {
        return vista;
    }
  
}
