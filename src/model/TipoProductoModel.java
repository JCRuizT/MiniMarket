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
import model.Table.TipoProducto;
/**
 *
 * @author quihu
 *
 */
public class TipoProductoModel {

    private final Conexion conexion;
    private final String table;

    public TipoProductoModel() {
        table = "TblTipoProducto";
        this.conexion = new Conexion();
    }
    
    public ArrayList<TipoProducto> getAll(){
        ArrayList<TipoProducto>data = new ArrayList<>();
        try {
            PreparedStatement sentence = conexion.sentence("select * from "+table);
            ResultSet result =  sentence.executeQuery();
            while(result.next()){
                TipoProducto tp = new TipoProducto();
                tp.setTipProId(result.getString("TipProId"));
                tp.setTipProIva(result.getString("TipProIva"));
                tp.setTipProNombre(result.getString("TipProNombre"));
                tp.setTblEstado_EstId(result.getString("TblEstado_EstId"));
                data.add(tp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
        
    }
 
    public TipoProducto create(TipoProducto tp){
        TipoProducto n = null;
        try {
            
            PreparedStatement sentence = conexion.sentence("insert into "+table+" values(?,?,?,?)");
            sentence.setString(1, null);
            sentence.setString(2, tp.getTipProNombre());
            sentence.setString(3, tp.getTipProIva());
            sentence.setString(4, "1");
            sentence.execute();
            PreparedStatement s = conexion.sentence("select * from "+table+" order by TipProId desc limit 1");
            System.out.println(s);
            ResultSet r =  s.executeQuery();
            if(r.next()){
                n = new TipoProducto();
                n.setTblEstado_EstId(r.getString("TblEstado_EstId"));
                n.setTipProId(r.getString("TipProId"));
                n.setTipProIva(r.getString("TipProIva"));
                n.setTipProNombre(r.getString("TipProNombre"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
    
    public boolean update(TipoProducto tp){
        try {
            PreparedStatement sentence = conexion.sentence("update "+table+" set TipProNombre = ?, TipProIva = ?, TblEstado_EstId = ? where TipProId = ?");
            sentence.setString(1,tp.getTipProNombre());
            sentence.setString(2, tp.getTipProIva());
            sentence.setString(3, tp.getTblEstado_EstId());
            sentence.setString(4, tp.getTipProId());
            return sentence.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        TipoProductoModel app = new TipoProductoModel();
        TipoProducto tp = new TipoProducto();
        tp.setTipProNombre("klllljkkjkjkklklllkkjklklnmmnmjklliukkkjknask");
        tp.setTipProIva("23");
        TipoProducto l = app.create(tp);
        System.out.println(l.getTipProId());
        

    }
    
}
