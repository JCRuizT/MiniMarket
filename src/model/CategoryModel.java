/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author quihu
 *
 */
public class CategoryModel {

    private Connection conexion;

    CategoryModel() {
        conexion = new Conexion().getConexion();
    }

    public void insertarCategoria(String nombre, double iva) {

        try {
            Statement comando = conexion.createStatement();
            comando.execute("insert into tbltipoproducto values (null,'" + nombre + "'," + iva + ")");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "primero error insercion" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }

}
