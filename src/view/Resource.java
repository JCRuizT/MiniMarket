/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static java.lang.Integer.parseInt;

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

}
