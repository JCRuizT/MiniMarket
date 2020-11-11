package model;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
    private PreparedStatement comando;
    private ResultSet registro;
    private PreparedStatement sentence;


    public Conexion() {
        
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
           // System.out.println(e.getMessage());
            conexion = null;
            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos, verifique que el servidor este encendido", "Error 404 : No se encontro la base de datos", JOptionPane.ERROR_MESSAGE);

            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos, verifique el servidor", "Error: Conexion a base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
            conexion = null;

            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos, verifique que el servidor este encendido", "Error 404 : No se encontro la base de datos", JOptionPane.ERROR_MESSAGE);

            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion con la base de datos, verifique el servidor", "Error: Conexion a base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }
    }
    
    public PreparedStatement sentence(String sql) throws SQLException{
        sentence = conexion.prepareStatement(sql);
        return sentence;
    }

    

    
    
    

}
