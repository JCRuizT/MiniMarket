package model;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pc-standard
 */
public class Conexion{

    private Connection conexion;
    private Statement comando;
    private ResultSet registro;
    String tabla;


    public Connection getConexion() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost:3306/bd_mini_proyecto";
            String user = "admin"; // root-admin
            String password = "juliocruizt"; //juliocruizt
            conexion = DriverManager.getConnection(host, user, password);

            if (conexion != null) {
                System.out.println("Conexión Exitosa");
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            conexion = null;
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            conexion = null;
        }
        return conexion;
    }

}
