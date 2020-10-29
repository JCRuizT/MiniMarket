/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.HacerPedidoModel;
import model.ProductoModel;
import view.DashboardView;
import view.HacerPedidoView;
import view.TipoPagoView;

/**
 *
 * @author quihu
 */
public class HacerPedidoController implements ActionListener {

    private HacerPedidoView vistaH;
    private TipoPagoView pagoVista;
    private HacerPedidoModel model;
    private ProductoModel modelProduct;
    private DashboardView vistaD;

    public HacerPedidoController(DashboardView vistaD) {

        modelProduct = new ProductoModel();
        vistaH = new HacerPedidoView(modelProduct.getAll());
        model = new HacerPedidoModel();
        this.vistaD = vistaD;

        vistaH.getButtonBuy().addActionListener(this);

    }

    public HacerPedidoView getVista() {
        return vistaH;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaH.getButtonBuy()) {
            
            vistaD.setVisible(false);

            TipoPagoController vista = new TipoPagoController(vistaD);

        }

    }

}
