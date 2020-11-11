/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.DetallePedidoModel;
import model.HistorialPedidoModel;
import model.Table.Factura;
import model.Table.HistorialPedido;
import model.Table.Pedido;
import view.DashboardView;
import view.FacturaFormat;
import view.LoginView;
import view.PagoExitosoView;

/**
 *
 * @author quihu
 */
public class PagoExitosoController implements ActionListener, MouseListener {

    private PagoExitosoView vista;
    private DashboardController vistaD;
    private Pedido pp;

    public PagoExitosoController(Pedido pp) {

        vista = new PagoExitosoView();
        vista.getOk().addActionListener(this);
        vista.getDescargar().addMouseListener(this);
        vista.getVer().addMouseListener(this);
        this.pp = pp;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vista.getOk()) {

            vista.dispose();
            DashboardController gui = new DashboardController(DashboardController.getUserInfo());

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(vista.getVer())) {

            HistorialPedidoModel z = new HistorialPedidoModel();
            HistorialPedido a = z.getOne(pp);

            DetallePedidoModel dp = new DetallePedidoModel();
            ArrayList<Factura> f = dp.listItemPedido(a);

            String n = FacturaFormat.setFactura(a.getPedId(), a.getUsuNombre1() + " " + a.getUsuApellido1(), a.getUsuIdentificacion(), a.getPedFecha(), f);

            try {
                Desktop.getDesktop().open(new File(n));
            } catch (IOException ex) {

            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
