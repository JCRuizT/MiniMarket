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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public ResultSet login(String user, String pass) {

        String query = "select UsuIdentificacion, UsuContrasenia, UsuNombre1,UsuNombre2 ,UsuApellido1, UsuApellido2, UsuCorreo from " + tabla + " where UsuIdentificacion = '" + user + "' and " + "UsuContrasenia='" + pass + "' and TblEstado_EstId = 1";

        ResultSet app = Crud.select(query, conexion);
        try {
            while (app.next()) {
                System.out.println(app.getString("UsuIdentificacion")+app.getString("UsuNombre1"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;

    }

}
