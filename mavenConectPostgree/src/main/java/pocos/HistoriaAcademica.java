
package pocos;

/**
 *
 * @author Brandon Trujillo
 */
public class HistoriaAcademica {
    private String idEstudiante = "";
    private int idHistoriaAcademica = 0;
    private String antiguedad = "";
    private String añoIngreso = "";
    private String seccion = "";

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public String getIdEstudiante() {
        return idEstudiante;
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
}
