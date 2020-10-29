/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static java.lang.Integer.parseInt;
import javax.swing.JComboBox;

/**
 *
 * @author pc-standard
 */
public class Resource {
    
    public static String transformFecha(String fecha){
        
        String mes[] = {"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov"
                ,"Dic"};
        String arr[] = fecha.split("-");
        int mesSelected = parseInt(arr[1])-1;
        String response  = arr[2]+" de "+mes[mesSelected]+" del "+arr[0];
        return response;
        
    }
    
      public static void setSelectedCombobox(JComboBox select, String txt) {

        for (int i = 0; i < select.getModel().getSize(); i++) {
            if (select.getItemAt(i).toString().equals(txt)) {
                select.setSelectedIndex(i);
                break;
            }
        }

    }
    


}
