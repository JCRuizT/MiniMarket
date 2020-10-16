/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UsuarioModel;
import view.CrearUsuarioView;
import view.DashboardView;
import view.UsuarioView;

/**
 *
 * @author quihu
 */
public class UsuarioController implements ActionListener {

    private UsuarioView vista;
    private DashboardController vistaController;
    private DashboardView vistaD;
    private UsuarioModel model;
    
    public UsuarioController(DashboardView vistaD) {
        
        model = new UsuarioModel();
        vista = new UsuarioView(model.listUsers());
        this.vistaD=vistaD;
      
        vista.getButtonCreateUsuario().addActionListener(this);
        vista.getButtonUpdateUsuario().addActionListener(this);

    }

    public UsuarioView getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getButtonCreateUsuario()) {
            
            vistaD.setVisible(false);
            
            CrearUsuarioController register = new CrearUsuarioController(vistaD);
        }
        
        
         if (e.getSource() == vista.getButtonCancelUsuario()) {
            
            vistaD.setVisible(false);
            
            CrearUsuarioController register = new CrearUsuarioController(vistaD);
        }
         
        if (e.getSource() == vista.getButtonUpdateUsuario()) {
            
            vistaD.setVisible(false);
            
            ActualizarUsuarioController register = new ActualizarUsuarioController(vistaD);
        }

    }
}
