/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Manuel
 */
public class Conexion {
    
    private static Connection con;
    
    public static Connection openConnection(){       
        try {
            // Cargarmos el driver.
            Class.forName("org.mariadb.jdbc.Driver");
            // Cremos la conexion.
            String URL = "jdbc:mariadb://localhost:3306/clinica?user=root&password=root";
            con = DriverManager.getConnection(URL);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }      
        return con;
    }
    
    public static void closeConnection(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
