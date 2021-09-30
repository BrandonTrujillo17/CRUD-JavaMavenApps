
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pocos.Estudiante;

/***
 * Esta clase permite el acceso de información de Estudiante
 * @author josuecg
 */
public class DAOEstudiante {
    
    /***
     * Este metodo permite obtener todos los estudiantes registrados dentro del sistema
     * @return una lista de estudiantes registrados
     */
    public static ArrayList<Estudiante> ObtenerEstudiantes(){
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try{
            Connection conn = Conexion.Conectar();
            String consulta = "Select * from Estudiante where estado = 't';";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            while(rs.next()){
                Estudiante estudiantesObtenidos = new Estudiante();
                estudiantesObtenidos.setIdEstudiante(rs.getString(1));
                estudiantesObtenidos.setPrimerNombre(rs.getString(2));
                estudiantesObtenidos.setSegundoNombre(rs.getString(4));
                estudiantesObtenidos.setPrimerApellido(rs.getString(3));
                estudiantesObtenidos.setSegundoApellido(rs.getString(5));
                estudiantesObtenidos.setActivo(rs.getBoolean(6));
                estudiantes.add(estudiantesObtenidos);
            }
            conn.close();
            stm.close();
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar con la BD");
        }
        
    return estudiantes;
    }
    
    /***
     * Este metodo verifica si una matricula esta repetida dentro del sistema
     * @param matricula La matricula a verificar
     * @return true si esta repetida, false sino
     */
    public static boolean verificarMatriculaRepetida(String matricula){
        boolean esRepetida = false;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("Select * from estudiante where idEstudiante = ?");
            consulta.setString(1, matricula);
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
                esRepetida = true;
            }
            conn.close();
            consulta.close();
            resultado.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return esRepetida;
    }
    
    /***
     * Este método registra a un estudiante dentro del sistema
     * @param matricula 
     * @param primerNombre
     * @param segundoNombre
     * @param primerApellido
     * @param segundoApellido
     * @return 1 si el registro fue exitoso, 0 si no
     */
    public static int registrarEstudiante (String matricula, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("INSERT INTO Estudiante (idestudiante, primer_nom, seg_nom, primer_ape, seg_ape, estado) "
                    + "VALUES (?, ?, ?, ?, ?, 't');");
            consulta.setString(1, matricula);
            consulta.setString(2, primerNombre);
            consulta.setString(3, segundoNombre);
            consulta.setString(4, primerApellido);
            consulta.setString(5, segundoApellido);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        } 
        return resultado;
    }
    
    /***
     * Permite editar la información de un estudiante
     * @param matricula
     * @param primerNombre
     * @param segundoNombre
     * @param primerApellido
     * @param segundoApellido
     * @param idEstudianteComparacion
     * @return 1 si el registro fue exitoso, 0 si no
     */
    public static int editarEstudiante (String matricula, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String idEstudianteComparacion){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("Update Estudiante set idEstudiante = ?, primerNombre = ?, segundoNombre = ?, primerApellido = ?, segundoApellido = ? "
                    + "Where idEstudiante = ?");
            consulta.setString(1, matricula);
            consulta.setString(2, primerNombre);
            consulta.setString(3, segundoNombre);
            consulta.setString(4, primerApellido);
            consulta.setString(5, segundoApellido);
            consulta.setString(6, idEstudianteComparacion);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        } 
        return resultado;
    }
    
    /***
     * Permite eliminar o dar de baja a un estudiante dentro del sistema
     * @param matricula sirve para identificar al estudiante que se dará de baja
     * @return 1 si fue correcto, 0 si no
     */
    public static int eliminarEstudiante (String matricula){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("Update Estudiante set activo = 'f' where idEstudiante = ?;");
            consulta.setString(1, matricula);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        } 
        return resultado;
    }
}
