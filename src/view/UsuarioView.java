/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static java.awt.Color.orange;
import static java.awt.Color.white;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.CENTER_BASELINE;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import model.Table.Usuario;

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

    public UsuarioView(ArrayList<Usuario> result) {

        setSize(x, y);
        setLayout(null);

        title.setText("Gestionar Usuarios");
        title.setLocation(150, 120);
        title.setSize(850, 40);
        title.setForeground(orange);
        title.setFont(new Font("Arial Black", CENTER_BASELINE, 35));
        title.setHorizontalAlignment(CENTER);

        String columns[] = {"id", "TipoIdentificacion","Identificación", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Celular", "Correo", "Rol","Estado"};
        tableList = new JTableComponent(columns);

        tableList.getScrollTable().setLocation(360, 250);
        tableList.getScrollTable().setSize(1000, 500);
        
        for(int i=0; i<result.size();i++){
            Object rs[] = {
                result.get(i),
                result.get(i).getTipNombre(),
                result.get(i).getUsuIdentificacion(),
                result.get(i).getUsuNombre1(),
                result.get(i).getUsuNombre2(),
                result.get(i).getUsuApellido1(),
                result.get(i).getUsuApellido2(),
                result.get(i).getUsuCelular(),
                result.get(i).getUsuCorreo(),
                result.get(i).getRolNombre(),
                result.get(i).getEstEstado()
                
                
            };
            tableList.getModel().addRow(rs);
        }

        buttonCreateUsuario = new JButton("Crear Usuario");
        buttonCreateUsuario.setLocation(360, 800);
        buttonCreateUsuario.setSize(230, 30);
        buttonCreateUsuario.setBackground(orange);
        buttonCreateUsuario.setForeground(white);
        buttonCreateUsuario.setFocusable(false);
        buttonCreateUsuario.setBorder(null);
        buttonCreateUsuario.setFont(new Font("Arial", BOLD, 15));

        buttonUpdateUsuario.setText("Actualizar Categoria");
        buttonUpdateUsuario.setLocation(600, 800);
        buttonUpdateUsuario.setSize(230, 30);
        buttonUpdateUsuario.setBackground(orange);
        buttonUpdateUsuario.setForeground(white);
        buttonUpdateUsuario.setFocusable(false);
        buttonUpdateUsuario.setBorder(null);
        buttonUpdateUsuario.setFont(new Font("Arial", BOLD, 15));

        buttonDeleteUsuario.setText("Eliminar Categoria");
        buttonDeleteUsuario.setLocation(890, 800);
        buttonDeleteUsuario.setSize(230, 30);
        buttonDeleteUsuario.setBackground(orange);
        buttonDeleteUsuario.setForeground(white);
        buttonDeleteUsuario.setFocusable(false);
        buttonDeleteUsuario.setBorder(null);
        buttonDeleteUsuario.setFont(new Font("Arial", BOLD, 15));

        buttonCancelUsuario.setText("Cancelar");
        buttonCancelUsuario.setLocation(1130, 800);
        buttonCancelUsuario.setSize(230, 30);
        buttonCancelUsuario.setBackground(orange);
        buttonCancelUsuario.setForeground(white);
        buttonCancelUsuario.setFocusable(false);
        buttonCancelUsuario.setBorder(null);
        buttonCancelUsuario.setFont(new Font("Arial", BOLD, 15));
        //buttonCancelCategory.setEnabled(false);
        //buttonCancelCategory.setVisible(false);

        FiltroRol.setLocation(1030, 200);
        FiltroRol.setSize(320, 30);
        FiltroRol.setFont(new Font("Segoe UI Light", CENTER_BASELINE, 20));
        FiltroRol.addItem("Tipo de usuario");
        FiltroRol.addItem("Administrador");
        FiltroRol.addItem("Vendedor");
        FiltroRol.addItem("Cliente");

        LabelFiltro.setLocation(950, 195);
        LabelFiltro.setSize(300, 40);
        LabelFiltro.setFont(new Font("Arial", BOLD, 20));
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

    public JButton getButtonDeleteUsuario() {
        return buttonDeleteUsuario;
    }

    public JButton getButtonUpdateUsuario() {
        return buttonUpdateUsuario;
    }

    public JButton getButtonCancelUsuario() {
        return buttonCancelUsuario;
    }

    public JTableComponent getTableList() {
        return tableList;
    }
    

}
