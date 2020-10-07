/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author pc-standard
 */
public class DashboardView extends JFrame implements MouseListener{
    
     Container contenedor = getContentPane();
     
        //PANELES 
          JPanel pagPrincipal = new JPanel();
          JPanel menu = new JPanel();
           
        //ETIQUETAS
          JLabel labelNameUser = new JLabel();
          JLabel labelCrearProd = new JLabel();
          JLabel labelCrearUsu = new JLabel();
          JLabel labelCrearCateg = new JLabel();
          JLabel labelHacerPedido = new JLabel();
          JLabel labelMenu = new JLabel();
          JLabel labelBienvenida = new JLabel();
          JLabel labelRol = new JLabel();
          JLabel picAdmin = new JLabel();
          JLabel close = new JLabel();
          JLabel minimize = new JLabel();
          JLabel picCrearUsu = new JLabel();
          JLabel picCrearProduc = new JLabel();
          JLabel picCrearCateg = new JLabel();
          JLabel picHacerPedido = new JLabel();
        
          
        //CAJA DE TEXTO
         JTextField xs = new JTextField();

        //BOTONES
         JButton buttonSubmit = new JButton();

        //ComboBox
         JComboBox fieldRol = new JComboBox();

        //VARIAVLES
        private final int x = 1430;
        private final int y = 900;
   
    
    public DashboardView(){
        
        //setTitle("MiniMarket");
        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);
         
        //Diseño
        
        pagPrincipal.setSize(x, y);
        pagPrincipal.setLocation(0, 0);
        pagPrincipal.setLayout(null);
        
        menu.setSize(300, 1430);
        menu.setLayout(null);
        menu.setLocation(0, 0);
        menu.setBackground(Color.orange);
        
        labelMenu.setForeground(Color.WHITE);
        labelMenu.setSize(300, 40);
        labelMenu.setLocation(0, 20);
        labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
        labelMenu.setFont(new Font("Arial Black", Font.BOLD, 30));
        labelMenu.setText("Menú");
        
        labelCrearUsu.setForeground(Color.WHITE);
        labelCrearUsu.setSize(300, 40);
        labelCrearUsu.setLocation(80, 100);
        labelCrearUsu.setFont(new Font("Arial", Font.BOLD, 20));
        labelCrearUsu.setText("Gestionar Usuario");
        labelCrearUsu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelCrearUsu.addMouseListener(this);
        
        labelCrearProd.setForeground(Color.WHITE);
        labelCrearProd.setSize(300, 40);
        labelCrearProd.setLocation(80, 140);
        labelCrearProd.setFont(new Font("Arial", Font.BOLD, 20));
        labelCrearProd.setText("Gestionar Producto");
        labelCrearProd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelCrearProd.addMouseListener(this);
        
        labelCrearCateg.setForeground(Color.WHITE);
        labelCrearCateg.setSize(300, 40);
        labelCrearCateg.setLocation(80, 180);
        labelCrearCateg.setFont(new Font("Arial", Font.BOLD, 20));
        labelCrearCateg.setText("Gestionar Categoria");
        labelCrearCateg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelCrearCateg.addMouseListener(this);
        
        labelHacerPedido.setForeground(Color.WHITE);
        labelHacerPedido.setSize(300, 40);
        labelHacerPedido.setLocation(80, 220);
        labelHacerPedido.setFont(new Font("Arial", Font.BOLD, 20));
        labelHacerPedido.setText("Hacer Pedido");
        labelHacerPedido.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelHacerPedido.addMouseListener(this);
        
        labelBienvenida.setForeground(Color.BLACK);
        labelBienvenida.setSize(300, 40);
        labelBienvenida.setLocation(350, 20);
        labelBienvenida.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
        labelBienvenida.setText("Bienvenido");
        
        labelRol.setForeground(Color.BLACK);
        labelRol.setSize(300, 40);
        labelRol.setLocation(350, 60);
        labelRol.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
        labelRol.setText("Administrador");
        
        labelNameUser.setForeground(Color.BLACK);
        labelNameUser.setSize(200, 40);
        labelNameUser.setLocation(1050, 35);
        labelNameUser.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
        labelNameUser.setText("Carlos Yepez");
        labelNameUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelNameUser.addMouseListener(this);
        
        picAdmin.setSize(70, 70);
        picAdmin.setLocation(1260, 20);
        ImageIcon imageAdmin = new ImageIcon(getClass().getResource("/imagenes/admin.png"));
        Icon iconAdmin = new ImageIcon(imageAdmin.getImage().getScaledInstance(picAdmin.getWidth(), picAdmin.getHeight(), Image.SCALE_DEFAULT));
        picAdmin.setIcon(iconAdmin);
        picAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        picAdmin.addMouseListener(this);
        
