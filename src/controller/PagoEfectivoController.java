/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import view.DashboardView;
import view.PagoEfectivoView;
import view.ProcesandoView;

/**
 *
 * @author quihu
 */
public class PagoEfectivoController extends TimerTask implements ActionListener {

    private PagoEfectivoView vista;
    private TipoPagoController vistaT;
    private DashboardView vistaD;
    private ProcesandoView carga;
    private boolean valid = false;

    public PagoEfectivoController(DashboardView vistaD) {

        vista = new PagoEfectivoView();
        vista.getFieldTotal().setText(HacerPedidoController.getTotalPagar());
        this.vistaD = vistaD;
        validPrecio();
        vista.getFieldRecibido().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                validPrecio();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                validPrecio();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                validPrecio();
            }

        });

        vista.getCancelar().addActionListener(this);
        vista.getPagar().addActionListener(this);

    }

    private void validPrecio() {
        String c = "";
        if (!vista.getFieldRecibido().getText().isEmpty()) {

            int l = Integer.parseInt(vista.getFieldRecibido().getText()) - Integer.parseInt(vista.getFieldTotal().getText());
            c = String.valueOf(l);
            valid = l >= 0;

        } else {
            c = String.valueOf(0 - Integer.parseInt(vista.getFieldTotal().getText()));
            valid = false;
        }

        if (!valid) {
            vista.getFieldCambio().setForeground(Color.red);
            vista.getLabelCambio().setText("Faltan");
        } else {
            vista.getFieldCambio().setForeground(Color.BLACK);
            vista.getLabelCambio().setText("Cambio");
        }

        vista.setFieldCambio(c);
    }

    @Override
    public void actionPerformed(ActionEvent me) {
        if (me.getSource() == vista.getCancelar()) {
            vista.setVisible(false);
            vistaT = new TipoPagoController(vistaD);
            vistaT.getVista();

        }

        if (me.getSource() == vista.getPagar()) {

            if (!valid) {
                
               JOptionPane.showMessageDialog(null, "El efectivo actual no es suficiente para realizar el pedido");

            } else {
                carga = new ProcesandoView();
                Timer contadorCarga = new Timer();
                contadorCarga.schedule(this, 5000);
                HacerPedidoController.createPedido("1");
            }

        }
    }

    @Override
    public void run() {
        carga.dispose();
        vistaD.dispose();
        vista.dispose();
        PagoExitosoController pagoOk = new PagoExitosoController();

    }

}
