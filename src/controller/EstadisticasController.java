/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.EstadisticaModel;
import model.Table.ProductoEstadistica;
import view.EstadisticaView;

/**
 *
 * @author quihu
 */
public class EstadisticasController {
    
    private EstadisticaView vista;
    private EstadisticaModel model;
    
    
    public EstadisticasController(){
       vista = new EstadisticaView();
       
       model = new EstadisticaModel();
       ProductoEstadistica mayor = model.getMayor();
       ProductoEstadistica menor = model.getMenor();
       
       vista.setResultadoMasVendido(mayor.getProNombre());
       vista.setResultadoMenosVendido(menor.getProNombre());
    }
    
    public EstadisticaView getVista(){
        return vista;
    }
    
    
}
