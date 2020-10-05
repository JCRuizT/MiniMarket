/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LoginModel;
import view.DashboardView;
import view.LoginView;

/**
 *
 * @author pc-standard
 */
public class LoginController implements ActionListener {

    private LoginView vista;
    private LoginModel modelo;

    public LoginController() {
        vista = new LoginView();
        modelo = new LoginModel();
        vista.getButtonSubmit().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getButtonSubmit())) {
            if (vista.getFieldRol().getSelectedItem().equals("Seleccionar rol")
                    || vista.getFieldUser().equals("") || vista.getFieldPass().getPassword().equals("")) {
                vista.setLabelError("Todos los campos son obligatorios");
            } else {
                vista.setLabelError("");
                boolean login = modelo.login(vista.getFieldUser().getText(), vista.getFieldPass().getText(), vista.getFieldRol().getSelectedItem().toString());
                if (login) {
                    vista.dispose();
                    new DashboardController(); // llama al perfil o zona de gestion

                } else {
                    vista.setLabelError("El usuario ingresado no existe");
                }
            }
        }
    }

    public static void main(String args[]) {
        LoginController app = new LoginController();
    }
}
