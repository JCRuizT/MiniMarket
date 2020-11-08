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
import model.Table.EstadisticaPedido;
import model.Table.Usuario;

/**
 *
 * @author pc-standard
 */
public class EstadisticaModel {

    private final Conexion conexion;

    public EstadisticaModel() {

        this.conexion = new Conexion();

    }

    public ArrayList<EstadisticaPedido> getAllPedidos() {
        ArrayList<EstadisticaPedido> data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("select u.UsuIdentificacion,p.PedId,p.PedFecha,u.UsuNombre1,UsuApellido2 from TblPedido as p,TblUsuario as u where p.TblUsuario_UsuIdentificacion = u.UsuIdentificacion");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                EstadisticaPedido ep = new EstadisticaPedido();
                ep.setUsuIdentificacion(result.getString("UsuIdentificacion"));
                ep.setUsuNombre1(result.getString("UsuNombre1"));
                ep.setUsuApellido2(result.getString("UsuApellido2"));
                ep.setPedFecha(result.getString("PedFecha"));
                ep.setPedId(result.getString("PedId"));

                data.add(ep);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }
    
    
    public ArrayList<EstadisticaPedido> getAllPedidos(Usuario u) {
        ArrayList<EstadisticaPedido> data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("select u.UsuIdentificacion,p.PedId,p.PedFecha,u.UsuNombre1,UsuApellido2 from TblPedido as p,TblUsuario as u where p.TblUsuario_UsuIdentificacion = u.UsuIdentificacion and p.TblUsuario_UsuIdentificacion = ?");
            sentence.setString(1, u.getUsuIdentificacion());
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                EstadisticaPedido ep = new EstadisticaPedido();
                ep.setUsuIdentificacion(result.getString("UsuIdentificacion"));
                ep.setUsuNombre1(result.getString("UsuNombre1"));
                ep.setUsuApellido2(result.getString("UsuApellido2"));
                ep.setPedFecha(result.getString("PedFecha"));
                ep.setPedId(result.getString("PedId"));
                data.add(ep);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }
    
  
    
   
    
    
    
    public static void main(String[] args) {
        EstadisticaModel a = new EstadisticaModel();
        Usuario n = new Usuario();
        n.setUsuIdentificacion("1005934460");
        for(int i = 0; i<a.getAllPedidos(n).size();i++){
            System.out.println(a.getAllPedidos(n).get(i).getPedId());
        }
    }

}
