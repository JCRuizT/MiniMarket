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
    private String tabla;

    public LoginModel() {

        tabla = "TblUsuario";
        conexion = new Conexion().getConexion();

    }

    public boolean login(String user, String pass) {

        try {
            String query = "select UsuIdentificacion,UsuContrasenia from " + tabla + " where UsuIdentificacion = '" + user + "' and " + "UsuContrasenia='" + pass + "' and TblEstado_EstId = 1";
            System.out.println(query);
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
