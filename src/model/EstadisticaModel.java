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
import model.Table.ProductoEstadistica;
import model.Table.Usuario;

/**
 *
 * @author pc-standard
 */
public class EstadisticaModel {

    private Conexion conexion;
    private String tabla;
    private Usuario userInfo;

    public EstadisticaModel() {
        conexion = new Conexion();
    }

    public ProductoEstadistica getMayor() {

        ProductoEstadistica data = new ProductoEstadistica();
        try {
            PreparedStatement sentence = conexion.sentence("SELECT TblProducto_ProRef,ProNombre, sum(ProPedCantidad) as ProPedCantidad FROM TblProductoPedido,TblProducto where ProRef = TblProducto_ProRef GROUP BY TblProducto_ProRef order by ProPedCantidad desc limit 1");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                data.setTblProducto_ProRef(result.getString("TblProducto_ProRef"));
                data.setProNombre(result.getString("ProNombre"));
                data.setProPedCantidad(result.getString("ProPedCantidad"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }

    public ProductoEstadistica getMenor() {

        ProductoEstadistica data = new ProductoEstadistica();
        try {
            PreparedStatement sentence = conexion.sentence("SELECT TblProducto_ProRef,ProNombre, sum(ProPedCantidad) as ProPedCantidad FROM TblProductoPedido,TblProducto where ProRef = TblProducto_ProRef GROUP BY TblProducto_ProRef order by ProPedCantidad asc limit 1");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                data.setTblProducto_ProRef(result.getString("TblProducto_ProRef"));
                data.setProNombre(result.getString("ProNombre"));
                data.setProPedCantidad(result.getString("ProPedCantidad"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;

    }

}
