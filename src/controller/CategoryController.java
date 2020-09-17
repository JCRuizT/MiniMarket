/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CategoryView;

/**
 *
 * @author pc-standard
 */
public class CategoryController implements ActionListener{
    
    private CategoryView vista;
    public CategoryController(){
        
        vista = new CategoryView();
        vista.getButtonCreateCategory().addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Epa");
    }
    
    public static void main(String[] args) {
        CategoryController app = new CategoryController();
    }
    
    
    
}
