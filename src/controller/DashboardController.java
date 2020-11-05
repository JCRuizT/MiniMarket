
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Table.Usuario;
import view.CerrarSesionView;
import view.DashboardView;

/**
 *
 * @author quihu
 */
public class DashboardController implements MouseListener {

    private int NumClick = 0;

    private DashboardView vista;
    private CategoryController controllerCreateCategory;
    private ProductController ControllerProduc;
    private UsuarioController usuarioController;
    private HacerPedidoController vistaPedido;
    private Usuario logged;
    private CerrarSesionView vistaCerrar;
    private static Usuario userInfo;

    public DashboardController(Usuario logged) {

        this.logged = logged;
        userInfo = logged;

        vista = new DashboardView();
        vista.setLabelRol(this.logged.getRolNombre());
        vista.setLabelNameUser(this.logged.getUsuNombre1() + " " + this.logged.getUsuApellido1());
        controllerCreateCategory = new CategoryController();
        ControllerProduc = new ProductController();
        usuarioController = new UsuarioController(vista);
        vistaPedido = new HacerPedidoController(vista);
        vistaCerrar = new CerrarSesionView();

        vista.getPicCrearCateg().addMouseListener(this);
        vista.getLabelCrearCateg().addMouseListener(this);
        vista.getPicCrearProduc().addMouseListener(this);
        vista.getLabelCrearProd().addMouseListener(this);
        vista.getPicCrearUsu().addMouseListener(this);
        vista.getLabelCrearUsu().addMouseListener(this);
        vista.getLabelHacerPedido().addMouseListener(this);
        vista.getPicHacerPedido().addMouseListener(this);
        vista.getPicAdmin().addMouseListener(this);

    }

    /* solo para desarrollo eliminar en version final */
    public DashboardController() {
        vista = new DashboardView();
        controllerCreateCategory = new CategoryController();
        ControllerProduc = new ProductController();
        usuarioController = new UsuarioController(vista);
        vistaPedido = new HacerPedidoController(vista);
        vistaCerrar = new CerrarSesionView();

        vista.getPicCrearCateg().addMouseListener(this);
        vista.getLabelCrearCateg().addMouseListener(this);
        vista.getPicCrearProduc().addMouseListener(this);
        vista.getLabelCrearProd().addMouseListener(this);
        vista.getPicCrearUsu().addMouseListener(this);
        vista.getLabelCrearUsu().addMouseListener(this);
        vista.getLabelHacerPedido().addMouseListener(this);
        vista.getPicHacerPedido().addMouseListener(this);
        vista.getPicAdmin().addMouseListener(this);

    }

    /*-----------------------------------------------*/
    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getSource() == vista.getPicAdmin()) {

            if (NumClick == 0) {

                vista.getCerrar().add(vistaCerrar);

                vistaCerrar.repaint();
                vistaCerrar.validate();
                vistaCerrar.invalidate();
                
                NumClick = 1;

            }else if(NumClick == 1){
                
                vista.getCerrar().remove(vistaCerrar);
                
                vista.repaint();
                vista.validate();
                vista.invalidate();
                
                 NumClick = 0;
                
            }

        }

        if (me.getSource() == vista.getPicCrearCateg() || me.getSource() == vista.getLabelCrearCateg()) {

            vista.getPagPrincipal().remove(usuarioController.getVista());
            vista.getPagPrincipal().remove(ControllerProduc.getVista());
            vista.getPagPrincipal().remove(vistaPedido.getVista());

            vista.getPagPrincipal().add(controllerCreateCategory.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

            controllerCreateCategory.getVista().setLocation(370, 120);

        }

        if (me.getSource() == vista.getPicCrearProduc() || me.getSource() == vista.getLabelCrearProd()) {

            vista.getPagPrincipal().remove(usuarioController.getVista());
            vista.getPagPrincipal().remove(controllerCreateCategory.getVista());
            vista.getPagPrincipal().remove(vistaPedido.getVista());

            vista.getPagPrincipal().add(ControllerProduc.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

            ControllerProduc.getVista().setLocation(370, 120);
        }

        if (me.getSource() == vista.getPicCrearUsu() || me.getSource() == vista.getLabelCrearUsu()) {

            vista.getPagPrincipal().remove(controllerCreateCategory.getVista());
            vista.getPagPrincipal().remove(ControllerProduc.getVista());
            vista.getPagPrincipal().remove(vistaPedido.getVista());

            vista.getPagPrincipal().add(usuarioController.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

        }

        if (me.getSource() == vista.getPicHacerPedido() || me.getSource() == vista.getLabelHacerPedido()) {

            vista.getPagPrincipal().remove(controllerCreateCategory.getVista());
            vista.getPagPrincipal().remove(ControllerProduc.getVista());
            vista.getPagPrincipal().remove(usuarioController.getVista());

            vista.getPagPrincipal().add(vistaPedido.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

            vistaPedido.getVista().setLocation(370, 120);

        }

    }

    public static Usuario getUserInfo() {
        return userInfo;
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
        DashboardController app = new DashboardController();
    }

}
