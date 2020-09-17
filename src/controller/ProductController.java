/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ProductView;

/**
 *
 * @author pc-standard
 */
public class ProductController implements ActionListener{
    
    private ProductView vista;
    public ProductController(){
        vista = new ProductView();
        vista.getButtonCreateProduct().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("----");
    }
    
    
    public static void main(String[] args) {
        ProductController app = new ProductController();
    }
    
}
