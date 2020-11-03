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
import view.Resource;

/**
 *
 * @author pc-standard
 */
public class ProductoModel {

    private final Conexion conexion;
    private final String table;

    public ProductoModel() {
        table = "TblProducto";
        this.conexion = new Conexion();
    }

    public ArrayList<Producto> getAll() {
        ArrayList<Producto> data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("select * from " + table + " as p, TblEstado as e,TblTipoProducto as tp where e.EstId = p.TblEstado_EstId and tp.TipProId = p.TblTipoProducto_TipId and p.TblEstado_EstId = 1 and p.ProStock > 0");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                Producto p = new Producto();
                p.setProRef(result.getString("ProRef"));
                p.setProNombre(result.getString("ProNombre"));
                p.setProPrecio(result.getString("ProPrecio"));
                p.setProStock(result.getString("ProStock"));
                p.setProFechaVencimiento(result.getString("ProFechaVencimiento"));
                p.setTblTipoProducto_TipId(result.getString("TblTipoProducto_TipId"));
                p.setTipProNombre(result.getString("TipProNombre"));
                p.setTblEstado_EstId(result.getString("EstId"));
                p.setTblEstado_EstEstado(result.getString("EstEstado"));
                data.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }

    public Producto create(Producto p) {
        
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
            
            System.out.println(sentence.toString());
            sentence.execute();
            PreparedStatement s = conexion.sentence("select * from "+table+",TblTipoProducto where TblTipoProducto_TipId = TipProId  order by ProRef desc limit 1");
            System.out.println(s);
            ResultSet r =  s.executeQuery();
            if(r.next()){
                n = new Producto();
                n.setProRef(r.getString("ProRef"));
                n.setProNombre(r.getString("ProNombre"));
                n.setProPrecio(r.getString("ProPrecio"));
                n.setProStock(r.getString("ProStock"));
                n.setTblEstado_EstId(r.getString("TblEstado_EstId"));
                n.setTblTipoProducto_TipId(r.getString("TblTipoProducto_TipId"));
                n.setTipProNombre(r.getString("TipProNombre"));
                n.setProFechaVencimiento(r.getString("ProFechaVencimiento"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

      public boolean update(Producto p){
        try {
            
            PreparedStatement sentence = conexion.sentence("update "+table+" set ProNombre = ?, ProPrecio = ?, ProStock = ?, ProFechaVencimiento = ?, TblTipoProducto_TipId = ?, TblEstado_EstId = ? where ProRef = ?");
            sentence.setString(1,p.getProNombre());
            sentence.setString(2, p.getProPrecio());
            sentence.setString(3, p.getProStock());
            sentence.setString(4, p.getProFechaVencimiento());
            sentence.setString(5, p.getTblTipoProducto_TipId());
            sentence.setString(6, p.getTblEstado_EstId());
            sentence.setString(7, p.getProRef());
            
            sentence.execute();
            

            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        ProductoModel app = new ProductoModel();
       /* Producto p = new Producto();
        
        p.setProNombre("ooolllloplp");
        p.setProPrecio("35");
        p.setProStock("3");
        p.setTblEstado_EstId("1");
        p.setProFechaVencimiento("2020-09-08");
        p.setTblTipoProducto_TipId("1");
        app.create(p);*/
 
        

    }

}
