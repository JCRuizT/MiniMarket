/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc-standard
 */
public class LoginModel {

    private Conexion conexion;
    private String tabla;

    public LoginModel() {

        tabla = "TblUsuario";
        conexion = new Conexion();

    }

    public ArrayList<String> login(String user, String pass) {

        ResultSet registro = null;
        try {
            //String query = "select UsuIdentificacion, UsuNombre1,UsuNombre2 ,UsuApellido1, UsuApellido2, UsuCorreo from " + tabla + " where UsuIdentificacion = '" + user + "' and " + "UsuContrasenia='" + pass + "' and TblEstado_EstId = 1";
            PreparedStatement sentence = conexion.sentence("select UsuIdentificacion, UsuNombre1,UsuNombre2 ,UsuApellido1, UsuApellido2, UsuCorreo from " + tabla + " where UsuIdentificacion = ? and UsuContrasenia = ? and TblEstado_EstId = 1");
            sentence.setString(1, user);
            sentence.setString(2, pass);
            registro = sentence.executeQuery();
            ArrayList<String> response = new ArrayList<String>();
            while (registro.next()) {
                response.add(registro.getString("UsuIdentificacion"));
                response.add(registro.getString("UsuNombre1"));
                response.add(registro.getString("UsuApellido1"));
                response.add(registro.getString("UsuApellido2"));
                response.add(registro.getString("UsuCorreo"));

            }

            return response;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

}
