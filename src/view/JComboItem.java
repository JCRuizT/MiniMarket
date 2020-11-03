/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author pc-standard
 */


public class JComboItem{

    private String name;
    private String id;

    public JComboItem(String id,String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public int hashCode(){
        return Integer.parseInt(id);
    }
}
