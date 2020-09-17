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
 * @author quihu
 *
 */
public class CategoryModel {

    private Connection conexion;

    public CategoryModel() {
        
        conexion = new Conexion().getConexion();
    }
    
    
    public boolean createCategory(String field[]){
        
        return Crud.insertar("TblTipoProducto",field, conexion);
        
    }
    
    public ResultSet listCategory(String tabla){
        
        return Crud.listar(tabla, conexion);
    }

}
