
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection Conectar(){
        Connection conn = null;
        try{
            
            String url = "jdbc:postgresql://localhost:5432/dapp?";
            String user = "capi";
            String password = "12345";

            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Conexión exitosa...");
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }   
    return conn;
    }           
} 

