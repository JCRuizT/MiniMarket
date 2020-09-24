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
    private String table;

    public CategoryModel() {
        table = "TblTipoProducto";
        conexion = new Conexion().getConexion();
    }
   
    public boolean createCategory(String field[]){
        field[0] = null;
        return Crud.insertar(table,field, conexion);
        
    }
    
    public boolean deleteCategory(String id){
        return Crud.eliminar(table, "TipProNombre",id, conexion);
    }
    
    public ResultSet listCategory(){
        
        return Crud.listar(table, conexion);
    }

}
