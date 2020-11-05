/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Table.Pedido;
import model.Table.ProductoPedido;

/**
 *
 * @author quihu
 */
public class DetallePedidoModel {

    private final Conexion conexion;
    private final String table;

    public DetallePedidoModel() {

        table = "TblProductoPedido";
        this.conexion = new Conexion();

    }

    public void create(ProductoPedido p) {

        try {

            PreparedStatement sentence = conexion.sentence("insert into " + table + " values(?,?,?,?)");
            sentence.setString(1, null);
            sentence.setString(2, p.getProPedCantidad());
            sentence.setString(3, p.getTblProducto_ProRef());
            sentence.setString(4, p.getTblPedido_PedId());
            sentence.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
