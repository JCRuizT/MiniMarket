/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DashboardController;
import java.awt.Color;
import static java.awt.Color.orange;
import static java.awt.Color.white;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.CENTER_BASELINE;
import static java.awt.Image.SCALE_DEFAULT;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Table.Producto;
import model.Table.Usuario;

/**
 *
 * @author quihu
 */
public class HacerPedidoView extends JPanel {

    JTextField fieldName = new JTextField();

    private JTableComponent tableList;
    private JTableComponent tableList2;

    private JButton buttonAddProduc = new JButton();
    private JButton buttonAddCant = new JButton();
    private JButton buttonDeleteProduc = new JButton();
    private JButton buttonBuy = new JButton();

    private JLabel labelName = new JLabel();
    private JLabel title = new JLabel();
    private JLabel shearch = new JLabel();
    private JLabel flecha = new JLabel();
    private JLabel PicPedido = new JLabel();
    private JLabel totalAPagar = new JLabel();
    private JLabel totalNum = new JLabel();
    private JComboBox selectClient;

    private JTableSearch fieldSearch;

    private final int x = 1500;
    private final int y = 1500;

    public HacerPedidoView(ArrayList<Producto> result, ArrayList<Usuario> user) {

        setSize(x, y);
        setLayout(null);

        title.setText("Hacer Pedido");
        title.setSize(850, 45);
        title.setForeground(orange);
        title.setFont(new Font("Arial Black", CENTER_BASELINE, 35));

        buttonAddProduc = new JButton("Añadir Producto");
        buttonAddProduc.setLocation(200, 620);
        buttonAddProduc.setSize(200, 30);
        buttonAddProduc.setBackground(orange);
        buttonAddProduc.setForeground(white);
        buttonAddProduc.setFocusable(false);
        buttonAddProduc.setBorder(null);
        buttonAddProduc.setFont(new Font("Arial", BOLD, 15));

        buttonDeleteProduc.setText("Remover unidad");
        buttonDeleteProduc.setLocation(0, 620);
        buttonDeleteProduc.setSize(180, 30);
        buttonDeleteProduc.setBackground(orange);
        buttonDeleteProduc.setForeground(white);
        buttonDeleteProduc.setFocusable(false);
        buttonDeleteProduc.setBorder(null);
        buttonDeleteProduc.setFont(new Font("Arial", BOLD, 15));

        if (!DashboardController.getUserInfo().getTblRol_RolId().equals("3")) {
            selectClient = new JComboBox();

            selectClient.setLocation(0, 670);
            selectClient.setSize(180, 30);
            selectClient.setFont(new Font("Arial", BOLD, 15));

            selectClient.addItem("Seleccionar Cliente");

            for (int i = 0; i < user.size(); i++) {
                if (Integer.parseInt(user.get(i).getUsuIdentificacion()) != -1) {
                    selectClient.addItem(new JComboItem(user.get(i).getUsuIdentificacion(), user.get(i).getUsuIdentificacion() + " - " + user.get(i).getUsuNombre1().toUpperCase()));
                }else{
                    selectClient.addItem(new JComboItem(user.get(i).getUsuIdentificacion(), user.get(i).getUsuNombre1().toUpperCase()+" "+user.get(i).getUsuApellido1().toUpperCase()));
                }
            }

        }

        buttonBuy = new JButton("Hacer Pedido");
        buttonBuy.setLocation(750, 670);
        buttonBuy.setSize(230, 40);
        buttonBuy.setBackground(orange);
        buttonBuy.setForeground(white);
        buttonBuy.setFocusable(false);
        buttonBuy.setBorder(null);
        buttonBuy.setFont(new Font("Arial", BOLD, 20));

        totalAPagar.setText("Total a pagar : $ ");
        totalAPagar.setLocation(750, 610);
        totalAPagar.setSize(300, 40);
        totalAPagar.setForeground(Color.BLACK);
        totalAPagar.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));

        totalNum.setText("0");
        totalNum.setLocation(940, 610);
        totalNum.setSize(300, 40);
        totalNum.setForeground(Color.GREEN);
        totalNum.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));

        flecha.setSize(50, 50);
        flecha.setLocation(415, 350);
        ImageIcon imageAdmin = new ImageIcon(getClass().getResource("/imagenes/flecha.png"));
        Icon iconAdmin = new ImageIcon(imageAdmin.getImage().getScaledInstance(flecha.getWidth(), flecha.getHeight(), SCALE_DEFAULT));
        flecha.setIcon(iconAdmin);

        PicPedido.setSize(60, 60);
        PicPedido.setLocation(490, 80);
        ImageIcon imageHacerPedido = new ImageIcon(getClass().getResource("/imagenes/pedidoList.png"));
        Icon iconHacerPedido = new ImageIcon(imageHacerPedido.getImage().getScaledInstance(PicPedido.getWidth(), PicPedido.getHeight(), SCALE_DEFAULT));
        PicPedido.setIcon(iconHacerPedido);

        labelName.setText("Lista de Compras");
        labelName.setLocation(560, 95);
        labelName.setSize(300, 30);
        labelName.setFont(new Font("Arial Black", CENTER_BASELINE, 25));

        String columns2[] = {"id", "Cantidad", "Nombre del Producto", "Precio Unt", "Precio Total"};
        tableList2 = new JTableComponent(columns2);

        tableList2.getScrollTable().setLocation(480, 150);
        tableList2.getScrollTable().setSize(500, 450);

        tableList2.getTable().getColumnModel().getColumn(1).setMaxWidth(60);
        tableList2.getTable().getColumnModel().getColumn(3).setMaxWidth(90);
        tableList2.getTable().getColumnModel().getColumn(4).setMaxWidth(90);

        String columns[] = {"id", "Nombre del Producto", "C.Disp", "Fecha vcto", "Precio"};
        tableList = new JTableComponent(columns);

        for (int i = 0; i < result.size(); i++) {
            Object rs[] = {result.get(i), result.get(i).getProNombre(), result.get(i).getProStock(), Resource.transformFecha(result.get(i).getProFechaVencimiento()), "$ " + result.get(i).getProPrecio()};
            tableList.getModel().addRow(rs);
        }

        tableList.getTable().getColumnModel().getColumn(1).setMinWidth(130);
        tableList.getTable().getColumnModel().getColumn(2).setMaxWidth(50);
        tableList.getTable().getColumnModel().getColumn(3).setMinWidth(120);
        tableList.getTable().getColumnModel().getColumn(4).setMaxWidth(60);

        fieldSearch = new JTableSearch(tableList.getTable());
        fieldSearch.setLocation(200, 110);
        fieldSearch.setSize(200, 30);
        fieldSearch.setFont(new Font("Segoe UI Light", BOLD, 20));

        shearch.setText("Buscar : ");
        shearch.setLocation(120, 100);
        shearch.setSize(100, 40);
        shearch.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));

        tableList.getTable().getColumnModel().getColumn(3).setMaxWidth(90);
        tableList.centerData(2);
        tableList.centerData(3);

        tableList.getScrollTable().setLocation(0, 150);
        tableList.getScrollTable().setSize(400, 450);

        add(totalAPagar);
        add(totalNum);
        add(shearch);
        add(title);
        add(labelName);
        add(flecha);
        add(buttonBuy);
        add(buttonAddProduc);
        add(fieldSearch);
        add(tableList.getScrollTable());
        add(tableList2.getScrollTable());
        add(buttonDeleteProduc);
        add(PicPedido);

        if (!DashboardController.getUserInfo().getTblRol_RolId().equals("3")) {
            add(selectClient);
        }

    }

    public void setSelectedCombobox(JComboBox select, String txt) {

        for (int i = 0; i < select.getModel().getSize(); i++) {
            if (select.getItemAt(i).toString().equals(txt)) {
                select.setSelectedIndex(i);
                break;
            }
        }

    }

    public JTableComponent getTableList() {
        return tableList;
    }

    public JTableComponent getTableList2() {
        return tableList2;
    }

    public JButton getButtonAddProduc() {
        return buttonAddProduc;
    }

    public JButton getButtonDeleteProduc() {
        return buttonDeleteProduc;
    }

    public JButton getButtonBuy() {
        return buttonBuy;
    }

    public String getTotalNum() {
        return totalNum.getText();
    }

    public void setTotalNum(String totalNum) {
        this.totalNum.setText(totalNum);
    }

    public JComboBox getSelectClient() {
        return selectClient;
    }

}
