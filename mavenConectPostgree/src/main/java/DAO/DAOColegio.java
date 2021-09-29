
package DAO;

import DAO.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pocos.Colegio;

/**
 *
 * @author Brandon Trujillo
 */
public class DAOColegio {
     public static ArrayList<Colegio> ObtenerColegios(){
        ArrayList<Colegio> colegios = new ArrayList<>();
        try{
            Connection conn = Conexion.Conectar();
            String consulta = "select * from colegio;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            while(rs.next()){
                Colegio colegiosObtenidos = new Colegio();
                colegiosObtenidos.setClaveColegio(rs.getString("idcolegio"));
                colegiosObtenidos.setNombreColegio(rs.getString("nombre_colegio"));
                colegiosObtenidos.setTipo(rs.getString("tipo"));
                colegios.add(colegiosObtenidos);
            }
            conn.close();
            stm.close();
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar con la BD");
        }
        
    return colegios;
    }
     
     public static String ObtenerColegioSeleccionado(String nombreColegio){
        String claveColegio = "";
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("select * from colegio where nombre_colegio = ?;");
            consulta.setString(1, nombreColegio);
            ResultSet rs = consulta.executeQuery();
            if(rs.next()){
                claveColegio = rs.getString("idcolegio");
            }
            conn.close();
            consulta.close();
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar con la BD");
        }
        
    return claveColegio;
    }
     
     public static int registrarColegio (String clave, String nombre, String tipo){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("INSERT INTO colegio (idcolegio, nombre_colegio, tipo) "
                    + "VALUES (?, ?, ?);");
            consulta.setString(1, clave);
            consulta.setString(2, nombre);
            consulta.setString(3, tipo);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        } 
        return resultado;
    }
    
}