        picCrearUsu.setSize(30, 30);
        picCrearUsu.setLocation(40, 100);
        ImageIcon imageCrearUsu = new ImageIcon(getClass().getResource("/imagenes/CrearUsuario.png"));
        Icon iconCrearUsu = new ImageIcon(imageCrearUsu.getImage().getScaledInstance(picCrearUsu.getWidth(), picCrearUsu.getHeight(), Image.SCALE_DEFAULT));
        picCrearUsu.setIcon(iconCrearUsu);
        picCrearUsu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        picCrearUsu.addMouseListener(this);
        
        picCrearProduc.setSize(30, 30);
        picCrearProduc.setLocation(40, 145);
        ImageIcon imageCrearProduc = new ImageIcon(getClass().getResource("/imagenes/CrearProducto.png"));
        Icon iconCrearProduc = new ImageIcon(imageCrearProduc.getImage().getScaledInstance(picCrearProduc.getWidth(), picCrearProduc.getHeight(), Image.SCALE_DEFAULT));
        picCrearProduc.setIcon(iconCrearProduc);
        picCrearProduc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        picCrearProduc.addMouseListener(this);
        
        picCrearCateg.setSize(30, 30);
        picCrearCateg.setLocation(40, 187);
        ImageIcon imageCrearCateg = new ImageIcon(getClass().getResource("/imagenes/categoria.png"));
        Icon iconCrearCateg = new ImageIcon(imageCrearCateg.getImage().getScaledInstance(picCrearCateg.getWidth(), picCrearCateg.getHeight(), Image.SCALE_DEFAULT));
        picCrearCateg.setIcon(iconCrearCateg);
        picCrearCateg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        picCrearCateg.addMouseListener(this);
        
        picHacerPedido.setSize(30, 30);
        picHacerPedido.setLocation(39, 225);
        ImageIcon imageHacerPedido = new ImageIcon(getClass().getResource("/imagenes/pedido.png"));
        Icon iconHacerPedido = new ImageIcon(imageHacerPedido.getImage().getScaledInstance(picHacerPedido.getWidth(), picHacerPedido.getHeight(), Image.SCALE_DEFAULT));
        picHacerPedido.setIcon(iconHacerPedido);
        picHacerPedido.setCursor(new Cursor(Cursor.HAND_CURSOR));
        picHacerPedido.addMouseListener(this);
        
        close.setSize(20, 20);
        close.setLocation(1390, 20);
        ImageIcon imageclose = new ImageIcon(getClass().getResource("/imagenes/CerrarN.png"));
        Icon iconclose = new ImageIcon(imageclose.getImage().getScaledInstance(close.getWidth(), close.getHeight(), Image.SCALE_DEFAULT));
        close.setIcon(iconclose);
        close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        close.addMouseListener(this);
        
        minimize.setSize(20, 20);
        minimize.setLocation(1360, 20);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/minimizarN.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(minimize.getWidth(), minimize.getHeight(), Image.SCALE_DEFAULT));
        minimize.setIcon(iconminimize);
        minimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimize.addMouseListener(this);
        
        menu.add(picHacerPedido);
        menu.add(labelHacerPedido);
        menu.add(picCrearCateg);
        menu.add(labelCrearCateg);
        menu.add(picCrearUsu);
        menu.add(picCrearProduc);
        menu.add(labelCrearUsu);
        menu.add(labelCrearProd);
        pagPrincipal.add(labelRol);
        pagPrincipal.add(labelBienvenida);
        menu.add(labelMenu);
        pagPrincipal.add(labelNameUser);
        pagPrincipal.add(close);
        pagPrincipal.add(minimize);
        pagPrincipal.add(picAdmin);
        pagPrincipal.add(menu);
        contenedor.add(pagPrincipal);
        
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
      public void mouseClicked(MouseEvent me) {
        if (me.getSource() == minimize) {
            setState(DashboardView.ICONIFIED);
        }
        if (me.getSource()==close){
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == buttonSubmit) {
            buttonSubmit.setBackground(new Color(202, 202, 202));
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == buttonSubmit) {
            buttonSubmit.setBackground(new Color(214, 214, 214));
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == buttonSubmit) {
            buttonSubmit.setBackground(new Color(214, 214, 214));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == buttonSubmit) {
            buttonSubmit.setBackground(new Color(197, 197, 197));
        }
    }

 
    
    //Metodos Getters 
    
    public JPanel getPagPrincipal() {
        return pagPrincipal;
    }

    public JLabel getLabelNameUser() {
        return labelNameUser;
    }

    public JLabel getLabelCrearProd() {
        return labelCrearProd;
    }

    public JLabel getLabelCrearUsu() {
        return labelCrearUsu;
    }

    public JLabel getLabelCrearCateg() {
        return labelCrearCateg;
    }

    public JLabel getLabelHacerPedido() {
        return labelHacerPedido;
    }

    public JLabel getPicAdmin() {
        return picAdmin;
    }

    public JLabel getPicCrearUsu() {
        return picCrearUsu;
    }

    public JLabel getPicCrearProduc() {
        return picCrearProduc;
    }

    public JLabel getPicCrearCateg() {
        return picCrearCateg;
    }

    public JLabel getPicHacerPedido() {
        return picHacerPedido;
    }
    
}