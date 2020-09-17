/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginView;

/**
 *
 * @author pc-standard
 */
public class LoginController implements ActionListener{
    
    private LoginView vista;
    private String user = "Julio Ruiz"; // Para Eliminar // Base de datos
    private String password = "123456"; // Para Eliminar // Base de datos
    
    public LoginController(){
        vista = new LoginView();
        vista.getButtonSubmit().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.getButtonSubmit())){
            
            if(vista.getFieldRol().getSelectedItem().equals("Seleccionar rol") 
                || vista.getFieldUser().equals("") || vista.getFieldPass().getPassword().equals("")){
                vista.setLabelError("Todos los campos son obligatorios");
            }else{
                vista.setLabelError("");
            }
        }
    }
    
    public static void main(String args[]){
        LoginController app = new LoginController();
        System.out.println("Quihuang");
    }
}

