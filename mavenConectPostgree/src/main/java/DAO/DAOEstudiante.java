
package DAO;

import DAO.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pocos.Estudiante;


public class DAOEstudiante {
    /**
     * método para obtener los estudiantes que esten activos
     * @return un array list de estudiantes
     */
    public static ArrayList<Estudiante> ObtenerEstudiantes(){
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try{
            Connection conn = Conexion.Conectar();
            String consulta = "Select e.*, c.nombre_colegio from Estudiante e INNER JOIN colegio c on e.idcolegio = c.idcolegio where estado = 't';";


            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
      
            while(rs.next()){
                 Estudiante estudiantesObtenidos = new Estudiante();
                estudiantesObtenidos.setIdEstudiante(rs.getString("idestudiante"));
                estudiantesObtenidos.setPrimerNombre(rs.getString("primer_nom"));
                estudiantesObtenidos.setSegundoNombre(rs.getString("seg_nom"));
                estudiantesObtenidos.setPrimerApellido(rs.getString("primer_ape"));
                estudiantesObtenidos.setSegundoApellido(rs.getString("seg_ape"));
                estudiantesObtenidos.setActivo(rs.getBoolean("estado"));
                estudiantesObtenidos.setClaveColegio(rs.getString("idcolegio"));
                estudiantesObtenidos.setNombreColegio(rs.getString("nombre_colegio"));
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
    
    /**
     * método que verifica si una matricula ya esta registrada
     * @param matricula
     * @return un boolean que dice si es repetida o no
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
    
    /**
     * metodo que inserta estudiantes a la tabla estudiante
     * @param matricula
     * @param primerNombre
     * @param segundoNombre
     * @param primerApellido
     * @param segundoApellido
     * @param claveColegio
     * @return una variable int con el número de rows afectadas tras el registro
     */
    public static int registrarEstudiante (String matricula, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String claveColegio){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("INSERT INTO Estudiante (idestudiante, primer_nom, primer_ape, seg_nom, seg_ape, estado, idcolegio) "
                    + "VALUES (?, ?, ?, ?, ?, 't', ?);");

            consulta.setString(1, matricula);
            consulta.setString(2, primerNombre);
            consulta.setString(3, primerApellido);
            consulta.setString(4, segundoNombre);
            consulta.setString(5, segundoApellido);
            consulta.setString(6, claveColegio);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        } 
        return resultado;
    }
    
    /**
     * método que edita estudiantes
     * @param matricula
     * @param primerNombre
     * @param segundoNombre
     * @param primerApellido
     * @param segundoApellido
     * @param claveColegio
     * @param idEstudianteComparacion
     * @return una variable int con el número de rows afectadas tras la edición
     */
    public static int editarEstudiante (String matricula, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String claveColegio, String idEstudianteComparacion){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("Update Estudiante set idEstudiante = ?, primer_nom = ?, primer_ape = ?, seg_nom = ?, seg_ape = ?, "
                    + "idcolegio = ? Where idEstudiante = ?");
            consulta.setString(1, matricula);
            consulta.setString(2, primerNombre);
            consulta.setString(3, primerApellido);
            consulta.setString(4, segundoNombre);
            consulta.setString(5, segundoApellido);
            consulta.setString(6, claveColegio);
            consulta.setString(7, idEstudianteComparacion);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        } 
        return resultado;
    }
    
    /**
     * método que cambia de estado a un estudiante
     * @param matricula
     * @return una variable int con el número de rows afectadas tras el cambio
     */
    public static int eliminarEstudiante (String matricula){
        int resultado = 0;
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("Update Estudiante set estado = 'f' where idEstudiante = ?;");
            consulta.setString(1, matricula);
            resultado = consulta.executeUpdate();
            conn.close();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        } 
        return resultado;
    }
    
    /**
     * método que obtiene a los estudiantes que no tiene historial academico asociado, usado para llenar el combo box que aparece en registrar historial
     * @return  arrayList de estudiantes
     */
    public static ArrayList<Estudiante> obtenerEstudiantesConHistorial(){
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try{
            Connection conn = Conexion.Conectar();
            String consulta = "Select e.idestudiante, CONCAT(e.primer_nom, ' ', e.primer_ape) as nombre from estudiante e where not EXISTS "
                    + "(select * from historia_academica h where h.estudiante_idestudiante = e.idestudiante);";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            while(rs.next()){
                Estudiante estudiantesObtenidos = new Estudiante();
                estudiantesObtenidos.setIdEstudiante(rs.getString("idestudiante"));
                estudiantesObtenidos.setPrimerNombre(rs.getString("nombre"));
                estudiantes.add(estudiantesObtenidos);
            }
            conn.close();
            stm.close();
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return estudiantes;
    }
    
    /**
     * metodo que obtiene el estudiante que se seleccionó de un combo Box
     * @param nombreEstudiante
     * @return String con el ID del estudiante
     */
    public static String ObtenerEstudianteSeleccionado(String nombreEstudiante){
        String idEstudiante = "";
        try{
            Connection conn = Conexion.Conectar();
            PreparedStatement consulta = conn.prepareStatement("select * from estudiante where concat(primer_nom, ' ', primer_ape) = ?;");
            consulta.setString(1, nombreEstudiante);
            ResultSet rs = consulta.executeQuery();
            if(rs.next()){
                idEstudiante= rs.getString("idestudiante");
            }
            conn.close();
            consulta.close();
            rs.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            
        }
        return idEstudiante;
    }
}
