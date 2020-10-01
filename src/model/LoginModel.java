/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pc-standard
 */
public class LoginModel {

    private Connection conexion;

    public LoginModel() {
        conexion = new Conexion().getConexion();
    }

    public boolean login(String user, String pass, String rol) {

        String userL = "";
        String passL = "";
        String tabla = "";
        String prefijo = "";
        
        if (rol.equals("Vendedor")) {
            tabla = "TblVendedor";
            prefijo = "Ven";

        } else if (rol.equals("Cliente")) {
            tabla = "TblCliente";
            prefijo = "Cli";
        } else if (rol.equals("Administrador")) {
            tabla = "TblAdministrador";
            prefijo = "Adm";
        }

        try {
            String query = "select * from " + tabla + " where " + prefijo + "Identificacion = '" + user + "' and " + prefijo + "Contrasenia='" + pass + "' and TblEstado_EstId = 1";
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery(query);
            if (registro.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

}
