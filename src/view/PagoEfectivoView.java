/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import static java.awt.Color.orange;
import static java.awt.Color.white;
import java.awt.Container;
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
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author quihu
 */
public class PagoEfectivoView extends JFrame {

    Container contenedor = getContentPane();
    JPanel main = new JPanel();
    JPanel img = new JPanel();

    JLabel Labeltitulo2 = new JLabel();
    JLabel LabelPropietario = new JLabel();
    JLabel LabelNumTarjeta = new JLabel();
    JLabel LabelCVV = new JLabel();
    JLabel mujerpago = new JLabel();

    JButton pagar = new JButton();
    JButton cancelar = new JButton();

    JTextField FieldTotal = new JTextField();
    JTextField FieldRecibido = new JTextField();
    JTextField FieldCambio = new JTextField();

    private final int x = 1135;
    private final int y = 800;

    public PagoEfectivoView() {

        setSize(x, y);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        main.setSize(x, y);
        main.setLocation(0, 0);
        main.setLayout(null);

        img.setSize(500, 800);
        img.setLocation(0, 0);
        img.setLayout(null);
        img.setBackground(Color.ORANGE);

        Labeltitulo2.setSize(700, 50);
        Labeltitulo2.setLocation(660, 80);
        Labeltitulo2.setFont(new Font("Arial Black", BOLD, 32));
        Labeltitulo2.setText("Pago en efectivo");

        LabelPropietario.setSize(700, 50);
        LabelPropietario.setLocation(740, 220);
        LabelPropietario.setFont(new Font("Arial", BOLD, 23));
        LabelPropietario.setText("Total a pagar");

        FieldTotal.setSize(300, 40);
        FieldTotal.setLocation(670, 280);
        FieldTotal.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));
        FieldTotal.setEditable(false);
        FieldTotal.setText("$ 235.000");
        FieldTotal.setForeground(Color.red);
        FieldTotal.setHorizontalAlignment(JTextField.CENTER);
        

        LabelNumTarjeta.setSize(700, 50);
        LabelNumTarjeta.setLocation(765, 350);
        LabelNumTarjeta.setFont(new Font("Arial", BOLD, 23));
        LabelNumTarjeta.setText("Recibido");

        FieldRecibido.setSize(300, 40);
        FieldRecibido.setLocation(670, 410);
        FieldRecibido.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));
        FieldRecibido.setHorizontalAlignment(JTextField.CENTER);

        LabelCVV.setSize(200, 50);
        LabelCVV.setLocation(770, 480);
        LabelCVV.setFont(new Font("Arial", BOLD, 23));
        LabelCVV.setText("Cambio");

        FieldCambio.setSize(300, 40);
        FieldCambio.setLocation(670, 540);
        FieldCambio.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 23));
        FieldCambio.setText("$ 10.000");
        FieldCambio.setEditable(false);
        FieldCambio.setHorizontalAlignment(JTextField.CENTER);

        pagar.setLocation(825, 740);
        pagar.setSize(280, 40);
        pagar.setBackground(orange);
        pagar.setForeground(white);
        pagar.setFocusable(false);
        pagar.setBorder(null);
        pagar.setFont(new Font("Arial Black", BOLD, 20));
        pagar.setText("Pagar");

        cancelar.setLocation(520, 740);
        cancelar.setSize(280, 40);
        cancelar.setBackground(orange);
        cancelar.setForeground(white);
        cancelar.setFocusable(false);
        cancelar.setBorder(null);
        cancelar.setFont(new Font("Arial Black", BOLD, 20));
        cancelar.setText("Cancelar");

        mujerpago.setSize(500, 800);
        mujerpago.setLocation(0, 0);
        ImageIcon imageminimize = new ImageIcon(getClass().getResource("/imagenes/mujerEfectivo.png"));
        Icon iconminimize = new ImageIcon(imageminimize.getImage().getScaledInstance(mujerpago.getWidth(), mujerpago.getHeight(), SCALE_DEFAULT));
        mujerpago.setIcon(iconminimize);

        main.add(pagar);
        main.add(cancelar);
        main.add(FieldCambio);
        main.add(LabelCVV);
        main.add(FieldRecibido);
        main.add(LabelNumTarjeta);
        main.add(FieldTotal);
        main.add(LabelPropietario);
        main.add(Labeltitulo2);
        img.add(mujerpago);
        main.add(img);
        contenedor.add(main);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JButton getPagar() {
        return pagar;
    }

    public JButton getCancelar() {
        return cancelar;
    }
    
    

    public static void main(String[] args) {
        PagoEfectivoView payMoney = new PagoEfectivoView();
    }

}
