/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.String.valueOf;
import javax.swing.JTextField;

/**
 *
 * @author pc-standard
 */
public class JNumberField extends JTextField implements KeyListener {

    public JNumberField() {
        super();
        super.addKeyListener(this);

    }

    public void validateNumber(KeyEvent e) {
        String txt = valueOf(e.getKeyChar());
        if (!(txt.equals("0") || txt.equals("1") || txt.equals("2") || txt.equals("3")
                || txt.equals("4") || txt.equals("5") || txt.equals("6") || txt.equals("7")
                || txt.equals("8") || txt.equals("9") || e.getKeyCode() == 8)) {

            e.consume();

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        validateNumber(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        validateNumber(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        validateNumber(e);
    }

}