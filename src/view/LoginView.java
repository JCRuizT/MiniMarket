/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;
import static java.awt.Color.orange;
import static java.awt.Color.red;
import static java.awt.Cursor.HAND_CURSOR;
import static java.awt.Font.BOLD;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.*;
import static java.lang.System.exit;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;

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
    JLabel title = new JLabel();
    JLabel labelUser = new JLabel("Numero de cedula");
    JLabel labelPass = new JLabel("Contraseña");
    JLabel labelError = new JLabel();
    JLabel minimize = new JLabel();
    JLabel close = new JLabel();
    //JLabel buttonSubmit = new JLabel();
    //CAJA DE TEXTO

    JNumberField fieldUser = new JNumberField();
    JPasswordField fieldPass = new JPasswordField(10);

    //BOTONES
    JButton buttonSubmit = new JButton();



    //VARIAVLES
    private final int x = 1280;
    private final int y = 800;

    public LoginView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        //setUndecorated(true);

        //Diseño
        background.setSize(x, y);
        background.setLocation(0, 0);
        background.setLayout(null);

        fondobackground.setSize(x, y);
        fondobackground.setLocation(0, 0);
        ImageIcon imagefondobackground = new ImageIcon(getClass().getResource("/imagenes/fondoverduras.jpg"));
        Icon iconfondobackground = new ImageIcon(imagefondobackground.getImage().getScaledInstance(fondobackground.getWidth(), fondobackground.getHeight(), SCALE_DEFAULT));
        fondobackground.setIcon(iconfondobackground);

        logo.setSize(300, 400);
        logo.setLocation(100, 60);
        ImageIcon imagelogo = new ImageIcon(getClass().getResource("/imagenes/logo.png"));
        Icon iconlogo = new ImageIcon(imagelogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), SCALE_DEFAULT));
        logo.setIcon(iconlogo);

        mainPanel.setSize(400, 500);
        mainPanel.setLayout(null);
        mainPanel.setLocation(250, 145);
        mainPanel.setBackground(WHITE);

        mainPanelLogo.setSize(400, 500);
        mainPanelLogo.setLayout(null);
        mainPanelLogo.setLocation(650, 145);
        mainPanelLogo.setBackground(orange);
        
        //Titulotext
        title.setForeground(BLUE);
        title.setSize(300, 30);
        title.setLocation(75,60);
        title.setFont(new Font("Segoe UI Light", BOLD,20));
        title.setText("Mini Market - Inicio de sesion");

        //CedulaText
        labelUser.setForeground(BLACK);
        labelUser.setSize(300, 30);
        labelUser.setLocation(140, 160);
        labelUser.setFont(new Font("Segoe UI Light", BOLD, 15));

        //ContraseñaText       
        labelPass.setForeground(BLACK);
        labelPass.setSize(300, 30);
        labelPass.setLocation(165, 240);
        labelPass.setFont(new Font("Segoe UI Light", BOLD, 15));

        //Caja texto Cedula
        fieldUser.setSize(140, 30);
        fieldUser.setLocation(140, 200);
        fieldUser.setBorder(null);
        fieldUser.setBackground(new Color(239, 239, 239));
        fieldUser.setHorizontalAlignment(CENTER);

        //Caja texto Password
        fieldPass.setSize(140, 30);
        fieldPass.setLocation(140, 277);
        fieldPass.setBorder(null);
        fieldPass.setBackground(new Color(239, 239, 239));
        fieldPass.setHorizontalAlignment(CENTER);

        //Etiq Boton enviar
        buttonSubmit.setSize(100, 40);
        buttonSubmit.setLocation(160, 380);
        buttonSubmit.setText("Iniciar sesion");
        buttonSubmit.setBackground(new Color(239, 239, 239));
        buttonSubmit.setOpaque(true);
        buttonSubmit.setBackground(new Color(197, 197, 197));
        buttonSubmit.setCursor(new Cursor(HAND_CURSOR));
        buttonSubmit.setHorizontalAlignment(CENTER);
        buttonSubmit.setForeground(WHITE);
        buttonSubmit.addMouseListener(this);
        buttonSubmit.setFocusPainted(false);
        buttonSubmit.setBorder(null);

 
        //logo
        logo.setLocation(50, 60);
        logo.setSize(300, 400);
        
        //textError
        
        labelError.setSize(280, 30);
        labelError.setLocation(65, 330);
        labelError.setHorizontalAlignment(CENTER);
        labelError.setFont(new Font("Segoe UI Light", BOLD, 15));
        labelError.setForeground(red);
        
        
        close.setSize(20, 20);
        close.setLocation(1230, 20);
        ImageIcon imageclose = new ImageIcon(getClass().getResource("/imagenes/Cerrar.png"));
        Icon iconclose = new ImageIcon(imageclose.getImage().getScaledInstance(close.getWidth(), close.getHeight(), SCALE_DEFAULT));
        close.setIcon(iconclose);
        close.setCursor(new Cursor(HAND_CURSOR));
        close.addMouseListener(this);
        
        minimize.setSize(20, 20);
        minimize.setLocation(1200, 20);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/minimizar.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(minimize.getWidth(), minimize.getHeight(), SCALE_DEFAULT));
        minimize.setIcon(iconminimize);
        minimize.setCursor(new Cursor(HAND_CURSOR));
        minimize.addMouseListener(this);
        
        
        

        //Agregar
        
        background.add(minimize);
        background.add(close);
        mainPanel.add(labelError);
        mainPanelLogo.add(logo);
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
        if (me.getSource() == minimize) {
            setState(ICONIFIED);
        }
        if (me.getSource()==close){
            exit(0);
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

    
    public JButton getButtonSubmit(){
        return buttonSubmit;
    }
}
    



