/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author quihu
 */
public class UsuarioModel {
    
    private Connection conexion;
    private String table;
    
    public UsuarioModel(){
        table = "TblUsuario";
        conexion = new Conexion().getConexion();
    }
    
    public ResultSet listUsers(){
 
      
        return Crud.select("select EstEstado as UsuEstado,RolNombre as UsuRol,TipNombre as UsuTip,UsuIdentificacion, UsuNombre1,UsuNombre2,UsuApellido1,UsuApellido2,UsuCelular,UsuCorreo"
                + " from TblUsuario,TblEstado,TblRol,TblTipoIdentificacion where TblRol_RolId = RolId and TblTipoIdentificacion_TipId = TipId and EstId = TblEstado_EstId", conexion);
    }
    
}
