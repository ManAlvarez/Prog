/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog11.bbdd;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Manuel
 *
 * Clase con métodos estáticos, para poder llamar a los métodos sin la necesidad
 * de instancias la clase.
 */
public class PropietariosDAO {

    // Constantes que hacen relación a la tabla y a los campos de la base de datos.
    private static final String TABLE = "PROPIETARIOS";
    private static final String COL1 = "ID_PROP";
    private static final String COL2 = "NOMBRE_PROP";
    private static final String COL3 = "DNI_PROP";

    /**
     * Método para insertar un propietario en la base de datos.
     *
     * @param nombre
     * @param dni
     * @param con
     * @return 0 si está insertado y -1 si no está insertado.
     */
    public static int insertPropietario(String nombre, String dni, Connection con) {
        // Tipo de sentencia PreparedStatement para realizar sentencias en SQL con parámetros.
        PreparedStatement ps;
        // Sentencia SQL para insertar un propietario.
        String insert = "INSERT INTO " + TABLE
                + " (" + COL2 + ", " + COL3 + ")"
                + " VALUES (?, ?);";

        try {
            if (!existPropietario(dni, con)) {
                // Preparamos la consulta y la ejecutamos.                     
                ps = con.prepareStatement(insert);
                ps.setString(1, nombre);
                ps.setString(2, dni);
                ps.executeUpdate();
                // Cerrammos el PreparedStatement.
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        if (existPropietario(dni, con)) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Método para obtener una lista de los vehículos de un propietario.
     *
     * @param dni
     * @param con
     * @return Una lista de los vehículos del propietario o null si el
     * propietario no existe o no tiene vehículos.
     */
    public static ArrayList<String> getVehiculosPropietario(String dni, Connection con) {
        if (existPropietario(dni, con)) {
            return VehiculosDAO.getVehiculos(getIdPropietario(dni, con), con);
        } else {
            return null;
        }
    }

    /**
     * Método para eliminar propietarios cuyo dni se corresponda con el
     * parámetro.
     *
     * @param dni
     * @param con
     * @return El número de registros que hemos eliminado.
     */
    public static int deletePropietario(String dni, Connection con) {
        int numRegDel = 0;
        PreparedStatement ps;
        // Sentencia SQL para eliminar los registros donde el dni_prop sea igual al parámetro.
        String delete = "DELETE FROM " + TABLE
                + " WHERE " + COL3 + " = ?;";
        try {
            // Preparamos la consulta y la ejecutamos
            // Informamos del número de registros borrados 
            ps = con.prepareStatement(delete);
            ps.setString(1, dni);
            numRegDel = ps.executeUpdate();
            // Cerramos el PreparedStatement.    
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return numRegDel;
    }

    /**
     * Método para comprobar si el dni de un propietario ya está en la base de
     * datos.
     *
     * @param dni
     * @param con
     * @return True si el dni ya está en la base de datos o False si no está.
     */
    public static boolean existPropietario(String dni, Connection con) {
        boolean exist = false;
        PreparedStatement ps;
        ResultSet rs;
        // Sentencia SQL para seleccionar todo donde el dni_prop de la bd es igual al parámetro dni.
        String query = "SELECT * FROM " + TABLE + " WHERE " + COL3 + " = ?;";
        try {
            // Ejecuta la consulta
            ps = con.prepareStatement(query);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            // Procesa los resultados
            exist = rs.next();
            // Cerrar ResultSet
            rs.close();
            // Cerrar PreparedStatement
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return exist;
    }

    /**
     * Método para comprobar si el idPropietario de un propietario ya está en la
     * base de datos.
     *
     * @param idPropietario
     * @param con
     * @return True si el idPropietario ya está en la base de datos o False si
     * no está.
     */
    public static boolean existPropietario(int idPropietario, Connection con) {
        boolean exist = false;
        PreparedStatement ps;
        ResultSet rs;
        // Sentencia SQL para seleccionar todo donde el id_prop de la bd es igual al parámetro idPropietario.
        String query = "SELECT * FROM " + TABLE + " WHERE " + COL1 + " = ?;";
        try {
            // Ejecuta la consulta
            ps = con.prepareStatement(query);
            ps.setInt(1, idPropietario);
            rs = ps.executeQuery();
            // Procesa los resultados
            exist = rs.next();
            // Cerrar ResultSet
            rs.close();
            // Cerrar PreparedStatement
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return exist;
    }

    /**
     * Método para obtener el idPropietario a través de su dni.
     *
     * @param dni
     * @param con
     * @return El id del propietario si lo encuentra o -1 si no lo encuentra.
     */
    public static int getIdPropietario(String dni, Connection con) {
        PreparedStatement ps;
        ResultSet rs;
        // Sentencia SQL para seleccionar donde el campo dni_prop sea igual al parámetro dni.
        String query = "SELECT * FROM " + TABLE + " WHERE " + COL3 + " = ?;";
        try {
            // Ejecuta la consulta
            ps = con.prepareStatement(query);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            // Procesa los resultados
            while (rs.next()) {
                if (rs.getString(COL3).equalsIgnoreCase(dni)) {
                    // Devolvemos el idPropietario
                    return rs.getInt(COL1);
                }
            }
            // Cerrar ResultSet
            rs.close();
            // Cerrar PreparedStatement.
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

}
