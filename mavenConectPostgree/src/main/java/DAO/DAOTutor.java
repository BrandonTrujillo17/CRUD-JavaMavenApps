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
                    tutor.setIdEstudiante(rs.getString("estudiante_idestudiante"));
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
    * Registro de los datos de tutor
    */
    public static int setTutor(String nombre, String apellidoMaterno, String apellidoPaterno, String direccion, 
                               String numeroFijo,String NumeroCelular, String idEstudiante){
        
        Connection conn = Conexion.Conectar();
        int resultado = 0;
        if(conn != null) {
            try {
                String query = "INSERT INTO public.tutor( estudiante_idestudiante, nombre_tutor, "
                             + "apellido_paterno, apellido_materno, direccion_tutor, fijo, celular)\n" +
                               " VALUES (?, ?, ?, ?, ?, ?, ?);";
                
                PreparedStatement ps = conn.prepareStatement(query);
                
                ps.setString(1,idEstudiante);
                ps.setString(2,nombre);
                ps.setString(3,apellidoPaterno);
                ps.setString(4,apellidoMaterno);
                ps.setString(5,direccion);
                ps.setString(6,numeroFijo);
                ps.setString(7,NumeroCelular);
                
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

    /*
    * Eliminación de tutor
    */
    public static int deleteTutor(int idTutor){
        Connection conn = Conexion.Conectar();
        int resultado = 0;
        if(conn != null) {
            try {
                String query = "DELETE FROM public.tutor WHERE idtutor = ?;";
                
                PreparedStatement ps = conn.prepareStatement(query);
                
                ps.setInt(1,idTutor);
                
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
    
    /*
    * Actualización de los datos de tutor
    */
    public static int updateTutor(String nombre, String apellidoMaterno, String apellidoPaterno,
                                  String direccion, String numeroFijo,String NumeroCelular, 
                                  String idEstudiante, int idTutor){

        Connection conn = Conexion.Conectar();

        int resultado = 0;

        if(conn != null) {
            try {
                String query = "UPDATE public.tutor SET estudiante_idestudiante=?, nombre_tutor=?, "
                             + "apellido_paterno=?, apellido_materno=?, direccion_tutor=?, fijo=?, celular=?\n"
                             + "WHERE idtutor = ?;";
                
                PreparedStatement ps = conn.prepareStatement(query);
                
                ps.setString(1,idEstudiante);
                ps.setString(2,nombre);
                ps.setString(3,apellidoPaterno);
                ps.setString(4,apellidoMaterno);
                ps.setString(5,direccion);
                ps.setString(6,numeroFijo);
                ps.setString(7,NumeroCelular);
                ps.setInt(8,idTutor);

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
    
    
}
