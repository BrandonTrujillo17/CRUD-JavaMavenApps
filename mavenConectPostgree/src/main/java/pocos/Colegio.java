
package pocos;

/**
 *
 * @author Brandon Trujillo
 * Clase colegio
 *
 */
public class Colegio {
    private String claveColegio = "";
    private String nombreColegio = "";
    private String tipo = "";

    public void setClaveColegio(String claveColegio) {
        this.claveColegio = claveColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public void setTipo(String esPublico) {
        this.tipo = esPublico;
    }

    public String getClaveColegio() {
        return claveColegio;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public String getTipo() {
        return tipo;
    }
    
    
}
