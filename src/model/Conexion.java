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
class Conexion{

    private Connection conexion;
    private Statement comando;
    private ResultSet registro;
    String tabla;

    public Conexion() {
        getConexion();
    }

    public void getConexion() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost:3306/bd_mini_proyecto";
            String user = "admin"; // root
            String password = "juliocruizt"; //
            conexion = DriverManager.getConnection(host, user, password);

            if (conexion != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            conexion = null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            conexion = null;
        }
    }
    
    public static void main(String[] args) {
        Conexion app = new Conexion();
    }

}
    /*
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void query() {
        try {
            String query = "select * from " + tabla;
            comando = conexion.createStatement();
            registro = comando.executeQuery(query);

            while (registro.next()) {

                System.out.println("Nombre " + registro.getString("Nombre"));
                System.out.println("Apellido " + registro.getString("Apellido"));
                System.out.println("Cedula " + registro.getString("Cedula"));
            }

            comando.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean create(String nombre, String apellido, int cedula) {

        try {
            comando = conexion.createStatement();
            comando.execute("Insert into " + tabla + "(nombre,apellido,cedula) values('" + nombre + "','" + apellido + "','" + cedula + "')");
            System.out.println("Registro creado");
            comando.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public void eliminarTodo() {
        try {
            comando = conexion.createStatement();
            comando.execute("delete from " + tabla);
            System.out.println("Registros eliminados");

            comando.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    */
