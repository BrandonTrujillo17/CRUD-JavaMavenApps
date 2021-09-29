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
    private String estatura;
    private String peso;
    private String discVisual;
    private String diabetes;
    private String hipertención;
    

    public InfoSalud() {
    }

    public InfoSalud(String numeroSeguro, String tipoSeguro, String tipoSangre, int idInfo, String estatura, String peso, String discVisual, String diabetes, String hipertención) {
        this.numeroSeguro = numeroSeguro;
        this.tipoSeguro = tipoSeguro;
        this.tipoSangre = tipoSangre;
        this.idInfo = idInfo;
        this.estatura = estatura;
        this.peso = peso;
        this.discVisual = discVisual;
        this.diabetes = diabetes;
        this.hipertención = hipertención;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDiscVisual() {
        return discVisual;
    }

    public void setDiscVisual(String discVisual) {
        this.discVisual = discVisual;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getHipertención() {
        return hipertención;
    }

    public void setHipertención(String hipertención) {
        this.hipertención = hipertención;
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
