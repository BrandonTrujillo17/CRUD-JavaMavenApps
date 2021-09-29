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
public class InfoSalud {
    private String numeroSeguro;
    private String tipoSeguro;
    private String tipoSangre;
    private int idInfo;

    public InfoSalud() {
    }
    
    public InfoSalud(String numeroSeguro, String tipoSeguro, String tipoSangre, int idInfo) {
        this.numeroSeguro = numeroSeguro;
        this.tipoSeguro = tipoSeguro;
        this.tipoSangre = tipoSangre;
        this.idInfo = idInfo;
    }
    
    public String getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(String numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public int getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
    }
    
    
}
