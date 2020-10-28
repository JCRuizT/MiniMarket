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
            carga = new ProcesandoView();
            Timer contadorCarga = new Timer();
            contadorCarga.schedule(this, 5000);
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
