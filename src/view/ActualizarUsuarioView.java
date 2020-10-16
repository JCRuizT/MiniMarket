/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import static java.awt.Color.orange;
import static java.awt.Color.red;
import static java.awt.Color.white;
import static java.awt.Cursor.HAND_CURSOR;
import static java.awt.Font.BOLD;
import static java.awt.Font.CENTER_BASELINE;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author quihu
 */
public class ActualizarUsuarioView extends JFrame {
    
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
    JLabel campOblig = new JLabel();
    JLabel campOblig2 = new JLabel();
    JLabel campOblig3 = new JLabel();
    JLabel campOblig4 = new JLabel();
    JLabel campOblig5 = new JLabel();
    JLabel campOblig6 = new JLabel();
  
    JLabel minimize = new JLabel();
    JLabel close = new JLabel();
    JLabel logoRegisto = new JLabel();

    JNumberField fieldnumIdentificacion = new JNumberField();
    JTextField fieldName = new JTextField();
    JTextField fieldSecondName = new JTextField();
    JTextField fieldLastName = new JTextField();
    JTextField fieldSecondLastName = new JTextField();
    JNumberField fieldCel = new JNumberField();
    JTextField fieldEmail = new JTextField();
    JPasswordField fieldPass = new JPasswordField();
    JPasswordField fieldConfirmPass = new JPasswordField();

    JComboBox tipoRol = new JComboBox();
    JComboBox estado = new JComboBox();
    
    ButtonGroup TipIdentificacion = new ButtonGroup();
    JRadioButton cc=new JRadioButton("C.C",true);
    JRadioButton ct=new JRadioButton("C.T",false);
    JRadioButton ti=new JRadioButton("T.I",false);
    
    JButton guardar = new JButton();
    JButton cancelar = new JButton();

