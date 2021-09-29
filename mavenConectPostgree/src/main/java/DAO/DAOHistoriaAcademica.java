
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
            PreparedStatement consulta = conn.prepareStatement("Select * from historia_academica;");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                HistoriaAcademica historial = new HistoriaAcademica();
                historial.setIdEstudiante(resultado.getString("estudiante_idestudiante"));
                historial.setIdHistoriaAcademica(resultado.getInt("idhistoria_academica"));
                historial.setAntiguedad(resultado.getString("antiguedad"));
                historial.setAñoIngreso(resultado.getString("año"));
                historial.setSeccion(resultado.getString("seccion"));
                historialObtenido.add(historial);
            }
            conn.close();
            consulta.close();
            resultado.close();
        }catch(SQLException ex){
            
        }
        return historialObtenido;
    }
}
