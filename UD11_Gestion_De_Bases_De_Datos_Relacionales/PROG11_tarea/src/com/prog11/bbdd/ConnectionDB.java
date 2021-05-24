/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog11.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Manuel
 */
public class ConnectionDB {

    private static Connection con;

    /**
     * Método para conectarnos a la base de datos.
     * @return Connection.
     */
    public static Connection openConnection() {
        try {
            // Cargar el driver de mysql.
            Class.forName("org.mariadb.jdbc.Driver");
            // Cadena de conexión para conectar com MariaDB en localhost,
            // seleccionar la base de datos llamada concesionario
            // con usuario y contraseña del servidor mariaDB: root y root
            String connectionUrl = "jdbc:mariadb://localhost:3306/concesionario?user=root&password=root";
            // Obtener la conexion.
            con = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    /**
     * Método para cerrar la conexión.
     */
    public static void closeConnection() {
        try {
            // Cerrar la conexión.
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
