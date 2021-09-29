/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pocos.Tutor;

/**
 *
 * @author Eduardo DA
 */
public class DAOTutor {
    
    /*
    *
    * Obtención de información de los tutores
    */
    public static ArrayList<Tutor> getTutors(){
       
        Connection conn = Conexion.Conectar();
        ArrayList<Tutor> tutores = new ArrayList<Tutor>();
        
        if(conn != null) {
            try {
                String query = "SELECT primer_nom, seg_nom, primer_ape, seg_ape,\n" +
                                "estudiante_idestudiante, nombre_tutor, apellido_paterno, apellido_materno, \n" +
                                "direccion_tutor, idtutor, fijo, celular\n" +
                                "FROM public.tutor left join public.estudiante on idestudiante = estudiante_idestudiante";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    Tutor tutor = new Tutor();
                    tutor.setIdTutor(rs.getInt("idtutor"));
                    tutor.setIdEstudiante(rs.getInt("estudiante_idestudiante"));
                    tutor.setNombre(rs.getString("nombre_tutor"));
                    tutor.setApellidoPaterno(rs.getString("apellido_paterno"));
                    tutor.setApellidoMaterno(rs.getString("apellido_materno"));
                    tutor.setDirección(rs.getString("direccion_tutor"));
                    tutor.setNumeroFijo(rs.getString("fijo"));
                    tutor.setNumeroCelular(rs.getString("celular"));
                    tutores.add(tutor);                    
                }
                conn.close();
            }catch(SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos");
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return tutores;
    }
    
    /*
    public static int setEstudiante(){
        Connection conn = Conexion.Conectar();
        int resultado = 0;
        if(conn != null) {
            try {
                String query = "";
                
                PreparedStatement ps = conn.prepareStatement(query);
                
                resultado = ps.executeUpdate();
                
                conn.close();
            }catch(SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos");
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return resultado;
    }
    */
    
}
