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
public class Producto {

    private String ProRef;
    private String ProNombre;
    private String ProPrecio;
    private String ProStock;
    private String TblEstado_EstId;
    private String ProFechaVencimiento;
    private String TblTipoProducto_TipId;
    private String TipProNombre;
    

    public String getProRef() {
        return ProRef;
    }

    public void setProRef(String ProRef) {
        this.ProRef = ProRef;
    }

    public String getProNombre() {
        return ProNombre;
    }

    public void setProNombre(String ProNombre) {
        this.ProNombre = ProNombre;
    }

    public String getProPrecio() {
        return ProPrecio;
    }

    public void setProPrecio(String ProPrecio) {
        this.ProPrecio = ProPrecio;
    }

    public String getProStock() {
        return ProStock;
    }

    public void setProStock(String ProStock) {
        this.ProStock = ProStock;
    }

    public String getTblEstado_EstId() {
        return TblEstado_EstId;
    }

    public void setTblEstado_EstId(String TblEstado_EstId) {
        this.TblEstado_EstId = TblEstado_EstId;
    }

    public String getProFechaVencimiento() {
        return ProFechaVencimiento;
    }

    public void setProFechaVencimiento(String ProFechaVencimiento) {
        this.ProFechaVencimiento = ProFechaVencimiento;
    }

    public String getTblTipoProducto_TipId() {
        return TblTipoProducto_TipId;
    }

    public void setTblTipoProducto_TipId(String TblTipoProducto_TipId) {
        this.TblTipoProducto_TipId = TblTipoProducto_TipId;
    }

    public String getTipProNombre() {
        return TipProNombre;
    }

    public void setTipProNombre(String TipProNombre) {
        this.TipProNombre = TipProNombre;
    }
    
    

}
