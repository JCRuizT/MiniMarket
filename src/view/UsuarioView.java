/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author quihu
 */
public class UsuarioView extends JPanel {

    private JTableComponent tableList;
    
    JComboBox FiltroRol = new JComboBox();
    
    JLabel LabelFiltro = new JLabel();

    JButton buttonCreateUsuario = new JButton();
    JButton buttonDeleteUsuario = new JButton();
    JButton buttonUpdateUsuario = new JButton();
    JButton buttonCancelUsuario = new JButton();

    JLabel title = new JLabel();

    private final int x = 1500;
    private final int y = 1500;

    public UsuarioView() {

        setSize(x, y);
        setLayout(null);

        title.setText("Gestionar Usuarios");
        title.setLocation(150, 120);
        title.setSize(850, 40);
        title.setForeground(Color.orange);
        title.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 35));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        String columns[] = {"id", "Identificación", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Celular", "Correo", "Rol"};
        tableList = new JTableComponent(columns);

        tableList.getScrollTable().setLocation(360, 250);
        tableList.getScrollTable().setSize(1000, 500);
        tableList.getTable().getColumnModel().getColumn(0).setMaxWidth(0);
        tableList.getTable().getColumnModel().getColumn(0).setMinWidth(0);
        tableList.getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
        tableList.getTable().getTableHeader().setResizingAllowed(false);

        buttonCreateUsuario = new JButton("Crear Usuario");
        buttonCreateUsuario.setLocation(360, 800);
        buttonCreateUsuario.setSize(230, 30);
        buttonCreateUsuario.setBackground(Color.orange);
        buttonCreateUsuario.setForeground(Color.white);
        buttonCreateUsuario.setFocusable(false);
        buttonCreateUsuario.setBorder(null);
        buttonCreateUsuario.setFont(new Font("Arial", Font.BOLD, 15));

        buttonUpdateUsuario.setText("Actualizar Categoria");
        buttonUpdateUsuario.setLocation(600, 800);
        buttonUpdateUsuario.setSize(230, 30);
        buttonUpdateUsuario.setBackground(Color.orange);
        buttonUpdateUsuario.setForeground(Color.white);
        buttonUpdateUsuario.setFocusable(false);
        buttonUpdateUsuario.setBorder(null);
        buttonUpdateUsuario.setFont(new Font("Arial", Font.BOLD, 15));

        buttonDeleteUsuario.setText("Eliminar Categoria");
        buttonDeleteUsuario.setLocation(890, 800);
        buttonDeleteUsuario.setSize(230, 30);
        buttonDeleteUsuario.setBackground(Color.orange);
        buttonDeleteUsuario.setForeground(Color.white);
        buttonDeleteUsuario.setFocusable(false);
        buttonDeleteUsuario.setBorder(null);
        buttonDeleteUsuario.setFont(new Font("Arial", Font.BOLD, 15));

        buttonCancelUsuario.setText("Cancelar");
        buttonCancelUsuario.setLocation(1130, 800);
        buttonCancelUsuario.setSize(230, 30);
        buttonCancelUsuario.setBackground(Color.orange);
        buttonCancelUsuario.setForeground(Color.white);
        buttonCancelUsuario.setFocusable(false);
        buttonCancelUsuario.setBorder(null);
        buttonCancelUsuario.setFont(new Font("Arial", Font.BOLD, 15));
        //buttonCancelCategory.setEnabled(false);
        //buttonCancelCategory.setVisible(false);
        
        FiltroRol.setLocation(1030, 200);
        FiltroRol.setSize(320,30);
        FiltroRol.setFont(new Font("Segoe UI Light", Font.CENTER_BASELINE, 20));
	FiltroRol.addItem("Tipo de usuario");
        FiltroRol.addItem("Administrador");
        FiltroRol.addItem("Vendedor");
        FiltroRol.addItem("Cliente");
          
        LabelFiltro.setLocation(950, 195);
        LabelFiltro.setSize(300, 40);
        LabelFiltro.setFont(new Font("Arial", Font.BOLD, 20));
        LabelFiltro.setText("Filtro :");

        add(LabelFiltro);
        add(FiltroRol);
        add(buttonUpdateUsuario);
        add(buttonDeleteUsuario);
        add(buttonCreateUsuario);
        add(buttonCancelUsuario);
        add(tableList.getScrollTable());
        add(title);
    }

    public JButton getButtonCreateUsuario() {
        return buttonCreateUsuario;
    }
    
    
}