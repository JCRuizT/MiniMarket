/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.HistorialPedidoModel;
import model.Table.HistorialPedido;
import model.Table.Usuario;
import view.HistorialPedidoView;

/**
 *
 * @author quihu
 */
public class HistorialPedidoController {

    private HistorialPedidoView vista;
    private HistorialPedidoModel model;

    public HistorialPedidoController() {

        model = new HistorialPedidoModel();
        ArrayList<HistorialPedido> data;
        if (DashboardController.getUserInfo().getTblRol_RolId().equals("1") || DashboardController.getUserInfo().getTblRol_RolId().equals("2")) {
            data = model.getAllPedidos();
        }else{
            Usuario a = new Usuario();
            a.setUsuIdentificacion(DashboardController.getUserInfo().getUsuIdentificacion());
            data = model.getAllPedidos(a);
        }
        
        vista = new HistorialPedidoView(data);

    }

    public HistorialPedidoView getVista() {
        return vista;
    }

}
