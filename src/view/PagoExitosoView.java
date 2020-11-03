/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Container;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author quihu
 */
public class PagoExitosoView extends JFrame {

    Container contenedor = getContentPane();
    JPanel main = new JPanel();
    JPanel fondoT = new JPanel();

    JLabel PicPagoExitoso = new JLabel();
    JLabel fondo = new JLabel();

    JButton Ok = new JButton();

    private final int x = 1430;
    private final int y = 900;

    public PagoExitosoView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        fondoT.setSize(x, y);
        fondoT.setLocation(0, 0);
        fondoT.setLayout(null);

        main.setSize(800, 800);
        main.setLocation(300, 50);
        main.setLayout(null);
        main.setBackground(Color.orange);

        fondo.setSize(1430, 900);
        fondo.setLocation(0, 0);
        ImageIcon imageCrearCateg = new ImageIcon(getClass().getResource("/imagenes/fondoTransparente.png"));
        Icon iconCrearCateg = new ImageIcon(imageCrearCateg.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), SCALE_DEFAULT));
        fondo.setIcon(iconCrearCateg);

        PicPagoExitoso.setSize(600, 239);
        PicPagoExitoso.setLocation(100, 200);
        ImageIcon imageCrearProduc = new ImageIcon(getClass().getResource("/imagenes/PagoExitoso.png"));
        Icon iconCrearProduc = new ImageIcon(imageCrearProduc.getImage().getScaledInstance(PicPagoExitoso.getWidth(), PicPagoExitoso.getHeight(), SCALE_DEFAULT));
        PicPagoExitoso.setIcon(iconCrearProduc);

        Ok.setLocation(300, 550);
        Ok.setSize(200, 50);
        Ok.setBackground(Color.darkGray);
        Ok.setForeground(white);
        Ok.setFocusable(false);
        Ok.setBorder(null);
        Ok.setFont(new Font("Arial Black", BOLD, 30));
        Ok.setText("Aceptar");

        main.add(Ok);
        main.add(PicPagoExitoso);
        fondoT.add(main);
        fondoT.add(fondo);
        contenedor.add(fondoT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JButton getOk() {
        return Ok;
    }
    

    public static void main(String[] args) {
        PagoExitosoView dsd = new PagoExitosoView();
    }
}
