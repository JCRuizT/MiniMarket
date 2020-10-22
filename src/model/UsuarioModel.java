/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Table.Usuario;

/**
 *
 * @author quihu
 */
public class UsuarioModel {
    
    private Conexion conexion;
    private String table;
    
    public UsuarioModel(){
        table = "TblUsuario";
        this.conexion = new Conexion();
    }
    
      public ArrayList<Usuario> getAll() {
        ArrayList<Usuario> data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("select * from " + table + " as u, TblEstado as e,TblTipoIdentificacion as ti,TblRol as r where e.EstId = u.TblEstado_EstId and u.TblTipoIdentificacion_TipId = ti.TipId and r.RolId = u.TblRol_RolId");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                Usuario u = new Usuario();
                u.setUsuIdentificacion(result.getString("UsuIdentificacion"));               
                u.setUsuNombre1(result.getString("UsuNombre1"));
                u.setUsuNombre2(result.getString("UsuNombre2"));
                u.setUsuApellido1(result.getString("UsuApellido1"));
                u.setUsuApellido2(result.getString("UsuApellido2"));
                u.setUsuCelular(result.getString("UsuCelular"));
                u.setUsuCorreo(result.getString("UsuCorreo"));               
                u.setTblTipoIdentificacion_TipId(result.getString("TblTipoIdentificacion_TipId"));
                u.setTblEstado_EstId(result.getString("TblEstado_EstId"));
                u.setTblRol_RolId("TblRol_RolId");
                u.setTipNombre(result.getString("TipNombre"));
                u.setRolNombre(result.getString("RolNombre"));
                u.setEstEstado(result.getString("EstEstado"));              
               
                data.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }
    
}
