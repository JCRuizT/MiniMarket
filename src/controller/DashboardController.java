/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.DashboardView;

/**
 *
 * @author quihu
 */
public class DashboardController implements MouseListener {

    private DashboardView vista;
    private CategoryController controllerCreateCategory;
    private ProductController ControllerProduc;
    private UsuarioController usuarioController;

    public DashboardController() {

        vista = new DashboardView();
        controllerCreateCategory = new CategoryController();
        ControllerProduc = new ProductController();
        usuarioController = new UsuarioController(vista);
        
        vista.getPicCrearCateg().addMouseListener(this);
        vista.getLabelCrearCateg().addMouseListener(this);
        vista.getPicCrearProduc().addMouseListener(this);
        vista.getLabelCrearProd().addMouseListener(this);
        vista.getPicCrearUsu().addMouseListener(this);
        vista.getLabelCrearUsu().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if (me.getSource() == vista.getPicCrearCateg() || me.getSource() == vista.getLabelCrearCateg()) {

            vista.getPagPrincipal().remove(usuarioController.getVista());
            vista.getPagPrincipal().remove(ControllerProduc.getVista());

            vista.getPagPrincipal().add(controllerCreateCategory.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

            controllerCreateCategory.getVista().setLocation(500, 150);
        }

        if (me.getSource() == vista.getPicCrearProduc() || me.getSource() == vista.getLabelCrearProd()) {
             
            vista.getPagPrincipal().remove(usuarioController.getVista());
            vista.getPagPrincipal().remove(controllerCreateCategory.getVista());

            vista.getPagPrincipal().add(ControllerProduc.getVista());

            vista.invalidate();
            vista.validate();
            vista.repaint();

            ControllerProduc.getVista().setLocation(500, 150);
        }
        
        if (me.getSource() == vista.getPicCrearUsu() || me.getSource() == vista.getLabelCrearUsu()) {
            
            vista.getPagPrincipal().remove(controllerCreateCategory.getVista());
            vista.getPagPrincipal().remove(ControllerProduc.getVista());
            
            vista.getPagPrincipal().add(usuarioController.getVista());
            
            vista.invalidate();
            vista.validate();
            vista.repaint();
      
        }
        
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
