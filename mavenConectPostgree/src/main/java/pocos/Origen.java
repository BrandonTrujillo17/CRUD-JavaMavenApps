/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocos;

/**
 *
 * @author josuecg
 */
public class Origen {
    private String estado;
    private String ciudad;
    private String colonia;
    private String calleNumero;

    public Origen(String estado, String ciudad, String colonia, String calleNumero) {
        this.estado = estado;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calleNumero = calleNumero;
    }

    public Origen() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }
    
    
}
