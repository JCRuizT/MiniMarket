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
 * @author quihu
 */
public class CrearUsuarioView extends JFrame implements MouseListener {

    Container contenedor = getContentPane();

    JPanel mainPanel = new JPanel();
    JPanel PanelLogo = new JPanel();

    JLabel message = new JLabel();
    JLabel labelTitulo = new JLabel();
    JLabel labelTipoIdentificacion = new JLabel();
    JLabel labelnumIdentificacion = new JLabel();
    JLabel labelName = new JLabel();
    JLabel labelSecondName = new JLabel();
    JLabel labelLastName = new JLabel();
    JLabel labelSecondLastName = new JLabel();
    JLabel labelCel = new JLabel();
    JLabel labelEmail = new JLabel();
    JLabel labelPass = new JLabel();
    JLabel labelConfirmPass = new JLabel();

    JLabel minimize = new JLabel();
    JLabel close = new JLabel();
    JLabel logoRegisto = new JLabel();

    JTextField fieldnumIdentificacion = new JTextField();
    JTextField fieldName = new JTextField();
    JTextField fieldSecondName = new JTextField();
    JTextField fieldLastName = new JTextField();
    JTextField fieldSecondLastName = new JTextField();
    JTextField fieldCel = new JTextField();
    JTextField fieldEmail = new JTextField();
    JPasswordField fieldPass = new JPasswordField();
    JPasswordField fieldConfirmPass = new JPasswordField();

    JComboBox tipoRol = new JComboBox();
    
    ButtonGroup TipIdentificacion = new ButtonGroup();
    JRadioButton cc=new JRadioButton("C.C",true);
    JRadioButton ct=new JRadioButton("C.T",false);
    JRadioButton ti=new JRadioButton("T.I",false);

    private final int x = 1000;
    private final int y = 900;

    public CrearUsuarioView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        mainPanel.setSize(x, y);
        mainPanel.setLocation(0, 0);
        mainPanel.setLayout(null);

        PanelLogo.setSize(x, 100);
        PanelLogo.setLocation(0, 0);
        PanelLogo.setLayout(null);
        PanelLogo.setBackground(Color.orange);
        
        labelTitulo.setText("Registro de Usuario");
        labelTitulo.setLocation(30, 25);
        labelTitulo.setSize(850,55);
        labelTitulo.setForeground(Color.white);
        labelTitulo.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 45));
        
        message.setText("*Obligatorio");
        message.setLocation(30, 110);
        message.setSize(250,30);
        message.setForeground(Color.red);
        message.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        labelName.setText("Primer Nombre");
        labelName.setLocation(30, 150);
        labelName.setSize(250,30);
        labelName.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        fieldName.setLocation(30,190);
        fieldName.setSize(200,30);
        fieldName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        labelSecondName.setText("Segundo Nombre");
        labelSecondName.setLocation(260, 150);
        labelSecondName.setSize(250,30);
        labelSecondName.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        fieldSecondName.setLocation(260,190);
        fieldSecondName.setSize(200,30);
        fieldSecondName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        labelLastName.setText("Primer Apellido");
        labelLastName.setLocation(30, 230);
        labelLastName.setSize(250,30);
        labelLastName.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        fieldLastName.setLocation(30,270);
        fieldLastName.setSize(200,30);
        fieldLastName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        labelSecondLastName.setText("Segundo Apellido");
        labelSecondLastName.setLocation(260, 230);
        labelSecondLastName.setSize(250,30);
        labelSecondLastName.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        fieldSecondLastName.setLocation(260,270);
        fieldSecondLastName.setSize(200,30);
        fieldSecondLastName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        labelnumIdentificacion.setText("N° Identificacion");
        labelnumIdentificacion.setLocation(30, 315);
        labelnumIdentificacion.setSize(250,30);
        labelnumIdentificacion.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        fieldnumIdentificacion.setLocation(30,355);
        fieldnumIdentificacion.setSize(200,30);
        fieldnumIdentificacion.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        labelTipoIdentificacion.setText("Tipo Identificacion");
        labelTipoIdentificacion.setLocation(260, 315);
        labelTipoIdentificacion.setSize(250,30);
        labelTipoIdentificacion.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
        
        
        
        cc.setLocation(260,355);
        cc.setSize(60,30);
        cc.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        ct.setLocation(320,355);
        ct.setSize(60,30);
        ct.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        ti.setLocation(380,355);
        ti.setSize(60,30);
        ti.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
        
        TipIdentificacion.add(cc);
        TipIdentificacion.add(ct);
        TipIdentificacion.add(ti);
        
        close.setSize(20, 20);
        close.setLocation(960, 20);
        ImageIcon imageclose = new ImageIcon(getClass().getResource("/imagenes/Cerrar.png"));
        Icon iconclose = new ImageIcon(imageclose.getImage().getScaledInstance(close.getWidth(), close.getHeight(), Image.SCALE_DEFAULT));
        close.setIcon(iconclose);
        close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        close.addMouseListener(this);
        
        logoRegisto.setSize(400, 400);
        logoRegisto.setLocation(550, 130);
        ImageIcon imagelogoRegisto = new ImageIcon(getClass().getResource("/imagenes/Registro.png"));
        Icon iconlogoRegisto = new ImageIcon(imagelogoRegisto.getImage().getScaledInstance(logoRegisto.getWidth(), logoRegisto.getHeight(), Image.SCALE_DEFAULT));
        logoRegisto.setIcon(iconlogoRegisto);
        logoRegisto.addMouseListener(this);

        minimize.setSize(20, 20);
        minimize.setLocation(930, 20);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/minimizar.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(minimize.getWidth(), minimize.getHeight(), Image.SCALE_DEFAULT));
        minimize.setIcon(iconminimize);
        minimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimize.addMouseListener(this);
       
        
        mainPanel.add(ti);
        mainPanel.add(ct);
        mainPanel.add(cc);
        mainPanel.add(labelTipoIdentificacion);
        mainPanel.add(fieldnumIdentificacion);
        mainPanel.add(labelnumIdentificacion);
        mainPanel.add(fieldSecondLastName);
        mainPanel.add(labelSecondLastName);
        mainPanel.add(fieldLastName);
        mainPanel.add(labelLastName);
        mainPanel.add(fieldSecondName);
        mainPanel.add(labelSecondName);
        mainPanel.add(fieldName);
        mainPanel.add(message);
        mainPanel.add(labelName);
        mainPanel.add(logoRegisto);
        PanelLogo.add(labelTitulo);
        PanelLogo.add(close);
        PanelLogo.add(minimize);
        mainPanel.add(PanelLogo);
        contenedor.add(mainPanel);

        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == minimize) {
            setState(LoginView.ICONIFIED);
        }
        if (me.getSource() == close) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    public static void main(String[] args) {

        CrearUsuarioView view = new CrearUsuarioView();
    }

}
