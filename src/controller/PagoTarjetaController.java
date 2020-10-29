/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import view.DashboardView;
import view.PagoTarjetaView;
import view.ProcesandoView;

/**
 *
 * @author quihu
 */
public class PagoTarjetaController extends TimerTask implements ActionListener {

    private PagoTarjetaView vista;
    private TipoPagoController vistaT;
    private DashboardView vistaD;
    private ProcesandoView carga;
    private PagoExitosoController PagoExitoso;

    public PagoTarjetaController(DashboardView vistaD) {

        vista = new PagoTarjetaView();

        this.vistaD = vistaD;

        vista.getCancelar().addActionListener(this);
        vista.getPagar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent me) {

        if (me.getSource() == vista.getCancelar()) {
            vista.setVisible(false);
            vistaT = new TipoPagoController(vistaD);
            vistaT.getVista();
        }

        if (me.getSource() == vista.getPagar()) {

            if (vista.getFieldnombre().getText().isEmpty() || vista.getFieldNumber().getText().isEmpty() || vista.getFieldCVV().getText().isEmpty() || vista.getFieldciudad().getText().isEmpty()
                    || vista.getFielddireccion().getText().isEmpty() || vista.getFieldpais().getText().isEmpty() || vista.getFieldcodigoPostal().getText().isEmpty() || vista.getAño().getSelectedIndex() == 0 || vista.getMes().getSelectedIndex() == 0) {

                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Verifique los Datos", JOptionPane.WARNING_MESSAGE);

            } else if (vista.getFieldnombre().getText().length() < 8) {

                JOptionPane.showMessageDialog(null, "Nombre no valido", "Error Nombre", JOptionPane.ERROR_MESSAGE);

            } else if (vista.getFieldNumber().getText().length() > 19 || vista.getFieldNumber().getText().length() < 19) {

                JOptionPane.showMessageDialog(null, "Numero de tarjeta no valida", "Error de Tarjeta", JOptionPane.ERROR_MESSAGE);

            } else if (vista.getFieldCVV().getText().length() < 3) {

                JOptionPane.showMessageDialog(null, "CVV Incorrecto", "Error de Tarjeta", JOptionPane.ERROR_MESSAGE);

            } else if (vista.getFieldpais().getText().length() < 4) {

                JOptionPane.showMessageDialog(null, "Pais Incorrecta", "Error Pais", JOptionPane.ERROR_MESSAGE);

            } else if (vista.getFieldciudad().getText().length() < 4) {

                JOptionPane.showMessageDialog(null, "Ciudad Incorrecta", "Error Ciudad", JOptionPane.ERROR_MESSAGE);

            } else if (vista.getFielddireccion().getText().length() < 8) {

                JOptionPane.showMessageDialog(null, "Dirreción Incorrecta", "Error Dirreción", JOptionPane.ERROR_MESSAGE);

            } else if (vista.getFieldcodigoPostal().getText().length() < 4) {

                JOptionPane.showMessageDialog(null, "Codigo postal incorrecto", "Error de Codigo Postal", JOptionPane.ERROR_MESSAGE);

            } else {

                carga = new ProcesandoView();
                Timer contadorCarga = new Timer();
                contadorCarga.schedule(this, 5000);

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
