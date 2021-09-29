/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocos;

/**
 *
 * @author brand
 */
public class Estudiante {
    private String idEstudiante = "";
    private String primerNombre = "";
    private String segundoNombre = "";
    private String primerApellido = "";
    private String segundoApellido = "";
    private boolean activo = true;
    private String claveColegio = "";
    private String nombreColegio = "";

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setClaveColegio(String claveColegio) {
        this.claveColegio = claveColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }
    

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getClaveColegio() {
        return claveColegio;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }
}
