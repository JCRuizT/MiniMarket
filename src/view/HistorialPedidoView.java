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
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import model.Table.Usuario;

/**
 *
 * @author quihu
 */
public class HistorialPedidoView extends JPanel {
    
    private JTableComponent tableList;

    JLabel LabelFiltro = new JLabel();

    private JTableSearch fieldSearch;

    JLabel title = new JLabel();

    private final int x = 1500;
    private final int y = 1500;

    public HistorialPedidoView(/*ArrayList<Usuario> result*/) {

        setSize(x, y);
        setLayout(null);

        title.setText("Historial de pedidos");
        title.setLocation(150, 120);
        title.setSize(850, 40);
        title.setForeground(orange);
        title.setFont(new Font("Arial Black", CENTER_BASELINE, 35));
        title.setHorizontalAlignment(CENTER);

        String columns[] = {"id", "N° Factura", "Identificación", "Primer Nombre","Primer Apellido", "Fecha", "Total"};
        tableList = new JTableComponent(columns);
       // tableList.getTable().getColumnModel().getColumn(1).setMaxWidth(40);
        

        tableList.getScrollTable().setLocation(360, 250);
        tableList.getScrollTable().setSize(1000, 500);

        /*for (int i = 0; i < result.size(); i++) {
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

        */

        fieldSearch = new JTableSearch(tableList.getTable());
        fieldSearch.setLocation(1040, 200);
        fieldSearch.setSize(310, 30);
        fieldSearch.setFont(new Font("Segoe UI Light", BOLD, 20));

        /*
        tableList.centerData(1);
        tableList.centerData(9);
        tableList.centerData(7);
        tableList.centerData(10);
        */

        LabelFiltro.setLocation(950, 195);
        LabelFiltro.setSize(300, 40);
        LabelFiltro.setFont(new Font("Arial", BOLD, 20));
        LabelFiltro.setText("Buscar :");

        add(LabelFiltro);
        add(fieldSearch);
        add(tableList.getScrollTable());
        add(title);
    }
    
    
    
}
