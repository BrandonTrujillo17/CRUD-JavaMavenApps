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
 *
 * @author josuecg
 */
public class DAOOrigen {
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
