/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.LoginModel;
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
            if (vista.getFieldUser().getText().equals("") || vista.getFieldPass().getText().equals("")) {
                vista.setLabelError("Todos los campos son obligatorios");
            } else {
                vista.setLabelError("");
                ArrayList<String> dataUser = modelo.login(vista.getFieldUser().getText(), vista.getFieldPass().getText());
                if (!dataUser.isEmpty()) {
                    vista.dispose();
                    new DashboardController(dataUser); // llama al perfil o zona de gestion

                } else {
                    vista.setLabelError("Usuario y/o contraseña incorrectos");
                }
            }
        }
    }

    public static void main(String args[]) {
        LoginController app = new LoginController();
    }
}
