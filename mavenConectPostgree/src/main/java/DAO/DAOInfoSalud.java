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
import java.sql.Statement;
import javax.swing.JOptionPane;
import pocos.Estudiante;
import pocos.InfoSalud;

/**
 *
 * @author josuecg
 */
public class DAOInfoSalud {
    public InfoSalud returnDatosSalud(String matriculaEstudiante){
        InfoSalud infoEstudiante = new InfoSalud();
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("Select * from inf_salud where estudiante_idestudiante = ?;");
            consulta.setString(1, matriculaEstudiante);
            ResultSet rs =  consulta.executeQuery();
            while(rs.next()){
                infoEstudiante.setIdInfo(rs.getInt(5));
                infoEstudiante.setNumeroSeguro(rs.getString(2));
                infoEstudiante.setTipoSangre(rs.getString(4));
                infoEstudiante.setTipoSeguro(rs.getString(3));
                infoEstudiante.setEstatura(rs.getString(6));
                infoEstudiante.setPeso(rs.getString(7));
                infoEstudiante.setDiscVisual(rs.getString(8));
                infoEstudiante.setDiabetes(rs.getString(9));
                infoEstudiante.setHipertención(rs.getString(10));
            }
            conn.close();
            consulta.close();
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la BD");
        }
        
    return infoEstudiante;
    }
    
    public int registrarInfMedica(InfoSalud infoSalud, String matricula){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("INSERT INTO inf_salud (estudiante_idestudiante, numero_seguro, tipo_seguro, grupo_sanguineo, "
                    + "estatura, peso, discapacidadvisual, diabetes, hipertencion) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            consulta.setString(1, matricula);
            consulta.setString(2, infoSalud.getNumeroSeguro());
            consulta.setString(3, infoSalud.getTipoSeguro());
            consulta.setString(4, infoSalud.getTipoSangre());
            consulta.setString(5, infoSalud.getEstatura());
            consulta.setString(6, infoSalud.getPeso());
            consulta.setString(7, infoSalud.getDiscVisual());
            consulta.setString(8, infoSalud.getDiabetes());
            consulta.setString(9, infoSalud.getHipertención());
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
        return resultado;
    }
    
    public int actualizarInfMedica(InfoSalud infoSalud, String matricula){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("UPDATE inf_salud SET numero_seguro=?, tipo_seguro=?, grupo_sanguineo=?, "
                    + "estatura=?, peso=?, discapacidadvisual=?, diabetes=?, hipertencion=? WHERE estudiante_idEstudiante=?;");
            consulta.setString(9, matricula);
            consulta.setString(1, infoSalud.getNumeroSeguro());
            consulta.setString(2, infoSalud.getTipoSeguro());
            consulta.setString(3, infoSalud.getTipoSangre());
            consulta.setString(4, infoSalud.getEstatura());
            consulta.setString(5, infoSalud.getPeso());
            consulta.setString(6, infoSalud.getDiscVisual());
            consulta.setString(7, infoSalud.getDiabetes());
            consulta.setString(8, infoSalud.getHipertención());
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
        return resultado;
    }
}
