/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author pc-standard
 */
public class ProductModel {
    

    private Connection conexion;
    private String table;

    public ProductModel() {
        
        table = "TblProducto";
        conexion = new Conexion().getConexion();
    }
    
    
    public boolean createProduct(String field[]){
        
        field[0] = null;
        return Crud.insertar(table,field, conexion);
        
    }
    
    public ResultSet listProduct(){
        
        return Crud.listar(table, conexion);
    }

}
