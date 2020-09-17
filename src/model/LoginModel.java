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

    public void userExist(String rol) {

        String tabla = "";
        String prefijo = "";
        if(rol.equals("Vendedor")){
            tabla = "TblVendedor";
            prefijo = "Ven";
        }else if(rol.equals("Cliente")){
            tabla = "TblCliente";
            prefijo = "Clie";
        }else if(rol.equals("Administrador")){
            tabla = "TblAdministrador";
            prefijo = "Adm";
        }
        
        System.out.println(tabla);
        
        try {
            
            
            String query = "select * from "+tabla;
            System.out.println(tabla);
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery(query);
            
            
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
