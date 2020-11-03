/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Table;

/**
 *
 * @author pc-standard
 */
public class ProductoPedido {
    
    private String ProPedId;
    private String TblProducto_ProRef;
    private String TblPedido_PedId;
  

    public String getProPedId() {
        return ProPedId;
    }

    public void setProPedId(String ProPedId) {
        this.ProPedId = ProPedId;
    }

    public String getTblProducto_ProRef() {
        return TblProducto_ProRef;
    }

    public void setTblProducto_ProRef(String TblProducto_ProRef) {
        this.TblProducto_ProRef = TblProducto_ProRef;
    }

    public String getTblPedido_PedId() {
        return TblPedido_PedId;
    }

    public void setTblPedido_PedId(String TblPedido_PedId) {
        this.TblPedido_PedId = TblPedido_PedId;
    }
    
}
