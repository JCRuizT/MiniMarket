/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static java.awt.Color.orange;
import static java.awt.Color.white;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.CENTER_BASELINE;
import static java.awt.Frame.HAND_CURSOR;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author quihu
 */
public class HacerPedidoView extends JPanel {
    
    JTextField fieldName = new JTextField();
    JComboBox fieldIva = new JComboBox();
    private JTableComponent tableList; 
    private JTableComponent tableList2; 
    
    JButton buttonAddProduc = new JButton();
    JButton buttonDeleteProduc = new JButton();
    JButton buttonBuy = new JButton();
    
    JLabel labelName = new JLabel();
    JLabel title = new JLabel();
    JLabel shearch = new JLabel();
    JLabel flecha = new JLabel();
    JLabel PicPedido = new JLabel();
    
    private JTableSearch fieldSearch;
    
    private final int x = 1500 ;
    private final int y = 1500;
    
    public HacerPedidoView(/*ArrayList<TipoProducto> result*/) {
        
        setSize(x, y);
        setLayout(null);
        
        title.setText("Hacer Pedido");
        title.setLocation(0, 0);
        title.setSize(850,45);
        title.setForeground(orange);
        title.setFont(new Font("Arial Black", CENTER_BASELINE, 35));
        
        buttonAddProduc = new JButton("Añadir Producto");
        buttonAddProduc.setLocation(200, 620);
        buttonAddProduc.setSize(200,30);
        buttonAddProduc.setBackground(orange);
        buttonAddProduc.setForeground(white);
        buttonAddProduc.setFocusable(false);
        buttonAddProduc.setBorder(null);
        buttonAddProduc.setFont(new Font("Arial", BOLD, 15));
        
        buttonDeleteProduc.setText("Remover Producto");
        buttonDeleteProduc.setLocation(480, 620);
        buttonDeleteProduc.setSize(200,30);
        buttonDeleteProduc.setBackground(orange);
        buttonDeleteProduc.setForeground(white);
        buttonDeleteProduc.setFocusable(false);
        buttonDeleteProduc.setBorder(null);
        buttonDeleteProduc.setFont(new Font("Arial", BOLD, 15));
        
        buttonBuy = new JButton("Hacer Pedido");
        buttonBuy.setLocation(750, 620);
        buttonBuy.setSize(230,30);
        buttonBuy.setBackground(orange);
        buttonBuy.setForeground(white);
        buttonBuy.setFocusable(false);
        buttonBuy.setBorder(null);
        buttonBuy.setFont(new Font("Arial", BOLD, 15));
        
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
        labelName.setSize(300,30);
        labelName.setFont(new Font("Arial Black", CENTER_BASELINE, 25));
        
        String columns2[] = {"id","Cantidad","Nombre del Producto","Precio Unt","Precio Total"};
        tableList2 = new JTableComponent(columns2);
        
        tableList2.getScrollTable().setLocation(480, 150);
        tableList2.getScrollTable().setSize(500, 450);
        
        tableList2.getTable().getColumnModel().getColumn(1).setMaxWidth(60);
        tableList2.getTable().getColumnModel().getColumn(3).setMaxWidth(90);
        tableList2.getTable().getColumnModel().getColumn(4).setMaxWidth(90);
        
        
        String columns[] = {"id","Nombre del Producto","Fecha vcto","Precio"};
        tableList = new JTableComponent(columns);
        
        fieldSearch = new JTableSearch(tableList.getTable());
        fieldSearch.setLocation(200, 110);
        fieldSearch.setSize(200,30);
        fieldSearch.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        shearch.setText("Buscar : ");
        shearch.setLocation(120, 100);
        shearch.setSize(100,40);
        shearch.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
     
        tableList.getTable().getColumnModel().getColumn(3).setMaxWidth(90);
        
          /*  
         for(int i=0; i<result.size();i++){
            String rs[] = {result.get(i).getTipProId(),result.get(i).getTipProNombre(),result.get(i).getTipProIva()}; 
            tableList.getModel().addRow(rs);
        }*/
        
        tableList.getScrollTable().setLocation(0, 150);
        tableList.getScrollTable().setSize(400, 450);
        
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
    
    public JButton getButtonDeleteCategory() {
        return buttonDeleteProduc;
    }

 
    public JButton getButtonCreateCategory() {
        return buttonAddProduc;
    }

    public JButton getButtonCancelCategory() {
        return buttonBuy;
    }
    

    public JTextField getFieldName() {
        return fieldName;
    }

    public JComboBox getFieldIva() {
        return fieldIva;
    }

    
}
