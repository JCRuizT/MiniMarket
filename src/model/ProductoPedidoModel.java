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
import model.Table.Producto;
import model.Table.ProductoPedido;

/**
 *
 * @author pc-standard
 */
public class ProductoPedidoModel {

    private final Conexion conexion;
    private final String table;

    public ProductoPedidoModel() {
        table = "TblProductoPedido";
        this.conexion = new Conexion();
    }

    public ArrayList<Producto> getAll() {
        ArrayList<Producto> data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("select * from " + table + ", TblEstado where EstId = TblEstado_EstId");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                Producto p = new Producto();
                p.setProRef(result.getString("ProRef"));
                p.setProNombre(result.getString("ProNombre"));
                p.setProPrecio(result.getString("ProPrecio"));
                p.setProStock(result.getString("ProStock"));
                p.setProFechaVencimiento(result.getString("ProFechaVencimiento"));
                p.setTblEstado_EstId(result.getString("EstEstado"));
                data.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }
    /*
    public Producto create(ProductoPedido p) {
        
        Producto n = null;
        try {
         
            PreparedStatement sentence = conexion.sentence("insert into " + table + " values(?,?,?)");
            sentence.setString(1,null);
            sentence.setString(2,p.getProNombre());
            sentence.setString(3, p.getProPrecio());
            sentence.setString(4, p.getProStock());
            sentence.setString(5, p.getProFechaVencimiento());
            sentence.setString(6, p.getTblTipoProducto_TipId());
            sentence.setString(7, "1");
            
            sentence.execute();
            PreparedStatement s = conexion.sentence("select * from "+table+" order by ProRef desc limit 1");
            ResultSet r =  s.executeQuery();
            if(r.next()){
                n = new Producto();
                n.setProRef(r.getString("ProRef"));
                n.setProNombre(r.getString("ProNombre"));
                n.setProPrecio("ProPrecio");
                n.setProStock("ProStock");
                n.setTblEstado_EstId("TblEstado_EstId");
                n.setTblTipoProducto_TipId("TblTipoProducto_TipId");
                n.setProFechaVencimiento("ProFechaVencimiento");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
    
      public Producto delete(Producto p) {
        
        Producto n = null;
        try {
         
            PreparedStatement sentence = conexion.sentence("insert into " + table + " values(?,?,?,?,?,?,?)");
            sentence.setString(1,null);
            sentence.setString(2,p.getProNombre());
            sentence.setString(3, p.getProPrecio());
            sentence.setString(4, p.getProStock());
            sentence.setString(5, p.getProFechaVencimiento());
            sentence.setString(6, p.getTblTipoProducto_TipId());
            sentence.setString(7, "1");
            
            sentence.execute();
            PreparedStatement s = conexion.sentence("select * from "+table+" order by ProRef desc limit 1");
            ResultSet r =  s.executeQuery();
            if(r.next()){
                n = new Producto();
                n.setProRef(r.getString("ProRef"));
                n.setProNombre(r.getString("ProNombre"));
                n.setProPrecio("ProPrecio");
                n.setProStock("ProStock");
                n.setTblEstado_EstId("TblEstado_EstId");
                n.setTblTipoProducto_TipId("TblTipoProducto_TipId");
                n.setProFechaVencimiento("ProFechaVencimiento");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }


    public static void main(String[] args) {
        ProductoModel app = new ProductoModel();
        Producto p = new Producto();
        
        p.setProNombre("ooolllloplp");
        p.setProPrecio("35");
        p.setProStock("3");
        p.setTblEstado_EstId("1");
        p.setProFechaVencimiento("2020-09-08");
        p.setTblTipoProducto_TipId("1");
        app.create(p);
 
        

    }

*/


}