    private final int x = 1000;
    private final int y = 740;
    
    
    public ActualizarUsuarioView(){
        
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
        PanelLogo.setBackground(orange);
        
        labelTitulo.setText("Actualizar Usuario");
        labelTitulo.setLocation(30, 25);
        labelTitulo.setSize(850,55);
        labelTitulo.setForeground(white);
        labelTitulo.setFont(new Font("Arial Black", CENTER_BASELINE, 45));
        
        message.setText("*Obligatorio");
        message.setLocation(30, 110);
        message.setSize(250,30);
        message.setForeground(red);
        message.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        labelName.setText("Primer Nombre");
        labelName.setLocation(30, 150);
        labelName.setSize(250,30);
        labelName.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        campOblig.setText("*");
        campOblig.setLocation(180, 150);
        campOblig.setSize(250,30);
        campOblig.setForeground(red);
        campOblig.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        fieldName.setLocation(30,190);
        fieldName.setSize(200,30);
        fieldName.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        labelSecondName.setText("Segundo Nombre");
        labelSecondName.setLocation(260, 150);
        labelSecondName.setSize(250,30);
        labelSecondName.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        fieldSecondName.setLocation(260,190);
        fieldSecondName.setSize(200,30);
        fieldSecondName.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        labelLastName.setText("Primer Apellido");
        labelLastName.setLocation(30, 230);
        labelLastName.setSize(250,30);
        labelLastName.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        fieldLastName.setLocation(30,270);
        fieldLastName.setSize(200,30);
        fieldLastName.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        labelSecondLastName.setText("Segundo Apellido");
        labelSecondLastName.setLocation(260, 230);
        labelSecondLastName.setSize(250,30);
        labelSecondLastName.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        campOblig2.setText("*");
        campOblig2.setLocation(180, 230);
        campOblig2.setSize(250,30);
        campOblig2.setForeground(red);
        campOblig2.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        fieldSecondLastName.setLocation(260,270);
        fieldSecondLastName.setSize(200,30);
        fieldSecondLastName.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        labelnumIdentificacion.setText("N° Identificacion");
        labelnumIdentificacion.setLocation(30, 315);
        labelnumIdentificacion.setSize(250,30);
        labelnumIdentificacion.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        campOblig3.setText("*");
        campOblig3.setLocation(192, 315);
        campOblig3.setSize(250,30);
        campOblig3.setForeground(red);
        campOblig3.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        fieldnumIdentificacion.setLocation(30,355);
        fieldnumIdentificacion.setSize(200,30);
        fieldnumIdentificacion.setFont(new Font("Segoe UI Light", BOLD, 20));
        fieldnumIdentificacion.setEditable(false);
        
        labelTipoIdentificacion.setText("Tipo Identificacion");
        labelTipoIdentificacion.setLocation(260, 315);
        labelTipoIdentificacion.setSize(250,30);
        labelTipoIdentificacion.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20)); 
        
        campOblig4.setText("*");
        campOblig4.setLocation(439, 315);
        campOblig4.setSize(250,30);
        campOblig4.setForeground(red);
        campOblig4.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        cc.setLocation(260,355);
        cc.setSize(60,30);
        cc.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        ct.setLocation(320,355);
        ct.setSize(60,30);
        ct.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        ti.setLocation(380,355);
        ti.setSize(60,30);
        ti.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        TipIdentificacion.add(cc);
        TipIdentificacion.add(ct);
        TipIdentificacion.add(ti);
        
        tipoRol.setLocation(30, 420);
        tipoRol.setSize(200,30);
        tipoRol.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
	tipoRol.addItem("Tipo de Usuario");
        tipoRol.addItem("Administrador");
        tipoRol.addItem("Vendedor");
        tipoRol.addItem("Cliente");
        
        estado.setLocation(260, 420);
        estado.setSize(200,30);
        estado.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
	estado.addItem("Estado de Usuario");
        estado.addItem("Activo");
        estado.addItem("Inativo");
        
        campOblig5.setText("*");
        campOblig5.setLocation(235, 410);
        campOblig5.setSize(250,30);
        campOblig5.setForeground(red);
        campOblig5.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        labelEmail.setText("Correo");
        labelEmail.setLocation(30, 470);
        labelEmail.setSize(250,30);
        labelEmail.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        fieldEmail.setLocation(30,510);
        fieldEmail.setSize(200,30);
        fieldEmail.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        labelCel.setText("Numero Celular");
        labelCel.setLocation(260, 470);
        labelCel.setSize(250,30);
        labelCel.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20)); 
        
        fieldCel.setLocation(260,510);
        fieldCel.setSize(200,30);
        fieldCel.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        labelPass.setText("Antigua Contraseña");
        labelPass.setLocation(30, 550);
        labelPass.setSize(250,30);
        labelPass.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        campOblig6.setText("*");
        campOblig6.setLocation(220, 550);
        campOblig6.setSize(250,30);
        campOblig6.setForeground(red);
        campOblig6.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        
        fieldPass.setLocation(30,590);
        fieldPass.setSize(200,30);
        fieldPass.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        labelConfirmPass.setText("Nueva Contraseña");
        labelConfirmPass.setLocation(260, 550);
        labelConfirmPass.setSize(250,30);
        labelConfirmPass.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20)); 
        
        fieldConfirmPass.setLocation(260,590);
        fieldConfirmPass.setSize(200,30);
        fieldConfirmPass.setFont(new Font("Segoe UI Light", BOLD, 20));
        
        guardar.setText("Guardar Cambios");
        guardar.setLocation(30, 650);
        guardar.setSize(430,30);
        guardar.setBackground(orange);
        guardar.setForeground(white);
        guardar.setFocusable(false);
        guardar.setBorder(null);
        guardar.setFont(new Font("Arial", BOLD, 20));
        guardar.setHorizontalAlignment(CENTER);
        
        cancelar.setText("Cancelar");
        cancelar.setLocation(30, 690);
        cancelar.setSize(430,30);
        cancelar.setBackground(orange);
        cancelar.setForeground(white);
        cancelar.setFocusable(false);
        cancelar.setBorder(null);
        cancelar.setFont(new Font("Arial", BOLD, 20));
        cancelar.setHorizontalAlignment(CENTER);
      
       
        close.setSize(20, 20);
        close.setLocation(960, 20);
        ImageIcon imageclose = new ImageIcon(getClass().getResource("/imagenes/Cerrar.png"));
        Icon iconclose = new ImageIcon(imageclose.getImage().getScaledInstance(close.getWidth(), close.getHeight(), SCALE_DEFAULT));
        close.setIcon(iconclose);
        close.setCursor(new Cursor(HAND_CURSOR));
        
        logoRegisto.setSize(500, 500);
        logoRegisto.setLocation(480, 150);
        ImageIcon imagelogoRegisto = new ImageIcon(getClass().getResource("/imagenes/update.png"));
        Icon iconlogoRegisto = new ImageIcon(imagelogoRegisto.getImage().getScaledInstance(logoRegisto.getWidth(), logoRegisto.getHeight(), SCALE_DEFAULT));
        logoRegisto.setIcon(iconlogoRegisto);

        minimize.setSize(20, 20);
        minimize.setLocation(930, 20);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/minimizar.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(minimize.getWidth(), minimize.getHeight(), SCALE_DEFAULT));
        minimize.setIcon(iconminimize);
        minimize.setCursor(new Cursor(HAND_CURSOR));
       
        mainPanel.add(estado);
        mainPanel.add(cancelar);
        mainPanel.add(guardar);
        mainPanel.add(campOblig6);
        mainPanel.add(campOblig5);
        mainPanel.add(campOblig4);
        mainPanel.add(campOblig3);
        mainPanel.add(campOblig2);
        mainPanel.add(campOblig);
        mainPanel.add(fieldConfirmPass);
        mainPanel.add(labelConfirmPass);
        mainPanel.add(fieldPass);
        mainPanel.add(labelPass);
        mainPanel.add(fieldCel);
        mainPanel.add(labelCel);
        mainPanel.add(fieldEmail);
        mainPanel.add(labelEmail);
        mainPanel.add(tipoRol);
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

    public JPasswordField getFieldConfirmPass() {
        return fieldConfirmPass;
    }

    public JNumberField getFieldnumIdentificacion() {
        return fieldnumIdentificacion;
    }

    public JTextField getFieldName() {
        return fieldName;
    }

    public JTextField getFieldSecondName() {
        return fieldSecondName;
    }

    public JTextField getFieldLastName() {
        return fieldLastName;
    }

    public JTextField getFieldSecondLastName() {
        return fieldSecondLastName;
    }

    public JNumberField getFieldCel() {
        return fieldCel;
    }

    public JTextField getFieldEmail() {
        return fieldEmail;
    }

    public JPasswordField getFieldPass() {
        return fieldPass;
    }

    public JComboBox getTipoRol() {
        return tipoRol;
    }

    public JComboBox getEstado() {
        return estado;
    }

    public ButtonGroup getTipIdentificacion() {
        return TipIdentificacion;
    }

    public JRadioButton getCc() {
        return cc;
    }

    public JRadioButton getCt() {
        return ct;
    }

    public JRadioButton getTi() {
        return ti;
    }

    
    //set

    public void setFieldnumIdentificacion(JNumberField fieldnumIdentificacion) {
        this.fieldnumIdentificacion = fieldnumIdentificacion;
    }

    public void setFieldName(JTextField fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldSecondName(JTextField fieldSecondName) {
        this.fieldSecondName = fieldSecondName;
    }

    public void setFieldLastName(JTextField fieldLastName) {
        this.fieldLastName = fieldLastName;
    }

    public void setFieldSecondLastName(JTextField fieldSecondLastName) {
        this.fieldSecondLastName = fieldSecondLastName;
    }

    public void setFieldCel(JNumberField fieldCel) {
        this.fieldCel = fieldCel;
    }

    public void setFieldEmail(JTextField fieldEmail) {
        this.fieldEmail = fieldEmail;
    }

    public void setFieldPass(JPasswordField fieldPass) {
        this.fieldPass = fieldPass;
    }

    public void setFieldConfirmPass(JPasswordField fieldConfirmPass) {
        this.fieldConfirmPass = fieldConfirmPass;
    }

    public void setTipoRol(JComboBox tipoRol) {
        this.tipoRol = tipoRol;
    }

    public void setEstado(JComboBox estado) {
        this.estado = estado;
    }

    public void setTipIdentificacion(ButtonGroup TipIdentificacion) {
        this.TipIdentificacion = TipIdentificacion;
    }

    public void setCc(JRadioButton cc) {
        this.cc = cc;
    }

    public void setCt(JRadioButton ct) {
        this.ct = ct;
    }

    public void setTi(JRadioButton ti) {
        this.ti = ti;
    }

    public void setGuardar(JButton guardar) {
        this.guardar = guardar;
    }
    
     public JButton getGuardar() {
        return guardar;
    }

    public JLabel getMinimize() {
        return minimize;
    }

    public JLabel getClose() {
        return close;
    }

    public JButton getCancelar() {
        return cancelar;
    }
    
    
    
    
    
     public static void main(String[] args) {

        ActualizarUsuarioView view = new ActualizarUsuarioView();
    }
    
}
