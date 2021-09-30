/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pocos.InfoSalud;
import pocos.Origen;

/**
 *Clase para el acceso a datos de la clase Origen, todas las conexiones y manipulaciones de dicho
 * objeto se encuentran aquí
 * @author josuecg
 */
public class DAOOrigen {
    
    /***
     * Este método registra los datos de origen de un estudiante dentro de la BD
     * @param origen Sirve para la conexión de la información de origen a la BD
     * @param matricula Hace referencia a la matricula del estudiante donde se registrara su origen
     * @return resultado Si es correcto el resultado entonces sera 1
     */
    public int registrarDatosOrigen(Origen origen, String matricula){
         int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("INSERT INTO origen (estado, ciudad, colonia, calle_numero, idestudiante) "
                    + "VALUES (?,?,?,?,?);");
            consulta.setString(1, origen.getEstado());
            consulta.setString(2, origen.getCiudad());
            consulta.setString(3, origen.getColonia());
            consulta.setString(4, origen.getCalleNumero());
            consulta.setString(5, matricula);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
        return resultado;
    }
    
    /***
     * Este método actualiza los datos de origen de el estudiante seleccionado
     * @param origen Sirve para actualizar los datos de origen
     * @param matricula Del estudiante seleccionado, con este dato se buscará dentro de la BD
     * @return resultado Si es 1 el resultado fue exitoso
     */
     public int actualizarDatosOrigen(Origen origen, String matricula){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("UPDATE origen SET estado=?, ciudad=?, colonia=?, "
                    + "calle_numero=? WHERE idestudiante=?;");
            consulta.setString(1, origen.getEstado());
            consulta.setString(2, origen.getCiudad());
            consulta.setString(3, origen.getColonia());
            consulta.setString(4, origen.getCalleNumero());
            consulta.setString(5, matricula);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
        return resultado;
    }
    
    /***
     * Este método recupera la información de origen del estudiante seleccionado
     * @param matricula sirve para buscar la información dentro de la BD
     * @return origen Retorna el objeto encontrado, si no retorna null
     */
    public Origen origenEstudiante(String matricula){
         Origen origenEstudiante = new Origen();
         try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("Select * from origen where idestudiante = ?;");
            consulta.setString(1, matricula);
            ResultSet rs =  consulta.executeQuery();
            while(rs.next()){
                origenEstudiante.setEstado(rs.getString(1));
                origenEstudiante.setCiudad(rs.getString(2));
                origenEstudiante.setColonia(rs.getString(3));
                origenEstudiante.setCalleNumero(rs.getString(4));
            }
            conn.close();
            consulta.close();
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la BD");
        }
         return origenEstudiante;
    }
}
