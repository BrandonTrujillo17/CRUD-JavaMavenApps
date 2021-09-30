
package pocos;

/**
 *
 * @author Brandon Trujillo
 */
public class HistoriaAcademica {
    private String idEstudiante = "";
    private String nombreEstudiante = "";
    private int idHistoriaAcademica = 0;
    private String antiguedad = "";
    private String añoIngreso = "";
    private String seccion = "";
    private String colegio_anterior = "";

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
    

    public void setIdHistoriaAcademica(int idHistoriaAcademica) {
        this.idHistoriaAcademica = idHistoriaAcademica;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setAñoIngreso(String añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setColegio_anterior(String colegio_anterior) {
        this.colegio_anterior = colegio_anterior;
    }
    

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    
    public int getIdHistoriaAcademica() {
        return idHistoriaAcademica;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public String getAñoIngreso() {
        return añoIngreso;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getColegio_anterior() {
        return colegio_anterior;
    }
    
}
