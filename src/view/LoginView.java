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
public class LoginView extends JFrame implements MouseListener{
    
    
    Container contenedor = getContentPane();

    //PANELES 
    JPanel background = new JPanel();
    JPanel mainPanelLogo = new JPanel();
    JPanel mainPanel = new JPanel();

    //ETIQUETAS 
    JLabel fondobackground = new JLabel();
    JLabel logo = new JLabel();
    JLabel title = new JLabel("Mini Market - Inicio de sesion");
    JLabel labelUser = new JLabel("Numero de cedula");
    JLabel labelPass = new JLabel("Contraseña");
    JLabel labelError = new JLabel();
    //JLabel buttonSubmit = new JLabel();
    //CAJA DE TEXTO

    JTextField fieldUser = new JTextField(10);
    JPasswordField fieldPass = new JPasswordField(10);

    //BOTONES
    JButton buttonSubmit = new JButton();

    //ComboBox
    JComboBox fieldRol = new JComboBox();

    //VARIAVLES
    private final int x = 1280;
    private final int y = 800;

    public LoginView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        //Diseño
        background.setSize(x, y);
        background.setLocation(0, 0);
        background.setLayout(null);

        fondobackground.setSize(x, y);
        fondobackground.setLocation(0, 0);
        ImageIcon imagefondobackground = new ImageIcon(getClass().getResource("/imagenes/fondoverduras.jpg"));
        Icon iconfondobackground = new ImageIcon(imagefondobackground.getImage().getScaledInstance(fondobackground.getWidth(), fondobackground.getHeight(), Image.SCALE_DEFAULT));
        fondobackground.setIcon(iconfondobackground);

        logo.setSize(300, 400);
        logo.setLocation(100, 60);
        ImageIcon imagelogo = new ImageIcon(getClass().getResource("/imagenes/logo.png"));
        Icon iconlogo = new ImageIcon(imagelogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(iconlogo);

        mainPanel.setSize(400, 500);
        mainPanel.setLayout(null);
        mainPanel.setLocation(250, 145);
        mainPanel.setBackground(Color.WHITE);

        mainPanelLogo.setSize(400, 500);
        mainPanelLogo.setLayout(null);
        mainPanelLogo.setLocation(650, 145);
        mainPanelLogo.setBackground(Color.orange);

        //Titulotext
        title.setForeground(Color.BLUE);
        title.setSize(300, 30);
        title.setLocation(65, 80);
        title.setFont(new Font("Segoe UI Light", Font.BOLD, 20));

        //CedulaText
        labelUser.setForeground(Color.BLACK);
        labelUser.setSize(300, 30);
        labelUser.setLocation(140, 140);
        labelUser.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

        //ContraseñaText       
        labelPass.setForeground(Color.BLACK);
        labelPass.setSize(300, 30);
        labelPass.setLocation(165, 220);
        labelPass.setFont(new Font("Segoe UI Light", Font.BOLD, 15));

        //Caja texto Cedula
        fieldUser.setSize(140, 30);
        fieldUser.setLocation(140, 180);
        fieldUser.setBorder(null);
        fieldUser.setBackground(new Color(239, 239, 239));
        fieldUser.setHorizontalAlignment(SwingConstants.CENTER);

        //Caja texto Password
        fieldPass.setSize(140, 30);
        fieldPass.setLocation(140, 250);
        fieldPass.setBorder(null);
        fieldPass.setBackground(new Color(239, 239, 239));
        fieldPass.setHorizontalAlignment(SwingConstants.CENTER);

        //Etiq Boton enviar
        buttonSubmit.setSize(100, 40);
        buttonSubmit.setLocation(155, 400);
        buttonSubmit.setText("Iniciar sesion");
        buttonSubmit.setBackground(new Color(239, 239, 239));
        buttonSubmit.setOpaque(true);
        buttonSubmit.setBackground(new Color(197, 197, 197));
        buttonSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonSubmit.setHorizontalAlignment(SwingConstants.CENTER);
        buttonSubmit.setForeground(Color.WHITE);
        buttonSubmit.addMouseListener(this);
        buttonSubmit.setFocusPainted(false);
        buttonSubmit.setBorder(null);

        //ComboBox
        fieldRol.setSize(140, 30);
        fieldRol.setLocation(140, 310);
        fieldRol.addItem("Seleccionar rol");
        fieldRol.addItem("Administrador");
        fieldRol.addItem("Vendedor");
        fieldRol.addItem("Cliente");

        //logo
        logo.setLocation(50, 60);
        logo.setSize(300, 400);
        
        //textError
        
        labelError.setSize(250, 30);
        labelError.setLocation(90, 350);
        labelError.setHorizontalAlignment(SwingConstants.CENTER);
        labelError.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
        labelError.setForeground(Color.red);
        

        //Agregar
        
        mainPanel.add(labelError);
        mainPanelLogo.add(logo);
        mainPanel.add(fieldRol);
        mainPanel.add(buttonSubmit);
        mainPanel.add(fieldPass);
        mainPanel.add(fieldUser);
        mainPanel.add(labelPass);
        mainPanel.add(labelUser);
        mainPanel.add(title);
        background.add(mainPanelLogo);
        background.add(mainPanel);
        background.add(fondobackground);
        contenedor.add(background);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    
       @Override
    public void mouseClicked(MouseEvent me) {
        if (buttonSubmit == buttonSubmit) {
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
      
    public void setLabelError(String labelError) {
        this.labelError.setText(labelError);
    }

    public JTextField getFieldUser() {
        return fieldUser;
    }

    public JPasswordField getFieldPass() {
        return fieldPass;
    }

    public JComboBox getFieldRol() {
        return fieldRol;
    }
    
    public JButton getButtonSubmit(){
        return buttonSubmit;
    }
}
    



