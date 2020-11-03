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
public class TipoProducto {

    private String TipProId;
    private String TipProNombre;
    private String TipProIva;
    private String TblEstado_EstId;

    public String getTipProId() {
        return TipProId;
    }

    public void setTipProId(String TipProId) {
        this.TipProId = TipProId;
    }

    public String getTipProNombre() {
        return TipProNombre;
    }

    public void setTipProNombre(String TipProNombre) {
        this.TipProNombre = TipProNombre;
    }

    public String getTipProIva() {
        return TipProIva;
    }

    public void setTipProIva(String TipProIva) {
        this.TipProIva = TipProIva;
    }

    public String getTblEstado_EstId() {
        return TblEstado_EstId;
    }

    public void setTblEstado_EstId(String TblEstado_EstId) {
        this.TblEstado_EstId = TblEstado_EstId;
    }
}
