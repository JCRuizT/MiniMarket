/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.PedidoModel;
import model.ProductoModel;
import model.Table.Pedido;
import model.Table.Producto;
import view.DashboardView;
import view.HacerPedidoView;
import view.Resource;
import view.TipoPagoView;

/**
 *
 * @author quihu
 */
public class HacerPedidoController implements ActionListener {

    private HacerPedidoView vistaH;
    private TipoPagoView pagoVista;
    private static PedidoModel model;
    private ProductoModel modelProduct;
    private DashboardView vistaD;
    private static ArrayList<Producto>list;
    private static String totalPagar;

    public HacerPedidoController(DashboardView vistaD) {
        

        modelProduct = new ProductoModel();
        vistaH = new HacerPedidoView(modelProduct.getAll());
        model = new PedidoModel();
        this.vistaD = vistaD;

        vistaH.getButtonBuy().addActionListener(this);
        vistaH.getButtonAddProduc().addActionListener(this);
        vistaH.getButtonDeleteProduc().addActionListener(this);

        vistaH.getTableList().getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                vistaH.getTableList2().getTable().clearSelection();
            }
        });

        vistaH.getTableList2().getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                vistaH.getTableList().getTable().clearSelection();
            }
        });

    }

    public HacerPedidoView getVista() {
        return vistaH;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaH.getButtonBuy()) {
            
            if(vistaH.getTableList2().getTable().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "No hay productos en la lista de compras para realizar el pedido");
            }else{
                
                list = new ArrayList<Producto>();
                for(int i=0;i<vistaH.getTableList2().getTable().getRowCount();i++){
                    
                    Producto p = (Producto) vistaH.getTableList2().getTable().getValueAt(i, 0);
                    p.setCantidad(vistaH.getTableList2().getTable().getValueAt(i, 1).toString());
                }

                vistaD.setVisible(false);
                TipoPagoController vista = new TipoPagoController(vistaD);
                
            }

        } else if (e.getSource().equals(vistaH.getButtonAddProduc())) {

            if (vistaH.getTableList().getTable().getSelectedRow() == -1 && vistaH.getTableList2().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            } else {
                addProducto();
                vistaH.setTotalNum(getTotal());
            }

        } else if (e.getSource().equals(vistaH.getButtonDeleteProduc())) {
            if (vistaH.getTableList2().getTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la lista de compras");
            } else {
                removeProducto();
                vistaH.setTotalNum(getTotal());
            }
        }

    }

    private void addProducto() {

        if (vistaH.getTableList().getTable().getSelectedRow() != -1) {

            Producto p = (Producto) vistaH.getTableList().getObject();
            if (Integer.parseInt(p.getProStock()) > 0) {
                Object rs[] = {p, 1, p.getProNombre(), p.getProPrecio(), p.getProPrecio()};
                vistaH.getTableList().getModel().removeRow(vistaH.getTableList().getTable().getSelectedRow());
                vistaH.getTableList2().getModel().addRow(rs);
            } else {
                JOptionPane.showMessageDialog(null, "El producto esta agotado");
            }

        } else if (vistaH.getTableList2().getTable().getSelectedRow() != -1) {
            Producto p = (Producto) vistaH.getTableList2().getObject();

            int cant = (int) vistaH.getTableList2().getTable().getValueAt(vistaH.getTableList2().getTable().getSelectedRow(), 1);
            int precioU = Integer.parseInt(vistaH.getTableList2().getTable().getValueAt(vistaH.getTableList2().getTable().getSelectedRow(), 3).toString());
            if (Integer.parseInt(p.getProStock()) > cant) {
                cant++;
                vistaH.getTableList2().getTable().setValueAt(cant, vistaH.getTableList2().getTable().getSelectedRow(), 1);
                vistaH.getTableList2().getTable().setValueAt((precioU * cant), vistaH.getTableList2().getTable().getSelectedRow(), 4);
            } else {
                JOptionPane.showMessageDialog(null, "El producto esta agotado");
            }

        }

    }

    private void removeProducto() {

        int cant = (int) vistaH.getTableList2().getTable().getValueAt(vistaH.getTableList2().getTable().getSelectedRow(), 1);
        int precioU = Integer.parseInt(vistaH.getTableList2().getTable().getValueAt(vistaH.getTableList2().getTable().getSelectedRow(), 3).toString());
        if (cant >= 2) {
            cant--;
            vistaH.getTableList2().getTable().setValueAt(cant, vistaH.getTableList2().getTable().getSelectedRow(), 1);
            vistaH.getTableList2().getTable().setValueAt((precioU * cant), vistaH.getTableList2().getTable().getSelectedRow(), 4);

        } else {

            cant--;
            Producto p = (Producto) vistaH.getTableList2().getObject();

            Object rs[] = {p, p.getProNombre(), p.getProStock(), Resource.transformFecha(p.getProFechaVencimiento()), p.getProPrecio()};
            vistaH.getTableList2().getModel().removeRow(vistaH.getTableList2().getTable().getSelectedRow());
            vistaH.getTableList().getModel().addRow(rs);

        }

    }

    private String getTotal() {

        String tot = "";
        if (vistaH.getTableList2().getTable().getRowCount() == 0) {
            tot = "0";
        } else {
            int suma = 0;
            for (int i = 0; i < vistaH.getTableList2().getTable().getRowCount(); i++) {
                int t = Integer.parseInt(vistaH.getTableList2().getTable().getValueAt(i, 4).toString());
                suma = suma+t;
            }
            tot = String.valueOf(suma);
            totalPagar = tot;
        }
        
        return tot;

    }

    public static String getTotalPagar() {
        return totalPagar;
    }
    
    
    public static void createPedido(String metodoPago){
        
        Pedido p = new Pedido();
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        
        String fecha = year+"-"+month+"-"+day;
        
        p.setPedFecha(fecha);
        p.setTblMetodoPago_MetId(metodoPago);
        p.setTblUsuario_UsuIdentificacion(DashboardController.getUserInfo().getUsuIdentificacion());
        model.create(p);

    }
    
    

}
