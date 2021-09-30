
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pocos.HistoriaAcademica;

/**
 *
 * @author Brandon Trujillo
 */
public class DAOHistoriaAcademica {
    public static ArrayList<HistoriaAcademica> obtenerHistorial(){
        ArrayList<HistoriaAcademica> historialObtenido = new ArrayList<>();
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("SELECT h.*, CONCAT(e.primer_nom, ' ', e.primer_ape) as nombre from historia_academica h inner join estudiante e ON "
                    + "h.estudiante_idestudiante = e.idestudiante;");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                HistoriaAcademica historial = new HistoriaAcademica();
                historial.setIdEstudiante(resultado.getString("estudiante_idestudiante"));
                historial.setNombreEstudiante(resultado.getString("nombre"));
                historial.setIdHistoriaAcademica(resultado.getInt("idhistoria_academica"));
                historial.setAntiguedad(resultado.getString("antiguedad"));
                historial.setAñoIngreso(resultado.getString("año"));
                historial.setSeccion(resultado.getString("sección"));
                historial.setColegio_anterior(resultado.getString("colegio_anterior"));
                historialObtenido.add(historial);
            }
            conn.close();
            consulta.close();
            resultado.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return historialObtenido;
    }
    
    public static int registrarHistorial (String idEstudiante, String antiguedad, String año, String seccion, String colegioAnterior){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("INSERT INTO historia_academica (estudiante_idestudiante, antiguedad, año, sección, colegio_anterior) "
                    + "VALUES (?, ?, ?, ?, ?);");
            consulta.setString(1, idEstudiante);
            consulta.setString(2, antiguedad);
            consulta.setString(3, año);
            consulta.setString(4, seccion);
            consulta.setString(5, colegioAnterior);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        } 
        return resultado;
    }
    
    public static int editarHistorial (String antiguedad, String año, String seccion, String colegioAnterior, String idEstudiante){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("update historia_academica set antiguedad = ?, año = ?, sección = ?, colegio_anterior = ? where estudiante_idestudiante = ?");
            consulta.setString(1, antiguedad);
            consulta.setString(2, año);
            consulta.setString(3, seccion);
            consulta.setString(4, colegioAnterior);
            consulta.setString(5, idEstudiante);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        } 
        return resultado;
    }
}
