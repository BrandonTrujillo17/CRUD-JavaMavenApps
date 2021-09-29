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
                infoEstudiante.setIdInfo(rs.getInt(1));
                infoEstudiante.setNumeroSeguro(rs.getString(2));
                infoEstudiante.setTipoSangre(rs.getString(3));
                infoEstudiante.setTipoSeguro(rs.getString(4));
            }
            conn.close();
            consulta.close();
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar con la BD");
        }
        
    return infoEstudiante;
    }
}
