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
import javax.swing.JOptionPane;

/**
 *
 * @author pc-standard
 */
public class Crud {

    public static boolean insertar(String tabla, String val[], Connection conexion) {
        String values = "";
        for (int i = 0; i < val.length; i++) {
            if (val[i] == null) {

                values = values + "null,";
            } else {
                if (i != val.length - 1) {
                    values = "" + values + "'" + val[i] + "',";
                } else {
                    values = values + "'" + val[i] + "'";
                }
            }
        }
        String sql = "insert into " + tabla + " values (" + values + ")";
        try {
            Statement comando = conexion.createStatement();
            comando.execute(sql);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage() + JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static ResultSet listar(String tabla, Connection conexion) {
        ResultSet registro = null;
        try {

            String sql = "select * from " + tabla + " where TblEstado_EstId = 1";
            System.out.println(sql);
            Statement comando = conexion.createStatement();
            registro = comando.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return registro;
    }

    public static boolean eliminar(String tabla, String field, String value, Connection conexion) {

        String sql = "update " + tabla + " set TblEstado_EstId = 2 where " + field + " = '" + value + "'";
        try {
            Statement comando = conexion.createStatement();
            comando.execute(sql);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage() + JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static ResultSet select(String sql, Connection conexion) {
        ResultSet registro = null;
        try {

            Statement comando = conexion.createStatement();
            registro = comando.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return registro;
    }

    public static ResultSet listarJoin(String field, String tabla1, String tabla2, String condition, Connection conexion) {
        ResultSet registro = null;
        try {

            String sql = "select " + field + " from " + tabla1 + "," + tabla2 + " where " + condition;
            Statement comando = conexion.createStatement();
            registro = comando.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return registro;
    }

}
